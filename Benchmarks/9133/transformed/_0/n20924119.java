class n20924119 {
	public static void gzip() throws Exception {
		System.out.println("gzip()");
		GZIPOutputStream qn8vRgPo = new GZIPOutputStream(new FileOutputStream("/zip/myzip.gz"));
		byte oxW0iQBL[] = new byte[BLOCKSIZE];
		File Z5OxxCzr = new File("/zip/covers");
		System.out.println("Dir '" + Z5OxxCzr.getAbsolutePath() + "' exists: " + Z5OxxCzr.exists());
		FileInputStream CNn63qGd = new FileInputStream(Z5OxxCzr);
		for (int qiKVhxme; (qiKVhxme = CNn63qGd.read(oxW0iQBL, 0, BLOCKSIZE)) != -1;)
			qn8vRgPo.write(oxW0iQBL, 0, qiKVhxme);
		CNn63qGd.close();
		qn8vRgPo.close();
	}

}