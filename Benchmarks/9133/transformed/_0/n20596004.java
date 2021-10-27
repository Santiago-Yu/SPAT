class n20596004 {
	public APIResponse create(Item XrCSlITI) throws Exception {
		APIResponse M1dXd5h7 = new APIResponse();
		connection = (HttpURLConnection) new URL(url + "/api/item/create").openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setUseCaches(false);
		connection.setConnectTimeout(TIMEOUT);
		connection.connect();
		marshaller.marshal(XrCSlITI, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()),
				new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
		connection.getOutputStream().flush();
		connection.getOutputStream().close();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			JSONObject HCTmIBsE = new JSONObject(new String(
					new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
			M1dXd5h7.setDone(true);
			M1dXd5h7.setMessage(unmarshaller.unmarshal(
					new MappedXMLStreamReader(HCTmIBsE, new MappedNamespaceConvention(new Configuration()))));
			connection.getInputStream().close();
		} else {
			M1dXd5h7.setDone(false);
			M1dXd5h7.setMessage("Create Item Error Code: Http (" + connection.getResponseCode() + ")");
		}
		connection.disconnect();
		return M1dXd5h7;
	}

}