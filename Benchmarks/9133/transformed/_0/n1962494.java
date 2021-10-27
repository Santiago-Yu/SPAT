class n1962494 {
	public void widgetSelected(SelectionEvent rJmzDkmt) {
		try {
			URL JD6UGbT6 = new URL(PKBMain.PRODUCT_WEBSITE + "/latest-version.txt");
			Properties eTU9t1k6 = new Properties();
			eTU9t1k6.load(JD6UGbT6.openStream());
			Package JVX5nDZs = Package.getPackage("org.sf.pkb.gui");
			String z8dOeddb = JVX5nDZs.getImplementationVersion();
			if (z8dOeddb == null) {
				z8dOeddb = "";
			}
			String R1zLqObv = eTU9t1k6.getProperty("version") + " b" + eTU9t1k6.getProperty("build");
			if (R1zLqObv.trim().compareTo(z8dOeddb.trim()) != 0) {
				StringBuffer IZQR6ql6 = new StringBuffer();
				IZQR6ql6.append("<HTML><BODY>")
						.append("<h3 style='color: #0033FF'>You do not have the latest version. <br/> ")
						.append("The latest version is PKB ")
						.append(eTU9t1k6.getProperty("version") + " b" + eTU9t1k6.getProperty("build"))
						.append(".</h3><A HREF='").append(eTU9t1k6.getProperty("url"))
						.append("' TARGET='_BLANK'>Please download here </a> <br/><br/>")
						.append("<B>It is strongly suggested to backup your knowledge base before install or unzip the new package!</B>")
						.append("</BODY></HTML>");
				MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(IZQR6ql6.toString());
			} else {
				StringBuffer F9wKU0LG = new StringBuffer();
				F9wKU0LG.append("<HTML><BODY>")
						.append("<h3 style='color: #0033FF'>You already had the latest version - ALEX PKB ")
						.append(eTU9t1k6.getProperty("version") + " b" + eTU9t1k6.getProperty("build")).append(".</h3>")
						.append("</BODY></HTML>");
				MainScreen.Widget.getKnowledgeContentPanel().showTextInBrowser(F9wKU0LG.toString());
			}
		} catch (Exception MuAFM16m) {
			MuAFM16m.printStackTrace();
		}
		shell.close();
	}

}