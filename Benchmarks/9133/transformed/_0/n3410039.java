class n3410039 {
	public void fillTableValues() {
		java.util.ArrayList HHx2s2yk = newgen.presentation.NewGenMain.getAppletInstance().getCataloguingPool();
		String C5HWBBnN = AdministrationXMLGenerator.getInstance().getPoolChronologicalSubDivision("4", HHx2s2yk);
		System.out.println(C5HWBBnN);
		try {
			java.net.URL pdjhgkCs = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
					+ ResourceBundle.getBundle("Administration").getString("ServletSubPath") + "SubDivisionServlet");
			java.net.URLConnection F4qivNvk = (java.net.URLConnection) pdjhgkCs.openConnection();
			F4qivNvk.setDoOutput(true);
			java.io.OutputStream gWd6SF2v = F4qivNvk.getOutputStream();
			gWd6SF2v.write(C5HWBBnN.getBytes());
			java.io.InputStream frvkw1Mw = F4qivNvk.getInputStream();
			SAXBuilder YvlGbLtJ = new SAXBuilder();
			Document AK2ftBqM = YvlGbLtJ.build(frvkw1Mw);
			Element QJFMkaVz = AK2ftBqM.getRootElement();
			java.util.List vC4tz3uu = QJFMkaVz.getChildren();
			for (int vfpOrJSQ = 0; vfpOrJSQ < vC4tz3uu.size(); vfpOrJSQ++) {
				Element mn16wc9r = (Element) vC4tz3uu.get(vfpOrJSQ);
				Object[] eXvcajCH = new Object[7];
				String[] oZpA3845 = new String[2];
				oZpA3845[0] = mn16wc9r.getChild("ChronologicalSubDivisionId").getText();
				oZpA3845[1] = mn16wc9r.getChild("LibraryId").getText();
				this.chronoid_libid.add(oZpA3845);
				eXvcajCH[0] = mn16wc9r.getChild("ChronologicalSubDivision").getText();
				this.dtmSearch.addRow(eXvcajCH);
			}
		} catch (Exception ytygJjUp) {
			System.out.println(ytygJjUp);
		}
	}

}