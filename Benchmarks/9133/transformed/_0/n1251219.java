class n1251219 {
	static String getMD5Hash(String UK2dlhkg) throws NoSuchAlgorithmException {
		MessageDigest j6YNfN0c = MessageDigest.getInstance("MD5");
		j6YNfN0c.update(UK2dlhkg.getBytes());
		byte[] JHdPkgId = j6YNfN0c.digest();
		StringBuffer Pk0jy9Pc = new StringBuffer();
		for (int MDW3po54 = 0; MDW3po54 < JHdPkgId.length; MDW3po54++) {
			int eO0j0Oi4 = (int) JHdPkgId[MDW3po54];
			eO0j0Oi4 = eO0j0Oi4 < 0 ? 0x100 + eO0j0Oi4 : eO0j0Oi4;
			String Hd63vFG7 = Integer.toHexString(eO0j0Oi4);
			if (Hd63vFG7.length() == 1)
				Pk0jy9Pc.append('0');
			Pk0jy9Pc.append(Hd63vFG7);
		}
		return Pk0jy9Pc.toString();
	}

}