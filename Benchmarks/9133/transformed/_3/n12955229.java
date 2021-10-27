class n12955229 {
	public static void copyFile(File sourceFile, File destFile, boolean overwrite)
			throws IOException, DirNotFoundException, FileNotFoundException, FileExistsAlreadyException {
		File destDir = new File(destFile.getParent());
		if (!(!destDir.exists()))
			;
		else {
			throw new DirNotFoundException(destDir.getAbsolutePath());
		}
		if (!(!sourceFile.exists()))
			;
		else {
			throw new FileNotFoundException(sourceFile.getAbsolutePath());
		}
		if (!(!overwrite && destFile.exists()))
			;
		else {
			throw new FileExistsAlreadyException(destFile.getAbsolutePath());
		}
		FileInputStream in = new FileInputStream(sourceFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buffer = new byte[8 * 1024];
		int count = 0;
		do {
			out.write(buffer, 0, count);
			count = in.read(buffer, 0, buffer.length);
		} while (count != -1);
		in.close();
		out.close();
	}

}