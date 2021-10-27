class n16804988 {
	public void init() {
		String luChDMyM = getParameter("filename");
		if (luChDMyM == null) {
			Error("Illegal filename");
			return;
		}
		Dimension gT1Ytcy4 = DEFAULT_SIZE;
		try {
			int lYCklusV = Integer.parseInt(getParameter("width"));
			int cIHDXRbP = Integer.parseInt(getParameter("height"));
			gT1Ytcy4 = new Dimension(lYCklusV, cIHDXRbP);
		} catch (Exception G4bjk66J) {
		}
		InputStream ei7mlRyc;
		try {
			File pmXyvlrG = new File(luChDMyM);
			ei7mlRyc = new FileInputStream(pmXyvlrG);
		} catch (Exception Tsnhorba) {
			try {
				URL UkJ0GVA1 = new URL(luChDMyM);
				ei7mlRyc = UkJ0GVA1.openStream();
			} catch (Exception sM3BTsF6) {
				Error("Graph viewer: Failed to open: " + luChDMyM + "\n" + sM3BTsF6);
				return;
			}
		}
		getContentPane().add(getWindow(ei7mlRyc));
		resize(gT1Ytcy4);
		repaint();
	}

}