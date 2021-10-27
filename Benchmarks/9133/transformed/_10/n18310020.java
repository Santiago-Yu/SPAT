class n18310020 {
	public static String postToAddress(Map<String, String> params, String address) throws Exception {
		String data = "";
		String separator = "";
		for (String key : params.keySet()) {
			data += separator + URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(params.get(key), "UTF-8");
			separator = "&";
		}
		System.out.println("sending: " + data);
		URL url = new URL(address);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line + System.getProperty("line.separator"));
		}
		wr.close();
		rd.close();
		return sb.toString();
	}

}