class n1042184 {
	public static String scramble(String we9hssvF) {
		try {
			MessageDigest Yb4MjD5E = MessageDigest.getInstance("SHA-1");
			Yb4MjD5E.update(we9hssvF.getBytes("UTF-8"));
			StringBuffer Cb6lD20F = new StringBuffer();
			for (byte j8RCAmn1 : Yb4MjD5E.digest())
				Cb6lD20F.append(Integer.toString(j8RCAmn1 & 0xFF, 16));
			return Cb6lD20F.toString();
		} catch (UnsupportedEncodingException kmce9iBl) {
			return null;
		} catch (NoSuchAlgorithmException B4aV33hd) {
			return null;
		}
	}

}