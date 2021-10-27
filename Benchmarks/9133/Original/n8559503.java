class n8559503{
    public void login(String username, String key) {
        if (isLogged()) {
            return;
        }
        if (null == this.username || null == this.key) {
            this.username = username;
            this.key = key;
        }
        final ProgressHandle handle = ProgressHandleFactory.createHandle("Logining into DreamHost");
        handle.start();
        working = true;
        fireChangeEvent();
        RequestProcessor.getDefault().post(new Runnable() {

            public void run() {
                try {
                    HttpsURLConnection connection = (HttpsURLConnection) urlGenerator(DreamHostCommands.CMD_DOMAIN_LIST_DOMAINS, null).openConnection();
                    String response = getResponse(connection);
                    Document document = builder.parse(new ByteArrayInputStream(response.getBytes()));
                    String result = document.getElementsByTagName("result").item(0).getTextContent();
                    logged = result.equals("success");
                } catch (SAXException ex) {
                    Logger.getLogger(DreamHostConnector.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DreamHostConnector.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (isLogged()) {
                        NbPreferences.forModule(DreamHostConnector.class).put("username", getUsername());
                        NbPreferences.forModule(DreamHostConnector.class).put("key", getKey());
                    }
                    handle.finish();
                    working = false;
                    fireChangeEvent();
                }
            }
        });
    }

}