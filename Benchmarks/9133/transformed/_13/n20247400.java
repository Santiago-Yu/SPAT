class n20247400 {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		FileChannel in = new FileInputStream(args[0]).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
	}

}