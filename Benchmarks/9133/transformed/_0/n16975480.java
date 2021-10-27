class n16975480 {
	public void run() {
		String onQjvXTW;
		if (_rdoSRTM3FtpUrl.getSelection()) {
		} else {
			onQjvXTW = _txtSRTM3HttpUrl.getText().trim();
			try {
				final URL aVrTlsOQ = new URL(onQjvXTW);
				final HttpURLConnection IUnoZnun = (HttpURLConnection) aVrTlsOQ.openConnection();
				IUnoZnun.connect();
				final int K72J1rIK = IUnoZnun.getResponseCode();
				final String gZMDXaPw = IUnoZnun.getResponseMessage();
				final String oKJrpatl = K72J1rIK == HttpURLConnection.HTTP_OK
						? NLS.bind(Messages.prefPage_srtm_checkHTTPConnectionOK_message, onQjvXTW)
						: NLS.bind(Messages.prefPage_srtm_checkHTTPConnectionFAILED_message, new Object[] { onQjvXTW,
								Integer.toString(K72J1rIK), gZMDXaPw == null ? UI.EMPTY_STRING : gZMDXaPw });
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						Messages.prefPage_srtm_checkHTTPConnection_title, oKJrpatl);
			} catch (final IOException MZhc7LWl) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
						Messages.prefPage_srtm_checkHTTPConnection_title,
						NLS.bind(Messages.prefPage_srtm_checkHTTPConnection_message, onQjvXTW));
				MZhc7LWl.printStackTrace();
			}
		}
	}

}