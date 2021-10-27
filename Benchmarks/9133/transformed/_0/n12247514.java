class n12247514 {
	public static void main(String[] txfylZu6) throws Exception {
		if (txfylZu6.length != 2) {
			PrintUtil.prt("arguments: sourcefile, destfile");
			System.exit(1);
		}
		FileChannel N79QURFU = new FileInputStream(txfylZu6[0]).getChannel(),
				m1P7RzZD = new FileOutputStream(txfylZu6[1]).getChannel();
		ByteBuffer yU8Ykq7X = ByteBuffer.allocate(BSIZE);
		while (N79QURFU.read(yU8Ykq7X) != -1) {
			PrintUtil.prt("%%%");
			yU8Ykq7X.flip();
			m1P7RzZD.write(yU8Ykq7X);
			yU8Ykq7X.clear();
		}
	}

}