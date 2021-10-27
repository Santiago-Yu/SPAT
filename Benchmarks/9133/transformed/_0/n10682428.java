class n10682428 {
	public static void readConfigFromResource(String hlgfYjby) throws Exception {
		URL ZJJzSm3b = ConfigXMLReader.class.getClassLoader().getResource(hlgfYjby);
		if (ZJJzSm3b == null)
			throw new FileNotFoundException("Couldn't find the config resource:" + hlgfYjby);
		System.out.println("Reading config from resource: " + ZJJzSm3b.toString());
		readConfig(ZJJzSm3b.openStream());
	}

}