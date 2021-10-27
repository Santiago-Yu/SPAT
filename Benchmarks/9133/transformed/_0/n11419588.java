class n11419588 {
	public static String MD5(String GQqP8xoV) {
		try {
			MessageDigest tq3ldrv4;
			tq3ldrv4 = MessageDigest.getInstance("MD5");
			byte[] hPkcH5I9 = new byte[32];
			tq3ldrv4.update(GQqP8xoV.getBytes("iso-8859-1"), 0, GQqP8xoV.length());
			hPkcH5I9 = tq3ldrv4.digest();
			return convertToHex(hPkcH5I9);
		} catch (Exception QQ4CGzHN) {
			System.out.println(QQ4CGzHN.toString());
		}
		return null;
	}

}