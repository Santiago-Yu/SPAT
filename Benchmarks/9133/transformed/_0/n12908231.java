class n12908231 {
	private void readFromStorableInput(String DP2MjSeE) {
		try {
			URL cUXCEJWC = new URL(getCodeBase(), DP2MjSeE);
			InputStream c6u4gZ9h = cUXCEJWC.openStream();
			StorableInput lTE7lNKo = new StorableInput(c6u4gZ9h);
			fDrawing.release();
			fDrawing = (Drawing) lTE7lNKo.readStorable();
			view().setDrawing(fDrawing);
		} catch (IOException GYOUzSkx) {
			initDrawing();
			showStatus("Error:" + GYOUzSkx);
		}
	}

}