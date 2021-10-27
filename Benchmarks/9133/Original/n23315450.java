class n23315450{
    public Manifest(URL url) throws IOException {
        if (!url.getProtocol().equals("jar")) {
            url = new URL("jar:" + url.toExternalForm() + "!/");
        }
        JarURLConnection uc = (JarURLConnection) url.openConnection();
        setManifest(uc.getManifest());
    }

}