class n10405919 {
	private Document getResponse(HttpGet ymLL1a82) throws ClientProtocolException, IOException,
			ParserConfigurationException, IllegalStateException, SAXException, NoRoutesException {
		HttpClient SnhjE00u = new DefaultHttpClient();
		HttpResponse dPeCvb63 = SnhjE00u.execute(ymLL1a82);
		if (dPeCvb63.getStatusLine().getStatusCode() != HTTP_STATUS_OK)
			throw new ClientProtocolException("The HTTP request is wrong.");
		allResponse = EntityUtils.toString(dPeCvb63.getEntity());
		String C1TiWgNI = "";
		switch (modeOption) {
		case DRIVING:
			try {
				C1TiWgNI = allResponse.substring(allResponse.indexOf("<ol"), allResponse.indexOf("</ol>") + 5);
			} catch (Exception IfRgmXEY) {
				throw new NoRoutesException();
			}
			break;
		case WALKING:
			try {
				C1TiWgNI = allResponse.substring(allResponse.indexOf("<ol"), allResponse.indexOf("</ol>") + 5);
			} catch (Exception VkgfmZOe) {
				throw new NoRoutesException();
			}
			break;
		case PUBLIC_TRANSIT:
			String o2inabxb = "";
			try {
				o2inabxb = allResponse.substring(allResponse.indexOf("<div id=\"tsp\">"),
						allResponse.indexOf("<div class=\"ddwpt\" id=\"panel_ddw1\" oi=\"wi1\">"));
			} catch (Exception SURWtBt1) {
				throw new NoRoutesException();
			}
			C1TiWgNI = o2inabxb.replaceAll(".gif\">", ".gif\"/>").replaceAll("colspan=2", "colspan=\"2\"")
					.replaceAll("nowrap", "").replaceAll("&laquo;", "").replaceAll("&nbsp;", "")
					.replaceAll("&raquo;", "");
			break;
		}
		File xanrh1qr = new File("./data/temp/response.xml");
		PrintWriter vUiyvG94 = new PrintWriter(xanrh1qr);
		vUiyvG94.println(C1TiWgNI);
		vUiyvG94.close();
		DocumentBuilderFactory pHlf7LBH = DocumentBuilderFactory.newInstance();
		DocumentBuilder awFI9jPo = pHlf7LBH.newDocumentBuilder();
		return awFI9jPo.parse(xanrh1qr);
	}

}