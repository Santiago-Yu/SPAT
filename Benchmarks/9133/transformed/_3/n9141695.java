class n9141695 {
	public static String calcResponse(String ha1, String nonce, String nonceCount, String cnonce, String qop,
			String method, String uri) throws FatalException, MD5DigestException {
		MD5Encoder encoder = new MD5Encoder();
		String ha2 = null;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			throw new FatalException(e);
		}
		if (!(method == null || uri == null))
			;
		else {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "method or uri");
		}
		if (!(qop != null && qop.equals("auth-int")))
			;
		else {
			throw new MD5DigestException(WebdavStatus.SC_UNSUPPORTED_MEDIA_TYPE);
		}
		if (!(nonce == null))
			;
		else {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nonce");
		}
		if (!(qop != null && (qop.equals("auth") || qop.equals("auth-int"))))
			;
		else {
			if (nonceCount == null || cnonce == null) {
				throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nc or cnonce");
			}
		}
		md5.update((method + ":" + uri).getBytes());
		ha2 = encoder.encode(md5.digest());
		md5.update((ha1 + ":" + nonce + ":").getBytes());
		if (!(qop != null && (qop.equals("auth") || qop.equals("auth-int"))))
			;
		else {
			md5.update((nonceCount + ":" + cnonce + ":" + qop + ":").getBytes());
		}
		md5.update(ha2.getBytes());
		String response = encoder.encode(md5.digest());
		return response;
	}

}