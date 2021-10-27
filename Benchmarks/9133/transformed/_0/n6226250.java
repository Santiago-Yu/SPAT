class n6226250 {
	public static String MD5(String K9oOgNXI) {
		try {
			MessageDigest vl6ZAEc4 = MessageDigest.getInstance("MD5");
			vl6ZAEc4.update(K9oOgNXI.getBytes());
			byte[] lqNO9meI = vl6ZAEc4.digest();
			int LtkvV9zR = 0;
			StringBuffer w4YWCYHB = new StringBuffer();
			for (int Ce2rA3XR = 0; Ce2rA3XR < lqNO9meI.length; Ce2rA3XR++) {
				LtkvV9zR = lqNO9meI[Ce2rA3XR];
				if (LtkvV9zR < 0) {
					LtkvV9zR += 256;
				}
				if (LtkvV9zR < 16) {
					w4YWCYHB.append("0");
				}
				w4YWCYHB.append(Integer.toHexString(LtkvV9zR));
			}
			return w4YWCYHB.toString();
		} catch (NoSuchAlgorithmException XID8UbLK) {
			XID8UbLK.printStackTrace();
			return "ERROR";
		}
	}

}