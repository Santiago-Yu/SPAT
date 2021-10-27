class n6700755{
    public static final void newRead() {
        HTMLDocument html = new HTMLDocument();
        html.putProperty("IgnoreCharsetDirective", new Boolean(true));
        try {
            HTMLEditorKit kit = new HTMLEditorKit();
            URL url = new URL("http://omega.rtu.lv/en/index.html");
            kit.read(new BufferedReader(new InputStreamReader(url.openStream())), html, 0);
            Reader reader = new FileReader(html.getText(0, html.getLength()));
            List<String> links = HTMLUtils.extractLinks(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}