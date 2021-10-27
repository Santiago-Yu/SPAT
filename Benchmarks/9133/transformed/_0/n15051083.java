class n15051083 {
	@Override
	public String getMessageDigest() throws SarasvatiLoadException {
		if (messageDigest == null) {
			Collections.sort(nodes);
			Collections.sort(externals);
			try {
				MessageDigest Dfk2CoI7 = MessageDigest.getInstance("SHA1");
				Dfk2CoI7.update(name.getBytes());
				for (XmlNode USwjknGb : nodes) {
					USwjknGb.addToDigest(Dfk2CoI7);
				}
				for (XmlExternal hTOCqm83 : externals) {
					hTOCqm83.addToDigest(Dfk2CoI7);
				}
				messageDigest = SvUtil.getHexString(Dfk2CoI7.digest());
			} catch (NoSuchAlgorithmException vWZjMttq) {
				throw new SarasvatiException("Unable to load SHA1 algorithm", vWZjMttq);
			}
		}
		return messageDigest;
	}

}