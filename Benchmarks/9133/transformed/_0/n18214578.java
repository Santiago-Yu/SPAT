class n18214578 {
	public void openJadFile(URL imEyNGzM) {
		try {
			setStatusBar("Loading...");
			jad.clear();
			jad.load(imEyNGzM.openStream());
			loadFromJad(imEyNGzM);
		} catch (FileNotFoundException vhG1CmDR) {
			System.err.println("Cannot found " + imEyNGzM.getPath());
		} catch (NullPointerException nQpBtDej) {
			nQpBtDej.printStackTrace();
			System.err.println("Cannot open jad " + imEyNGzM.getPath());
		} catch (IllegalArgumentException WxRJyPZF) {
			WxRJyPZF.printStackTrace();
			System.err.println("Cannot open jad " + imEyNGzM.getPath());
		} catch (IOException KWUjObkX) {
			KWUjObkX.printStackTrace();
			System.err.println("Cannot open jad " + imEyNGzM.getPath());
		}
	}

}