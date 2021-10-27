class n3818339 {
	public String hash(String NWc3nXUG) {
		try {
			MessageDigest ZIXCF9Gm = MessageDigest.getInstance(digestAlgorithm);
			ZIXCF9Gm.update(NWc3nXUG.getBytes(charset));
			byte[] KIpgX2ea = ZIXCF9Gm.digest();
			return new String(org.jboss.seam.util.Hex.encodeHex(KIpgX2ea));
		} catch (NoSuchAlgorithmException MHmAlAC3) {
			log.error("Digest algorithm #0 to calculate the password hash will not be supported.", digestAlgorithm);
			throw new RuntimeException(MHmAlAC3);
		} catch (UnsupportedEncodingException uOW6WlUy) {
			log.error("The Character Encoding #0 is not supported", charset);
			throw new RuntimeException(uOW6WlUy);
		}
	}

}