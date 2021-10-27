class n21368983 {
	public APIResponse update(Application mn85yO3x) throws Exception {
		APIResponse HfdUExG7 = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/application/update").openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setUseCaches(false);
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		marshaller.marshal(mn85yO3x, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()),
				new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JSONObject oh067XL0 = new JSONObject(new String(
					new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
			HfdUExG7.setDone(true);
			HfdUExG7.setMessage(unmarshaller.unmarshal(
					new MappedXMLStreamReader(oh067XL0, new MappedNamespaceConvention(new Configuration()))));
			connection.getInputStream().close();
		} else {
			HfdUExG7.setDone(false);
			HfdUExG7.setMessage("Update Application Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return HfdUExG7;
	}

}