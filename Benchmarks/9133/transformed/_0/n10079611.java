class n10079611 {
	public static void copy(File PZsn9Yya, File kc3q20Jn) throws IOException {
		if (PZsn9Yya == null)
			throw new NullPointerException("Source file must not be null");
		if (kc3q20Jn == null)
			throw new NullPointerException("Target file must not be null");
		if (!PZsn9Yya.exists())
			throw new IOException("Source file " + PZsn9Yya.getPath() + " does not exist");
		if (!PZsn9Yya.isFile())
			throw new IOException("Source file " + PZsn9Yya.getPath() + " is not a regular file");
		if (!PZsn9Yya.canRead())
			throw new IOException("Source file " + PZsn9Yya.getPath() + " can not be read (missing acces right)");
		if (!kc3q20Jn.exists())
			throw new IOException("Target file " + kc3q20Jn.getPath() + " does not exist");
		if (!kc3q20Jn.isFile())
			throw new IOException("Target file " + kc3q20Jn.getPath() + " is not a regular file");
		if (!kc3q20Jn.canWrite())
			throw new IOException("Target file " + kc3q20Jn.getPath() + " is write protected");
		InputStream B7Agifl4 = null;
		OutputStream PKuWg10o = null;
		try {
			B7Agifl4 = new FileInputStream(PZsn9Yya);
			PKuWg10o = new FileOutputStream(kc3q20Jn);
			byte[] zBcnHik4 = new byte[1024];
			while (B7Agifl4.available() > 0) {
				int tWPM6D5R = B7Agifl4.read(zBcnHik4);
				if (tWPM6D5R > 0)
					PKuWg10o.write(zBcnHik4, 0, tWPM6D5R);
			}
		} finally {
			if (B7Agifl4 != null)
				try {
					B7Agifl4.close();
				} catch (IOException FkSlPnbs) {
				}
			if (PKuWg10o != null)
				try {
					PKuWg10o.close();
				} catch (IOException F897mOc2) {
				}
		}
	}

}