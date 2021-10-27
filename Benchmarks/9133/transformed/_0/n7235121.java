class n7235121 {
	public static final String getUniqueId() {
		String SYKXABPZ = "";
		try {
			MessageDigest SHBES4qv = MessageDigest.getInstance("MD5");
			String XtNTq8Q3 = "" + (System.currentTimeMillis() + 1);
			String RGTTKOjw = "";
			try {
				RGTTKOjw = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException kBwaSd4U) {
				throw new RuntimeException("Error trying to get localhost" + kBwaSd4U.getMessage());
			}
			String UvwsDpks = "" + new Random().nextInt();
			String FqQqY0Pu = XtNTq8Q3 + RGTTKOjw + UvwsDpks;
			SHBES4qv.reset();
			SHBES4qv.update(FqQqY0Pu.getBytes());
			SYKXABPZ = toHexString(SHBES4qv.digest());
		} catch (NoSuchAlgorithmException RElnJp1K) {
			throw new RuntimeException("NoSuchAlgorithmException : " + RElnJp1K.getMessage());
		}
		return SYKXABPZ;
	}

}