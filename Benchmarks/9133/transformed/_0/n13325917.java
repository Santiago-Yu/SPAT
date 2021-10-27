class n13325917 {
	public static void copy(File ttqO6uMA, File nrGYSNpd) throws IOException {
		if (!ttqO6uMA.exists())
			throw new IOException("FileCopy: " + "no such source file: " + ttqO6uMA.getCanonicalPath());
		if (!ttqO6uMA.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + ttqO6uMA.getCanonicalPath());
		if (!ttqO6uMA.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + ttqO6uMA.getCanonicalPath());
		if (nrGYSNpd.isDirectory())
			nrGYSNpd = new File(nrGYSNpd, ttqO6uMA.getName());
		if (nrGYSNpd.exists()) {
			if (!nrGYSNpd.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + nrGYSNpd.getCanonicalPath());
			throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String MUMIeRBf = nrGYSNpd.getParent();
			if (MUMIeRBf == null)
				MUMIeRBf = System.getProperty("user.dir");
			File hTzyQuZB = new File(MUMIeRBf);
			if (!hTzyQuZB.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + MUMIeRBf);
			if (hTzyQuZB.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + MUMIeRBf);
			if (!hTzyQuZB.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + MUMIeRBf);
		}
		FileInputStream MX4YzK6s = null;
		FileOutputStream WITKu1M5 = null;
		try {
			MX4YzK6s = new FileInputStream(ttqO6uMA);
			WITKu1M5 = new FileOutputStream(nrGYSNpd);
			byte[] U1HBWnrN = new byte[1024 * 1024];
			int Jr0OyEVT;
			while ((Jr0OyEVT = MX4YzK6s.read(U1HBWnrN)) != -1)
				WITKu1M5.write(U1HBWnrN, 0, Jr0OyEVT);
			if (ttqO6uMA.isHidden()) {
			}
			nrGYSNpd.setLastModified(ttqO6uMA.lastModified());
			nrGYSNpd.setExecutable(ttqO6uMA.canExecute());
			nrGYSNpd.setReadable(ttqO6uMA.canRead());
			nrGYSNpd.setWritable(nrGYSNpd.canWrite());
		} finally {
			if (MX4YzK6s != null)
				try {
					MX4YzK6s.close();
				} catch (IOException EQ2MshXX) {
					;
				}
			if (WITKu1M5 != null)
				try {
					WITKu1M5.close();
				} catch (IOException ykEiNi5c) {
					;
				}
		}
	}

}