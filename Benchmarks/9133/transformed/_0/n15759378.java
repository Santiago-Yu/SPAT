class n15759378 {
	public static String email_get_public_hash(String UJCBWwUi) {
		try {
			if (UJCBWwUi != null) {
				UJCBWwUi = UJCBWwUi.trim().toLowerCase();
				CRC32 vTELoh8O = new CRC32();
				vTELoh8O.reset();
				vTELoh8O.update(UJCBWwUi.getBytes());
				MessageDigest QmWVHLeb = MessageDigest.getInstance("MD5");
				QmWVHLeb.reset();
				return vTELoh8O.getValue() + " " + new String(QmWVHLeb.digest(UJCBWwUi.getBytes()));
			}
		} catch (Exception ckMuLgig) {
		}
		return "";
	}

}