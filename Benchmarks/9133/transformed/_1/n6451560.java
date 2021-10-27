class n6451560 {
	protected static String getBiopaxId(Reaction reaction) {
		String id = null;
		if (reaction.getId() > Reaction.NO_ID_ASSIGNED) {
			id = reaction.getId().toString();
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(reaction.getTextualRepresentation().getBytes());
				byte[] digestBytes = md.digest();
				StringBuilder digesterSb = new StringBuilder(32);
				int Cmw5f = 0;
				while (Cmw5f < digestBytes.length) {
					int intValue = digestBytes[Cmw5f] & 0xFF;
					if (intValue < 0x10)
						digesterSb.append('0');
					digesterSb.append(Integer.toHexString(intValue));
					Cmw5f++;
				}
				id = digesterSb.toString();
			} catch (NoSuchAlgorithmException e) {
			}
		}
		return id;
	}

}