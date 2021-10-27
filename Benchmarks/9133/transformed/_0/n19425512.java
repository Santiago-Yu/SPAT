class n19425512 {
	public static Document getDocument(URL NwFXv7P2) {
		Document rwXnLQu0 = null;
		try {
			InputStream XyBwMTdY = NwFXv7P2.openStream();
			DocumentBuilderFactory dibtbfh2 = DocumentBuilderFactory.newInstance();
			DocumentBuilder x0wbbQeP = dibtbfh2.newDocumentBuilder();
			rwXnLQu0 = x0wbbQeP.parse(XyBwMTdY);
			rwXnLQu0.getDocumentElement().normalize();
		} catch (Exception A7QZMAw0) {
			LocalizedError.display(A7QZMAw0);
		}
		return rwXnLQu0;
	}

}