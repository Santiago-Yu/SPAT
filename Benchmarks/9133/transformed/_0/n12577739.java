class n12577739 {
	public static String digest(String L1BAWJLp) {
		try {
			byte[] u6NCw1Pu;
			synchronized (__TYPE) {
				if (__md == null) {
					try {
						__md = MessageDigest.getInstance("MD5");
					} catch (Exception UHc6s6Ad) {
						log.warn(LogSupport.EXCEPTION, UHc6s6Ad);
						return null;
					}
				}
				__md.reset();
				__md.update(L1BAWJLp.getBytes(StringUtil.__ISO_8859_1));
				u6NCw1Pu = __md.digest();
			}
			return __TYPE + TypeUtil.toString(u6NCw1Pu, 16);
		} catch (Exception zVjTgJ27) {
			log.warn(LogSupport.EXCEPTION, zVjTgJ27);
			return null;
		}
	}

}