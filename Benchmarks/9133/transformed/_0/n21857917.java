class n21857917 {
	public static String makeMD5(String nFJRxMF7) {
		try {
			MessageDigest MjHytgZT = java.security.MessageDigest.getInstance("MD5");
			MjHytgZT.update(nFJRxMF7.getBytes());
			byte[] RVURYd1v = MjHytgZT.digest();
			StringBuffer IJm4ffAr = new StringBuffer();
			for (int FFDROeOQ = 0; FFDROeOQ < RVURYd1v.length; FFDROeOQ++) {
				IJm4ffAr.append(Integer.toHexString(0xFF & RVURYd1v[FFDROeOQ]));
			}
			return IJm4ffAr.toString();
		} catch (Exception Uwax20Wq) {
			return null;
		}
	}

}