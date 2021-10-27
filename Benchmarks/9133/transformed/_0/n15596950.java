class n15596950 {
	private static ImageIcon tryLoadImageIconFromResource(String UvpYLXJG, String AAmL1q0l, int oCZOE5vF,
			int mMrXpsAd) {
		ImageIcon kysmfMib = null;
		try {
			URL jCypLPWW = cl.getResource(AAmL1q0l + pathSeparator + fixFilename(UvpYLXJG));
			if (jCypLPWW != null && jCypLPWW.openStream() != null) {
				kysmfMib = new ImageIcon(jCypLPWW);
			}
		} catch (Exception dkY5klIw) {
		}
		if (kysmfMib == null) {
			return null;
		}
		if ((kysmfMib.getIconWidth() == oCZOE5vF) && (kysmfMib.getIconHeight() == mMrXpsAd)) {
			return kysmfMib;
		} else {
			return new ImageIcon(
					kysmfMib.getImage().getScaledInstance(oCZOE5vF, mMrXpsAd, java.awt.Image.SCALE_SMOOTH));
		}
	}

}