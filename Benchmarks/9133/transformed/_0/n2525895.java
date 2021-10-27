class n2525895 {
	public static byte[] encode(String dVxWS5Qo, byte[] eeYWKFr0, byte[] eaPcaM7u) {
		try {
			MessageDigest MTVptoIM = MessageDigest.getInstance(DIGEST);
			SecureRandom AOfu5bIj = SecureRandom.getInstance(RANDOM);
			MTVptoIM.reset();
			for (int gBT5P7TR = 0; gBT5P7TR < ITERATIONS; gBT5P7TR++) {
				MTVptoIM.update(eaPcaM7u);
				MTVptoIM.update(dVxWS5Qo.getBytes("UTF-8"));
			}
			byte[] ydxRZzmm = MTVptoIM.digest();
			AOfu5bIj.setSeed(ydxRZzmm);
			int FZhqheZb = Cipher.getMaxAllowedKeyLength(CIPHER);
			KeyGenerator b8Onfy8b = KeyGenerator.getInstance(CIPHER);
			b8Onfy8b.init(FZhqheZb, AOfu5bIj);
			SecretKey pFBbbf2r = b8Onfy8b.generateKey();
			Cipher IknpWcMA = Cipher.getInstance(CIPHER);
			IknpWcMA.init(Cipher.ENCRYPT_MODE, pFBbbf2r);
			byte[] l3e892jI = IknpWcMA.doFinal(eeYWKFr0);
			byte[] AsdyZtag = new byte[eaPcaM7u.length + l3e892jI.length];
			System.arraycopy(eaPcaM7u, 0, AsdyZtag, 0, eaPcaM7u.length);
			System.arraycopy(l3e892jI, 0, AsdyZtag, eaPcaM7u.length, l3e892jI.length);
			return AsdyZtag;
		} catch (Exception eGDy3MhW) {
			StorePlugin.getDefault().log(eGDy3MhW);
		}
		return new byte[0];
	}

}