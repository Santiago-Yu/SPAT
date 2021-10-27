class n6317842 {
	public static String MD5(String UCDJQOy0, String WbYfqkvy) {
		MessageDigest xGd1vnai = null;
		try {
			xGd1vnai = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException GcfOXbcy) {
			GcfOXbcy.printStackTrace();
		}
		xGd1vnai.reset();
		try {
			xGd1vnai.update(UCDJQOy0.getBytes(WbYfqkvy));
		} catch (UnsupportedEncodingException PknygoA3) {
			PknygoA3.printStackTrace();
		}
		byte[] pMTj70mf = xGd1vnai.digest();
		StringBuffer cm84U8tw = new StringBuffer();
		for (int MKSzucxv = 0; MKSzucxv < pMTj70mf.length; MKSzucxv++) {
			if (Integer.toHexString(0xFF & pMTj70mf[MKSzucxv]).length() == 1)
				cm84U8tw.append("0").append(Integer.toHexString(0xFF & pMTj70mf[MKSzucxv]));
			else
				cm84U8tw.append(Integer.toHexString(0xFF & pMTj70mf[MKSzucxv]));
		}
		return cm84U8tw.toString();
	}

}