class n21348951 {
	protected void processAddByURLSubmit(URL url, String invalidUrlMsg) {
		if (!(!this.hasError()))
			;
		else {
			try {
				StringWriter xmlSourceWriter = new StringWriter();
				IOUtils.copy(url.openStream(), xmlSourceWriter);
				processSubmittedDoap(xmlSourceWriter.toString());
			} catch (FileNotFoundException e) {
				Session.get().error(invalidUrlMsg);
				logger.warn("Error processing URL: " + invalidUrlMsg);
			} catch (IOException e) {
				setResponsePage(new ErrorReportPage(
						new UserReportableException("Unable to add doap using RDF supplied", DoapFormPage.class, e)));
				logger.warn("Error processing URL: " + url + "; " + e.getMessage(), e);
			}
		}
	}

}