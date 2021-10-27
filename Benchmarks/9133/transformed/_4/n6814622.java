class n6814622 {
	protected void loadConfigure() {
		try {
			confFile = System.getProperty("user.home");
			confFile = confFile + W.sepa + ".elm" + W.sepa + "vesma.conf";
			URL url = W.getResource(confFile);
			InputStream is = url.openStream();
			confDoc = W.loadDocumentFromInputStreamDOM(is);
			Element e = confDoc.getDocumentElement();
			Element ee = W.getChildByTagNameDOM(e, "rmiregistry");
			String s = W.getAttrDataDOM(ee, "enable");
			rmiregistryCB.setSelected(bbb(s));
			s = W.getDataDOM(e, "serverName");
			serverNameTF.setText(s);
			ee = W.getChildByTagNameDOM(e, "clients");
			Element eee = null;
			ArrayList<String> tmpAl = new ArrayList<String>();
			String defaultClient = null;
			ArrayList al = W.getChildrenByTagNameDOM(ee, "client");
			Iterator i = al.iterator();
			while (i.hasNext()) {
				eee = (Element) i.next();
				String clientString = W.getDataDOM(eee);
				tmpAl.add(clientString);
				String defaultString = W.getAttrDataDOM(eee, "default");
				defaultClient = (defaultString.equals("true")) ? clientString : defaultClient;
			}
			String ss[] = (String[]) tmpAl.toArray(new String[0]);
			clientClassCB.removeAllItems();
			for (int ii = 0; ii < ss.length; ii++)
				clientClassCB.addItem(ss[ii]);
			clientClassCB.setSelectedItem(defaultClient);
			ee = W.getChildByTagNameDOM(e, "loadVE");
			s = W.getAttrDataDOM(ee, "enable");
			emptyCB.setSelected(bbb(s) == false);
			s = W.getAttrDataDOM(ee, "file");
			roomFileTF.setText(s);
			ee = W.getChildByTagNameDOM(e, "elmBridge");
			s = W.getAttrDataDOM(ee, "enable");
			bridgeCB.setSelected(bbb(s));
			s = W.getAttrDataDOM(ee, "confFile");
			bridgeConfFileTF.setText(s);
			ee = W.getChildByTagNameDOM(e, "outIPAddress");
			s = W.getDataDOM(ee);
			bridgeOutIPTF.setText(s);
			bridgeInIPTF.setText(W.getIPAddress());
		} catch (Exception ee) {
			makeDefaultConfiguration();
			saveConfiguration();
			System.out.println("A default config file was created.");
		}
		packAndShow();
	}

}