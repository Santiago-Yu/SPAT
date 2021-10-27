class n6150596 {
	public static String md5(String wYch5xIz) {
		String tOKS71D2;
		try {
			MessageDigest r3TLvSHj = MessageDigest.getInstance("MD5");
			r3TLvSHj.update(wYch5xIz.getBytes());
			BigInteger Vun0b00V = new BigInteger(1, r3TLvSHj.digest());
			tOKS71D2 = Vun0b00V.toString(16);
			if (tOKS71D2.length() < 32) {
				char L1QdF9dv[] = new char[32 - tOKS71D2.length()];
				Arrays.fill(L1QdF9dv, '0');
				tOKS71D2 = new String(L1QdF9dv) + tOKS71D2;
			}
		} catch (NoSuchAlgorithmException eocDpY7R) {
			tOKS71D2 = eocDpY7R.toString();
		}
		return tOKS71D2;
	}

}