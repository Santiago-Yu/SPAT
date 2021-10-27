class n23439557 {
	public static void main(String[] JCV8wjqB) throws Exception {
		if (JCV8wjqB.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel GWWXWWF2 = new FileInputStream(JCV8wjqB[0]).getChannel(),
				czkJGREY = new FileOutputStream(JCV8wjqB[1]).getChannel();
		GWWXWWF2.transferTo(0, GWWXWWF2.size(), czkJGREY);
	}

}