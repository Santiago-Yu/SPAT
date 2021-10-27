class n13720140 {
	private void modifyProperty(String nqGuSVsf, String eZ9cXkOU, Long BGB0uurX) throws JspTagException {
		Property bn65TnHG = new Property(new Long(nqGuSVsf), BGB0uurX);
		String ktNVKcNw = eZ9cXkOU;
		System.out.println(bn65TnHG.getName());
		if (bn65TnHG.getName().equals("Password")) {
			try {
				MessageDigest Z1egSMxz = MessageDigest.getInstance("MD5");
				Z1egSMxz.update(eZ9cXkOU.getBytes());
				byte kpUEgOeD[] = Z1egSMxz.digest();
				StringBuffer WPboqeSn = new StringBuffer();
				for (int aHiohr6R = 0; aHiohr6R < kpUEgOeD.length; aHiohr6R++) {
					WPboqeSn.append(hexDigit(kpUEgOeD[aHiohr6R]));
				}
				ktNVKcNw = WPboqeSn.toString();
				Z1egSMxz.reset();
			} catch (NoSuchAlgorithmException QzCKKEcl) {
				System.err.println(
						"jspShop: Could not get instance of MD5 algorithm. Please fix this!" + QzCKKEcl.getMessage());
				QzCKKEcl.printStackTrace();
				throw new JspTagException("Error crypting password!: " + QzCKKEcl.getMessage());
			}
		}
		bn65TnHG.setValue(ktNVKcNw);
	}

}