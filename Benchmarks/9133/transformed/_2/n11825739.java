class n11825739 {
	public static void copyFile(String from, String to, boolean append) throws IOException {
		FileChannel in = new FileInputStream(from).getChannel();
		FileChannel out = new FileOutputStream(to, append).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		for (; in.read(buffer) != -1;) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
	}

}