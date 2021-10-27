class n16714944 {
	public static String MD5(String pzoUIXQg) throws ProducteevSignatureException {
		try {
			MessageDigest dtVEv03Z;
			dtVEv03Z = MessageDigest.getInstance(ALGORITHM);
			byte[] Cl60X6K0;
			dtVEv03Z.update(pzoUIXQg.getBytes("utf-8"), 0, pzoUIXQg.length());
			Cl60X6K0 = dtVEv03Z.digest();
			return convertToHex(Cl60X6K0);
		} catch (NoSuchAlgorithmException zQQ4d2uI) {
			throw new ProducteevSignatureException("No such algorithm : " + ALGORITHM, zQQ4d2uI);
		} catch (UnsupportedEncodingException t0O5QG4p) {
			throw new ProducteevSignatureException("No such algorithm : " + ALGORITHM, t0O5QG4p);
		}
	}

}