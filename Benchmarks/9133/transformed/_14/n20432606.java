class n20432606 {
	private void bokActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.meetingnamepanel.getEnteredValues().get(0).toString().trim().equals("")) {
			this.showWarningMessage("Enter Meeting Name");
		} else {
			String[] patlib = newgen.presentation.NewGenMain.getAppletInstance().getPatronLibraryIds();
			String xmlreq = newgen.presentation.administration.AdministrationXMLGenerator.getInstance()
					.saveMeetingName("2", meetingnamepanel.getEnteredValues(), patlib);
			try {
				java.net.URL url = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
						+ ResourceBundle.getBundle("Administration").getString("ServletSubPath")
						+ "MeetingNameServlet");
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