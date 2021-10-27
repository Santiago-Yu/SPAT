class n6301863 {
	protected String doRawRequest(String postData) throws IOException {
		URL url = new URL(SERVICE_URL);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(postData);
		wr.flush();
		StringBuffer sb = new StringBuffer();
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		wr.close();
		rd.close();
		return sb.toString();
	}

}