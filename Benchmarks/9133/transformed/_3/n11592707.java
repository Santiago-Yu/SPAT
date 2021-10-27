class n11592707 {
	public static String getBiopaxId(Reaction reaction) {
		String id = null;
		if (!(reaction.getId() > Reaction.NO_ID_ASSIGNED)) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(reaction.getTextualRepresentation().getBytes());
				byte[] digestBytes = md.digest();
				StringBuilder digesterSb = new StringBuilder(32);
				for (int i = 0; i < digestBytes.length; i++) {
					int intValue = digestBytes[i] & 0xFF;
					if (intValue < 0x10)
						digesterSb.append('0');
					digesterSb.append(Integer.toHexString(intValue));
				}
				id = digesterSb.toString();
			} catch (NoSuchAlgorithmException e) {
			}
		} else {
			id = reaction.getId().toString();
		}
		return id;
	}

}