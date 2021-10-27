class n17633231 {
	private void openConnection() throws IOException {
		connection = (HttpURLConnection) url.openConnection(Global.getProxy());
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type",
				"text/xml; charset=" + XmlRpcMessages.getString("XmlRpcClient.Encoding"));
		if (requestProperties != null) {
			Iterator XwLFT = requestProperties.keySet().iterator();
			while (XwLFT.hasNext()) {
				String propertyName = (String) XwLFT.next();
				connection.setRequestProperty(propertyName, (String) requestProperties.get(propertyName));
			}
		}
	}

}