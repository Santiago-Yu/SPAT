class n14879478 {
	public static void copyFile(File src, File dst) throws IOException {
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dst));
		BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
		int count = 0;
		byte[] buf = new byte[1024];
		while ((count = is.read(buf, 0, 1024)) != -1)
			os.write(buf, 0, count);
		is.close();
		os.close();
	}

}