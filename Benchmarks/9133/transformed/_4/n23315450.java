class n23315450 {
	public Manifest(URL url) throws IOException {
        url = (!url.getProtocol().equals("jar")) ? new URL("jar:" + url.toExternalForm() + "!/") : url;
        JarURLConnection uc = (JarURLConnection) url.openConnection();
        setManifest(uc.getManifest());
    }

}