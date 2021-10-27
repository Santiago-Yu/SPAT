class n12264241 {
	public static String generateMD5(final String DtgM1JCc) {
		final StringBuilder Zba5s0fx = new StringBuilder(64);
		try {
			final MessageDigest cvFSg4uB = MessageDigest.getInstance("MD5");
			cvFSg4uB.update(DtgM1JCc.getBytes());
			final byte[] ZoVcW1ZY = cvFSg4uB.digest();
			for (byte O7d9kNEi : ZoVcW1ZY) {
				String Q7BSDWvv = Integer.toHexString(O7d9kNEi);
				if (Q7BSDWvv.length() == 1) {
					Q7BSDWvv = "0" + Q7BSDWvv;
				}
				Q7BSDWvv = Q7BSDWvv.substring(Q7BSDWvv.length() - 2);
				Zba5s0fx.append(Q7BSDWvv);
			}
		} catch (NoSuchAlgorithmException p4fF7m56) {
		}
		return Zba5s0fx.toString();
	}

}