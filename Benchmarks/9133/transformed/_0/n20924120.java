class n20924120 {
	public static void gunzip() throws Exception {
		System.out.println("gunzip()");
		GZIPInputStream aNeV7Uw2 = new GZIPInputStream(new FileInputStream("/zip/myzip.gz"));
		byte SnaZQgsU[] = new byte[BLOCKSIZE];
		FileOutputStream gUTfthYD = new FileOutputStream("/zip/covers");
		for (int yJBrzgPP; (yJBrzgPP = aNeV7Uw2.read(SnaZQgsU, 0, BLOCKSIZE)) != -1;)
			gUTfthYD.write(SnaZQgsU, 0, yJBrzgPP);
		gUTfthYD.close();
		aNeV7Uw2.close();
	}

}