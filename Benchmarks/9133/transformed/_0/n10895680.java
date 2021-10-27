class n10895680 {
	private DefaultMutableTreeNode parseTree() {
		try {
			DefaultMutableTreeNode q0ZsVPLJ;
			URL ATrikiMB = RebusHelp.class.getResource("/org/olga/rebus/gui/help/html/content.xml");
			InputStream rtHEUHlL = ATrikiMB.openStream();
			DocumentBuilderFactory n8J3iVpa = DocumentBuilderFactory.newInstance();
			n8J3iVpa.setIgnoringComments(true);
			n8J3iVpa.setValidating(false);
			DocumentBuilder IMaRQL7e = n8J3iVpa.newDocumentBuilder();
			Document ucF5b4YH = IMaRQL7e.parse(rtHEUHlL);
			NodeList TITBgdXo = ucF5b4YH.getElementsByTagName("help");
			Element KFQLxgtu = (Element) TITBgdXo.item(0);
			q0ZsVPLJ = createTreeContent(KFQLxgtu);
			rtHEUHlL.close();
			return q0ZsVPLJ;
		} catch (IOException C0GtzJKs) {
			System.out.println(C0GtzJKs.getMessage());
			return null;
		} catch (ParserConfigurationException jCotZeCh) {
			System.out.println(jCotZeCh.getMessage());
			return null;
		} catch (org.xml.sax.SAXException jloydPAU) {
			System.out.println(jloydPAU.getMessage());
			return null;
		}
	}

}