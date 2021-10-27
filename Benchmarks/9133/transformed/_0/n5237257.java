class n5237257 {
	private void download(String IDgfZr79) {
		String oRCjYeqW = Activator.showSaveDialog(IDgfZr79, new String[] { ".xls" });
		if (oRCjYeqW != null) {
			InputStream XBvYOUgB = null;
			OutputStream wIpQ2gVP = null;
			try {
				XBvYOUgB = this.getClass().getResourceAsStream("/" + IDgfZr79);
				wIpQ2gVP = new FileOutputStream(oRCjYeqW);
				IOUtils.copy(XBvYOUgB, wIpQ2gVP);
			} catch (IOException f6iAK1XK) {
				Activator.showExceptionDialog(f6iAK1XK);
			} finally {
				if (XBvYOUgB != null) {
					try {
						XBvYOUgB.close();
					} catch (IOException O5sqK2ZH) {
						Activator.showExceptionDialog(O5sqK2ZH);
					}
				}
				if (wIpQ2gVP != null) {
					try {
						wIpQ2gVP.close();
					} catch (IOException KTLqFzLV) {
						Activator.showExceptionDialog(KTLqFzLV);
					}
				}
			}
		}
	}

}