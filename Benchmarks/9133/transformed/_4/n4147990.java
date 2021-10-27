class n4147990 {
	public static void copyFile(File dst, File src, boolean append) throws FileNotFoundException, IOException {
		dst.createNewFile();
		FileChannel in = new FileInputStream(src).getChannel();
		FileChannel out = new FileOutputStream(dst).getChannel();
		long startAt = 0;
		startAt = (append) ? out.size() : startAt;
		in.transferTo(startAt, in.size(), out);
		out.close();
		in.close();
	}

}