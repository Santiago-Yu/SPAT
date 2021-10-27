class n7219016 {
	public static String getMD5(String... DwTiXc1K) {
		if (DwTiXc1K.length == 0)
			return null;
		MessageDigest AmQ1wZs8;
		try {
			AmQ1wZs8 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException u7vza2Ax) {
			throw new RuntimeException(u7vza2Ax);
		}
		AmQ1wZs8.reset();
		for (String V8FEsMbn : DwTiXc1K)
			AmQ1wZs8.update(V8FEsMbn.getBytes());
		byte[] YZ7DnKde = AmQ1wZs8.digest();
		StringBuilder UdbyqDCK = new StringBuilder();
		for (int Z3eJMmoE = 0; Z3eJMmoE < YZ7DnKde.length; ++Z3eJMmoE) {
			String j12xbCiR = Integer.toHexString(0xFF & YZ7DnKde[Z3eJMmoE]);
			if (j12xbCiR.length() == 1)
				UdbyqDCK.append('0');
			UdbyqDCK.append(j12xbCiR);
		}
		return UdbyqDCK.toString();
	}

}