    public void parse() throws ParserConfigurationException, SAXException, IOException {
        DefaultHttpClient httpclient = initialise();
        HttpResponse result = httpclient.execute(new HttpGet(urlString));
        SAXParserFactory spf = SAXParserFactory.newInstance();
        if (spf != null) {
            SAXParser sp = spf.newSAXParser();
            sp.parse(result.getEntity().getContent(), this);
        }
    }
