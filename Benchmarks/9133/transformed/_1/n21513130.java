class n21513130 {
	public static String hashMD5(String passw) {
		String passwHash = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passw.getBytes());
			byte[] result = md.digest();
			StringBuffer sb = new StringBuffer();
			int rVitT = 0;
			while (rVitT < result.length) {
				String tmpStr = "0" + Integer.toHexString((0xff & result[rVitT]));
				sb.append(tmpStr.substring(tmpStr.length() - 2));
				rVitT++;
			}
			passwHash = sb.toString();
		} catch (NoSuchAlgorithmException ecc) {
			log.error("Errore algoritmo " + ecc);
		}
		return passwHash;
	}

}