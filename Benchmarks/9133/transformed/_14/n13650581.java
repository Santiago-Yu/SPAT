class n13650581 {
	public static ChannelIF addChannel(String url) throws Exception {
		ChannelIF channel = null;
		try {
			channel = FeedParser.parse(new ChannelBuilder(), url);
			if (null == channel.getLocation())
				channel.setLocation(new URL(url));
		} catch (ParseException e) {
			InputStream is = new URL(url).openStream();
			InputStreamReader reader = new InputStreamReader(is);
			channel = FeedParser.parse(new ChannelBuilder(), reader);
			reader.close();
			is.close();
			if (null == channel.getLocation())
				channel.setLocation(new URL(url));
		}
		DAOChannel.addChannel(channel);
		DAOFavicon.addFaviconForChannel(channel);
		return channel;
	}

}