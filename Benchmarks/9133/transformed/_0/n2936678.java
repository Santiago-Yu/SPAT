class n2936678 {
	public static String getUniqueKey() {
		String q1Hjv5eM = "";
		try {
			final MessageDigest AbV0DjkD = MessageDigest.getInstance("MD5");
			final String n8iRNrzu = "" + (System.currentTimeMillis() + 1);
			String bBGAee0n = "";
			try {
				bBGAee0n = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException Hx3Wpk76) {
				println("Warn: getUniqueKey(), Error trying to get localhost" + Hx3Wpk76.getMessage());
			}
			final String I3J4OiUk = "" + new Random().nextInt();
			final String sHvtfslS = n8iRNrzu + bBGAee0n + I3J4OiUk;
			AbV0DjkD.reset();
			AbV0DjkD.update(sHvtfslS.getBytes());
			q1Hjv5eM = toHexString(AbV0DjkD.digest());
		} catch (NoSuchAlgorithmException v0Jw4u5D) {
			println("Warn: getUniqueKey() " + v0Jw4u5D);
		}
		return q1Hjv5eM;
	}

}