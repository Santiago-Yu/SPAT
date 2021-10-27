class n6814622 {
	protected void loadConfigure() {
		try {
			confFile = System.getProperty("user.home");
			confFile = confFile + W.sepa + ".elm" + W.sepa + "vesma.conf";
			URL xWWTu1al = W.getResource(confFile);
			InputStream YHr0VcAD = xWWTu1al.openStream();
			confDoc = W.loadDocumentFromInputStreamDOM(YHr0VcAD);
			Element fj1xblVC = confDoc.getDocumentElement();
			Element eFEYmAQi = W.getChildByTagNameDOM(fj1xblVC, "rmiregistry");
			String DjfEML7u = W.getAttrDataDOM(eFEYmAQi, "enable");
			rmiregistryCB.setSelected(bbb(DjfEML7u));
			DjfEML7u = W.getDataDOM(fj1xblVC, "serverName");
			serverNameTF.setText(DjfEML7u);
			eFEYmAQi = W.getChildByTagNameDOM(fj1xblVC, "clients");
			Element rTUZ09LK = null;
			ArrayList<String> kNZeu17w = new ArrayList<String>();
			String d055JZv2 = null;
			ArrayList WPVEhAV5 = W.getChildrenByTagNameDOM(eFEYmAQi, "client");
			Iterator De1GKr3D = WPVEhAV5.iterator();
			while (De1GKr3D.hasNext()) {
				rTUZ09LK = (Element) De1GKr3D.next();
				String Ya16i6ZV = W.getDataDOM(rTUZ09LK);
				kNZeu17w.add(Ya16i6ZV);
				String IQaf1VU8 = W.getAttrDataDOM(rTUZ09LK, "default");
				if (IQaf1VU8.equals("true")) {
					d055JZv2 = Ya16i6ZV;
				}
			}
			String p2roD45A[] = (String[]) kNZeu17w.toArray(new String[0]);
			clientClassCB.removeAllItems();
			for (int sGJJZCEj = 0; sGJJZCEj < p2roD45A.length; sGJJZCEj++)
				clientClassCB.addItem(p2roD45A[sGJJZCEj]);
			clientClassCB.setSelectedItem(d055JZv2);
			eFEYmAQi = W.getChildByTagNameDOM(fj1xblVC, "loadVE");
			DjfEML7u = W.getAttrDataDOM(eFEYmAQi, "enable");
			emptyCB.setSelected(bbb(DjfEML7u) == false);
			DjfEML7u = W.getAttrDataDOM(eFEYmAQi, "file");
			roomFileTF.setText(DjfEML7u);
			eFEYmAQi = W.getChildByTagNameDOM(fj1xblVC, "elmBridge");
			DjfEML7u = W.getAttrDataDOM(eFEYmAQi, "enable");
			bridgeCB.setSelected(bbb(DjfEML7u));
			DjfEML7u = W.getAttrDataDOM(eFEYmAQi, "confFile");
			bridgeConfFileTF.setText(DjfEML7u);
			eFEYmAQi = W.getChildByTagNameDOM(fj1xblVC, "outIPAddress");
			DjfEML7u = W.getDataDOM(eFEYmAQi);
			bridgeOutIPTF.setText(DjfEML7u);
			bridgeInIPTF.setText(W.getIPAddress());
		} catch (Exception is7HVLpq) {
			makeDefaultConfiguration();
			saveConfiguration();
			System.out.println("A default config file was created.");
		}
		packAndShow();
	}

}