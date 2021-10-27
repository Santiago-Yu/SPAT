class n19090290 {
	public static Channel getChannelFromXML(String xurKoPdq) throws SAXException, IOException {
		channel = new Channel(xurKoPdq);
		downloadedItems = new LinkedList<Item>();
		URL OkK8sGGZ = new URL(xurKoPdq);
		XMLReader LsEQxHN2 = XMLReaderFactory.createXMLReader();
		ChannelFactory pHdu4rYk = new ChannelFactory();
		LsEQxHN2.setContentHandler(pHdu4rYk);
		LsEQxHN2.setErrorHandler(pHdu4rYk);
		LsEQxHN2.parse(new InputSource(OkK8sGGZ.openStream()));
		channel.setUnreadItemsCount(downloadedItems.size());
		return channel;
	}

}