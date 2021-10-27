class n3691037 {
	public PVBrowserSearchDocument(URL url, PVBrowserModel applicationModel) {
        if (url != null) {
			try {
				data.loadFromXML(url.openStream());
				loadOpenPVsFromData();
				setHasChanges(false);
				setSource(url);
			} catch (java.io.IOException exception) {
				System.err.println(exception);
				displayWarning("Open Failed!", exception.getMessage(), exception);
			}
		}
        this(applicationModel);
    }

}