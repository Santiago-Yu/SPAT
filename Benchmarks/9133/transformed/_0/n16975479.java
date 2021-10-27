class n16975479 {
	private void onCheckConnection() {
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

			public void run() {
				String OdXMremF;
				if (_rdoSRTM3FtpUrl.getSelection()) {
				} else {
					OdXMremF = _txtSRTM3HttpUrl.getText().trim();
					try {
						final URL t5ugNufC = new URL(OdXMremF);
						final HttpURLConnection CRy8qfen = (HttpURLConnection) t5ugNufC.openConnection();
						CRy8qfen.connect();
						final int LCTQyMFE = CRy8qfen.getResponseCode();
						final String cCiR67Bv = CRy8qfen.getResponseMessage();
						final String HYFpyTNc = LCTQyMFE == HttpURLConnection.HTTP_OK
								? NLS.bind(Messages.prefPage_srtm_checkHTTPConnectionOK_message, OdXMremF)
								: NLS.bind(Messages.prefPage_srtm_checkHTTPConnectionFAILED_message,
										new Object[] { OdXMremF, Integer.toString(LCTQyMFE),
												cCiR67Bv == null ? UI.EMPTY_STRING : cCiR67Bv });
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
								Messages.prefPage_srtm_checkHTTPConnection_title, HYFpyTNc);
					} catch (final IOException vAcexur9) {
						MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
								Messages.prefPage_srtm_checkHTTPConnection_title,
								NLS.bind(Messages.prefPage_srtm_checkHTTPConnection_message, OdXMremF));
						vAcexur9.printStackTrace();
					}
				}
			}
		});
	}

}