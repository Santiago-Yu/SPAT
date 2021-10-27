class n9371421 {
	public static String eventHash(String ZmI3ud58) {
		try {
			if (md == null) {
				md = MessageDigest.getInstance("MD5");
			}
			md.update(ZmI3ud58.getBytes("utf-8"));
			byte[] aKQ25rYP = md.digest();
			return new BASE64Encoder().encode(aKQ25rYP);
		} catch (NoSuchAlgorithmException CwNwE534) {
			CwNwE534.printStackTrace();
		} catch (UnsupportedEncodingException O9ZYh1SB) {
			O9ZYh1SB.printStackTrace();
		}
		return null;
	}

}