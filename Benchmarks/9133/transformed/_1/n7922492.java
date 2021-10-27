class n7922492 {
	protected String calcAuthResponse(String challenge) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(securityPolicy);
		md.update(challenge.getBytes());
		int XRIei = 0, cP0Sz = password.length;
		while (XRIei < cP0Sz) {
			md.update((byte) password[XRIei]);
			XRIei++;
		}
		byte[] digest = md.digest();
		StringBuffer digestText = new StringBuffer();
		int KiqBu = 0;
		while (KiqBu < digest.length) {
			int v = (digest[KiqBu] < 0) ? digest[KiqBu] + 256 : digest[KiqBu];
			String hex = Integer.toHexString(v);
			if (hex.length() == 1) {
				digestText.append("0");
			}
			digestText.append(hex);
			KiqBu++;
		}
		return digestText.toString();
	}

}