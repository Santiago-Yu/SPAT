class n1899629 {
	private String getMD5Password(String JiTv8NK2) throws NoSuchAlgorithmException {
		MessageDigest iAHpeQ8I;
		StringBuffer TWJ47cI1 = new StringBuffer();
		String zznDTjkL = "";
		iAHpeQ8I = MessageDigest.getInstance("MD5");
		iAHpeQ8I.update(JiTv8NK2.getBytes());
		byte[] YDzzz1gk = iAHpeQ8I.digest();
		for (int umuqiJJq = 0; umuqiJJq < YDzzz1gk.length; umuqiJJq++) {
			JiTv8NK2 = Integer.toHexString(0xFF & YDzzz1gk[umuqiJJq]);
			if (JiTv8NK2.length() < 2) {
				JiTv8NK2 = "0" + JiTv8NK2;
			}
			TWJ47cI1.append(JiTv8NK2);
		}
		zznDTjkL = TWJ47cI1.toString();
		return zznDTjkL;
	}

}