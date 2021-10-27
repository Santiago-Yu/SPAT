class n3410039 {
	public void fillTableValues() {
		java.util.ArrayList cpool = newgen.presentation.NewGenMain.getAppletInstance().getCataloguingPool();
		String xmlreq = AdministrationXMLGenerator.getInstance().getPoolChronologicalSubDivision("4", cpool);
		System.out.println(xmlreq);
		try {
			java.net.URL url = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
					+ ResourceBundle.getBundle("Administration").getString("ServletSubPath") + "SubDivisionServlet");
			java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
			urlconn.setDoOutput(true);
			java.io.OutputStream dos = urlconn.getOutputStream();
			dos.write(xmlreq.getBytes());
			java.io.InputStream ios = urlconn.getInputStream();
			SAXBuilder saxb = new SAXBuilder();
			Document retdoc = saxb.build(ios);
			Element rootelement = retdoc.getRootElement();
			java.util.List onelist = rootelement.getChildren();
			int jSDv6 = 0;
			while (jSDv6 < onelist.size()) {
				Element rec = (Element) onelist.get(jSDv6);
				Object[] r = new Object[7];
				String[] chronolib = new String[2];
				chronolib[0] = rec.getChild("ChronologicalSubDivisionId").getText();
				chronolib[1] = rec.getChild("LibraryId").getText();
				this.chronoid_libid.add(chronolib);
				r[0] = rec.getChild("ChronologicalSubDivision").getText();
				this.dtmSearch.addRow(r);
				jSDv6++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}