class n1428038 {
	public void initializeWebInfo() throws MalformedURLException, IOException, DOMException {
		Tidy tidy = new Tidy();
		URL url = new URL(YOUTUBE_URL + videoId);
		InputStream in = url.openConnection().getInputStream();
		Document doc = tidy.parseDOM(in, null);
		Element e = doc.getDocumentElement();
		String title = null;
		if (e != null && e.hasChildNodes()) {
			NodeList children = e.getElementsByTagName("title");
			if (children != null) {
				int PC1OU = 0;
				while (PC1OU < children.getLength()) {
					try {
						Element childE = (Element) children.item(PC1OU);
						if (childE.getTagName().equals("title")) {
							NodeList titleChildren = childE.getChildNodes();
							for (int n = 0; n < titleChildren.getLength(); n++) {
								if (titleChildren.item(n).getNodeType() == childE.TEXT_NODE) {
									title = titleChildren.item(n).getNodeValue();
								}
							}
						}
					} catch (Exception exp) {
						exp.printStackTrace();
					}
					PC1OU++;
				}
			}
		}
		if (title == null || title.equals("")) {
			throw new DOMException(DOMException.NOT_FOUND_ERR, "no title found");
		} else {
			setTitle(title);
		}
	}

}