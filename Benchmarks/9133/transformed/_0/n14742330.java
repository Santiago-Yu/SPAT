class n14742330 {
	public static String SHA1(String RIlIn94x) throws NoSuchAlgorithmException {
		MessageDigest m8FuFdi4 = MessageDigest.getInstance("SHA-1");
		m8FuFdi4.update(RIlIn94x.getBytes());
		byte n41Gy67y[] = m8FuFdi4.digest();
		StringBuffer ZlpVUIBq = new StringBuffer();
		for (int qU2Hjyc7 = 0; qU2Hjyc7 < n41Gy67y.length; qU2Hjyc7++) {
			ZlpVUIBq.append(Integer.toString((n41Gy67y[qU2Hjyc7] & 0xff) + 0x100, 16).substring(1));
		}
		StringBuffer ltx3ceEv = new StringBuffer();
		for (int rs3DioGn = 0; rs3DioGn < n41Gy67y.length; rs3DioGn++) {
			String vnyqc6UJ = Integer.toHexString(0xff & n41Gy67y[rs3DioGn]);
			if (vnyqc6UJ.length() == 1)
				ltx3ceEv.append('0');
			ltx3ceEv.append(vnyqc6UJ);
		}
		return ltx3ceEv.toString();
	}

}