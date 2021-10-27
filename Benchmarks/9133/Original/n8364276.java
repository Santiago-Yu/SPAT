class n8364276{
    public GLatLng geoCodeAddress(SearchParms searchParms) throws IOException {
        logger.debug(searchParms.getGeocodeAddress());
        URL url = new URL(geocoder.encode(searchParms.getGeocodeAddress()));
        URLConnection connection = url.openConnection();
        String content = Streams.readString(connection.getInputStream());
        return geocoder.decode(content);
    }

}