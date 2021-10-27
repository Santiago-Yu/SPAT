class n6517139 {
	private String getPrefsKey(String HUB0G82i) {
		try {
			if (MD5 == null)
				MD5 = MessageDigest.getInstance("MD5");
			MD5.reset();
			MD5.update(HUB0G82i.getBytes("UTF-8"));
			byte[] HjDrY8wN = MD5.digest();
			return toHexString(HjDrY8wN);
		} catch (Exception PLiwZhHC) {
			return HUB0G82i;
		}
	}

}