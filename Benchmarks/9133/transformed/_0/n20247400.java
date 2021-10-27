class n20247400 {
	public static void main(String[] Hh3CViXA) throws Exception {
		if (Hh3CViXA.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel IlikHV0n = new FileInputStream(Hh3CViXA[0]).getChannel(),
				rYegxwlS = new FileOutputStream(Hh3CViXA[1]).getChannel();
		ByteBuffer r74ggvsM = ByteBuffer.allocate(BSIZE);
		while (IlikHV0n.read(r74ggvsM) != -1) {
			r74ggvsM.flip();
			rYegxwlS.write(r74ggvsM);
			r74ggvsM.clear();
		}
	}

}