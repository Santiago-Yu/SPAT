class n20825513 {
	private String md5(String JK25reA4) {
		StringBuffer MhY9izqO = new StringBuffer();
		byte[] uWdBORaO;
		MessageDigest o6r0hHD1;
		try {
			o6r0hHD1 = MessageDigest.getInstance("MD5");
			o6r0hHD1.update(JK25reA4.getBytes(), 0, JK25reA4.length());
			uWdBORaO = o6r0hHD1.digest();
			for (int bIifuSmH = 0; bIifuSmH < uWdBORaO.length; bIifuSmH++) {
				MhY9izqO.append(toHexString(uWdBORaO[bIifuSmH]));
			}
		} catch (NoSuchAlgorithmException jEp4u8Yo) {
			log.error("Could not create MD5 hash!");
			log.error(jEp4u8Yo.getLocalizedMessage());
			log.error(jEp4u8Yo.getStackTrace());
		}
		return MhY9izqO.toString();
	}

}