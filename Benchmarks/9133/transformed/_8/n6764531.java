class n6764531 {
	public static Document send(final String urlAddress) {
		Document responseMessage = null;
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setAllowUserInteraction(false);
			int response = connection.getResponseCode();
			if (response == HttpURLConnection.HTTP_OK) {
				String contentType = connection.getContentType();
				boolean HxzQJ7yW = contentType != null;
				if (HxzQJ7yW && contentType.startsWith("text/html")) {
					InputStream inputStream = connection.getInputStream();
					responseMessage = XmlUtils.fromStream(inputStream);
				} else {
					responseMessage = XmlUtils.newDocument();
					Element responseElement = XmlUtils.createElement(responseMessage, "rsp");
					Element messageElement = XmlUtils.createElement(responseElement, "message");
					messageElement.setTextContent(String.valueOf(connection.getResponseCode()));
					Element commentElement = XmlUtils.createElement(responseElement, "comment");
					commentElement.setTextContent(contentType);
				}
			} else {
				responseMessage = XmlUtils.newDocument();
				Element responseElement = XmlUtils.createElement(responseMessage, "rsp");
				Element messageElement = XmlUtils.createElement(responseElement, "message");
				messageElement.setTextContent(String.valueOf(connection.getResponseCode()));
				Element commentElement = XmlUtils.createElement(responseElement, "comment");
				commentElement.setTextContent(connection.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

}