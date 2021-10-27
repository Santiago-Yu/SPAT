class n12146394 {
	public static String md5Crypt(final byte[] gEw3Meds, final byte[] RbUwZQfG) throws NoSuchAlgorithmException {
		if (gEw3Meds == null || gEw3Meds.length == 0) {
			throw new IllegalArgumentException("Argument 'key' cannot be null or an empty array.");
		}
		if (RbUwZQfG == null || RbUwZQfG.length == 0) {
			throw new IllegalArgumentException("Argument 'salt' cannot be null or an empty array.");
		}
		final MessageDigest b9huHGpw = MessageDigest.getInstance("MD5");
		b9huHGpw.update(gEw3Meds);
		b9huHGpw.update(MAGIC.getBytes());
		b9huHGpw.update(RbUwZQfG);
		final MessageDigest gsEkyeRg = MessageDigest.getInstance("MD5");
		gsEkyeRg.update(gEw3Meds);
		gsEkyeRg.update(RbUwZQfG);
		gsEkyeRg.update(gEw3Meds);
		byte[] Bw67rImt = gsEkyeRg.digest();
		for (int TNOzhkrX = gEw3Meds.length; TNOzhkrX > 0; TNOzhkrX -= 16) {
			b9huHGpw.update(Bw67rImt, 0, TNOzhkrX > 16 ? 16 : TNOzhkrX);
		}
		Bw67rImt = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int S6eqquLr = 0, o3U90TTe = gEw3Meds.length; o3U90TTe != 0; o3U90TTe >>>= 1) {
			if ((o3U90TTe & 1) == 1)
				b9huHGpw.update(Bw67rImt, S6eqquLr, 1);
			else
				b9huHGpw.update(gEw3Meds, S6eqquLr, 1);
		}
		final StringBuilder sTakGh6r = new StringBuilder();
		sTakGh6r.append(MAGIC);
		sTakGh6r.append(new String(RbUwZQfG));
		sTakGh6r.append('$');
		Bw67rImt = b9huHGpw.digest();
		for (int WfR2cC0V = 0; WfR2cC0V < 1000; WfR2cC0V++) {
			final MessageDigest f7lBCWTh = MessageDigest.getInstance("MD5");
			if ((WfR2cC0V & 1) != 0) {
				f7lBCWTh.update(gEw3Meds);
			} else {
				f7lBCWTh.update(Bw67rImt);
			}
			if ((WfR2cC0V % 3) != 0) {
				f7lBCWTh.update(RbUwZQfG);
			}
			if ((WfR2cC0V % 7) != 0) {
				f7lBCWTh.update(gEw3Meds);
			}
			if ((WfR2cC0V & 1) != 0) {
				f7lBCWTh.update(Bw67rImt);
			} else {
				f7lBCWTh.update(gEw3Meds);
			}
			Bw67rImt = f7lBCWTh.digest();
		}
		int[] P044U1QB = new int[] { (Bw67rImt[0] & 0x7f) | (Bw67rImt[0] & 0x80),
				(Bw67rImt[1] & 0x7f) | (Bw67rImt[1] & 0x80), (Bw67rImt[2] & 0x7f) | (Bw67rImt[2] & 0x80),
				(Bw67rImt[3] & 0x7f) | (Bw67rImt[3] & 0x80), (Bw67rImt[4] & 0x7f) | (Bw67rImt[4] & 0x80),
				(Bw67rImt[5] & 0x7f) | (Bw67rImt[5] & 0x80), (Bw67rImt[6] & 0x7f) | (Bw67rImt[6] & 0x80),
				(Bw67rImt[7] & 0x7f) | (Bw67rImt[7] & 0x80), (Bw67rImt[8] & 0x7f) | (Bw67rImt[8] & 0x80),
				(Bw67rImt[9] & 0x7f) | (Bw67rImt[9] & 0x80), (Bw67rImt[10] & 0x7f) | (Bw67rImt[10] & 0x80),
				(Bw67rImt[11] & 0x7f) | (Bw67rImt[11] & 0x80), (Bw67rImt[12] & 0x7f) | (Bw67rImt[12] & 0x80),
				(Bw67rImt[13] & 0x7f) | (Bw67rImt[13] & 0x80), (Bw67rImt[14] & 0x7f) | (Bw67rImt[14] & 0x80),
				(Bw67rImt[15] & 0x7f) | (Bw67rImt[15] & 0x80) };
		to64(sTakGh6r, P044U1QB[0] << 16 | P044U1QB[6] << 8 | P044U1QB[12], 4);
		to64(sTakGh6r, P044U1QB[1] << 16 | P044U1QB[7] << 8 | P044U1QB[13], 4);
		to64(sTakGh6r, P044U1QB[2] << 16 | P044U1QB[8] << 8 | P044U1QB[14], 4);
		to64(sTakGh6r, P044U1QB[3] << 16 | P044U1QB[9] << 8 | P044U1QB[15], 4);
		to64(sTakGh6r, P044U1QB[4] << 16 | P044U1QB[10] << 8 | P044U1QB[5], 4);
		to64(sTakGh6r, P044U1QB[11], 2);
		return sTakGh6r.toString();
	}

}