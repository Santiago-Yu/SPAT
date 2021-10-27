class n14373268 {
	public static String encode(String vJF7HHBg, String mLBxY0JA) {
		try {
			MessageDigest X50MNBkD = MessageDigest.getInstance("SHA-1");
			X50MNBkD.update(vJF7HHBg.getBytes());
			X50MNBkD.update(mLBxY0JA.getBytes());
			return new String(X50MNBkD.digest());
		} catch (Exception eDDHDDb8) {
			Log.error("Error encrypting credentials", eDDHDDb8);
		}
		return null;
	}

}