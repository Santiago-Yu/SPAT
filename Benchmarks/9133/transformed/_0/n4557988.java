class n4557988 {
	public Attributes getAttributes()
			throws SchemaViolationException, NoSuchAlgorithmException, UnsupportedEncodingException {
		BasicAttributes ZrTEcppv = new BasicAttributes(true);
		BasicAttribute OhVFufzA = new BasicAttribute("objectclass", "inetOrgPerson");
		OhVFufzA.add("organizationalPerson");
		OhVFufzA.add("person");
		ZrTEcppv.put(OhVFufzA);
		if (lastName != null && firstName != null) {
			ZrTEcppv.put("sn", lastName);
			ZrTEcppv.put("givenName", firstName);
			ZrTEcppv.put("cn", firstName + " " + lastName);
		} else {
			throw new SchemaViolationException("user must have surname");
		}
		if (password != null) {
			MessageDigest yivOyqbv = MessageDigest.getInstance("md5");
			yivOyqbv.reset();
			yivOyqbv.update(password.getBytes("utf-8"));
			byte[] V2xRUBS5 = yivOyqbv.digest();
			String ChhGykl3 = Base64.encodeBase64String(V2xRUBS5);
			ZrTEcppv.put("userPassword", "{MD5}" + ChhGykl3);
		}
		if (email != null) {
			ZrTEcppv.put("mail", email);
		}
		return (Attributes) ZrTEcppv;
	}

}