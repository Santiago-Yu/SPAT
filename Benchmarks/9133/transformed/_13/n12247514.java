class n12247514 {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			PrintUtil.prt("arguments: sourcefile, destfile");
			System.exit(1);
		}
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		FileChannel in = new FileInputStream(args[0]).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		while (in.read(buff) != -1) {
			PrintUtil.prt("%%%");
			buff.flip();
			out.write(buff);
			buff.clear();
		}
	}

}