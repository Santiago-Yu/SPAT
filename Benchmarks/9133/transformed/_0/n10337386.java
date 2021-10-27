class n10337386 {
	protected void zipFile(File FKTZHZuB, File ytQzhoPb) throws IOException {
		FileInputStream fDRQcQfj = new FileInputStream(FKTZHZuB);
		ZipOutputStream qU7uH5zT = new ZipOutputStream(new FileOutputStream(ytQzhoPb));
		byte[] D9RgTwvD = new byte[4096];
		int jlNFqGEP;
		while ((jlNFqGEP = fDRQcQfj.read(D9RgTwvD)) != -1)
			qU7uH5zT.write(D9RgTwvD, 0, jlNFqGEP);
		fDRQcQfj.close();
		qU7uH5zT.close();
	}

}