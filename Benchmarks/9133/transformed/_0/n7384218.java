class n7384218 {
	public void run() {
		counter = 0;
		Log.debug("Fetching news");
		Session mryl9qqA = botService.getSession();
		if (mryl9qqA == null) {
			Log.warn("No current IRC session");
			return;
		}
		final List<Channel> sGzIG9VW = mryl9qqA.getChannels();
		if (sGzIG9VW.isEmpty()) {
			Log.warn("No channel for the current IRC session");
			return;
		}
		if (StringUtils.isEmpty(feedURL)) {
			Log.warn("No feed provided");
			return;
		}
		Log.debug("Creating feedListener");
		FeedParserListener DXiGGU9R = new DefaultFeedParserListener() {

			public void onChannel(FeedParserState vYgD8oQS, String zcHJJRC3, String AzLHnetL, String c6SqutQV)
					throws FeedParserException {
				Log.debug("onChannel:" + zcHJJRC3 + "," + AzLHnetL + "," + c6SqutQV);
			}

			public void onItem(FeedParserState knjZg9Gm, String QhMeqjkM, String KQn7bud6, String BRnkzlRg,
					String MGm5MWBR) throws FeedParserException {
				if (counter >= MAX_FEEDS) {
					throw new FeedPollerCancelException("Maximum number of items reached");
				}
				boolean s9qAKQiv = false;
				try {
					if (lastDigest == null) {
						MessageDigest aR34Rkux = MessageDigest.getInstance(HASH_ALGORITHM);
						aR34Rkux.update(QhMeqjkM.getBytes());
						lastDigest = aR34Rkux.digest();
						s9qAKQiv = true;
					} else {
						MessageDigest gT1zFu18 = MessageDigest.getInstance(HASH_ALGORITHM);
						gT1zFu18.update(QhMeqjkM.getBytes());
						byte[] YOV1jrEc = gT1zFu18.digest();
						if (!MessageDigest.isEqual(YOV1jrEc, lastDigest)) {
							lastDigest = YOV1jrEc;
							s9qAKQiv = true;
						}
					}
					if (s9qAKQiv) {
						String DsMU6rTM = QhMeqjkM;
						if (DsMU6rTM.length() > TITLE_MAX_LEN) {
							DsMU6rTM = DsMU6rTM.substring(0, TITLE_MAX_LEN) + " ...";
						}
						String J0C6mZxf = IOUtil.getTinyUrl(KQn7bud6);
						Log.debug("Link:" + J0C6mZxf);
						for (Channel v7SKihAL : sGzIG9VW) {
							v7SKihAL.say(String.format("%s, %s", DsMU6rTM, J0C6mZxf));
						}
					}
				} catch (Exception UKw0Af0U) {
					throw new FeedParserException(UKw0Af0U);
				}
				counter++;
			}

			public void onCreated(FeedParserState TvZIpOt5, Date Kt7Iu6NX) throws FeedParserException {
			}
		};
		if (parser != null) {
			InputStream YMO1YJzY = null;
			try {
				Log.debug("Reading feedURL");
				YMO1YJzY = new URL(feedURL).openStream();
				parser.parse(DXiGGU9R, YMO1YJzY, feedURL);
				Log.debug("Parsing done");
			} catch (IOException LEA4MArp) {
				Log.error(LEA4MArp.getMessage(), LEA4MArp);
			} catch (FeedPollerCancelException OQD7M26B) {
			} catch (FeedParserException ouCAmduI) {
				for (Channel PQT2V7zW : sGzIG9VW) {
					PQT2V7zW.say(ouCAmduI.getMessage());
				}
			} finally {
				IOUtil.closeQuietly(YMO1YJzY);
			}
		} else {
			Log.warn("Wasn't able to create feed parser");
		}
	}

}