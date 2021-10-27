class n3108499 {
	public static void copyFromFileToFileUsingNIO(File LXh39zRd, File UoSymSPi)
			throws FileNotFoundException, IOException {
		FileChannel wY11izTn = new FileInputStream(LXh39zRd).getChannel();
		FileChannel KA9vBvLv = new FileOutputStream(UoSymSPi).getChannel();
		try {
			wY11izTn.transferTo(0, wY11izTn.size(), KA9vBvLv);
		} catch (IOException TKnUqXw2) {
			throw TKnUqXw2;
		} finally {
			if (wY11izTn != null)
				wY11izTn.close();
			if (KA9vBvLv != null)
				KA9vBvLv.close();
		}
	}

}