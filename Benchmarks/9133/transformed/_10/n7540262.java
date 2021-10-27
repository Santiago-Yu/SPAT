class n7540262 {
	public static boolean sendPostRequest(String path, Map<String, String> params, String encoding) throws Exception {
		StringBuilder sb = new StringBuilder("");
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue(), encoding)).append('&');
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		URL url = new URL(path);
		byte[] data = sb.toString().getBytes();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setConnectTimeout(5 * 1000);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length));
		OutputStream outStream = conn.getOutputStream();
		outStream.write(data);
		outStream.flush();
		outStream.close();
		if (conn.getResponseCode() == 200) {
			InputStream inputStream = conn.getInputStream();
			return ResponseResult.parseXML(inputStream);
		}
		return false;
	}

}