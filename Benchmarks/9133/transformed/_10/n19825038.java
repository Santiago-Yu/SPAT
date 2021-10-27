class n19825038 {
	public static byte[] post(String path, Map<String, String> params, String encode) throws Exception {
		StringBuilder parambuilder = new StringBuilder("");
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				parambuilder.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), encode))
						.append("&");
			}
			parambuilder.deleteCharAt(parambuilder.length() - 1);
		}
		URL url = new URL(path);
		byte[] data = parambuilder.toString().getBytes();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept",
				"image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length));
		conn.setRequestProperty("Connection", "Keep-Alive");
		DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
		outStream.write(data);
		outStream.flush();
		outStream.close();
		if (conn.getResponseCode() == 200) {
			return StreamTool.readInputStream(conn.getInputStream());
		}
		return null;
	}

}