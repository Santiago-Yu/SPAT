class n7482978 {
	public static boolean BMPfromURL(URL AuTkTI4q, MainClass niUgN7Yy) {
		TextField GL28G3Dc = niUgN7Yy.TF;
		PixCanvas t3CCG3XI = niUgN7Yy.canvas;
		Image oEaU5g7o = null;
		try {
			oEaU5g7o = Toolkit.getDefaultToolkit().createImage(BMPReader.getBMPImage(AuTkTI4q.openStream()));
		} catch (IOException By9x7mFF) {
			return false;
		}
		if (oEaU5g7o == null) {
			GL28G3Dc.setText("Error not a typical image BMP format");
			return false;
		}
		MediaTracker LSBDJ71j = new MediaTracker(t3CCG3XI);
		LSBDJ71j.addImage(oEaU5g7o, 0);
		try {
			LSBDJ71j.waitForID(0);
		} catch (InterruptedException DeSlRRke) {
		}
		;
		if (LSBDJ71j.isErrorID(0)) {
			Tools.debug(OpenOther.class, "Tracker error " + LSBDJ71j.getErrorsAny().toString());
			return false;
		}
		PixObject HR2xC8dX = new PixObject(AuTkTI4q, oEaU5g7o, t3CCG3XI, false, null);
		niUgN7Yy.vimages.addElement(HR2xC8dX);
		GL28G3Dc.setText(AuTkTI4q.toString());
		t3CCG3XI.repaint();
		return true;
	}

}