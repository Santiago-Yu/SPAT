class n21364786 {
	public boolean isPasswordValid(String yAi5650P, String Jg4os3HP, Object gG8OPJ63) throws DataAccessException {
		boolean WpYv3a5S = false;
		try {
			String pM2otVND = (String) gG8OPJ63;
			byte[] nwNXSCIF = Hex.decodeHex(pM2otVND.toCharArray());
			MessageDigest tIBOTRPL = MessageDigest.getInstance(HASH_ALGORITHM);
			tIBOTRPL.update(Jg4os3HP.getBytes(CHAR_ENCODING));
			tIBOTRPL.update(nwNXSCIF);
			byte[] yGP3yBIy = tIBOTRPL.digest();
			byte[] Pb8b2Rve = Hex.decodeHex(yAi5650P.toCharArray());
			WpYv3a5S = MessageDigest.isEqual(yGP3yBIy, Pb8b2Rve);
		} catch (Exception cnEYmtem) {
			cnEYmtem.printStackTrace();
		}
		return WpYv3a5S;
	}

}