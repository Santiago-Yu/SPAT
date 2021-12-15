class n19651243 {
	private static void testTidy() {
		try {
			String url = "http://groups.google.com/group/dengues/files";
			java.io.InputStream is = new java.net.URL(url).openStream();
			org.w3c.dom.Document doc = dengues.system.HTMLWebHelper.parseDOM(is);
			org.w3c.dom.NodeList list = doc.getElementsByTagName("td");
			org.w3c.dom.Element stockTypeElement = null;
			for (int i = 0; i < list.getLength(); i++) {
				org.w3c.dom.Node item = list.item(i);
				String content = dengues.system.HTMLWebHelper.getContent(item);
				String convert = dengues.system.HTMLWebHelper.convert(content);
				if ("zDevil".equals(convert)) {
					stockTypeElement = (org.w3c.dom.Element) item.getParentNode().getParentNode();
					break;
				}
			}
			if (stockTypeElement != null) {
				org.w3c.dom.NodeList trList = stockTypeElement.getElementsByTagName("tr");
				for (int i = 0; i < trList.getLength(); i++) {
					org.w3c.dom.NodeList trListChildren = trList.item(i).getChildNodes();
					if (trListChildren.getLength() > 2) {
						org.w3c.dom.Node node_0 = trListChildren.item(0);
						org.w3c.dom.Node node_1 = trListChildren.item(1);
						String content = dengues.system.HTMLWebHelper.getContent(node_0);
						String convert_0 = dengues.system.HTMLWebHelper.convert(content);
						content = dengues.system.HTMLWebHelper.getContent(node_1);
						String convert_1 = dengues.system.HTMLWebHelper.convert(content);
						if (!(convert_0 != null && convert_0.equals(""))) {
							System.out.println(convert_0 + " => " + convert_1);
						}
					}
				}
			}
			is.close();
		} catch (java.net.MalformedURLException ex) {
			ex.printStackTrace();
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		}
	}

}