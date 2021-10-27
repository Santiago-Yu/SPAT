class n12908232 {
	private void readFromObjectInput(String ZzOawLFT) {
		try {
			URL pL2QP5Ip = new URL(getCodeBase(), ZzOawLFT);
			InputStream HZWwRepy = pL2QP5Ip.openStream();
			ObjectInput Yt0CvXpb = new ObjectInputStream(HZWwRepy);
			fDrawing.release();
			fDrawing = (Drawing) Yt0CvXpb.readObject();
			view().setDrawing(fDrawing);
		} catch (IOException CkLFGziL) {
			initDrawing();
			showStatus("Error: " + CkLFGziL);
		} catch (ClassNotFoundException fIdwjm47) {
			initDrawing();
			showStatus("Class not found: " + fIdwjm47);
		}
	}

}