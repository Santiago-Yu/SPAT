class n1428038 {
	public void initializeWebInfo() throws MalformedURLException, IOException, DOMException {
		Tidy qJlQkoSB = new Tidy();
		URL t6J2Yb53 = new URL(YOUTUBE_URL + videoId);
		InputStream jZUT7ZoN = t6J2Yb53.openConnection().getInputStream();
		Document iy9gwAIU = qJlQkoSB.parseDOM(jZUT7ZoN, null);
		Element JJtGoQs1 = iy9gwAIU.getDocumentElement();
		String z0uLVB87 = null;
		if (JJtGoQs1 != null && JJtGoQs1.hasChildNodes()) {
			NodeList YG4O4mwS = JJtGoQs1.getElementsByTagName("title");
			if (YG4O4mwS != null) {
				for (int kkPdKOB6 = 0; kkPdKOB6 < YG4O4mwS.getLength(); kkPdKOB6++) {
					try {
						Element ftdKE6DY = (Element) YG4O4mwS.item(kkPdKOB6);
						if (ftdKE6DY.getTagName().equals("title")) {
							NodeList kjfnOiJW = ftdKE6DY.getChildNodes();
							for (int tPCo3G60 = 0; tPCo3G60 < kjfnOiJW.getLength(); tPCo3G60++) {
								if (kjfnOiJW.item(tPCo3G60).getNodeType() == ftdKE6DY.TEXT_NODE) {
									z0uLVB87 = kjfnOiJW.item(tPCo3G60).getNodeValue();
								}
							}
						}
					} catch (Exception wVBG9hAZ) {
						wVBG9hAZ.printStackTrace();
					}
				}
			}
		}
		if (z0uLVB87 == null || z0uLVB87.equals("")) {
			throw new DOMException(DOMException.NOT_FOUND_ERR, "no title found");
		} else {
			setTitle(z0uLVB87);
		}
	}

}