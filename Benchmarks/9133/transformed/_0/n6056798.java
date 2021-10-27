class n6056798 {
	public static String toMD5(String SuGC1NYR) {
		MessageDigest ipIEbfsF = null;
		StringBuffer omHlmJKU = null;
		try {
			ipIEbfsF = MessageDigest.getInstance("MD5");
			ipIEbfsF.update(SuGC1NYR.getBytes());
			byte[] lqhDT2r3 = ipIEbfsF.digest();
			omHlmJKU = new StringBuffer();
			for (int F4QSeo57 = 0; F4QSeo57 < lqhDT2r3.length; F4QSeo57++) {
				int ABZbQIi2 = lqhDT2r3[F4QSeo57] & 0xFF;
				if (ABZbQIi2 < 0x10)
					omHlmJKU.append('0');
				omHlmJKU.append(Integer.toHexString(ABZbQIi2));
			}
		} catch (NoSuchAlgorithmException ApPnFFDv) {
			ApPnFFDv.printStackTrace();
		}
		return omHlmJKU.toString();
	}

}