class n9141695 {
	public static String calcResponse(String XTsFSegt, String OrpA93ks, String sXetXEZY, String a2AzRIMi,
			String tDWwpbwX, String L5UzRqnN, String DRr2JiVH) throws FatalException, MD5DigestException {
		MD5Encoder Wfeq97vG = new MD5Encoder();
		String yifz8iYi = null;
		MessageDigest RAMypnIs = null;
		try {
			RAMypnIs = MessageDigest.getInstance("MD5");
		} catch (Exception z3bNL73T) {
			throw new FatalException(z3bNL73T);
		}
		if (L5UzRqnN == null || DRr2JiVH == null) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "method or uri");
		}
		if (tDWwpbwX != null && tDWwpbwX.equals("auth-int")) {
			throw new MD5DigestException(WebdavStatus.SC_UNSUPPORTED_MEDIA_TYPE);
		}
		if (OrpA93ks == null) {
			throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nonce");
		}
		if (tDWwpbwX != null && (tDWwpbwX.equals("auth") || tDWwpbwX.equals("auth-int"))) {
			if (sXetXEZY == null || a2AzRIMi == null) {
				throw new MD5DigestException(WebdavStatus.SC_BAD_REQUEST, "nc or cnonce");
			}
		}
		RAMypnIs.update((L5UzRqnN + ":" + DRr2JiVH).getBytes());
		yifz8iYi = Wfeq97vG.encode(RAMypnIs.digest());
		RAMypnIs.update((XTsFSegt + ":" + OrpA93ks + ":").getBytes());
		if (tDWwpbwX != null && (tDWwpbwX.equals("auth") || tDWwpbwX.equals("auth-int"))) {
			RAMypnIs.update((sXetXEZY + ":" + a2AzRIMi + ":" + tDWwpbwX + ":").getBytes());
		}
		RAMypnIs.update(yifz8iYi.getBytes());
		String ueBY0h4Q = Wfeq97vG.encode(RAMypnIs.digest());
		return ueBY0h4Q;
	}

}