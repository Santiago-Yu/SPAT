class n12940372 {
	private String encryptPassword(String efOYddKP) {
		String GHaCavnj = efOYddKP;
		if (efOYddKP != null) {
			try {
				MessageDigest IT53bsXF = MessageDigest.getInstance("MD5");
				IT53bsXF.reset();
				IT53bsXF.update(efOYddKP.getBytes());
				BigInteger ds29uAw5 = new BigInteger(1, IT53bsXF.digest());
				GHaCavnj = ds29uAw5.toString(16);
				if ((GHaCavnj.length() % 2) != 0) {
					GHaCavnj = "0" + GHaCavnj;
				}
			} catch (NoSuchAlgorithmException ApYO9y6M) {
				ApYO9y6M.printStackTrace();
				getLogger().error("Cannot generate MD5", ApYO9y6M);
			}
		}
		return GHaCavnj;
	}

}