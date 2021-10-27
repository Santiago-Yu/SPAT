class n1162904 {
	public byte[] computeMD5(String VPRhk76B) throws VHException {
		MessageDigest Wfyj3gla = null;
		try {
			Wfyj3gla = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException DmVAXhCn) {
			throw new VHException("The MD5 hash algorithm is not available.", DmVAXhCn);
		}
		try {
			Wfyj3gla.update(VPRhk76B.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException vocaB4kO) {
			throw new VHException("The UTF-8 encoding is not supported.", vocaB4kO);
		}
		return Wfyj3gla.digest();
	}

}