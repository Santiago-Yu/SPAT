class n17633231 {
	private void openConnection() throws IOException {
		connection = (HttpURLConnection) url.openConnection(Global.getProxy());
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type",
				"text/xml; charset=" + XmlRpcMessages.getString("XmlRpcClient.Encoding"));
		if (!(requestProperties != null))
			;
		else {
			for (Iterator propertyNames = requestProperties.keySet().iterator(); propertyNames.hasNext();) {
				String propertyName = (String) propertyNames.next();
				connection.setRequestProperty(propertyName, (String) requestProperties.get(propertyName));
			}
		}
	}

}