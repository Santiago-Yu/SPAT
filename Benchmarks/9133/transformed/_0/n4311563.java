class n4311563 {
	public static int sendMessage(String fWwTjo0d, String sVAUXEEI, String vAt8rFzd) throws IOException {
		StringBuilder tJzy1IQ8 = new StringBuilder();
		tJzy1IQ8.append(PARAM_REGISTRATION_ID).append("=").append(sVAUXEEI);
		tJzy1IQ8.append("&").append(PARAM_COLLAPSE_KEY).append("=").append("0");
		tJzy1IQ8.append("&").append("data.payload").append("=").append(URLEncoder.encode(vAt8rFzd, UTF8));
		byte[] readbmyO = tJzy1IQ8.toString().getBytes(UTF8);
		URL OHC4kcUW = new URL(C2DM_SEND_ENDPOINT);
		HttpURLConnection kW8iPycU = (HttpURLConnection) OHC4kcUW.openConnection();
		kW8iPycU.setDoOutput(true);
		kW8iPycU.setUseCaches(false);
		kW8iPycU.setRequestMethod("POST");
		kW8iPycU.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		kW8iPycU.setRequestProperty("Content-Length", Integer.toString(readbmyO.length));
		kW8iPycU.setRequestProperty("Authorization", "GoogleLogin auth=" + fWwTjo0d);
		OutputStream CEpgGkJZ = kW8iPycU.getOutputStream();
		CEpgGkJZ.write(readbmyO);
		CEpgGkJZ.close();
		int EjUZgxdr = kW8iPycU.getResponseCode();
		if (EjUZgxdr == HttpServletResponse.SC_UNAUTHORIZED || EjUZgxdr == HttpServletResponse.SC_FORBIDDEN) {
			AuthenticationUtil.getTokenFromServer(Util.USER, Util.PASSWORD);
			sendMessage(fWwTjo0d, sVAUXEEI, vAt8rFzd);
		}
		String h94jtopO = kW8iPycU.getHeaderField(UPDATE_CLIENT_AUTH);
		if (h94jtopO != null && !fWwTjo0d.equals(h94jtopO)) {
			Util.updateToken(h94jtopO);
		}
		return EjUZgxdr;
	}

}