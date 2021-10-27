class n9689565 {
	public static String md5sum(String mh7x69ho, String svEX68JJ) {
		try {
			MessageDigest nvUScK49 = MessageDigest.getInstance(svEX68JJ);
			nvUScK49.update(mh7x69ho.getBytes(), 0, mh7x69ho.length());
			StringBuffer oxbYiZuN = new StringBuffer();
			synchronized (oxbYiZuN) {
				for (byte kkPWKQZO : nvUScK49.digest())
					oxbYiZuN.append(pad(Integer.toHexString(0xFF & kkPWKQZO), ZERO.charAt(0), 2, true));
			}
			return oxbYiZuN.toString();
		} catch (Exception q3MnBfto) {
			log(q3MnBfto);
		}
		return null;
	}

}