class n21348951 {
	protected void processAddByURLSubmit(URL siDOaHPU, String cGXkuNIj) {
		if (!this.hasError()) {
			try {
				StringWriter zFMsHO15 = new StringWriter();
				IOUtils.copy(siDOaHPU.openStream(), zFMsHO15);
				processSubmittedDoap(zFMsHO15.toString());
			} catch (FileNotFoundException UoGxXcqK) {
				Session.get().error(cGXkuNIj);
				logger.warn("Error processing URL: " + cGXkuNIj);
			} catch (IOException IiGAxJ6a) {
				setResponsePage(new ErrorReportPage(new UserReportableException("Unable to add doap using RDF supplied",
						DoapFormPage.class, IiGAxJ6a)));
				logger.warn("Error processing URL: " + siDOaHPU + "; " + IiGAxJ6a.getMessage(), IiGAxJ6a);
			}
		}
	}

}