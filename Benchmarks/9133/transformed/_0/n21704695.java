class n21704695 {
	public String hmacSHA256(String wTE2aTRm, byte[] BjIyCUMy) {
		MessageDigest haMTrs85 = null;
		try {
			haMTrs85 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException Rugk4ri4) {
			throw new java.lang.AssertionError(
					this.getClass().getName() + ".hmacSHA256(): SHA-256 algorithm not found!");
		}
		if (BjIyCUMy.length > 64) {
			haMTrs85.update(BjIyCUMy);
			BjIyCUMy = haMTrs85.digest();
			haMTrs85.reset();
		}
		byte spbIXmG7[] = new byte[64];
		for (int de77iHPS = 0; de77iHPS < BjIyCUMy.length; ++de77iHPS)
			spbIXmG7[de77iHPS] = BjIyCUMy[de77iHPS];
		for (int fg1x99VJ = BjIyCUMy.length; fg1x99VJ < spbIXmG7.length; ++fg1x99VJ)
			spbIXmG7[fg1x99VJ] = 0;
		for (int QPWPwmxk = 0; QPWPwmxk < 64; ++QPWPwmxk)
			spbIXmG7[QPWPwmxk] ^= 0x36;
		haMTrs85.update(spbIXmG7);
		try {
			haMTrs85.update(wTE2aTRm.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException O6cUwGh5) {
			throw new java.lang.AssertionError("ITunesU.hmacSH256(): UTF-8 encoding not supported!");
		}
		byte[] eLzMN72N = haMTrs85.digest();
		haMTrs85.reset();
		for (int KHAc16th = 0; KHAc16th < 64; ++KHAc16th)
			spbIXmG7[KHAc16th] ^= (0x36 ^ 0x5c);
		haMTrs85.update(spbIXmG7);
		haMTrs85.update(eLzMN72N);
		eLzMN72N = haMTrs85.digest();
		char[] rrUbinoE = new char[eLzMN72N.length * 2];
		for (int gcs7RoaF = 0; gcs7RoaF < eLzMN72N.length; ++gcs7RoaF) {
			for (int Xc8yKqJn = 0; Xc8yKqJn < 2; ++Xc8yKqJn) {
				int EqmlFZGW = (eLzMN72N[gcs7RoaF] >> (4 - 4 * Xc8yKqJn)) & 0xf;
				char tFgocpfX = (EqmlFZGW < 10) ? ('0') : ('a' - 10);
				rrUbinoE[gcs7RoaF * 2 + Xc8yKqJn] = (char) (tFgocpfX + EqmlFZGW);
			}
		}
		return new String(rrUbinoE);
	}

}