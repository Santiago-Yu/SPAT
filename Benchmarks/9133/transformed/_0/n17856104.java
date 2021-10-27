class n17856104 {
	public static String SHA1(String qWHQ07XN) throws NoSuchAlgorithmException {
		MessageDigest h9wvkgsd = MessageDigest.getInstance("SHA-1");
		h9wvkgsd.update(qWHQ07XN.getBytes());
		byte jq9n18Aa[] = h9wvkgsd.digest();
		StringBuilder fDgpfGT7 = new StringBuilder();
		for (int NShQorgY = 0; NShQorgY < jq9n18Aa.length; NShQorgY++) {
			fDgpfGT7.append(Integer.toString((jq9n18Aa[NShQorgY] & 0xff) + 0x100, 16).substring(1));
		}
		StringBuilder rG7ukD76 = new StringBuilder();
		for (int wC2gEWtQ = 0; wC2gEWtQ < jq9n18Aa.length; wC2gEWtQ++) {
			String DXJtsHNK = Integer.toHexString(0xff & jq9n18Aa[wC2gEWtQ]);
			if (DXJtsHNK.length() == 1)
				rG7ukD76.append('0');
			rG7ukD76.append(DXJtsHNK);
		}
		return rG7ukD76.toString();
	}

}