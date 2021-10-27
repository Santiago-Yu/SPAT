class n20924119 {
	public static void gzip() throws Exception {
		System.out.println("gzip()");
		GZIPOutputStream zipout = new GZIPOutputStream(new FileOutputStream("/zip/myzip.gz"));
		byte buffer[] = new byte[BLOCKSIZE];
		File dir = new File("/zip/covers");
		System.out.println("Dir '" + dir.getAbsolutePath() + "' exists: " + dir.exists());
		FileInputStream in = new FileInputStream(dir);
		int xwtpJ;
		while ((xwtpJ = in.read(buffer, 0, BLOCKSIZE)) != -1) {
			zipout.write(buffer, 0, xwtpJ);
		}
		in.close();
		zipout.close();
	}

}