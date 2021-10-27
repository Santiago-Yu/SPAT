class n3298868 {
	public APIResponse update(Transaction NqXcvhJq) throws Exception {
		APIResponse XzGGBrDF = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/transaction/update").openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setUseCaches(false);
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		marshaller.marshal(NqXcvhJq, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()),
				new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JSONObject ZK7DQcqI = new JSONObject(new String(
					new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
			XzGGBrDF.setDone(true);
			XzGGBrDF.setMessage(unmarshaller.unmarshal(
					new MappedXMLStreamReader(ZK7DQcqI, new MappedNamespaceConvention(new Configuration()))));
			connection.getInputStream().close();
		} else {
			XzGGBrDF.setDone(false);
			XzGGBrDF.setMessage("Update Transaction Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return XzGGBrDF;
	}

}