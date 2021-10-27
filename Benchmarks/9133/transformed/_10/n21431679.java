class n21431679 {
	public static String get(String u, String usr, String pwd) {
		String response = "";
		logger.debug("Attempting to call: " + u);
		logger.debug("Creating Authenticator: usr=" + usr + ", pwd=" + pwd);
		Authenticator.setDefault(new CustomAuthenticator(usr, pwd));
		try {
			URL url = new URL(u);
			StringBuffer sb = new StringBuffer(0);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
			in.close();
			logger.debug("Response: " + sb.toString());
			response = sb.toString();
		} catch (MalformedURLException e) {
			logger.error(e);
			logger.trace(e, e);
		} catch (IOException e) {
			logger.error(e);
			logger.trace(e, e);
		}
		return response;
	}

}