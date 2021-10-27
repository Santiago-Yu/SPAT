class n18041906{
    public Location getLocation(String ip) throws Exception {
        URL url = new URL("http://api.hostip.info/?ip=" + ip);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(url.openStream());
        System.out.println(doc.asXML());
        Location location = new Location(doc);
        return location;
    }

}