class n3946138 {
	public static void main(String U6u0TlXq[]) throws Exception {
		FileInputStream defaWYWB = new FileInputStream("D:/work/test.txt");
		FileOutputStream McAZ9hu9 = new FileOutputStream("D:/work/output.txt");
		FileChannel CsevjLy9 = defaWYWB.getChannel();
		FileChannel c02JRqtt = McAZ9hu9.getChannel();
		ByteBuffer KuCYM69e = ByteBuffer.allocate(1024);
		while (true) {
			int iZdEp2Ow = CsevjLy9.read(KuCYM69e);
			if (iZdEp2Ow == -1)
				break;
			KuCYM69e.flip();
			c02JRqtt.write(KuCYM69e);
			KuCYM69e.clear();
		}
	}

}