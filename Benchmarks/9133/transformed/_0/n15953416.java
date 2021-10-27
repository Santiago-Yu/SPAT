class n15953416 {
	public static String getMD5(String LTyDZuVC) {
		try {
			MessageDigest P8HfZloy = MessageDigest.getInstance("MD5");
			String TH3I25Qj = "UseTheForce4";
			LTyDZuVC = TH3I25Qj + LTyDZuVC;
			P8HfZloy.update(LTyDZuVC.getBytes(), 0, LTyDZuVC.length());
			LTyDZuVC = new BigInteger(1, P8HfZloy.digest()).toString(16);
		} catch (Exception MF7nI7DY) {
		}
		return LTyDZuVC;
	}

}