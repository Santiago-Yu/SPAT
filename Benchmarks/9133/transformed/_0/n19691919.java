class n19691919 {
	public static void main(String[] PZ0jd3TI) throws IOException {
		FileChannel EQFBMeFN = new FileOutputStream("src/com/aaron/nio/data.txt").getChannel();
		EQFBMeFN.write(ByteBuffer.wrap("dfsdf ".getBytes()));
		EQFBMeFN.close();
		EQFBMeFN = new RandomAccessFile("src/com/aaron/nio/data.txt", "rw").getChannel();
		EQFBMeFN.position(EQFBMeFN.size());
		EQFBMeFN.write(ByteBuffer.wrap("ÖÐÎÄµÄ ".getBytes()));
		EQFBMeFN.close();
		EQFBMeFN = new FileInputStream("src/com/aaron/nio/data.txt").getChannel();
		ByteBuffer NPFxPcIg = ByteBuffer.allocate(1024);
		EQFBMeFN.read(NPFxPcIg);
		NPFxPcIg.flip();
		while (NPFxPcIg.hasRemaining()) {
			System.out.print(NPFxPcIg.getChar());
		}
		EQFBMeFN.close();
	}

}