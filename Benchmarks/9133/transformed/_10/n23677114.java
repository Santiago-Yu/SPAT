class n23677114 {
	public static void copyFile1(File srcFile, File destFile) throws IOException {
		FileInputStream fis = new FileInputStream(srcFile);

		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = fis.getChannel();

		FileOutputStream fos = new FileOutputStream(destFile);
		FileChannel destination = fos.getChannel();

		destination.transferFrom(source, 0, source.size());

		source.close();
		destination.close();

		fis.close();
		fos.close();
	}

}