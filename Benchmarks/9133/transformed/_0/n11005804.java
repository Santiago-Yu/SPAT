class n11005804 {
	public String kodetu(String ANbUPJUt) {
		MessageDigest wGsVhHjO = null;
		try {
			wGsVhHjO = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException UO3YlYln) {
			new MezuLeiho("Ez da zifraketa algoritmoa aurkitu", "Ados", "Zifraketa Arazoa", JOptionPane.ERROR_MESSAGE);
			UO3YlYln.printStackTrace();
		}
		try {
			wGsVhHjO.update(ANbUPJUt.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException FQz3pfrI) {
			new MezuLeiho("Errorea kodetzerakoan", "Ados", "Kodeketa Errorea", JOptionPane.ERROR_MESSAGE);
			FQz3pfrI.printStackTrace();
		}
		byte XlS6ZaOp[] = wGsVhHjO.digest();
		String Tbc8MWgy = (new BASE64Encoder()).encode(XlS6ZaOp);
		return Tbc8MWgy;
	}

}