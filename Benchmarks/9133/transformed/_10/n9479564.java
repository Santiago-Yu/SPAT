class n9479564 {
	public String sendGetRequest(String endpoint, String requestParameters, String username, String password)
			throws Exception {
		String result = null;
		if (endpoint.startsWith("http://")) {
			try {
				String urlStr = endpoint;
				if (requestParameters != null && requestParameters.length() > 0) {
					urlStr += "?" + requestParameters;
				}
				URL url = new URL(urlStr);
				String userPassword = username + ":" + password;
				URLConnection conn = url.openConnection();
				byte[] encoding = org.apache.commons.codec.binary.Base64.encodeBase64(userPassword.getBytes());
				String authStringEnc = new String(encoding);
				log.debug("Base64 encoded auth string: '" + authStringEnc + "'");
				conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
				StringBuffer sb = new StringBuffer();
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
				rd.close();
				result = sb.toString();
			} catch (Throwable e) {
				throw new Exception("problem issuing get to URL", e);
			}
		}
		return result;
	}

}