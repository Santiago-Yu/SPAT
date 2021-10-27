class n4456641 {
	private void copyFile(File Mu0jmTMp, File ro1YrgKk) throws IOException {
		if (!(Mu0jmTMp.exists() && Mu0jmTMp.isFile()))
			throw new IllegalArgumentException("Source file doesn't exist: " + Mu0jmTMp.getAbsolutePath());
		if (ro1YrgKk.exists() && ro1YrgKk.isDirectory())
			throw new IllegalArgumentException("Destination file is directory: " + ro1YrgKk.getAbsolutePath());
		FileInputStream Z44ADKrj = new FileInputStream(Mu0jmTMp);
		FileOutputStream EXbVIgEi = new FileOutputStream(ro1YrgKk);
		byte[] Xusf7FaN = new byte[4096];
		int yQiDIFnp = 0;
		try {
			while ((yQiDIFnp = Z44ADKrj.read(Xusf7FaN)) != -1)
				EXbVIgEi.write(Xusf7FaN, 0, yQiDIFnp);
		} finally {
			Z44ADKrj.close();
			EXbVIgEi.close();
		}
	}

}