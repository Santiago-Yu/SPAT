class n10422459 {
	private synchronized void renewToken() {
		if (!(System.currentTimeMillis() > (lastTokenRenewal + 10000)))
			return;
		String token = null;
		lastTokenRenewal = System.currentTimeMillis();
		System.out.println("loading error - refresh token");
		byte[] buff = null;
		try {
			BufferedInputStream bis = null;
			System.out.println("Calling timeout : " + getServingURL() + "?token_timeout=true");
			URL remoteurl = new URL(getServingURL() + "?token_timeout=true");
			URLConnection connection = remoteurl.openConnection();
			connection.setRequestProperty("Referer", getServingURL());
			int length = connection.getContentLength();
			buff = new byte[length];
			InputStream in = connection.getInputStream();
			int bytesRead = 0;
			while (bytesRead < length) {
				bytesRead += in.read(buff, bytesRead, in.available());
			}
			token = new String(buff);
		} catch (Exception e) {
		}
		if (token != null && !token.equals("")) {
			token = token.trim();
			this.info.setToken(token);
		} else {
			System.out.println("Token returned was null");
		}
	}

}