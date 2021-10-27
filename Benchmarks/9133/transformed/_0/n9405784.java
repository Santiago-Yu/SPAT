class n9405784 {
	public void startImport(ActionEvent ulT3FwrT) {
		final PsiExchange i3lPAqle = PsiExchangeFactory
				.createPsiExchange(IntactContext.getCurrentInstance().getSpringContext());
		for (final URL UwsUzSYI : urlsToImport) {
			try {
				if (log.isInfoEnabled())
					log.info("Importing: " + UwsUzSYI);
				i3lPAqle.importIntoIntact(UwsUzSYI.openStream());
			} catch (IOException HArLYzHX) {
				handleException(HArLYzHX);
				return;
			}
		}
		addInfoMessage("File successfully imported", Arrays.asList(urlsToImport).toString());
	}

}