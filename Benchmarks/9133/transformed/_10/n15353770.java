class n15353770 {
	private String createHash() {
		String hash = "";
		try {
			final java.util.Calendar c = java.util.Calendar.getInstance();
			String day = "" + c.get(java.util.Calendar.DATE);
			String month = "" + (c.get(java.util.Calendar.MONTH) + 1);
			day = (day.length() == 1) ? '0' + day : day;
			month = (month.length() == 1) ? '0' + month : month;
			final String hashString = getStringProperty("hashkey") + day + "." + month + "."
					+ c.get(java.util.Calendar.YEAR);
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(hashString.getBytes());
			hash = "";
			final byte digest[] = md.digest();
			for (int i = 0; i < digest.length; i++) {
				final String s = Integer.toHexString(digest[i] & 0xFF);
				hash += ((s.length() == 1) ? "0" + s : s);
			}
		} catch (final NoSuchAlgorithmException e) {
			bot.getLogger().log(e);
		}
		return hash;
	}

}