class n21368981 {
	public APIResponse create(Application IluiVGMt) throws Exception {
		APIResponse j1NXYZvc = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/application/create").openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setUseCaches(false);
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		marshaller.marshal(IluiVGMt, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()),
				new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JSONObject sz9T0XIO = new JSONObject(new String(
					new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
			j1NXYZvc.setDone(true);
			j1NXYZvc.setMessage(unmarshaller.unmarshal(
					new MappedXMLStreamReader(sz9T0XIO, new MappedNamespaceConvention(new Configuration()))));
			connection.getInputStream().close();
		} else {
			j1NXYZvc.setDone(false);
			j1NXYZvc.setMessage("Create Application Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return j1NXYZvc;
	}

}