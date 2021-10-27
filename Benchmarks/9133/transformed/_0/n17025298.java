class n17025298 {
	public static String createMD5(String LZc99TKh) {
		String jGVAhscZ = null;
		String YbJC0KHb = LZc99TKh + StaticBox.getsSalt();
		try {
			MessageDigest xZxho7hy = MessageDigest.getInstance("MD5");
			xZxho7hy.update(YbJC0KHb.getBytes(), 0, YbJC0KHb.length());
			byte Ht65dnNh[] = xZxho7hy.digest();
			StringBuffer cyp5Xm8g = new StringBuffer();
			for (int rwXWWjau = 0; rwXWWjau < Ht65dnNh.length; rwXWWjau++) {
				cyp5Xm8g.append(Integer.toString((Ht65dnNh[rwXWWjau] & 0xff) + 0x100, 16).substring(1));
			}
			jGVAhscZ = cyp5Xm8g.toString();
		} catch (NoSuchAlgorithmException gFqTl5aP) {
			System.err.println("Can not use md5 algorithm");
		}
		return jGVAhscZ;
	}

}