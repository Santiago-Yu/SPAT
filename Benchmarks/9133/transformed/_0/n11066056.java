class n11066056 {
	public static void copyFile(File ImCQe3FN, File LaV099u8) throws IOException {
		FileChannel BCql5jDA = new FileInputStream(ImCQe3FN).getChannel();
		FileChannel bqEeDUcL = new FileOutputStream(LaV099u8).getChannel();
		try {
			BCql5jDA.transferTo(0, BCql5jDA.size(), bqEeDUcL);
		} catch (IOException dADm4fGN) {
			throw dADm4fGN;
		} finally {
			if (BCql5jDA != null)
				BCql5jDA.close();
			if (bqEeDUcL != null)
				bqEeDUcL.close();
		}
	}

}