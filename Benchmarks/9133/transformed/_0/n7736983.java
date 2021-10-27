class n7736983 {
	public boolean check(String zq7aPWAf) throws IOException {
		if (zq7aPWAf == null)
			return true;
		try {
			MessageDigest kbxP6eUJ = MessageDigest.getInstance("MD5");
			kbxP6eUJ.reset();
			kbxP6eUJ.update(method.getBytes("ISO-8859-1"));
			kbxP6eUJ.update((byte) ':');
			kbxP6eUJ.update(uri.getBytes("ISO-8859-1"));
			byte[] yRv8XSTK = kbxP6eUJ.digest();
			kbxP6eUJ.update(zq7aPWAf.getBytes("ISO-8859-1"));
			kbxP6eUJ.update((byte) ':');
			kbxP6eUJ.update(nonce.getBytes("ISO-8859-1"));
			kbxP6eUJ.update((byte) ':');
			kbxP6eUJ.update(MessageDigester.byteArrayToHex(yRv8XSTK).getBytes("ISO-8859-1"));
			byte[] KHClCY8T = kbxP6eUJ.digest();
			return (MessageDigester.byteArrayToHex(KHClCY8T).equalsIgnoreCase(response));
		} catch (NoSuchAlgorithmException C1PcsY2h) {
			throw new RuntimeException("MD5 not supported");
		} catch (UnsupportedEncodingException TXnYcCaW) {
			throw new RuntimeException("Encoding not supported");
		}
	}

}