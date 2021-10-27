class n14227643 {
	public String hmacSHA256(String kJQJSq2J, byte[] i9XvxE3k) {
		MessageDigest YwLK1JPY = null;
		try {
			YwLK1JPY = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException hHoj2VfT) {
			throw new java.lang.AssertionError(
					this.getClass().getName() + ".hmacSHA256(): SHA-256 algorithm not found!");
		}
		if (i9XvxE3k.length > 64) {
			YwLK1JPY.update(i9XvxE3k);
			i9XvxE3k = YwLK1JPY.digest();
			YwLK1JPY.reset();
		}
		byte WMnfitd4[] = new byte[64];
		for (int cwOCuDB8 = 0; cwOCuDB8 < i9XvxE3k.length; ++cwOCuDB8)
			WMnfitd4[cwOCuDB8] = i9XvxE3k[cwOCuDB8];
		for (int otYnVHPI = i9XvxE3k.length; otYnVHPI < WMnfitd4.length; ++otYnVHPI)
			WMnfitd4[otYnVHPI] = 0;
		for (int A7BfSESM = 0; A7BfSESM < 64; ++A7BfSESM)
			WMnfitd4[A7BfSESM] ^= 0x36;
		YwLK1JPY.update(WMnfitd4);
		try {
			YwLK1JPY.update(kJQJSq2J.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException aRSaM1wO) {
			throw new java.lang.AssertionError("ITunesU.hmacSH256(): UTF-8 encoding not supported!");
		}
		byte[] dtTmLEpQ = YwLK1JPY.digest();
		YwLK1JPY.reset();
		for (int YzIo3WDq = 0; YzIo3WDq < 64; ++YzIo3WDq)
			WMnfitd4[YzIo3WDq] ^= (0x36 ^ 0x5c);
		YwLK1JPY.update(WMnfitd4);
		YwLK1JPY.update(dtTmLEpQ);
		dtTmLEpQ = YwLK1JPY.digest();
		char[] YxJqAKj2 = new char[dtTmLEpQ.length * 2];
		for (int Vd14Izj5 = 0; Vd14Izj5 < dtTmLEpQ.length; ++Vd14Izj5) {
			for (int sBMCAVYh = 0; sBMCAVYh < 2; ++sBMCAVYh) {
				int dodwtepe = (dtTmLEpQ[Vd14Izj5] >> (4 - 4 * sBMCAVYh)) & 0xf;
				char SoIGF9iL = (dodwtepe < 10) ? ('0') : ('a' - 10);
				YxJqAKj2[Vd14Izj5 * 2 + sBMCAVYh] = (char) (SoIGF9iL + dodwtepe);
			}
		}
		return new String(YxJqAKj2);
	}

}