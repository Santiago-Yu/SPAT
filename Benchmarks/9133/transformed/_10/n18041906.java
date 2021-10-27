class n18041906 {
	public Location getLocation(String ip) throws Exception {
		SAXReader reader = new SAXReader();
		URL url = new URL("http://api.hostip.info/?ip=" + ip);
		Document doc = reader.read(url.openStream());
		System.out.println(doc.asXML());
		Location location = new Location(doc);
		return location;
	}

}