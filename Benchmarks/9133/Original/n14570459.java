class n14570459{
    public void createFeed(Context ctx, URL url) {
        try {
            targetFlag = TARGET_FEED;
            droidDB = NewsDroidDB.getInstance(ctx);
            currentFeed.Url = url;
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            xr.setContentHandler(this);
            xr.parse(new InputSource(url.openStream()));
        } catch (IOException e) {
            Log.e(e.getMessage());
        } catch (SAXException e) {
            Log.e(e.getMessage());
        } catch (ParserConfigurationException e) {
            Log.e(e.getMessage());
        }
    }

}