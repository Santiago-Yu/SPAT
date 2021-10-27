class n7839811 {
	public static String md5(String gmhruhxD) {
		byte[] OjwsKaFu;
		try {
			MessageDigest QBJXQ4sJ;
			QBJXQ4sJ = MessageDigest.getInstance("MD5");
			QBJXQ4sJ.update(gmhruhxD.getBytes());
			OjwsKaFu = QBJXQ4sJ.digest();
		} catch (Exception LGAmEEfM) {
			return null;
		}
		return MyUtils.byte2HexStr(OjwsKaFu);
	}

}