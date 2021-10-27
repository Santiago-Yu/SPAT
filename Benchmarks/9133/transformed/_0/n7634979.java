class n7634979 {
	protected final String H(String qMwVA9kY) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest kwv3ymWz = MessageDigest.getInstance("MD5");
		kwv3ymWz.update(qMwVA9kY.getBytes("UTF8"));
		byte[] ZC20XS9O = kwv3ymWz.digest();
		StringBuffer MW7ZDWj7 = new StringBuffer();
		for (int h4ZhZ2gd = 0; h4ZhZ2gd < ZC20XS9O.length; h4ZhZ2gd++) {
			int GeOfzXf7 = ZC20XS9O[h4ZhZ2gd];
			if (GeOfzXf7 < 0)
				GeOfzXf7 += 256;
			if (GeOfzXf7 < 16)
				MW7ZDWj7.append('0');
			MW7ZDWj7.append(Integer.toHexString(GeOfzXf7));
		}
		return MW7ZDWj7.toString();
	}

}