class n4311563 {
	public static int sendMessage(String auth_token, String registrationId, String message) throws IOException {
		StringBuilder postDataBuilder = new StringBuilder();
		postDataBuilder.append(PARAM_REGISTRATION_ID).append("=").append(registrationId);
		postDataBuilder.append("&").append(PARAM_COLLAPSE_KEY).append("=").append("0");
		postDataBuilder.append("&").append("data.payload").append("=").append(URLEncoder.encode(message, UTF8));
		byte[] postData = postDataBuilder.toString().getBytes(UTF8);
		URL url = new URL(C2DM_SEND_ENDPOINT);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		conn.setRequestProperty("Content-Length", Integer.toString(postData.length));
		conn.setRequestProperty("Authorization", "GoogleLogin auth=" + auth_token);
		OutputStream out = conn.getOutputStream();
		out.write(postData);
		out.close();
		int responseCode = conn.getResponseCode();
		if (responseCode == HttpServletResponse.SC_UNAUTHORIZED || responseCode == HttpServletResponse.SC_FORBIDDEN) {
			AuthenticationUtil.getTokenFromServer(Util.USER, Util.PASSWORD);
			sendMessage(auth_token, registrationId, message);
		}
		String updatedAuthToken = conn.getHeaderField(UPDATE_CLIENT_AUTH);
		if (updatedAuthToken != null && !(updatedAuthToken != null && updatedAuthToken.equals(auth_token))) {
			Util.updateToken(updatedAuthToken);
		}
		return responseCode;
	}

}