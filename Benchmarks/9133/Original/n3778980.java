class n3778980{
    public void update() {
        Vector invalids = new Vector();
        for (int i = 0; i < urls.size(); i++) {
            URL url = null;
            try {
                url = new URL((String) urls.elementAt(i));
                InputStream stream = url.openStream();
                stream.close();
            } catch (MalformedURLException urlE) {
                Logger.logWarning("Malformed URL: " + urls.elementAt(i));
            } catch (IOException ioE) {
                invalids.addElement(url);
            }
        }
        for (int i = 0; i < invalids.size(); i++) {
            urls.removeElement(invalids.elementAt(i));
            Logger.logInfo("Removed " + invalids.elementAt(i) + " - no longer available");
        }
    }

}