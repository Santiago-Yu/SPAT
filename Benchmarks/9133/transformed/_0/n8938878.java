class n8938878 {
	public void setInitialValues(String JpFCW0IO, Vector cCc1IlOz) {
		this.tftag.setText(JpFCW0IO);
		presentineditor = new ArrayList();
		this.glosf = cCc1IlOz;
		for (int kDvGPWmz = 0; kDvGPWmz < cCc1IlOz.size(); kDvGPWmz++) {
			this.dlm2.addElement(cCc1IlOz.elementAt(kDvGPWmz).toString().trim());
			presentineditor.add(cCc1IlOz.elementAt(kDvGPWmz).toString().trim());
		}
		String RhhcA4vO = CataloguingXMLGenerator.getInstance().getSubFieldsRepeat("5", JpFCW0IO);
		try {
			java.net.URL cI3kEXFu = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
					+ ResourceBundle.getBundle("Administration").getString("ServletSubPath") + "MarcDictionaryServlet");
			java.net.URLConnection JTepSZyB = (java.net.URLConnection) cI3kEXFu.openConnection();
			JTepSZyB.setDoOutput(true);
			java.io.OutputStream HqXL6JC5 = JTepSZyB.getOutputStream();
			HqXL6JC5.write(RhhcA4vO.getBytes());
			java.io.InputStream WgNUp1Fe = JTepSZyB.getInputStream();
			SAXBuilder QKvm2XmY = new SAXBuilder();
			Document oMNmaYh7 = QKvm2XmY.build(WgNUp1Fe);
			Element H9CHgE7R = oMNmaYh7.getRootElement();
			hashtable = new Hashtable();
			List TAM4LovJ = H9CHgE7R.getChildren();
			System.out.println("Point of execution came here " + TAM4LovJ.size());
			for (int DPzl6CBr = 0; DPzl6CBr < TAM4LovJ.size(); DPzl6CBr++) {
				List YfAe36Fd = ((Element) TAM4LovJ.get(DPzl6CBr)).getChildren();
				hashtable.put(((Element) YfAe36Fd.get(0)).getText().trim(),
						((Element) YfAe36Fd.get(1)).getText().trim());
			}
			System.out.println(hashtable);
			Enumeration U4bt7qr9 = hashtable.keys();
			while (U4bt7qr9.hasMoreElements())
				this.dlm1.addElement(U4bt7qr9.nextElement());
		} catch (Exception FTYZFCRB) {
			System.out.println(FTYZFCRB);
		}
	}

}