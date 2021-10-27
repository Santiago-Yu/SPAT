class n16981230 {
	public static String encrypt(final String ibFk2j4m, final String KvFrqB9p, final byte[] rp6l7kBK) {
		final StringBuffer FCPrj5bo = new StringBuffer();
		MessageDigest TZ8SyeJu = null;
		int tZjRZUDs = 0;
		if ("CRYPT".equalsIgnoreCase(KvFrqB9p)) {
			throw new InternalError("Not implemented");
		} else if ("SHA".equalsIgnoreCase(KvFrqB9p) || "SSHA".equalsIgnoreCase(KvFrqB9p)) {
			tZjRZUDs = 20;
			if (rp6l7kBK != null && rp6l7kBK.length > 0) {
				FCPrj5bo.append("{SSHA}");
			} else {
				FCPrj5bo.append("{SHA}");
			}
			try {
				TZ8SyeJu = MessageDigest.getInstance("SHA-1");
			} catch (final NoSuchAlgorithmException Pi2p2OpF) {
				throw new InternalError("Invalid algorithm");
			}
		} else if ("MD5".equalsIgnoreCase(KvFrqB9p) || "SMD5".equalsIgnoreCase(KvFrqB9p)) {
			tZjRZUDs = 16;
			if (rp6l7kBK != null && rp6l7kBK.length > 0) {
				FCPrj5bo.append("{SMD5}");
			} else {
				FCPrj5bo.append("{MD5}");
			}
			try {
				TZ8SyeJu = MessageDigest.getInstance("MD5");
			} catch (final NoSuchAlgorithmException wk7XSCdl) {
				throw new InternalError("Invalid algorithm");
			}
		}
		int FolH8rnf = tZjRZUDs;
		TZ8SyeJu.reset();
		TZ8SyeJu.update(ibFk2j4m.getBytes());
		if (rp6l7kBK != null && rp6l7kBK.length > 0) {
			TZ8SyeJu.update(rp6l7kBK);
			FolH8rnf += rp6l7kBK.length;
		}
		final byte[] Ft3eTH5c = new byte[FolH8rnf];
		System.arraycopy(TZ8SyeJu.digest(), 0, Ft3eTH5c, 0, tZjRZUDs);
		if (rp6l7kBK != null && rp6l7kBK.length > 0) {
			System.arraycopy(rp6l7kBK, 0, Ft3eTH5c, tZjRZUDs, rp6l7kBK.length);
		}
		FCPrj5bo.append(Base64.encode(Ft3eTH5c));
		return FCPrj5bo.toString();
	}

}