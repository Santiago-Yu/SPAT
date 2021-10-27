class n19090290{
    public static Channel getChannelFromXML(String channelURL) throws SAXException, IOException {
        channel = new Channel(channelURL);
        downloadedItems = new LinkedList<Item>();
        URL url = new URL(channelURL);
        XMLReader xr = XMLReaderFactory.createXMLReader();
        ChannelFactory handler = new ChannelFactory();
        xr.setContentHandler(handler);
        xr.setErrorHandler(handler);
        xr.parse(new InputSource(url.openStream()));
        channel.setUnreadItemsCount(downloadedItems.size());
        return channel;
    }

}