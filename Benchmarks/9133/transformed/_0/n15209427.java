class n15209427 {
	private void bokActionPerformed(java.awt.event.ActionEvent Hrj3dNPi) {
		if (this.tfGeneralSubDivision.getText().trim().equals("")) {
			this.showWarningMessage("Enter general sub division");
		} else {
			String[] EFd4jfqv = newgen.presentation.NewGenMain.getAppletInstance().getPatronLibraryIds();
			String oceqUDAP = newgen.presentation.administration.AdministrationXMLGenerator.getInstance()
					.saveGeneralSubDivision("1", this.tfGeneralSubDivision.getText(), EFd4jfqv);
			System.out.println(oceqUDAP);
			try {
				java.net.URL qgM89DWe = new java.net.URL(
						ResourceBundle.getBundle("Administration").getString("ServerURL")
								+ ResourceBundle.getBundle("Administration").getString("ServletSubPath")
								+ "SubDivisionServlet");
				java.net.URLConnection oZkPyT56 = (java.net.URLConnection) qgM89DWe.openConnection();
				oZkPyT56.setDoOutput(true);
				java.io.OutputStream YOMVeIDG = oZkPyT56.getOutputStream();
				YOMVeIDG.write(oceqUDAP.getBytes());
				java.io.InputStream idzBiyMn = oZkPyT56.getInputStream();
				SAXBuilder GFACFDt1 = new SAXBuilder();
				Document bYZD0OUQ = GFACFDt1.build(idzBiyMn);
				Element wDndDdBP = bYZD0OUQ.getRootElement();
				if (wDndDdBP.getChild("Error") == null) {
					this.showInformationMessage(
							ResourceBundle.getBundle("Administration").getString("DataSavedInDatabase"));
				} else {
					this.showErrorMessage(
							ResourceBundle.getBundle("Administration").getString("ErrorPleaseContactTheVendor"));
				}
			} catch (Exception sHLcjRDx) {
				System.out.println(sHLcjRDx);
			}
		}
	}

}