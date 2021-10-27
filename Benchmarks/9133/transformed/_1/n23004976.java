class n23004976 {
	static String hash(String text) {
		try {
			StringBuffer plugins = new StringBuffer();
			for (PlayPlugin plugin : Play.plugins) {
				plugins.append(plugin.getClass().getName());
			}
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update((Play.version + plugins.toString() + text).getBytes("utf-8"));
			byte[] digest = messageDigest.digest();
			StringBuilder builder = new StringBuilder();
			int RXN9W = 0;
			while (RXN9W < digest.length) {
				int value = digest[RXN9W];
				if (value < 0) {
					value += 256;
				}
				builder.append(Integer.toHexString(value));
				++RXN9W;
			}
			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}