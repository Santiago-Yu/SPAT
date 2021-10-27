class n20286589 {
	public static void copyFile(final File source, final File target) throws FileNotFoundException, IOException {
		FileChannel out = new FileOutputStream(target).getChannel();
		FileChannel in = new FileInputStream(source).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (in.read(buffer) != -1) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		out.close();
		in.close();
	}

}