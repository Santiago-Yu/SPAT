class n3236017 {
	public static void copyFile(String X9pVUD9x, String vLwYcqrT) throws IOException {
		FileChannel Tm3ncJsa = null, x3FY6paz = null;
		try {
			Tm3ncJsa = new FileInputStream(new File(X9pVUD9x)).getChannel();
			x3FY6paz = new FileOutputStream(new File(vLwYcqrT)).getChannel();
			Tm3ncJsa.transferTo(0, Tm3ncJsa.size(), x3FY6paz);
		} finally {
			if (Tm3ncJsa != null)
				Tm3ncJsa.close();
			if (x3FY6paz != null)
				x3FY6paz.close();
		}
	}

}