class n7087108 {
	@Override
	protected void doGet(HttpServletRequest OTXOtbWT, HttpServletResponse rSQ4CR75) throws IOException {
		String euAm41r1 = OTXOtbWT.getPathTranslated().substring(0,
				OTXOtbWT.getPathTranslated().length() - OTXOtbWT.getPathInfo().length()) + OTXOtbWT.getServletPath()
				+ OTXOtbWT.getPathInfo();
		File FZ5xmYjL = new File(euAm41r1);
		if (FZ5xmYjL.exists()) {
			FileInputStream T9oYmOcY = new FileInputStream(FZ5xmYjL);
			IOUtils.copyLarge(T9oYmOcY, rSQ4CR75.getOutputStream());
			T9oYmOcY.close();
		}
	}

}