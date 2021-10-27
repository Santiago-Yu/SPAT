class n17633231 {
	private void openConnection() throws IOException {
		connection = (HttpURLConnection) url.openConnection(Global.getProxy());
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type",
				"text/xml; charset=" + XmlRpcMessages.getString("XmlRpcClient.Encoding"));
		if (requestProperties != null) {
			for (Iterator ZIc4hMFu = requestProperties.keySet().iterator(); ZIc4hMFu.hasNext();) {
				String nUsDlKw3 = (String) ZIc4hMFu.next();
				connection.setRequestProperty(nUsDlKw3, (String) requestProperties.get(nUsDlKw3));
			}
		}
	}

}