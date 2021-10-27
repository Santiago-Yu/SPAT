class n7384220 {
	public void onItem(FeedParserState Zro1wy3O, String bgm9PQhX, String DQYCf9VX, String BeMZPf3z, String nlFz2nzl)
			throws FeedParserException {
		if (counter >= MAX_FEEDS) {
			throw new FeedPollerCancelException("Maximum number of items reached");
		}
		boolean unG7evcz = false;
		try {
			if (lastDigest == null) {
				MessageDigest MBBY9DsF = MessageDigest.getInstance(HASH_ALGORITHM);
				MBBY9DsF.update(bgm9PQhX.getBytes());
				lastDigest = MBBY9DsF.digest();
				unG7evcz = true;
			} else {
				MessageDigest JQouwPkz = MessageDigest.getInstance(HASH_ALGORITHM);
				JQouwPkz.update(bgm9PQhX.getBytes());
				byte[] Gk5Vux9r = JQouwPkz.digest();
				if (!MessageDigest.isEqual(Gk5Vux9r, lastDigest)) {
					lastDigest = Gk5Vux9r;
					unG7evcz = true;
				}
			}
			if (unG7evcz) {
				String P8brVsuE = bgm9PQhX;
				if (P8brVsuE.length() > TITLE_MAX_LEN) {
					P8brVsuE = P8brVsuE.substring(0, TITLE_MAX_LEN) + " ...";
				}
				String ZVF2rILO = IOUtil.getTinyUrl(DQYCf9VX);
				Log.debug("Link:" + ZVF2rILO);
				for (Channel X0uliv3L : channels) {
					X0uliv3L.say(String.format("%s, %s", P8brVsuE, ZVF2rILO));
				}
			}
		} catch (Exception WfHroQgJ) {
			throw new FeedParserException(WfHroQgJ);
		}
		counter++;
	}

}