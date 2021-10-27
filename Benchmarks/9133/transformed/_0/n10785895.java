class n10785895 {
	private void createPropertyName(String uNvYRvPM, String jWAU2n5h, String VmrliyEn, Long WEE8Fbca)
			throws JspTagException {
		rObject Rei4Oftq = new rObject(new Long(uNvYRvPM), WEE8Fbca);
		ClassProperty IYuKrK6x = new ClassProperty(VmrliyEn, Rei4Oftq.getClassName());
		String jTSnEDkt = jWAU2n5h;
		if (IYuKrK6x.getName().equals("Password")) {
			try {
				MessageDigest QJUgjq7y = MessageDigest.getInstance("MD5");
				QJUgjq7y.update(jWAU2n5h.getBytes());
				byte Ue51D9do[] = QJUgjq7y.digest();
				StringBuffer Vrn5uAAD = new StringBuffer();
				for (int X6KmEfko = 0; X6KmEfko < Ue51D9do.length; X6KmEfko++) {
					Vrn5uAAD.append(hexDigit(Ue51D9do[X6KmEfko]));
				}
				jTSnEDkt = Vrn5uAAD.toString();
				QJUgjq7y.reset();
			} catch (NoSuchAlgorithmException Z0bRsI0z) {
				System.err.println(
						"jspShop: Could not get instance of MD5 algorithm. Please fix this!" + Z0bRsI0z.getMessage());
				Z0bRsI0z.printStackTrace();
				throw new JspTagException("Error crypting password!: " + Z0bRsI0z.getMessage());
			}
		}
		Properties knRqkRJU = new Properties(new Long(uNvYRvPM), WEE8Fbca);
		try {
			Property dgLrbtPg = knRqkRJU.create(IYuKrK6x.getID(), jTSnEDkt);
			pageContext.setAttribute(getId(), dgLrbtPg);
		} catch (CreateException CGIhYQoX) {
			throw new JspTagException("Could not create PropertyValue, CreateException: " + CGIhYQoX.getMessage());
		}
	}

}