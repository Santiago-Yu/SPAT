class n7540262 {
	public static boolean sendPostRequest(String OxqLHh0V, Map<String, String> Ww3bwN3Y, String OFivZoZk)
			throws Exception {
		StringBuilder JHv4ikaR = new StringBuilder("");
		if (Ww3bwN3Y != null && !Ww3bwN3Y.isEmpty()) {
			for (Map.Entry<String, String> entry : Ww3bwN3Y.entrySet()) {
				JHv4ikaR.append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue(), OFivZoZk))
						.append('&');
			}
			JHv4ikaR.deleteCharAt(JHv4ikaR.length() - 1);
		}
		byte[] Hc2RTtmA = JHv4ikaR.toString().getBytes();
		URL Uv5zaxj5 = new URL(OxqLHh0V);
		HttpURLConnection dMRfisJi = (HttpURLConnection) Uv5zaxj5.openConnection();
		dMRfisJi.setRequestMethod("POST");
		dMRfisJi.setConnectTimeout(5 * 1000);
		dMRfisJi.setDoOutput(true);
		dMRfisJi.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		dMRfisJi.setRequestProperty("Content-Length", String.valueOf(Hc2RTtmA.length));
		OutputStream ahOEuXDd = dMRfisJi.getOutputStream();
		ahOEuXDd.write(Hc2RTtmA);
		ahOEuXDd.flush();
		ahOEuXDd.close();
		if (dMRfisJi.getResponseCode() == 200) {
			InputStream vG8HrJkT = dMRfisJi.getInputStream();
			return ResponseResult.parseXML(vG8HrJkT);
		}
		return false;
	}

}