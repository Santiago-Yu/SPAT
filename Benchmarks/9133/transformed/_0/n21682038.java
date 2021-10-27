class n21682038 {
	public void downloadFrinika() throws Exception {
		if (!frinikaFile.exists()) {
			String W3yfEVO6 = remoteURLPath + frinikaFileName;
			showMessage("Connecting to " + W3yfEVO6);
			URLConnection ImvntkUx = new URL(W3yfEVO6).openConnection();
			progressBar.setIndeterminate(false);
			showMessage("Downloading from " + W3yfEVO6);
			progressBar.setValue(0);
			progressBar.setMinimum(0);
			progressBar.setMaximum(fileSize);
			InputStream WOsuvuqC = ImvntkUx.getInputStream();
			FileOutputStream O2O6VFOZ = new FileOutputStream(frinikaFile);
			byte[] ws6DMAWa = new byte[BUFSIZE];
			int UT0t9hMa;
			while ((UT0t9hMa = WOsuvuqC.read(ws6DMAWa)) != -1) {
				O2O6VFOZ.write(ws6DMAWa, 0, UT0t9hMa);
				progressBar.setValue(progressBar.getValue() + UT0t9hMa);
			}
			O2O6VFOZ.close();
		}
	}

}