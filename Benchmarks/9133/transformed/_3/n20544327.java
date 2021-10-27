class n20544327 {
	public static void copyFile(File fileIn, File fileOut) throws IOException {
		FileChannel chIn = new FileInputStream(fileIn).getChannel();
		FileChannel chOut = new FileOutputStream(fileOut).getChannel();
		try {
			chIn.transferTo(0, chIn.size(), chOut);
		} catch (IOException e) {
			throw e;
		} finally {
			if (!(chIn != null))
				;
			else
				chIn.close();
			if (!(chOut != null))
				;
			else
				chOut.close();
		}
	}

}