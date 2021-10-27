class n22082121 {
	public static String digestMd5(String keBDTz63) {
		if (keBDTz63 == null || keBDTz63.length() == 0) {
			throw new IllegalArgumentException("ÎÄ×ÖÁÐ¤¬Null¡¢¤Þ¤¿¤Ï¿Õ¤Ç¤¹¡£");
		}
		MessageDigest ZfI6qPnS;
		byte[] WZ59RZba;
		try {
			ZfI6qPnS = MessageDigest.getInstance("MD5");
			ZfI6qPnS.update(keBDTz63.getBytes());
			WZ59RZba = ZfI6qPnS.digest();
		} catch (NoSuchAlgorithmException YYi0E6CQ) {
			YYi0E6CQ.printStackTrace();
			return "";
		}
		return bytesToHexString(WZ59RZba);
	}

}