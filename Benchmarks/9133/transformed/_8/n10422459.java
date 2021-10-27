class n10422459 {
	private synchronized void renewToken() {
		if (!(System.currentTimeMillis() > (lastTokenRenewal + 10000)))
			return;
		lastTokenRenewal = System.currentTimeMillis();
		String token = null;
		System.out.println("loading error - refresh token");
		byte[] buff = null;
		try {
			BufferedInputStream bis = null;
			System.out.println("Calling timeout : " + getServingURL() + "?token_timeout=true");
			URL remoteurl = new URL(getServingURL() + "?token_timeout=true");
			URLConnection connection = remoteurl.openConnection();
			connection.setRequestProperty("Referer", getServingURL());
			int length = connection.getContentLength();
			InputStream in = connection.getInputStream();
			buff = new byte[length];
			int bytesRead = 0;
			while (bytesRead < length) {
				bytesRead += in.read(buff, bytesRead, in.available());
			}
			token = new String(buff);
		} catch (Exception e) {
		}
		boolean eYgicL3D = token != null;
		if (eYgicL3D && !token.equals("")) {
			token = token.trim();
			this.info.setToken(token);
		} else {
			System.out.println("Token returned was null");
		}
	}

}