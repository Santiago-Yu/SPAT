class n8938878 {
	public void setInitialValues(String Tag, Vector subfields) {
		this.tftag.setText(Tag);
		presentineditor = new ArrayList();
		this.glosf = subfields;
		for (int i = 0; i < subfields.size(); i++) {
			this.dlm2.addElement(subfields.elementAt(i).toString().trim());
			presentineditor.add(subfields.elementAt(i).toString().trim());
		}
		String xmlreq = CataloguingXMLGenerator.getInstance().getSubFieldsRepeat("5", Tag);
		try {
			java.net.URL url = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
					+ ResourceBundle.getBundle("Administration").getString("ServletSubPath") + "MarcDictionaryServlet");
			java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
			urlconn.setDoOutput(true);
			java.io.OutputStream dos = urlconn.getOutputStream();
			dos.write(xmlreq.getBytes());
			SAXBuilder saxb = new SAXBuilder();
			java.io.InputStream ios = urlconn.getInputStream();
			Document retdoc = saxb.build(ios);
			Element retroot = retdoc.getRootElement();
			hashtable = new Hashtable();
			List list = retroot.getChildren();
			System.out.println("Point of execution came here " + list.size());
			for (int i = 0; i < list.size(); i++) {
				List chilist = ((Element) list.get(i)).getChildren();
				hashtable.put(((Element) chilist.get(0)).getText().trim(), ((Element) chilist.get(1)).getText().trim());
			}
			System.out.println(hashtable);
			Enumeration keys = hashtable.keys();
			while (keys.hasMoreElements())
				this.dlm1.addElement(keys.nextElement());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}