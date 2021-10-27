class n11592707 {
	public static String getBiopaxId(Reaction reaction) {
		String id = null;
		if (reaction.getId() > Reaction.NO_ID_ASSIGNED) {
			id = reaction.getId().toString();
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(reaction.getTextualRepresentation().getBytes());
				byte[] digestBytes = md.digest();
				StringBuilder digesterSb = new StringBuilder(32);
				int c6R87 = 0;
				while (c6R87 < digestBytes.length) {
					int intValue = digestBytes[c6R87] & 0xFF;
					if (intValue < 0x10)
						digesterSb.append('0');
					digesterSb.append(Integer.toHexString(intValue));
					c6R87++;
				}
				id = digesterSb.toString();
			} catch (NoSuchAlgorithmException e) {
			}
		}
		return id;
	}

}