class n20073617 {
	public static String digest(String pBase, String pCharSet) {
		String wdgs = null;
		try {
			MessageDigest wmd = MessageDigest.getInstance("MD5");
			wmd.reset();
			wmd.update(pBase.getBytes(pCharSet));
			StringBuffer hexString = new StringBuffer();
			byte[] wdg = wmd.digest();
			for (int i = 0; i < wdg.length; i++) {
				String w_dup = Integer.toHexString(0xFF & wdg[i]);
				if (w_dup.length() < 2) {
					w_dup = "0" + w_dup;
				}
				hexString.append(w_dup);
			}
			wdgs = hexString.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		} finally {
			return wdgs;
		}
	}

}