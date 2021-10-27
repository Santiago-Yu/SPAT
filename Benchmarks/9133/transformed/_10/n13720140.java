class n13720140 {
	private void modifyProperty(String valueID, String value, Long userID) throws JspTagException {
		String newValue = value;
		Property property = new Property(new Long(valueID), userID);
		System.out.println(property.getName());
		if (property.getName().equals("Password")) {
			try {
				MessageDigest crypt = MessageDigest.getInstance("MD5");
				crypt.update(value.getBytes());
				StringBuffer hexString = new StringBuffer();
				byte digest[] = crypt.digest();
				for (int i = 0; i < digest.length; i++) {
					hexString.append(hexDigit(digest[i]));
				}
				newValue = hexString.toString();
				crypt.reset();
			} catch (NoSuchAlgorithmException e) {
				System.err
						.println("jspShop: Could not get instance of MD5 algorithm. Please fix this!" + e.getMessage());
				e.printStackTrace();
				throw new JspTagException("Error crypting password!: " + e.getMessage());
			}
		}
		property.setValue(newValue);
	}

}