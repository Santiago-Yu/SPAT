class n11796920 {
	public boolean check(Object ivSP5CaK) {
		String IMjZOcnr = (ivSP5CaK instanceof String) ? (String) ivSP5CaK : ivSP5CaK.toString();
		try {
			MessageDigest qvkR37yD = MessageDigest.getInstance("MD5");
			byte[] V7e3fh4F;
			if (ivSP5CaK instanceof Credential.MD5) {
				V7e3fh4F = ((Credential.MD5) ivSP5CaK).getDigest();
			} else {
				qvkR37yD.update(username.getBytes(StringUtil.__ISO_8859_1));
				qvkR37yD.update((byte) ':');
				qvkR37yD.update(realm.getBytes(StringUtil.__ISO_8859_1));
				qvkR37yD.update((byte) ':');
				qvkR37yD.update(IMjZOcnr.getBytes(StringUtil.__ISO_8859_1));
				V7e3fh4F = qvkR37yD.digest();
			}
			qvkR37yD.reset();
			qvkR37yD.update(method.getBytes(StringUtil.__ISO_8859_1));
			qvkR37yD.update((byte) ':');
			qvkR37yD.update(uri.getBytes(StringUtil.__ISO_8859_1));
			byte[] CFgiQupq = qvkR37yD.digest();
			qvkR37yD.update(TypeUtil.toString(V7e3fh4F, 16).getBytes(StringUtil.__ISO_8859_1));
			qvkR37yD.update((byte) ':');
			qvkR37yD.update(nonce.getBytes(StringUtil.__ISO_8859_1));
			qvkR37yD.update((byte) ':');
			qvkR37yD.update(nc.getBytes(StringUtil.__ISO_8859_1));
			qvkR37yD.update((byte) ':');
			qvkR37yD.update(cnonce.getBytes(StringUtil.__ISO_8859_1));
			qvkR37yD.update((byte) ':');
			qvkR37yD.update(qop.getBytes(StringUtil.__ISO_8859_1));
			qvkR37yD.update((byte) ':');
			qvkR37yD.update(TypeUtil.toString(CFgiQupq, 16).getBytes(StringUtil.__ISO_8859_1));
			byte[] bbihBAga = qvkR37yD.digest();
			return (TypeUtil.toString(bbihBAga, 16).equalsIgnoreCase(response));
		} catch (Exception hNs17CIz) {
			Log.warn(hNs17CIz);
		}
		return false;
	}

}