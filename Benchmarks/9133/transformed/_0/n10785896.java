class n10785896 {
	private void createProperty(String njXBsiFi, String p99CEWsL, String YbVivr4x, Long hFlg4B4t)
			throws JspTagException {
		ClassProperty jL5YaMFH = new ClassProperty(new Long(YbVivr4x));
		String cYRK9mto = p99CEWsL;
		if (jL5YaMFH.getName().equals("Password")) {
			try {
				MessageDigest HOKqNGlb = MessageDigest.getInstance("MD5");
				HOKqNGlb.update(p99CEWsL.getBytes());
				byte uhblmSyl[] = HOKqNGlb.digest();
				StringBuffer rpNoU5jS = new StringBuffer();
				for (int ws9sfz65 = 0; ws9sfz65 < uhblmSyl.length; ws9sfz65++) {
					rpNoU5jS.append(hexDigit(uhblmSyl[ws9sfz65]));
				}
				cYRK9mto = rpNoU5jS.toString();
				HOKqNGlb.reset();
			} catch (NoSuchAlgorithmException bDsJISnO) {
				System.err.println(
						"jspShop: Could not get instance of MD5 algorithm. Please fix this!" + bDsJISnO.getMessage());
				bDsJISnO.printStackTrace();
				throw new JspTagException("Error crypting password!: " + bDsJISnO.getMessage());
			}
		}
		Properties MHpbO1Vp = new Properties(new Long(njXBsiFi), hFlg4B4t);
		try {
			Property flGGACRF = MHpbO1Vp.create(new Long(YbVivr4x), cYRK9mto);
			pageContext.setAttribute(getId(), flGGACRF);
		} catch (CreateException nyaLFDUp) {
			throw new JspTagException("Could not create PropertyValue, CreateException: " + nyaLFDUp.getMessage());
		}
	}

}