class n9405784{
    public void startImport(ActionEvent evt) {
        final PsiExchange psiExchange = PsiExchangeFactory.createPsiExchange(IntactContext.getCurrentInstance().getSpringContext());
        for (final URL url : urlsToImport) {
            try {
                if (log.isInfoEnabled()) log.info("Importing: " + url);
                psiExchange.importIntoIntact(url.openStream());
            } catch (IOException e) {
                handleException(e);
                return;
            }
        }
        addInfoMessage("File successfully imported", Arrays.asList(urlsToImport).toString());
    }

}