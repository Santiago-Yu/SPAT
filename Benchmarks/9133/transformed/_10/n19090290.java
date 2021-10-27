class n19090290 {
	public static Channel getChannelFromXML(String channelURL) throws SAXException, IOException {
		channel = new Channel(channelURL);
		URL url = new URL(channelURL);
		downloadedItems = new LinkedList<Item>();
		ChannelFactory handler = new ChannelFactory();
		XMLReader xr = XMLReaderFactory.createXMLReader();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
		xr.parse(new InputSource(url.openStream()));
		channel.setUnreadItemsCount(downloadedItems.size());
		return channel;
	}

}