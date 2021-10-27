class n10959933 {
	public static void main(String[] paVTShoQ) throws Exception {
		FileChannel UL9mbH9c = new FileOutputStream("data.txt").getChannel();
		UL9mbH9c.write(ByteBuffer.wrap("some text ".getBytes()));
		UL9mbH9c.close();
		UL9mbH9c = new RandomAccessFile("data.txt", "rw").getChannel();
		UL9mbH9c.position(UL9mbH9c.size());
		UL9mbH9c.write(ByteBuffer.wrap("some more".getBytes()));
		UL9mbH9c.close();
		UL9mbH9c = new FileInputStream("data.txt").getChannel();
		ByteBuffer EEf7rjly = ByteBuffer.allocate(BSIZE);
		UL9mbH9c.read(EEf7rjly);
		EEf7rjly.flip();
		while (EEf7rjly.hasRemaining()) {
			PrintUtil.prt((char) EEf7rjly.get());
		}
	}

}