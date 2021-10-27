class n3928959 {
	public static void copyFile(File from, File to) throws IOException {
		FileOutputStream out = null;
		FileInputStream in = null;
		try {
			out = new FileOutputStream(to);
			in = new FileInputStream(from);
			int len = 0;
			byte[] bytes = new byte[1024 * 4];
			while ((len = in.read(bytes)) >= 0)
				out.write(bytes, 0, len);
		} finally {
			Streams.closeQuietly(in);
			Streams.closeQuietly(out);
		}
	}

}