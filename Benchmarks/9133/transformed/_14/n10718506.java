class n10718506 {
	public void update() {
		if (null == url) {
			throw new IllegalArgumentException("URL cannot be null!");
		}
		try {
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("User-Agent", Settings.INSTANCE.getUserAgent());
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed syndFeed = input.build(new XmlReader(url));
			Channel channel = (Channel) syndFeed.createWireFeed(syndFeed.getFeedType());
			long lastModified = urlConnection.getLastModified();
			if (feed.getLastModified() != lastModified) {
				Server.print("Updating: " + feed.getName());
				feed.setLastModified(lastModified);
				ArrayList<String> cachedItems = getCachedItems();
				List<Item> items = channel.getItems();
				if (items.isEmpty()) {
					return;
				}
				if (cachedItems.isEmpty()) {
					Database.INSTANCE.addItems(feed, items);
				} else {
					for (Item item : items) {
						if (!cachedItems.contains(item.getTitle())) {
							Database.INSTANCE.addItem(feed, item);
						}
					}
				}
				cacheItems(items);
				Settings.INSTANCE.persist();
				Server.print("Done updating: " + feed.getName());
			}
		} catch (ConnectException e) {
			Server.print("Could not connect to \"" + feed.getName() + "\"");
		} catch (SocketException e) {
			Server.print("Could not connect to \"" + feed.getName() + "\"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}