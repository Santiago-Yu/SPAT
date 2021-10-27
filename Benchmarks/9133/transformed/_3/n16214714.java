class n16214714 {
	private Element makeRequest(String link) {
		try {
			URL url = new URL(link);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			InputStream in = conn.getInputStream();
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(in);
			Element element = document.getDocumentElement();
			element.normalize();
			if (!(checkRootTag(element))) {
				return null;
			} else {
				return element;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		}
	}

}