class n3053403 {
	public static void main(String[] hV6LIVRk) throws Exception {
		FileChannel hUnLFAfS = new FileOutputStream("data2.txt").getChannel();
		hUnLFAfS.write(ByteBuffer.wrap("Some text".getBytes()));
		hUnLFAfS.close();
		hUnLFAfS = new FileInputStream("data2.txt").getChannel();
		ByteBuffer sWXuGXU5 = ByteBuffer.allocate(BSIZE);
		hUnLFAfS.read(sWXuGXU5);
		sWXuGXU5.flip();
		System.out.println(sWXuGXU5.asCharBuffer());
		sWXuGXU5.rewind();
		String j3OD7hqa = System.getProperty("file.encoding");
		System.out.println("Decoded using " + j3OD7hqa + ": " + Charset.forName(j3OD7hqa).decode(sWXuGXU5));
		hUnLFAfS = new FileOutputStream("data2.txt").getChannel();
		hUnLFAfS.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		hUnLFAfS.close();
		hUnLFAfS = new FileInputStream("data2.txt").getChannel();
		sWXuGXU5.clear();
		hUnLFAfS.read(sWXuGXU5);
		sWXuGXU5.flip();
		System.out.println(sWXuGXU5.asCharBuffer());
		hUnLFAfS = new FileOutputStream("data2.txt").getChannel();
		sWXuGXU5 = ByteBuffer.allocate(24);
		sWXuGXU5.asCharBuffer().put("Some text");
		hUnLFAfS.write(sWXuGXU5);
		hUnLFAfS.close();
		hUnLFAfS = new FileInputStream("data2.txt").getChannel();
		sWXuGXU5.clear();
		hUnLFAfS.read(sWXuGXU5);
		sWXuGXU5.flip();
		System.out.println(sWXuGXU5.asCharBuffer());
	}

}