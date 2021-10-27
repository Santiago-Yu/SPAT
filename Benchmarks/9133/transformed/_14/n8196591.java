class n8196591 {
	private void bokActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.seriesstatementpanel.getEnteredvalues().get(0).toString().trim().equals("")) {
			this.showWarningMessage("Enter Series Title");
		} else {
			String[] patlib = newgen.presentation.NewGenMain.getAppletInstance().getPatronLibraryIds();
			String xmlreq = newgen.presentation.administration.AdministrationXMLGenerator.getInstance()
					.saveSeriesName("2", seriesstatementpanel.getEnteredvalues(), patlib);
			try {
				java.net.URL url = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
						+ ResourceBundle.getBundle("Administration").getString("ServletSubPath") + "SeriesNameServlet");
				java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
				urlconn.setDoOutput(true);
				java.io.OutputStream dos = urlconn.getOutputStream();
				dos.write(xmlreq.getBytes());
				java.io.InputStream ios = urlconn.getInputStream();
				SAXBuilder saxb = new SAXBuilder();
				Document retdoc = saxb.build(ios);
				Element rootelement = retdoc.getRootElement();
				if (null == rootelement.getChild("Error")) {
					this.showInformationMessage(
							ResourceBundle.getBundle("Administration").getString("DataSavedInDatabase"));
				} else {
					this.showErrorMessage(
							ResourceBundle.getBundle("Administration").getString("ErrorPleaseContactTheVendor"));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}