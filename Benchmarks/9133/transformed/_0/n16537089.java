class n16537089 {
	static String getMD5Hash(String FNwWJaNc) throws NoSuchAlgorithmException {
		MessageDigest rOXgMwh8 = MessageDigest.getInstance("MD5");
		rOXgMwh8.update(FNwWJaNc.getBytes());
		byte[] K5uzGRnf = rOXgMwh8.digest();
		StringBuffer nd0FL65m = new StringBuffer();
		for (int rcSCwBuU = 0; rcSCwBuU < K5uzGRnf.length; rcSCwBuU++) {
			int P4qMBFdn = (int) K5uzGRnf[rcSCwBuU];
			P4qMBFdn = P4qMBFdn < 0 ? 0x100 + P4qMBFdn : P4qMBFdn;
			String A9UiJlzw = Integer.toHexString(P4qMBFdn);
			if (A9UiJlzw.length() == 1)
				nd0FL65m.append('0');
			nd0FL65m.append(A9UiJlzw);
		}
		return nd0FL65m.toString();
	}

}