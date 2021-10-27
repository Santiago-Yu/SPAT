class n5135685 {
	private NodeInfo loadNodeMeta(int id, int properties) {
		String query = mServer + "load.php" + ("?id=" + id) + ("&mask=" + properties);
		NodeInfo info = null;
		try {
			URL url = new URL(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setRequestMethod("GET");
			setCredentials(conn);
			conn.connect();
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				InputStream stream = conn.getInputStream();
				MimeType contentType = new MimeType(conn.getContentType());
				if (contentType.getBaseType().equals("text/xml")) {
					try {
						JAXBContext context = JAXBContext.newInstance(NetProcessorInfo.class);
						Unmarshaller unm = context.createUnmarshaller();
						NetProcessorInfo root = (NetProcessorInfo) unm.unmarshal(stream);
						if ((root != null) && (1 == root.getNodes().length)) {
							info = root.getNodes()[0];
						}
					} catch (Exception ex) {
					}
				}
				stream.close();
			}
		} catch (Exception ex) {
		}
		return info;
	}

}