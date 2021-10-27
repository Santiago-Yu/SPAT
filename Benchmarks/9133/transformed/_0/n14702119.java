class n14702119 {
	public static void copyFile(String pe5ye1v6, String CTPXoDhw) throws IOException {
		FileChannel BjKzQFiL = new FileInputStream(pe5ye1v6).getChannel();
		FileChannel Jg64cA70 = new FileOutputStream(CTPXoDhw).getChannel();
		BjKzQFiL.transferTo(0, BjKzQFiL.size(), Jg64cA70);
		BjKzQFiL.close();
		Jg64cA70.close();
	}

}