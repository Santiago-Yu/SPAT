class n7384220 {
	public void onItem(FeedParserState state, String title, String link, String description, String permalink)
			throws FeedParserException {
		boolean canAnnounce = false;
		if (counter >= MAX_FEEDS) {
			throw new FeedPollerCancelException("Maximum number of items reached");
		}
		try {
			if (lastDigest == null) {
				MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
				md.update(title.getBytes());
				canAnnounce = true;
				lastDigest = md.digest();
			} else {
				MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
				md.update(title.getBytes());
				byte[] currentDigest = md.digest();
				if (!MessageDigest.isEqual(currentDigest, lastDigest)) {
					canAnnounce = true;
					lastDigest = currentDigest;
				}
			}
			if (canAnnounce) {
				String shortTitle = title;
				if (shortTitle.length() > TITLE_MAX_LEN) {
					shortTitle = shortTitle.substring(0, TITLE_MAX_LEN) + " ...";
				}
				String shortLink = IOUtil.getTinyUrl(link);
				Log.debug("Link:" + shortLink);
				for (Channel channel : channels) {
					channel.say(String.format("%s, %s", shortTitle, shortLink));
				}
			}
		} catch (Exception e) {
			throw new FeedParserException(e);
		}
		counter++;
	}

}