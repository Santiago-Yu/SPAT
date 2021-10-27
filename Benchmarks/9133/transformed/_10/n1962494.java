class n1962494 {
	public void widgetSelected(SelectionEvent event) {
		try {
			Properties prop = new Properties();
			URL url = new URL(PKBMain.PRODUCT_WEBSITE + "/latest-version.txt");
			prop.load(url.openStream());
			Package currentPackage = Package.getPackage("org.sf.pkb.gui");
			String version = currentPackage.getImplementationVersion();
			String remoteVersion = prop.getProperty("version") + " b" + prop.getProperty("build");
			if (version == null) {
				version = "";
			}
			if (remoteVersion.trim().compareTo(version.trim()) != 0) {
				StringBuffer buf = new StringBuffer();
				buf.append("<HTML><BODY>")
						.append("<h3 style='color: #0033FF'>You do not have the latest version. <br/> ")
						.append("The latest version is PKB ")
						.append(prop.getProperty("version") + " b" + prop.getProperty("build"))
						.append(".</h3><A HREF='").append(prop.getProperty("url"))
						.append("' TARGET='_BLANK'>Please download here </a> <br/><br/>")
						.append("<B>It is strongly suggested to backup your knowledge base before install or unzip the new package!</B>")
						.append("</BODY></HTML>");
				MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(buf.toString());
			} else {
				StringBuffer buf = new StringBuffer();
				buf.append("<HTML><BODY>")
						.append("<h3 style='color: #0033FF'>You already had the latest version - ALEX PKB ")
						.append(prop.getProperty("version") + " b" + prop.getProperty("build")).append(".</h3>")
						.append("</BODY></HTML>");
				MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(buf.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		shell.close();
	}

}