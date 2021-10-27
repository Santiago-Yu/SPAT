class n9398454 {
	private static RemoteFile getRemoteFile(String OovQr6Qr) {
		long mrMuYYaY = 0;
		String i2zt5A13 = "";
		try {
			HttpURLConnection zfalw1BG = (HttpURLConnection) (new URL(OovQr6Qr)).openConnection();
			mrMuYYaY = zfalw1BG.getContentLength();
			i2zt5A13 = zfalw1BG.getURL().toString();
			zfalw1BG.disconnect();
		} catch (Exception KmmiCKcu) {
			KmmiCKcu.printStackTrace();
		}
		RemoteFile xlNLkOrQ = new RemoteFile(mrMuYYaY, i2zt5A13);
		return xlNLkOrQ;
	}

}