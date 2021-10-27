class n3551701 {
	public static void copyFile(File src, File dst) throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		fos = new FileOutputStream(dst);
		fis = new FileInputStream(src);
		int read = 0;
		byte[] buffer = new byte[16384];
		while ((read = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, read);
		}
		fis.close();
		fos.flush();
		fos.close();
	}

}