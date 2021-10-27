class n20024580{
    public void run() {
        URL url;
        InputSource i;
        Message m = ThemeListActivity.FeaturedThemesProgressHandler.obtainMessage();
        try {
            url = new URL(mUrl);
            i = new InputSource(url.openStream());
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            FeaturedThemesHandler fth = new FeaturedThemesHandler();
            xr.setContentHandler(fth);
            xr.parse(i);
            m.obj = fth.getParsedData();
        } catch (MalformedURLException e) {
            m.obj = e.toString();
            Log.e(TAG, "Malformed URL!", e);
        } catch (IOException e) {
            m.obj = e.toString();
            Log.e(TAG, "Exception on opening Input Stream", e);
        } catch (ParserConfigurationException e) {
            m.obj = e.toString();
            Log.e(TAG, "Exception on parsing XML File", e);
        } catch (SAXException e) {
            m.obj = e.toString();
            Log.e(TAG, "Exception while creating SAXParser", e);
        }
        ThemeListActivity.FeaturedThemesProgressHandler.sendMessage(m);
    }

}