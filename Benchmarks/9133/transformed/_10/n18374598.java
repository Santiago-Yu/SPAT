class n18374598 {
	private synchronized File download() throws AMSpacksException {
		String a = addr.url.toExternalForm();
		int p = a.lastIndexOf('/');
		if (p < 0) {
			p = a.lastIndexOf('\\');
		}
		File td = null;
		if (p < 0) {
			a = "" + Math.random();
		} else {
			a = a.substring(p + 1);
		}
		try {
			td = File.createTempFile(a, "").getParentFile();
		} catch (IOException ex) {
			td = new File(".");
		}
		File f = new File(td, a);
		td.delete();
		int progress = 0;
		long total = addr.update.getSize();
		try {
			FileOutputStream out = new FileOutputStream(f);
			InputStream in = new BufferedInputStream(addr.url.openStream());
			int n;
			byte[] buf = new byte[500];
			long percentage = 0;
			callback.updateProgress(percentage);
			do {
				n = in.read(buf);
				if (n > 0) {
					out.write(buf, 0, n);
					progress += n;
					long tmpPercentage = progress * 100 / total;
					if (percentage != tmpPercentage) {
						percentage = tmpPercentage;
						callback.updateProgress(percentage);
					}
				}
			} while (n > 0);
			in.close();
			out.flush();
			out.close();
		} catch (Exception ex) {
			f.delete();
			throw new DownloadFailedException("Error downloading update.", ex);
		}
		long size = f.length();
		String checksum = CheckSumFinder.checkSum(f);
		if (size == addr.update.getSize() && checksum.equalsIgnoreCase(addr.update.getChecksum()))
			return f;
		else {
			f.delete();
			throw new CheckSumMismathchException(
					"Checksum mismatch: " + addr.update.getChecksum() + " expected but was " + checksum);
		}
	}

}