class n4456641 {
	private void copyFile(File srcFile, File destFile) throws IOException {
		if (!(srcFile.exists() && srcFile.isFile()))
			throw new IllegalArgumentException("Source file doesn't exist: " + srcFile.getAbsolutePath());
		FileInputStream in = new FileInputStream(srcFile);
		if (destFile.exists() && destFile.isDirectory())
			throw new IllegalArgumentException("Destination file is directory: " + destFile.getAbsolutePath());
		byte[] buffer = new byte[4096];
		FileOutputStream out = new FileOutputStream(destFile);
		int no = 0;
		try {
			while ((no = in.read(buffer)) != -1)
				out.write(buffer, 0, no);
		} finally {
			in.close();
			out.close();
		}
	}

}