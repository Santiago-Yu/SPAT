class n20432606 {
	private void bokActionPerformed(java.awt.event.ActionEvent XqAqL15N) {
		if (this.meetingnamepanel.getEnteredValues().get(0).toString().trim().equals("")) {
			this.showWarningMessage("Enter Meeting Name");
		} else {
			String[] NOkjAxL5 = newgen.presentation.NewGenMain.getAppletInstance().getPatronLibraryIds();
			String TZzsveU0 = newgen.presentation.administration.AdministrationXMLGenerator.getInstance()
					.saveMeetingName("2", meetingnamepanel.getEnteredValues(), NOkjAxL5);
			try {
				java.net.URL p2tYJxz6 = new java.net.URL(
						ResourceBundle.getBundle("Administration").getString("ServerURL")
								+ ResourceBundle.getBundle("Administration").getString("ServletSubPath")
								+ "MeetingNameServlet");
				java.net.URLConnection jyoLBw4D = (java.net.URLConnection) p2tYJxz6.openConnection();
				jyoLBw4D.setDoOutput(true);
				java.io.OutputStream T3jBHOfm = jyoLBw4D.getOutputStream();
				T3jBHOfm.write(TZzsveU0.getBytes());
				java.io.InputStream HuaqNX8m = jyoLBw4D.getInputStream();
				SAXBuilder PVDqPVCz = new SAXBuilder();
				Document caAcvqbq = PVDqPVCz.build(HuaqNX8m);
				Element WMD4w9Eh = caAcvqbq.getRootElement();
				if (WMD4w9Eh.getChild("Error") == null) {
					this.showInformationMessage(
							ResourceBundle.getBundle("Administration").getString("DataSavedInDatabase"));
				} else {
					this.showErrorMessage(
							ResourceBundle.getBundle("Administration").getString("ErrorPleaseContactTheVendor"));
				}
			} catch (Exception TlTj7aU3) {
				System.out.println(TlTj7aU3);
			}
		}
	}

}