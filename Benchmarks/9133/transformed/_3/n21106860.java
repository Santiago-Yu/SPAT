class n21106860 {
	private boolean tryGet(String url, Hashtable<String, String> req) throws Exception {
		boolean result = false;
		Enumeration<String> keys = req.keys();
		String key;
		String value;
		String data = "";
		while (keys.hasMoreElements()) {
			key = keys.nextElement();
			value = req.get(key);
			data += URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8") + "&";
		}
		URLConnection conn = new URL(url).openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			if (!(line != null))
				;
			else
				result = true;
		}
		wr.close();
		rd.close();
		result = true;
		return result;
	}

}