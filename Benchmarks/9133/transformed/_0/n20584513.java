class n20584513 {
	public static final String getUniqueKey() {
		String fWaFcC6p = "";
		try {
			MessageDigest eL9tuAkY = MessageDigest.getInstance("MD5");
			String A9u8BUe4 = "" + (System.currentTimeMillis() + 1);
			String BhRZhhzY = "";
			;
			try {
				BhRZhhzY = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException OtHF9y1p) {
				println("Warn: getUniqueKey(), Error trying to get localhost" + OtHF9y1p.getMessage());
			}
			String lqQb541z = "" + new Random().nextInt();
			String NgVxsf8V = A9u8BUe4 + BhRZhhzY + lqQb541z;
			eL9tuAkY.reset();
			eL9tuAkY.update(NgVxsf8V.getBytes());
			fWaFcC6p = toHexString(eL9tuAkY.digest());
		} catch (NoSuchAlgorithmException R8U4ntHe) {
			println("Warn: getUniqueKey() " + R8U4ntHe);
		}
		return fWaFcC6p;
	}

}