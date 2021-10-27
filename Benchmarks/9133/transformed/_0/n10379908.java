class n10379908 {
	public void setContentMD5() {
		MessageDigest vELm1CML = null;
		try {
			vELm1CML = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException wIbfwwIY) {
			wIbfwwIY.printStackTrace();
			contentMD5 = null;
		}
		vELm1CML.update(content.getBytes());
		byte ekZZbsrO[] = vELm1CML.digest();
		String LHzsY34y = "";
		for (int CQrog0do = 0; CQrog0do < ekZZbsrO.length; CQrog0do++) {
			String OggoFqhL = Integer.toHexString(ekZZbsrO[CQrog0do] & 0xFF);
			LHzsY34y += ((OggoFqhL.length() == 1) ? "0" + OggoFqhL : OggoFqhL);
		}
		contentMD5 = LHzsY34y;
	}

}