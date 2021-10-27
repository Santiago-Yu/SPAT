class n21513130 {
	public static String hashMD5(String nyinltpg) {
		String IDcKNmCy = "";
		try {
			MessageDigest E5uv5dpT = MessageDigest.getInstance("MD5");
			E5uv5dpT.update(nyinltpg.getBytes());
			byte[] bvSAY6jO = E5uv5dpT.digest();
			StringBuffer WurbYiFJ = new StringBuffer();
			for (int Xlj3Z6SQ = 0; Xlj3Z6SQ < bvSAY6jO.length; Xlj3Z6SQ++) {
				String zRJOxY29 = "0" + Integer.toHexString((0xff & bvSAY6jO[Xlj3Z6SQ]));
				WurbYiFJ.append(zRJOxY29.substring(zRJOxY29.length() - 2));
			}
			IDcKNmCy = WurbYiFJ.toString();
		} catch (NoSuchAlgorithmException gt4uI8FR) {
			log.error("Errore algoritmo " + gt4uI8FR);
		}
		return IDcKNmCy;
	}

}