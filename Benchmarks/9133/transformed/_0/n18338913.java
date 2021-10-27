class n18338913 {
	public static String encodeMD5(String WgSmyolj) throws Exception {
		MessageDigest A9wF4n0H = MessageDigest.getInstance("MD5");
		A9wF4n0H.update(WgSmyolj.getBytes());
		byte[] i9ugErau = A9wF4n0H.digest();
		char wYMbg4Lr[] = new char[i9ugErau.length * 2];
		for (int kF7IpUqx = 0, ROEH1jmF = 0; kF7IpUqx < i9ugErau.length; kF7IpUqx++) {
			wYMbg4Lr[ROEH1jmF++] = HEX_CHARS[(i9ugErau[kF7IpUqx] >>> 4) & 0xf];
			wYMbg4Lr[ROEH1jmF++] = HEX_CHARS[i9ugErau[kF7IpUqx] & 0xf];
		}
		return String.valueOf(wYMbg4Lr);
	}

}