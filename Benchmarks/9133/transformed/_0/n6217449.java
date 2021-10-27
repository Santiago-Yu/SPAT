class n6217449 {
	private void copyFile(File Jitvmnky) throws IOException {
		File loV6EdC0 = new File(Jitvmnky.getCanonicalPath() + ".backup");
		if (!loV6EdC0.exists()) {
			FileChannel guCH7HRR = new FileInputStream(Jitvmnky).getChannel();
			loV6EdC0.createNewFile();
			FileChannel f6UZYzTO = new FileOutputStream(loV6EdC0).getChannel();
			f6UZYzTO.transferFrom(guCH7HRR, 0, guCH7HRR.size());
			guCH7HRR.close();
			f6UZYzTO.close();
		}
	}

}