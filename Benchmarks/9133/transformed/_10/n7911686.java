class n7911686 {
	public static void copyFile(File source, File destination) throws IOException {
		FileChannel out = null;
		FileChannel in = null;
		try {
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(destination).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}