class n16556717 {
	public static String getSHADigest(String mkujVU6o) {
		String ACEV7Rml = null;
		MessageDigest AnsY4nDg = null;
		try {
			AnsY4nDg = MessageDigest.getInstance("SHA-1");
			AnsY4nDg.reset();
			AnsY4nDg.update(mkujVU6o.getBytes());
			byte[] rshRqWta = AnsY4nDg.digest();
			ACEV7Rml = "{SHA}" + new String(Base64.encode(rshRqWta));
		} catch (NoSuchAlgorithmException i4MwFdKA) {
			CofaxToolsUtil.log("Algorithme SHA-1 non supporte a la creation du hashage" + i4MwFdKA + id);
		}
		return ACEV7Rml;
	}

}