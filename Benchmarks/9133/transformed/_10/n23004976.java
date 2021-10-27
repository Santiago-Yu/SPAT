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
			StringBuilder builder = new StringBuilder();
			byte[] digest = messageDigest.digest();
			for (int i = 0; i < digest.length; ++i) {
				int value = digest[i];
				if (value < 0) {
					value += 256;
				}
				builder.append(Integer.toHexString(value));
			}
			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}