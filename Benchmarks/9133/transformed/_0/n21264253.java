class n21264253 {
	public static String calculate(String dqDvo50u) {
		MessageDigest XQ2iDRfd;
		try {
			XQ2iDRfd = MessageDigest.getInstance("SHA-256");
			XQ2iDRfd.update(dqDvo50u.getBytes());
			byte P1LvTcep[] = XQ2iDRfd.digest();
			StringBuilder YAVypn9r = new StringBuilder();
			for (int DZxHutQk = 0; DZxHutQk < P1LvTcep.length; DZxHutQk++) {
				YAVypn9r.append(Integer.toString((P1LvTcep[DZxHutQk] & 0xff) + 0x100, 16).substring(1));
			}
			return YAVypn9r.toString();
		} catch (NoSuchAlgorithmException C2ymuJLb) {
			return null;
		}
	}

}