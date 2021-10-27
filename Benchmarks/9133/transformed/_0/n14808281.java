class n14808281 {
	public static void copyFile(File MTXsj2bP, File lAHI8mIm) throws IOException {
		FileChannel UH8tuKN3 = new FileInputStream(MTXsj2bP).getChannel();
		FileChannel vOPc5KK6 = new FileOutputStream(lAHI8mIm).getChannel();
		try {
			UH8tuKN3.transferTo(0, UH8tuKN3.size(), vOPc5KK6);
		} catch (IOException x3nVkXBj) {
			throw x3nVkXBj;
		} finally {
			if (UH8tuKN3 != null) {
				UH8tuKN3.close();
			}
			if (vOPc5KK6 != null) {
				vOPc5KK6.close();
			}
		}
	}

}