class n18374598 {
	private synchronized File download() throws AMSpacksException {
		String NOvOZ8vw = addr.url.toExternalForm();
		int IWymRt0v = NOvOZ8vw.lastIndexOf('/');
		if (IWymRt0v < 0) {
			IWymRt0v = NOvOZ8vw.lastIndexOf('\\');
		}
		if (IWymRt0v < 0) {
			NOvOZ8vw = "" + Math.random();
		} else {
			NOvOZ8vw = NOvOZ8vw.substring(IWymRt0v + 1);
		}
		File tm81I7a9 = null;
		try {
			tm81I7a9 = File.createTempFile(NOvOZ8vw, "").getParentFile();
		} catch (IOException siK2m8jN) {
			tm81I7a9 = new File(".");
		}
		File fY4r1ahY = new File(tm81I7a9, NOvOZ8vw);
		tm81I7a9.delete();
		long um8jnBYq = addr.update.getSize();
		int O4uAFBVK = 0;
		try {
			InputStream TmDbjSPg = new BufferedInputStream(addr.url.openStream());
			FileOutputStream BcmhlUk8 = new FileOutputStream(fY4r1ahY);
			byte[] IgeQCCYD = new byte[500];
			int H1aidEZf;
			long lYHnPlXb = 0;
			callback.updateProgress(lYHnPlXb);
			do {
				H1aidEZf = TmDbjSPg.read(IgeQCCYD);
				if (H1aidEZf > 0) {
					BcmhlUk8.write(IgeQCCYD, 0, H1aidEZf);
					O4uAFBVK += H1aidEZf;
					long ieYFNdan = O4uAFBVK * 100 / um8jnBYq;
					if (lYHnPlXb != ieYFNdan) {
						lYHnPlXb = ieYFNdan;
						callback.updateProgress(lYHnPlXb);
					}
				}
			} while (H1aidEZf > 0);
			TmDbjSPg.close();
			BcmhlUk8.flush();
			BcmhlUk8.close();
		} catch (Exception eTUqlMSl) {
			fY4r1ahY.delete();
			throw new DownloadFailedException("Error downloading update.", eTUqlMSl);
		}
		long vRuzVbv8 = fY4r1ahY.length();
		String OeV45kVd = CheckSumFinder.checkSum(fY4r1ahY);
		if (vRuzVbv8 == addr.update.getSize() && OeV45kVd.equalsIgnoreCase(addr.update.getChecksum()))
			return fY4r1ahY;
		else {
			fY4r1ahY.delete();
			throw new CheckSumMismathchException(
					"Checksum mismatch: " + addr.update.getChecksum() + " expected but was " + OeV45kVd);
		}
	}

}