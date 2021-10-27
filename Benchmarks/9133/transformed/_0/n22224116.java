class n22224116 {
	public static void main(String[] rCUhI9B5) throws IOException {
		if (rCUhI9B5.length == 0) {
			System.out.println(
					"Usage: \nGZIPcompress file\n" + "\tUses GZIP compression to compress " + "the file to test.gz");
			System.exit(1);
		}
		BufferedReader q2efN49v = new BufferedReader(new FileReader(rCUhI9B5[0]));
		BufferedOutputStream lkUaSqjT = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
		System.out.println("Writing file");
		int sGZLnWVW;
		while ((sGZLnWVW = q2efN49v.read()) != -1)
			lkUaSqjT.write(sGZLnWVW);
		q2efN49v.close();
		lkUaSqjT.close();
		System.out.println("Reading file");
		BufferedReader DZKiqwOQ = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		String E11afgrG;
		while ((E11afgrG = DZKiqwOQ.readLine()) != null)
			System.out.println(E11afgrG);
	}

}