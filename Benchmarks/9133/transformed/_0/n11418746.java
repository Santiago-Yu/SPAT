class n11418746 {
	private String buildShaHashOf(String Bgp2xgCg) {
		try {
			MessageDigest hQgahUop = MessageDigest.getInstance("SHA");
			hQgahUop.update(Bgp2xgCg.getBytes());
			return new BigInteger(1, hQgahUop.digest()).toString(16);
		} catch (NoSuchAlgorithmException r1VcHTzJ) {
			r1VcHTzJ.printStackTrace();
			return "";
		}
	}

}