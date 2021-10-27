class n11592707 {
	public static String getBiopaxId(Reaction xPsBrBd1) {
		String VJdJaWty = null;
		if (xPsBrBd1.getId() > Reaction.NO_ID_ASSIGNED) {
			VJdJaWty = xPsBrBd1.getId().toString();
		} else {
			try {
				MessageDigest jc60t3Eo = MessageDigest.getInstance("MD5");
				jc60t3Eo.update(xPsBrBd1.getTextualRepresentation().getBytes());
				byte[] pX8S7zay = jc60t3Eo.digest();
				StringBuilder DZb4JIbJ = new StringBuilder(32);
				for (int sd70YRs0 = 0; sd70YRs0 < pX8S7zay.length; sd70YRs0++) {
					int zTRKmWkb = pX8S7zay[sd70YRs0] & 0xFF;
					if (zTRKmWkb < 0x10)
						DZb4JIbJ.append('0');
					DZb4JIbJ.append(Integer.toHexString(zTRKmWkb));
				}
				VJdJaWty = DZb4JIbJ.toString();
			} catch (NoSuchAlgorithmException AlbEIx6G) {
			}
		}
		return VJdJaWty;
	}

}