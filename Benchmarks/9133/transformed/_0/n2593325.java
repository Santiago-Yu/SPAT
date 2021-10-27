class n2593325 {
	public static String getMD5Str(String tsA9VUl6) {
		MessageDigest WcpNSAEx = null;
		try {
			WcpNSAEx = MessageDigest.getInstance("MD5");
			WcpNSAEx.reset();
			WcpNSAEx.update(tsA9VUl6.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException NWTGTp0r) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException n8y1mp4N) {
			n8y1mp4N.printStackTrace();
		}
		byte[] GVKi9SkJ = WcpNSAEx.digest();
		StringBuffer ACN7h5Qg = new StringBuffer();
		for (int pdtK1TQD = 0; pdtK1TQD < GVKi9SkJ.length; pdtK1TQD++) {
			if (Integer.toHexString(0xFF & GVKi9SkJ[pdtK1TQD]).length() == 1)
				ACN7h5Qg.append("0").append(Integer.toHexString(0xFF & GVKi9SkJ[pdtK1TQD]));
			else
				ACN7h5Qg.append(Integer.toHexString(0xFF & GVKi9SkJ[pdtK1TQD]));
		}
		return ACN7h5Qg.substring(8, 24).toString().toUpperCase();
	}

}