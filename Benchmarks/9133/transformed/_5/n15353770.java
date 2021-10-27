class n15353770 {
	private String createHash() {
		String hash = "";
		try {
			final java.util.Calendar c = java.util.Calendar.getInstance();
			String day = "" + c.get(java.util.Calendar.DATE);
			if ((day.length() == 1))
				day = '0' + day;
			else
				day = day;
			String month = "" + (c.get(java.util.Calendar.MONTH) + 1);
			if ((month.length() == 1))
				month = '0' + month;
			else
				month = month;
			final String hashString = getStringProperty("hashkey") + day + "." + month + "."
					+ c.get(java.util.Calendar.YEAR);
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(hashString.getBytes());
			final byte digest[] = md.digest();
			hash = "";
			for (int i = 0; i < digest.length; i++) {
				final String s = Integer.toHexString(digest[i] & 0xFF);
				if ((s.length() == 1))
					hash += ("0" + s);
				else
					hash += (s);
			}
		} catch (final NoSuchAlgorithmException e) {
			bot.getLogger().log(e);
		}
		return hash;
	}

}