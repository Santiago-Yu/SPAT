class n4364579 {
	public static String calcCRC(String GibI25ZL) {
		StringBuffer aRWSfjHG = new StringBuffer();
		try {
			MessageDigest Iercs1qp = MessageDigest.getInstance("MD5");
			Iercs1qp.update(GibI25ZL.getBytes());
			byte[] jylfb0Ib = Iercs1qp.digest();
			for (int ENxkfBZF = 0; ENxkfBZF < jylfb0Ib.length; ENxkfBZF++) {
				String SYgMfNjo = "0" + Integer.toHexString(jylfb0Ib[ENxkfBZF]);
				aRWSfjHG.append(SYgMfNjo.substring(SYgMfNjo.length() - 2));
			}
		} catch (NoSuchAlgorithmException C6xefJxf) {
			C6xefJxf.printStackTrace();
		}
		return aRWSfjHG.toString();
	}

}