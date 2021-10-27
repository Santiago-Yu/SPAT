class n17164077{
    public void readConfig(String urlString) throws Exception {
        try {
            URL url = new URL(urlString);
            InputStream in = url.openStream();
            XmlDoc xml = new Parser().parse(new InputSource(in), true, true);
            Verifier v = new Verifier(InputOutput.create(SCHEMA), null);
            v.verify(xml.getDocument());
            this.config = xml.getDocument();
        } catch (Exception e) {
            log("Can't read " + urlString + ": " + e.toString());
            throw e;
        }
        initParms();
        log("Got parameters: \n" + paramsInfo());
        initMessages();
        log("Got messages: \n" + messagesInfo());
        checkMessageId();
    }

}