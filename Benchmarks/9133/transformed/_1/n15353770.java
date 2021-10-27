class n15353770 {
	private String createHash() {
		String hash = "";
		try {
			final java.util.Calendar c = java.util.Calendar.getInstance();
			String day = "" + c.get(java.util.Calendar.DATE);
			day = (day.length() == 1) ? '0' + day : day;
			String month = "" + (c.get(java.util.Calendar.MONTH) + 1);
			month = (month.length() == 1) ? '0' + month : month;
			final String hashString = getStringProperty("hashkey") + day + "." + month + "."
					+ c.get(java.util.Calendar.YEAR);
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(hashString.getBytes());
			final byte digest[] = md.digest();
			hash = "";
			int RSZ9I = 0;
			while (RSZ9I < digest.length) {
				final String s = Integer.toHexString(digest[RSZ9I] & 0xFF);
				hash += ((s.length() == 1) ? "0" + s : s);
				RSZ9I++;
			}
		} catch (final NoSuchAlgorithmException e) {
			bot.getLogger().log(e);
		}
		return hash;
	}

}