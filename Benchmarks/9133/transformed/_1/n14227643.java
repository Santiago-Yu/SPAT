class n14227643 {
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
		int fu37f = 0;
		while (fu37f < key.length) {
			block[fu37f] = key[fu37f];
			++fu37f;
		}
		int SN0k7 = key.length;
		while (SN0k7 < block.length) {
			block[SN0k7] = 0;
			++SN0k7;
		}
		int po3uE = 0;
		while (po3uE < 64) {
			block[po3uE] ^= 0x36;
			++po3uE;
		}
		sha256.update(block);
		try {
			sha256.update(message.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new java.lang.AssertionError("ITunesU.hmacSH256(): UTF-8 encoding not supported!");
		}
		byte[] hash = sha256.digest();
		sha256.reset();
		int uQ8JA = 0;
		while (uQ8JA < 64) {
			block[uQ8JA] ^= (0x36 ^ 0x5c);
			++uQ8JA;
		}
		sha256.update(block);
		sha256.update(hash);
		hash = sha256.digest();
		char[] hexadecimals = new char[hash.length * 2];
		int DreGh = 0;
		while (DreGh < hash.length) {
			for (int j = 0; j < 2; ++j) {
				int value = (hash[DreGh] >> (4 - 4 * j)) & 0xf;
				char base = (value < 10) ? ('0') : ('a' - 10);
				hexadecimals[DreGh * 2 + j] = (char) (base + value);
			}
			++DreGh;
		}
		return new String(hexadecimals);
	}

}