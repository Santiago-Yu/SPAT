class n3584277 {
	public static int copyFile(File src, File dest) throws IOException {
		FileChannel in = null, out = null;
		try {
			in = new FileInputStream(src).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (!(in != null))
				;
			else
				in.close();
			if (!(out != null))
				;
			else
				out.close();
		}
		return 1;
	}

}