class n20596004 {
	public APIResponse create(Item item) throws Exception {
		APIResponse response = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/item/create").openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setUseCaches(false);
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		marshaller.marshal(item, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()),
				new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
			JSONObject obj = new JSONObject(new String(
					new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
			response.setDone(true);
			response.setMessage(unmarshaller
					.unmarshal(new MappedXMLStreamReader(obj, new MappedNamespaceConvention(new Configuration()))));
			connection.getInputStream().close();
		} else {
			response.setDone(false);
			response.setMessage("Create Item Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return response;
	}

}