class n5656506 {
	private void copyFile(File BaXrTFVn, File ufRvuh2W) throws IOException {
		FileChannel NJqcyCMZ = new FileInputStream(BaXrTFVn).getChannel();
		FileChannel S3DJGB5r = new FileOutputStream(ufRvuh2W).getChannel();
		S3DJGB5r.transferFrom(NJqcyCMZ, 0, NJqcyCMZ.size());
		NJqcyCMZ.close();
		S3DJGB5r.close();
	}

}