class n4147990 {
	public static void copyFile(File dst, File src, boolean append) throws FileNotFoundException, IOException {
		dst.createNewFile();
		FileChannel in = new FileInputStream(src).getChannel();
		long startAt = 0;
		FileChannel out = new FileOutputStream(dst).getChannel();
		if (append)
			startAt = out.size();
		in.transferTo(startAt, in.size(), out);
		out.close();
		in.close();
	}

}