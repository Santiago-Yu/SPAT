class n20924120 {
	public static void gunzip() throws Exception {
		System.out.println("gunzip()");
		byte buffer[] = new byte[BLOCKSIZE];
		GZIPInputStream zipin = new GZIPInputStream(new FileInputStream("/zip/myzip.gz"));
		FileOutputStream out = new FileOutputStream("/zip/covers");
		for (int length; (length = zipin.read(buffer, 0, BLOCKSIZE)) != -1;)
			out.write(buffer, 0, length);
		out.close();
		zipin.close();
	}

}