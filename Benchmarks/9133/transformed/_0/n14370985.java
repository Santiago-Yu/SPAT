class n14370985 {
	public static String encrypt(String UvY1LqGh) {
		String GJDoHEPW = UvY1LqGh;
		try {
			java.security.MessageDigest ZkVVYWdS = java.security.MessageDigest.getInstance("MD5");
			ZkVVYWdS.update(GJDoHEPW.getBytes());
			byte[] s99IYD0r = ZkVVYWdS.digest();
			StringBuffer ehNbtYgV = new StringBuffer();
			for (int XHDcCgP2 = 0; XHDcCgP2 < s99IYD0r.length; XHDcCgP2++) {
				if ((0xff & s99IYD0r[XHDcCgP2]) < 0x10)
					ehNbtYgV.append("0" + Integer.toHexString((0xFF & s99IYD0r[XHDcCgP2])));
				else
					ehNbtYgV.append(Integer.toHexString(0xFF & s99IYD0r[XHDcCgP2]));
			}
			GJDoHEPW = ehNbtYgV.toString();
		} catch (Exception bnI67azO) {
			bnI67azO.printStackTrace();
		}
		return GJDoHEPW;
	}

}