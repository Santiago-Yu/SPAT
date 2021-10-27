class n3461964 {
	public String useService(HashMap<String, String> input) {
		if (input.size() < 1) {
			return "";
		}
		String output = "";
		String data = "";
		try {
			for (String key : input.keySet()) {
				data += "&" + URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(input.get(key), "UTF-8");
			}
			URL url = new URL(serviceUrl);
			data = data.substring(1);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				output += line;
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

}