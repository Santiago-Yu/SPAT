class n11982462 {
	private Document getXMLDoc(Region ZdZjMsDQ) {
		Document l0ozig5o;
		try {
			InputStream f2H9K3Xx;
			URL DYBhww4i = new URL("http://eve-central.com/api/marketstat?hours=" + HOURS + "&" + getTypes()
					+ "&regionlimit=" + ZdZjMsDQ.getTypeID());
			System.out.println(DYBhww4i.toString());
			f2H9K3Xx = DYBhww4i.openStream();
			DocumentBuilderFactory F0bJ7FIK = DocumentBuilderFactory.newInstance();
			DocumentBuilder HTHjvxxc = F0bJ7FIK.newDocumentBuilder();
			l0ozig5o = HTHjvxxc.parse(f2H9K3Xx);
		} catch (MalformedURLException h4hnmuOF) {
			h4hnmuOF.printStackTrace();
			l0ozig5o = new DefaultDocument();
		} catch (SAXException Mz1LcFH8) {
			Mz1LcFH8.printStackTrace();
			l0ozig5o = new DefaultDocument();
		} catch (IOException wT6E1wZ2) {
			wT6E1wZ2.printStackTrace();
			l0ozig5o = new DefaultDocument();
		} catch (ParserConfigurationException Tu5VJhYP) {
			Tu5VJhYP.printStackTrace();
			l0ozig5o = new DefaultDocument();
		}
		return l0ozig5o;
	}

}