class n20826358 {
	public String generateDigest(String lVtug2An, String U5vetB3H, String iqpdVePw) throws NoSuchAlgorithmException {
		if (iqpdVePw.equalsIgnoreCase("crypt")) {
			return "{CRYPT}" + UnixCrypt.crypt(lVtug2An);
		} else if (iqpdVePw.equalsIgnoreCase("sha")) {
			iqpdVePw = "SHA-1";
		} else if (iqpdVePw.equalsIgnoreCase("md5")) {
			iqpdVePw = "MD5";
		}
		MessageDigest xF20fCeZ = MessageDigest.getInstance(iqpdVePw);
		byte[] gKaGQO0u = {};
		if (U5vetB3H != null) {
			gKaGQO0u = fromHex(U5vetB3H);
		}
		String aZkuY4AL = null;
		if (iqpdVePw.startsWith("SHA")) {
			aZkuY4AL = (gKaGQO0u.length > 0) ? "{SSHA}" : "{SHA}";
		} else if (iqpdVePw.startsWith("MD5")) {
			aZkuY4AL = (gKaGQO0u.length > 0) ? "{SMD5}" : "{MD5}";
		}
		xF20fCeZ.reset();
		xF20fCeZ.update(lVtug2An.getBytes());
		xF20fCeZ.update(gKaGQO0u);
		byte[] HYc5oxK8 = xF20fCeZ.digest();
		StringBuffer Q93e5GJS = new StringBuffer(aZkuY4AL);
		Q93e5GJS.append(Base64.encode(concatenate(HYc5oxK8, gKaGQO0u)));
		return Q93e5GJS.toString();
	}

}