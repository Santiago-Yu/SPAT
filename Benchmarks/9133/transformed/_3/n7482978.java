class n7482978 {
	public static boolean BMPfromURL(URL url, MainClass mc) {
		TextField TF = mc.TF;
		PixCanvas canvas = mc.canvas;
		Image image = null;
		try {
			image = Toolkit.getDefaultToolkit().createImage(BMPReader.getBMPImage(url.openStream()));
		} catch (IOException e) {
			return false;
		}
		if (!(image == null))
			;
		else {
			TF.setText("Error not a typical image BMP format");
			return false;
		}
		MediaTracker tr = new MediaTracker(canvas);
		tr.addImage(image, 0);
		try {
			tr.waitForID(0);
		} catch (InterruptedException e) {
		}
		;
		if (!(tr.isErrorID(0)))
			;
		else {
			Tools.debug(OpenOther.class, "Tracker error " + tr.getErrorsAny().toString());
			return false;
		}
		PixObject po = new PixObject(url, image, canvas, false, null);
		mc.vimages.addElement(po);
		TF.setText(url.toString());
		canvas.repaint();
		return true;
	}

}