class n3584277 {
	public static int copyFile(File src, File dest) throws IOException {
		FileChannel out = null;
		FileChannel in = null;
		try {
			in = new FileInputStream(src).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
		return 1;
	}

}