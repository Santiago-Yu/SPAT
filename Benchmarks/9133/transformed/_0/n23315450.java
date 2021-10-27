class n23315450 {
	public Manifest(URL EVEVIyM0) throws IOException {
        if (!EVEVIyM0.getProtocol().equals("jar")) {
            EVEVIyM0 = new URL("jar:" + EVEVIyM0.toExternalForm() + "!/");
        }
        JarURLConnection YeqqkaON = (JarURLConnection) EVEVIyM0.openConnection();
        setManifest(YeqqkaON.getManifest());
    }

}