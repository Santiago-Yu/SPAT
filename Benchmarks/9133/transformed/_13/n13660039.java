class n13660039 {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			PrintUtil.prt("arguments: sourcefile, destfile");
			System.exit(1);
		}
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		FileChannel in = new FileInputStream(args[0]).getChannel();
		in.transferTo(0, in.size(), out);
	}

}