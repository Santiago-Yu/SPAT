class n14647876 {
	public static void copyFile(IPath s2xi4ktO, IPath bDQEyuO4) throws IOException {
		File XSyou18f = s2xi4ktO.toFile();
		File ftshfdhg = bDQEyuO4.toFile();
		if (!XSyou18f.exists())
			throw new IOException("FileCopy: " + "no such source file: " + s2xi4ktO);
		if (!XSyou18f.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + s2xi4ktO);
		if (!XSyou18f.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + s2xi4ktO);
		if (ftshfdhg.isDirectory())
			ftshfdhg = new File(ftshfdhg, XSyou18f.getName());
		if (ftshfdhg.exists()) {
			if (!ftshfdhg.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + bDQEyuO4);
		} else {
			String myD61cTP = ftshfdhg.getParent();
			if (myD61cTP == null)
				myD61cTP = System.getProperty("user.dir");
			File KPtwn3ms = new File(myD61cTP);
			if (!KPtwn3ms.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + myD61cTP);
			if (KPtwn3ms.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + myD61cTP);
			if (!KPtwn3ms.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + myD61cTP);
		}
		InputStream MZFfMZ35 = null;
		OutputStream oYBgPMwc = null;
		try {
			MZFfMZ35 = new BufferedInputStream(new FileInputStream(XSyou18f));
			oYBgPMwc = new BufferedOutputStream(new FileOutputStream(ftshfdhg));
			byte[] AjpdO4VQ = new byte[4096];
			int twOF4mLs;
			while ((twOF4mLs = MZFfMZ35.read(AjpdO4VQ)) != -1)
				oYBgPMwc.write(AjpdO4VQ, 0, twOF4mLs);
		} finally {
			if (MZFfMZ35 != null)
				try {
					MZFfMZ35.close();
				} catch (IOException yVmlfKN3) {
				}
			if (oYBgPMwc != null)
				try {
					oYBgPMwc.close();
				} catch (IOException YO5aIvI8) {
				}
		}
	}

}