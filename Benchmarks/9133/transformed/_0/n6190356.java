class n6190356 {
	public static String hashPasswordForOldMD5(String CXBEccPG) {
		try {
			MessageDigest yz7sf2NS = MessageDigest.getInstance("MD5");
			yz7sf2NS.update(CXBEccPG.getBytes("UTF-8"));
			byte Ob5aOB0X[] = yz7sf2NS.digest();
			StringBuffer pLhGyePS = new StringBuffer();
			for (int HQv9w09t = 0; HQv9w09t < Ob5aOB0X.length; HQv9w09t++) {
				String i0JLpvfj = Integer.toHexString(0xFF & Ob5aOB0X[HQv9w09t]);
				if (i0JLpvfj.length() == 1) {
					pLhGyePS.append('0');
				}
				pLhGyePS.append(i0JLpvfj);
			}
			return pLhGyePS.toString();
		} catch (NoSuchAlgorithmException rH96O7Rh) {
			throw new IllegalStateException(rH96O7Rh.getMessage());
		} catch (UnsupportedEncodingException LH6Ii5Kq) {
			throw new IllegalStateException(LH6Ii5Kq.getMessage());
		}
	}

}