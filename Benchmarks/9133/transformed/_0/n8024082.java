class n8024082 {
	public static void main(String[] KaUDfxvZ) throws Exception {
		FileChannel BHjYvcj2 = new FileOutputStream("data.txt").getChannel();
		BHjYvcj2.write(ByteBuffer.wrap("Some text ".getBytes()));
		BHjYvcj2.close();
		BHjYvcj2 = new RandomAccessFile("data.txt", "rw").getChannel();
		BHjYvcj2.position(BHjYvcj2.size());
		BHjYvcj2.write(ByteBuffer.wrap("Some more".getBytes()));
		BHjYvcj2.close();
		BHjYvcj2 = new FileInputStream("data.txt").getChannel();
		ByteBuffer V6N3YZib = ByteBuffer.allocate(BSIZE);
		BHjYvcj2.read(V6N3YZib);
		V6N3YZib.flip();
		while (V6N3YZib.hasRemaining())
			System.out.print((char) V6N3YZib.get());
	}

}