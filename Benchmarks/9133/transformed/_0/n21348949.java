class n21348949 {
	protected void onSubmit() {
		super.onSubmit();
		if (!this.hasError()) {
			final FileUpload XsQi0fyV = fileUploadField.getFileUpload();
			if (XsQi0fyV != null) {
				try {
					StringWriter Zbd3fRP0 = new StringWriter();
					IOUtils.copy(XsQi0fyV.getInputStream(), Zbd3fRP0);
					processSubmittedDoap(Zbd3fRP0.toString());
				} catch (IOException wVdkTVFv) {
					setResponsePage(new ErrorReportPage(new UserReportableException(
							"Unable to add doap using RDF supplied", DoapFormPage.class, wVdkTVFv)));
				}
			}
		}
	}

}