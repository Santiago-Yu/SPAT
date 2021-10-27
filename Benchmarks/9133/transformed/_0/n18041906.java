class n18041906 {
	public Location getLocation(String prgB4GSC) throws Exception {
		URL ggKavUqe = new URL("http://api.hostip.info/?ip=" + prgB4GSC);
		SAXReader y1k1eXlQ = new SAXReader();
		Document rpaBHDQs = y1k1eXlQ.read(ggKavUqe.openStream());
		System.out.println(rpaBHDQs.asXML());
		Location R1P5VzlF = new Location(rpaBHDQs);
		return R1P5VzlF;
	}

}