class n6784542{
    public Coordinates geocode(Address address) {
        Coordinates geocoordinates = null;
        String web = YAHOOURL + "?appid=" + applicationId + "&location=" + createLocation(address);
        URL url;
        try {
            url = new URL(web);
            InputStream in = url.openStream();
            geocoordinates = YahooXmlReader.readConfig(in);
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return geocoordinates;
    }

}