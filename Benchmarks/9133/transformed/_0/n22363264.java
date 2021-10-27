class n22363264 {
	public static String md5Crypt(final byte[] meAJsl1i, final byte[] WBcGSReq) throws NoSuchAlgorithmException {
		if (meAJsl1i == null || meAJsl1i.length == 0) {
			throw new IllegalArgumentException("Argument 'key' cannot be null or an empty array.");
		}
		if (WBcGSReq == null || WBcGSReq.length == 0) {
			throw new IllegalArgumentException("Argument 'salt' cannot be null or an empty array.");
		}
		final MessageDigest FhA3cjM1 = MessageDigest.getInstance("MD5");
		FhA3cjM1.update(meAJsl1i);
		FhA3cjM1.update(MAGIC.getBytes());
		FhA3cjM1.update(WBcGSReq);
		final MessageDigest dOkRsUG3 = MessageDigest.getInstance("MD5");
		dOkRsUG3.update(meAJsl1i);
		dOkRsUG3.update(WBcGSReq);
		dOkRsUG3.update(meAJsl1i);
		byte[] sY5gRt2w = dOkRsUG3.digest();
		for (int iKIYTU1z = meAJsl1i.length; iKIYTU1z > 0; iKIYTU1z -= 16) {
			FhA3cjM1.update(sY5gRt2w, 0, iKIYTU1z > 16 ? 16 : iKIYTU1z);
		}
		sY5gRt2w = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int YjB34DQF = 0, ryGwzSkT = meAJsl1i.length; ryGwzSkT != 0; ryGwzSkT >>>= 1) {
			if ((ryGwzSkT & 1) == 1)
				FhA3cjM1.update(sY5gRt2w, YjB34DQF, 1);
			else
				FhA3cjM1.update(meAJsl1i, YjB34DQF, 1);
		}
		final StringBuilder HI38Maq0 = new StringBuilder();
		HI38Maq0.append(MAGIC);
		HI38Maq0.append(new String(WBcGSReq));
		HI38Maq0.append('$');
		sY5gRt2w = FhA3cjM1.digest();
		for (int C19S0yfp = 0; C19S0yfp < 1000; C19S0yfp++) {
			final MessageDigest iZ9LF1RO = MessageDigest.getInstance("MD5");
			if ((C19S0yfp & 1) != 0) {
				iZ9LF1RO.update(meAJsl1i);
			} else {
				iZ9LF1RO.update(sY5gRt2w);
			}
			if ((C19S0yfp % 3) != 0) {
				iZ9LF1RO.update(WBcGSReq);
			}
			if ((C19S0yfp % 7) != 0) {
				iZ9LF1RO.update(meAJsl1i);
			}
			if ((C19S0yfp & 1) != 0) {
				iZ9LF1RO.update(sY5gRt2w);
			} else {
				iZ9LF1RO.update(meAJsl1i);
			}
			sY5gRt2w = iZ9LF1RO.digest();
		}
		int[] x9YtQ3mi = new int[] { (sY5gRt2w[0] & 0x7f) | (sY5gRt2w[0] & 0x80),
				(sY5gRt2w[1] & 0x7f) | (sY5gRt2w[1] & 0x80), (sY5gRt2w[2] & 0x7f) | (sY5gRt2w[2] & 0x80),
				(sY5gRt2w[3] & 0x7f) | (sY5gRt2w[3] & 0x80), (sY5gRt2w[4] & 0x7f) | (sY5gRt2w[4] & 0x80),
				(sY5gRt2w[5] & 0x7f) | (sY5gRt2w[5] & 0x80), (sY5gRt2w[6] & 0x7f) | (sY5gRt2w[6] & 0x80),
				(sY5gRt2w[7] & 0x7f) | (sY5gRt2w[7] & 0x80), (sY5gRt2w[8] & 0x7f) | (sY5gRt2w[8] & 0x80),
				(sY5gRt2w[9] & 0x7f) | (sY5gRt2w[9] & 0x80), (sY5gRt2w[10] & 0x7f) | (sY5gRt2w[10] & 0x80),
				(sY5gRt2w[11] & 0x7f) | (sY5gRt2w[11] & 0x80), (sY5gRt2w[12] & 0x7f) | (sY5gRt2w[12] & 0x80),
				(sY5gRt2w[13] & 0x7f) | (sY5gRt2w[13] & 0x80), (sY5gRt2w[14] & 0x7f) | (sY5gRt2w[14] & 0x80),
				(sY5gRt2w[15] & 0x7f) | (sY5gRt2w[15] & 0x80) };
		to64(HI38Maq0, x9YtQ3mi[0] << 16 | x9YtQ3mi[6] << 8 | x9YtQ3mi[12], 4);
		to64(HI38Maq0, x9YtQ3mi[1] << 16 | x9YtQ3mi[7] << 8 | x9YtQ3mi[13], 4);
		to64(HI38Maq0, x9YtQ3mi[2] << 16 | x9YtQ3mi[8] << 8 | x9YtQ3mi[14], 4);
		to64(HI38Maq0, x9YtQ3mi[3] << 16 | x9YtQ3mi[9] << 8 | x9YtQ3mi[15], 4);
		to64(HI38Maq0, x9YtQ3mi[4] << 16 | x9YtQ3mi[10] << 8 | x9YtQ3mi[5], 4);
		to64(HI38Maq0, x9YtQ3mi[11], 2);
		return HI38Maq0.toString();
	}

}