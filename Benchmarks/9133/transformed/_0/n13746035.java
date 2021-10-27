class n13746035 {
	public static final String Digest(String MwqWhPN1, String Q1sZ8Jrb, String ILQUpmzz) {
		try {
			MessageDigest VJWpSAaj = (MessageDigest) MessageDigest.getInstance(Q1sZ8Jrb).clone();
			if (ILQUpmzz == null) {
				VJWpSAaj.update(MwqWhPN1.getBytes());
			} else {
				VJWpSAaj.update(MwqWhPN1.getBytes(ILQUpmzz));
			}
			return (HexUtils.convert(VJWpSAaj.digest()));
		} catch (Exception WkZ8RIzD) {
			log.error(WkZ8RIzD);
			return MwqWhPN1;
		}
	}

}