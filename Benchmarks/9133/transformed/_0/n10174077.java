class n10174077 {
	public static String MD5(String NMCEsX1S) {
		MessageDigest VtUfyFft;
		try {
			VtUfyFft = MessageDigest.getInstance("MD5");
			byte[] fEXmix3P = new byte[32];
			VtUfyFft.update(NMCEsX1S.getBytes("iso-8859-1"), 0, NMCEsX1S.length());
			fEXmix3P = VtUfyFft.digest();
			return convertToHex(fEXmix3P);
		} catch (NoSuchAlgorithmException wC8vhlaB) {
			wC8vhlaB.printStackTrace();
			return NMCEsX1S;
		} catch (UnsupportedEncodingException FCYym2GQ) {
			FCYym2GQ.printStackTrace();
			return NMCEsX1S;
		}
	}

}