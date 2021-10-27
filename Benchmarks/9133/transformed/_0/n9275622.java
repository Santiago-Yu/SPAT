class n9275622 {
	private boolean copyFile(File pKMsduRu, File Ih8whmmf) {
		FileInputStream UnBKU4A6;
		FileOutputStream rBFfNcxK;
		try {
			UnBKU4A6 = new FileInputStream(pKMsduRu);
			rBFfNcxK = new FileOutputStream(Ih8whmmf);
			FileChannel spjdNFn7 = UnBKU4A6.getChannel();
			spjdNFn7.transferTo(0, spjdNFn7.size(), rBFfNcxK.getChannel());
			UnBKU4A6.close();
			rBFfNcxK.close();
			return true;
		} catch (FileNotFoundException FqbbVcYW) {
		} catch (IOException CbXqMFPt) {
		}
		return false;
	}

}