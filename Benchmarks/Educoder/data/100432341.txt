    public Document getContentAsDocument() {
        synchronized (this.url) {
            URLConnection connection = this.url.openConnection();
            if (doReload(connection)) {
                InputSource inputSource = new InputSource(connection.getInputStream());
                DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
                this.document = factory.newDocumentBuilder().parse(inputSource);
            }
            return this.document;
        }
    }
