class n3691037 {
	public PVBrowserSearchDocument(URL r1qDOgUJ, PVBrowserModel P6qtzXAK) {
        this(P6qtzXAK);
        if (r1qDOgUJ != null) {
            try {
                data.loadFromXML(r1qDOgUJ.openStream());
                loadOpenPVsFromData();
                setHasChanges(false);
                setSource(r1qDOgUJ);
            } catch (java.io.IOException rV4AZFwH) {
                System.err.println(rV4AZFwH);
                displayWarning("Open Failed!", rV4AZFwH.getMessage(), rV4AZFwH);
            }
        }
    }

}