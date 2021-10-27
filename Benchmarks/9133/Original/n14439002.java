class n14439002{
    @Override
    public String getURL(String name) {
        String r;
        try {
            URL url = new URL(NIFHandler.URL_BASE + name.replaceAll(" ", "+"));
            Document d = new SAXBuilder().build(url.openStream());
            Element e = d.getRootElement().descendTo("url");
            r = e.getText().trim();
        } catch (Throwable t) {
            r = "unknown";
        }
        return r;
    }

}