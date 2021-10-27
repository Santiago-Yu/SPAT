class n4721547 {
	public static void main(String[] args) throws Exception {
		String infile = "C:\\copy.sql";
		FileInputStream fin = new FileInputStream(infile);
		String outfile = "C:\\copy.txt";
		FileChannel fcin = fin.getChannel();
		FileOutputStream fout = new FileOutputStream(outfile);
		FileChannel fcout = fout.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			buffer.clear();
			int r = fcin.read(buffer);
			if (r == -1) {
				break;
			}
			buffer.flip();
			fcout.write(buffer);
		}
	}

}