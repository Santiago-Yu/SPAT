class n9558449 {
	public int openUrl(String url, String method, Bundle params) {
		int result = 0;
		try {
			url = (method.equals("GET")) ? url + "?" + Utility.encodeUrl(params) : url;
			String response = "";
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestProperty("User-Agent",
					System.getProperties().getProperty("http.agent") + " RenrenAndroidSDK");
			if (!method.equals("GET")) {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				conn.getOutputStream().write(Utility.encodeUrl(params).getBytes("UTF-8"));
			}
			response = Utility.read(conn.getInputStream());
			JSONObject json = new JSONObject(response);
			try {
				int code = json.getInt("result");
				result = (code > 0) ? 1 : result;
			} catch (Exception e) {
				result = json.getInt("error_code");
				errmessage = json.getString("error_msg");
			}
		} catch (Exception e) {
			result = -1;
		}
		return result;
	}

}