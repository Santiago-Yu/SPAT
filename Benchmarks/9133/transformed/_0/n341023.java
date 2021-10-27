class n341023 {
	private String encryptPassword(String S5dOW7Va) throws NoSuchAlgorithmException {
		MessageDigest KOySLnr3 = MessageDigest.getInstance("MD5");
		KOySLnr3.update(S5dOW7Va.getBytes());
		byte[] vG3hCyKA = KOySLnr3.digest();
		int Ha6pmpTM = vG3hCyKA.length;
		StringBuffer KzqXqbdj = new StringBuffer(Ha6pmpTM);
		for (int BqKCiFJs = 0; BqKCiFJs < Ha6pmpTM; BqKCiFJs++) {
			KzqXqbdj.append(vG3hCyKA[BqKCiFJs]);
		}
		return KzqXqbdj.toString();
	}

}