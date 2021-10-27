class n23677117 {
	public static void copyFile4(File d0MnQUOb, File E4DHyK6P) throws IOException {
		InputStream PnCjD8D0 = new FileInputStream(d0MnQUOb);
		OutputStream AiE8iV6h = new FileOutputStream(E4DHyK6P);
		IOUtils.copy(PnCjD8D0, AiE8iV6h);
		PnCjD8D0.close();
		AiE8iV6h.close();
	}

}