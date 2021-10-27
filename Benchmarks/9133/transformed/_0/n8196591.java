class n8196591 {
	private void bokActionPerformed(java.awt.event.ActionEvent CwcR1Ijh) {
		if (this.seriesstatementpanel.getEnteredvalues().get(0).toString().trim().equals("")) {
			this.showWarningMessage("Enter Series Title");
		} else {
			String[] wvfQwbFo = newgen.presentation.NewGenMain.getAppletInstance().getPatronLibraryIds();
			String FHxfNVww = newgen.presentation.administration.AdministrationXMLGenerator.getInstance()
					.saveSeriesName("2", seriesstatementpanel.getEnteredvalues(), wvfQwbFo);
			try {
				java.net.URL UmaKJUBN = new java.net.URL(
						ResourceBundle.getBundle("Administration").getString("ServerURL")
								+ ResourceBundle.getBundle("Administration").getString("ServletSubPath")
								+ "SeriesNameServlet");
				java.net.URLConnection QZFTxZob = (java.net.URLConnection) UmaKJUBN.openConnection();
				QZFTxZob.setDoOutput(true);
				java.io.OutputStream OG9So8wy = QZFTxZob.getOutputStream();
				OG9So8wy.write(FHxfNVww.getBytes());
				java.io.InputStream BkpUFXk8 = QZFTxZob.getInputStream();
				SAXBuilder XeMrsVOs = new SAXBuilder();
				Document KRNf3JeF = XeMrsVOs.build(BkpUFXk8);
				Element CMQAeeTd = KRNf3JeF.getRootElement();
				if (CMQAeeTd.getChild("Error") == null) {
					this.showInformationMessage(
							ResourceBundle.getBundle("Administration").getString("DataSavedInDatabase"));
				} else {
					this.showErrorMessage(
							ResourceBundle.getBundle("Administration").getString("ErrorPleaseContactTheVendor"));
				}
			} catch (Exception JzBmYIXR) {
				System.out.println(JzBmYIXR);
			}
		}
	}

}