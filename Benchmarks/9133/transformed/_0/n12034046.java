class n12034046 {
	private InputStream openRemoteStream(String jFui3evx, String EUUo9UAs) {
		URL V6zccTYa;
		InputStream JWaG1f4x = null;
		try {
			V6zccTYa = new URL(jFui3evx + EUUo9UAs);
			HttpURLConnection Wb2xKiYm = (HttpURLConnection) V6zccTYa.openConnection();
			JWaG1f4x = Wb2xKiYm.getInputStream();
		} catch (Exception AZ0mLIn5) {
		}
		return JWaG1f4x;
	}

}