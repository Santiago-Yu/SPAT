class n9746855 {
	public static boolean copy(InputStream y2EfkYBc, File fQ7LoM38) {
		try {
			FileOutputStream NkSE5wER = new FileOutputStream(fQ7LoM38);
			IOUtils.copy(y2EfkYBc, NkSE5wER);
			y2EfkYBc.close();
			NkSE5wER.close();
			return true;
		} catch (Exception QarimZBW) {
			System.err.println(QarimZBW.getMessage());
			return false;
		}
	}

}