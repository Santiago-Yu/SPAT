class n13281981 {
	private void bokActionPerformed(java.awt.event.ActionEvent pb1xWVyf) {
		Vector UkVC5p5D = this.uniformtitlepanel.getEnteredValuesKeys();
		String[] zdhx0erJ = newgen.presentation.NewGenMain.getAppletInstance().getPatronLibraryIds();
		String TausgrVh = newgen.presentation.administration.AdministrationXMLGenerator.getInstance()
				.saveUniformTitleSH("2", UkVC5p5D, zdhx0erJ);
		System.out.println(TausgrVh);
		try {
			java.net.URL urZLDQqn = new java.net.URL(ResourceBundle.getBundle("Administration").getString("ServerURL")
					+ ResourceBundle.getBundle("Administration").getString("ServletSubPath")
					+ "UniformTitleSubjectHeadingServlet");
			java.net.URLConnection xy7wdT6n = (java.net.URLConnection) urZLDQqn.openConnection();
			xy7wdT6n.setDoOutput(true);
			java.io.OutputStream FUBwDOZn = xy7wdT6n.getOutputStream();
			FUBwDOZn.write(TausgrVh.getBytes());
			java.io.InputStream VNw59BcG = xy7wdT6n.getInputStream();
			SAXBuilder CF6FHEJL = new SAXBuilder();
			Document ilFT7LIu = CF6FHEJL.build(VNw59BcG);
			Element S6x8jF6y = ilFT7LIu.getRootElement();
			if (S6x8jF6y.getChild("Error") == null) {
				this.showInformationMessage(
						ResourceBundle.getBundle("Administration").getString("DataSavedInDatabase"));
			} else {
				this.showErrorMessage(
						ResourceBundle.getBundle("Administration").getString("ErrorPleaseContactTheVendor"));
			}
		} catch (Exception Yb3m5ZpI) {
			System.out.println(Yb3m5ZpI);
		}
	}

}