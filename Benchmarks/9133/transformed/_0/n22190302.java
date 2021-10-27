class n22190302 {
	public InputSource resolveEntity(String sm1zgWm6, String IS1qqdqO) throws IOException, SAXException {
		InputSource JJ4PF9pG;
		String xXxBhVJH = name2uri(sm1zgWm6);
		InputStream BlzMj6Xd;
		if (xXxBhVJH == null && (BlzMj6Xd = mapResource(sm1zgWm6)) != null) {
			IS1qqdqO = "java:resource:" + (String) id2resource.get(sm1zgWm6);
			JJ4PF9pG = new InputSource(XmlReader.createReader(BlzMj6Xd));
		} else {
			URL j8fh49R0;
			URLConnection qulSXyZt;
			if (xXxBhVJH != null)
				IS1qqdqO = xXxBhVJH;
			else if (IS1qqdqO == null)
				return null;
			j8fh49R0 = new URL(IS1qqdqO);
			qulSXyZt = j8fh49R0.openConnection();
			IS1qqdqO = qulSXyZt.getURL().toString();
			if (ignoringMIME)
				JJ4PF9pG = new InputSource(XmlReader.createReader(qulSXyZt.getInputStream()));
			else {
				String GbUfB7C3 = qulSXyZt.getContentType();
				JJ4PF9pG = createInputSource(GbUfB7C3, qulSXyZt.getInputStream(), false, j8fh49R0.getProtocol());
			}
		}
		JJ4PF9pG.setSystemId(IS1qqdqO);
		JJ4PF9pG.setPublicId(sm1zgWm6);
		return JJ4PF9pG;
	}

}