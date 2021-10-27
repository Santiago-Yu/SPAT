class n20004216 {
	public boolean check(Object VwNfNhtx) {
		String mNSAE0X7 = (VwNfNhtx instanceof String) ? (String) VwNfNhtx : VwNfNhtx.toString();
		try {
			MessageDigest dZzEneRH = MessageDigest.getInstance("MD5");
			byte[] DdxkYiA9;
			if (VwNfNhtx instanceof Credential.MD5) {
				DdxkYiA9 = ((Credential.MD5) VwNfNhtx).getDigest();
			} else {
				dZzEneRH.update(username.getBytes(StringUtil.__ISO_8859_1));
				dZzEneRH.update((byte) ':');
				dZzEneRH.update(realm.getBytes(StringUtil.__ISO_8859_1));
				dZzEneRH.update((byte) ':');
				dZzEneRH.update(mNSAE0X7.getBytes(StringUtil.__ISO_8859_1));
				DdxkYiA9 = dZzEneRH.digest();
			}
			dZzEneRH.reset();
			dZzEneRH.update(method.getBytes(StringUtil.__ISO_8859_1));
			dZzEneRH.update((byte) ':');
			dZzEneRH.update(uri.getBytes(StringUtil.__ISO_8859_1));
			byte[] efRzjIfm = dZzEneRH.digest();
			dZzEneRH.update(TypeUtil.toString(DdxkYiA9, 16).getBytes(StringUtil.__ISO_8859_1));
			dZzEneRH.update((byte) ':');
			dZzEneRH.update(nonce.getBytes(StringUtil.__ISO_8859_1));
			dZzEneRH.update((byte) ':');
			dZzEneRH.update(nc.getBytes(StringUtil.__ISO_8859_1));
			dZzEneRH.update((byte) ':');
			dZzEneRH.update(cnonce.getBytes(StringUtil.__ISO_8859_1));
			dZzEneRH.update((byte) ':');
			dZzEneRH.update(qop.getBytes(StringUtil.__ISO_8859_1));
			dZzEneRH.update((byte) ':');
			dZzEneRH.update(TypeUtil.toString(efRzjIfm, 16).getBytes(StringUtil.__ISO_8859_1));
			byte[] ciOd0oDR = dZzEneRH.digest();
			return (TypeUtil.toString(ciOd0oDR, 16).equalsIgnoreCase(response));
		} catch (Exception LRpN2Gmx) {
			log.warn(LogSupport.EXCEPTION, LRpN2Gmx);
		}
		return false;
	}

}