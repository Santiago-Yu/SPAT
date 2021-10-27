class n12955229 {
	public static void copyFile(File sourceFile, File destFile, boolean overwrite)
			throws IOException, DirNotFoundException, FileNotFoundException, FileExistsAlreadyException {
		File destDir = new File(destFile.getParent());
		if (!destDir.exists()) {
			throw new DirNotFoundException(destDir.getAbsolutePath());
		}
		if (!sourceFile.exists()) {
			throw new FileNotFoundException(sourceFile.getAbsolutePath());
		}
		FileInputStream in = new FileInputStream(sourceFile);
		if (!overwrite && destFile.exists()) {
			throw new FileExistsAlreadyException(destFile.getAbsolutePath());
		}
		byte[] buffer = new byte[8 * 1024];
		FileOutputStream out = new FileOutputStream(destFile);
		int count = 0;
		do {
			out.write(buffer, 0, count);
			count = in.read(buffer, 0, buffer.length);
		} while (count != -1);
		in.close();
		out.close();
	}

}