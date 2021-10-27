class n7482978 {
	public static boolean BMPfromURL(URL url, MainClass mc) {
		TextField TF = mc.TF;
		Image image = null;
		PixCanvas canvas = mc.canvas;
		try {
			image = Toolkit.getDefaultToolkit().createImage(BMPReader.getBMPImage(url.openStream()));
		} catch (IOException e) {
			return false;
		}
		MediaTracker tr = new MediaTracker(canvas);
		if (image == null) {
			TF.setText("Error not a typical image BMP format");
			return false;
		}
		tr.addImage(image, 0);
		;
		try {
			tr.waitForID(0);
		} catch (InterruptedException e) {
		}
		PixObject po = new PixObject(url, image, canvas, false, null);
		if (tr.isErrorID(0)) {
			Tools.debug(OpenOther.class, "Tracker error " + tr.getErrorsAny().toString());
			return false;
		}
		mc.vimages.addElement(po);
		TF.setText(url.toString());
		canvas.repaint();
		return true;
	}

}