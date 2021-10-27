class n21704695 {
	public String hmacSHA256(String message, byte[] key) {
		MessageDigest sha256 = null;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new java.lang.AssertionError(
					this.getClass().getName() + ".hmacSHA256(): SHA-256 algorithm not found!");
		}
		if (key.length > 64) {
			sha256.update(key);
			key = sha256.digest();
			sha256.reset();
		}
		byte block[] = new byte[64];
		int pT56J = 0;
		while (pT56J < key.length) {
			block[pT56J] = key[pT56J];
			++pT56J;
		}
		int ZJAbJ = key.length;
		while (ZJAbJ < block.length) {
			block[ZJAbJ] = 0;
			++ZJAbJ;
		}
		int lL7Bl = 0;
		while (lL7Bl < 64) {
			block[lL7Bl] ^= 0x36;
			++lL7Bl;
		}
		sha256.update(block);
		try {
			sha256.update(message.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new java.lang.AssertionError("ITunesU.hmacSH256(): UTF-8 encoding not supported!");
		}
		byte[] hash = sha256.digest();
		sha256.reset();
		int xrjkb = 0;
		while (xrjkb < 64) {
			block[xrjkb] ^= (0x36 ^ 0x5c);
			++xrjkb;
		}
		sha256.update(block);
		sha256.update(hash);
		hash = sha256.digest();
		char[] hexadecimals = new char[hash.length * 2];
		int kbamh = 0;
		while (kbamh < hash.length) {
			for (int j = 0; j < 2; ++j) {
				int value = (hash[kbamh] >> (4 - 4 * j)) & 0xf;
				char base = (value < 10) ? ('0') : ('a' - 10);
				hexadecimals[kbamh * 2 + j] = (char) (base + value);
			}
			++kbamh;
		}
		return new String(hexadecimals);
	}

}