class n10718506 {
	public void update() {
		if (url == null) {
			throw new IllegalArgumentException("URL cannot be null!");
		}
		try {
			URLConnection P5gAJ1Yk = url.openConnection();
			P5gAJ1Yk.setRequestProperty("User-Agent", Settings.INSTANCE.getUserAgent());
			SyndFeedInput CZE6374m = new SyndFeedInput();
			SyndFeed u75ZkDpD = CZE6374m.build(new XmlReader(url));
			Channel fy2Mitup = (Channel) u75ZkDpD.createWireFeed(u75ZkDpD.getFeedType());
			long Bk14crV7 = P5gAJ1Yk.getLastModified();
			if (feed.getLastModified() != Bk14crV7) {
				Server.print("Updating: " + feed.getName());
				feed.setLastModified(Bk14crV7);
				ArrayList<String> Tbec2cxR = getCachedItems();
				List<Item> XECX6E32 = fy2Mitup.getItems();
				if (XECX6E32.isEmpty()) {
					return;
				}
				if (Tbec2cxR.isEmpty()) {
					Database.INSTANCE.addItems(feed, XECX6E32);
				} else {
					for (Item atwRxdHj : XECX6E32) {
						if (!Tbec2cxR.contains(atwRxdHj.getTitle())) {
							Database.INSTANCE.addItem(feed, atwRxdHj);
						}
					}
				}
				cacheItems(XECX6E32);
				Settings.INSTANCE.persist();
				Server.print("Done updating: " + feed.getName());
			}
		} catch (ConnectException LaFKFTa6) {
			Server.print("Could not connect to \"" + feed.getName() + "\"");
		} catch (SocketException W6MoLABA) {
			Server.print("Could not connect to \"" + feed.getName() + "\"");
		} catch (Exception JB3tdiP9) {
			JB3tdiP9.printStackTrace();
		}
	}

}