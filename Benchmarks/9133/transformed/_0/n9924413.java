class n9924413 {
	private void startOpening(final URL WMVLqSF2) {
		final WebAccessor bHOVrpJD = this;
		openerThread = new Thread() {

			public void run() {
				iStream = null;
				try {
					tryProxy = false;
					URLConnection QNJNoVNo = WMVLqSF2.openConnection();
					if (QNJNoVNo instanceof HttpURLConnection) {
						HttpURLConnection vRFI2PiH = (HttpURLConnection) QNJNoVNo;
						contentLength = vRFI2PiH.getContentLength();
					}
					InputStream vjwBs79K = QNJNoVNo.getInputStream();
					iStream = new LoggedInputStream(vjwBs79K, bHOVrpJD);
				} catch (ConnectException ycVaqlhx) {
					tryProxy = true;
					exception = ycVaqlhx;
				} catch (Exception nmYv73vG) {
					exception = nmYv73vG;
				} finally {
					if (dialog != null) {
						Thread.yield();
						dialog.setVisible(false);
					}
				}
			}
		};
		openerThread.start();
	}

}