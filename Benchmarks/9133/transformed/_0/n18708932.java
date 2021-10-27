class n18708932 {
	public APIResponse create(User sHqkPBjO) throws Exception {
		APIResponse GipdPUmP = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/user/create").openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setUseCaches(false);
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		marshaller.marshal(sHqkPBjO, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()),
				new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JSONObject yvoNENr7 = new JSONObject(new String(
					new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
			GipdPUmP.setDone(true);
			GipdPUmP.setMessage(unmarshaller.unmarshal(
					new MappedXMLStreamReader(yvoNENr7, new MappedNamespaceConvention(new Configuration()))));
			connection.getInputStream().close();
		} else {
			GipdPUmP.setDone(false);
			GipdPUmP.setMessage("Create User Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return GipdPUmP;
	}

}