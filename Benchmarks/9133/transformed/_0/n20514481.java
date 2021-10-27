class n20514481 {
	public static File copy(String vJj8DDrc, String ceBq90rB) throws IOException {
		File sqbR6CTA = new File(vJj8DDrc);
		File vQm92Ccq = new File(ceBq90rB);
		System.out.println("AbsolutePath fromFile: " + sqbR6CTA.getAbsolutePath());
		System.out.println("AbsolutePath toFile: " + vQm92Ccq.getAbsolutePath());
		if (!sqbR6CTA.exists())
			throw new IOException("FileCopy: " + "no such source file: " + vJj8DDrc);
		if (!sqbR6CTA.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + vJj8DDrc);
		if (!sqbR6CTA.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + vJj8DDrc);
		if (vQm92Ccq.isDirectory())
			vQm92Ccq = new File(vQm92Ccq, sqbR6CTA.getName());
		if (vQm92Ccq.exists()) {
			if (!vQm92Ccq.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + ceBq90rB);
		} else {
			String gyX8sTdU = vQm92Ccq.getParent();
			if (gyX8sTdU == null)
				gyX8sTdU = System.getProperty("user.dir");
			File VzXhU9aE = new File(gyX8sTdU);
			if (!VzXhU9aE.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + gyX8sTdU);
			if (VzXhU9aE.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + gyX8sTdU);
			if (!VzXhU9aE.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + gyX8sTdU);
		}
		FileInputStream tfrCSKLt = null;
		FileOutputStream I7dSuLWc = null;
		try {
			tfrCSKLt = new FileInputStream(sqbR6CTA);
			I7dSuLWc = new FileOutputStream(vQm92Ccq);
			byte[] sDKzfe4t = new byte[4096];
			int rKWqOf5b;
			while ((rKWqOf5b = tfrCSKLt.read(sDKzfe4t)) != -1)
				I7dSuLWc.write(sDKzfe4t, 0, rKWqOf5b);
		} finally {
			if (tfrCSKLt != null)
				try {
					tfrCSKLt.close();
				} catch (IOException SNRVLNMq) {
					;
				}
			if (I7dSuLWc != null)
				try {
					I7dSuLWc.close();
				} catch (IOException jxBQAcTq) {
					;
				}
		}
		return vQm92Ccq;
	}

}