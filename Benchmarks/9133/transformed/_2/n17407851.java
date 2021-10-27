class n17407851 {
	private String _doPost(final String urlStr, final Map<String, String> params) {
		String paramsStr = "";
		for (String key : params.keySet()) {
			try {
				paramsStr += URLEncoder.encode(key, ENCODING) + "=" + URLEncoder.encode(params.get(key), ENCODING)
						+ "&";
			} catch (UnsupportedEncodingException e) {
				s_logger.debug(
						"UnsupportedEncodingException caught. Trying to encode: " + key + " and " + params.get(key));
				return null;
			}
		}
		if (paramsStr.length() == 0) {
			s_logger.debug("POST will not complete, no parameters specified.");
			return null;
		}
		s_logger.debug("POST to server will be done with the following parameters: " + paramsStr);
		HttpURLConnection connection = null;
		String responseStr = null;
		try {
			connection = (HttpURLConnection) (new URL(urlStr)).openConnection();
			connection.setRequestMethod(REQUEST_METHOD);
			connection.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
			dos.write(paramsStr.getBytes());
			dos.flush();
			dos.close();
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			for (; (line = rd.readLine()) != null;) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			responseStr = response.toString();
		} catch (ProtocolException e) {
			s_logger.debug("ProtocolException caught. Unable to execute POST.");
		} catch (MalformedURLException e) {
			s_logger.debug("MalformedURLException caught. Unexpected. Url is: " + urlStr);
		} catch (IOException e) {
			s_logger.debug("IOException caught. Unable to execute POST.");
		}
		return responseStr;
	}

}