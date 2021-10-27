class n20979580{
    public void doAction() throws MalformedURLException, IOException, Exception {
        URL url = new URL(CheckNewVersionAction.VERSION_FILE);
        InputStream is = url.openStream();
        byte[] buffer = Utils.loadBytes(is);
        is.close();
        String version = new String(buffer);
        if (version != null) {
            version = version.substring(0, version.lastIndexOf("\n") == -1 ? version.length() : version.lastIndexOf("\n"));
        }
        hasNewVersion = !DAOSystem.getSystem().getVersion().equals(version);
    }

}