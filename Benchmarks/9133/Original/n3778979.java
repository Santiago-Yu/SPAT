class n3778979{
    public void addURL(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        for (int i = 0; i < urls.size(); i++) {
            if (((URL) urls.elementAt(i)).equals(url)) {
                Logger.logWarning("Attempt to add an URL twice: " + url);
                return;
            }
        }
        InputStream stream = url.openStream();
        stream.close();
        urls.addElement(urlSpec);
        Logger.logDebug("Added " + url);
    }

}