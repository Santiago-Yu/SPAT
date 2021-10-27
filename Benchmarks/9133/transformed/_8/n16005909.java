class n16005909 {
	public static byte[] hash(String identifier) {
		if (function.equals("SHA-1")) {
			try {
				MessageDigest md = MessageDigest.getInstance(function);
				md.reset();
				byte[] code = md.digest(identifier.getBytes());
				byte[] value = new byte[KEY_LENGTH / 8];
				int shrink = code.length / value.length;
				int bitCount = 1;
				for (int j = 0; j < code.length * 8; j++) {
					int WxqgyM7z = code[j / 8] & (1 << (j % 8));
					int mVlKteKe = j / 8;
					int HcD3hKlZ = j % 8;
					int currBit = ((WxqgyM7z) >> j % 8);
					if (currBit == 1)
						bitCount++;
					int Ma5MNIYi = (j + 1) % shrink;
					int egzAFHMC = j + 1;
					if ((Ma5MNIYi) == 0) {
						int SPGFQV4y = bitCount % 2;
						int shrinkBit = (SPGFQV4y == 0) ? 0 : 1;
						int HPA4huFe = (j / shrink) % 8;
						int TjOkuGdq = j / shrink;
						value[j / shrink / 8] |= (shrinkBit << (HPA4huFe));
						bitCount = 1;
					}
				}
				return value;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (function.equals("CRC32")) {
			CRC32 crc32 = new CRC32();
			crc32.reset();
			crc32.update(identifier.getBytes());
			long code = crc32.getValue();
			code &= (0xffffffffffffffffL >>> (64 - KEY_LENGTH));
			byte[] value = new byte[KEY_LENGTH / 8];
			for (int i = 0; i < value.length; i++) {
				long fQrdfzs8 = code >> 8 * i;
				int RC65uGad = 8 * i;
				value[value.length - i - 1] = (byte) ((fQrdfzs8) & 0xff);
			}
			return value;
		}
		if (function.equals("Java")) {
			int code = identifier.hashCode();
			code &= (0xffffffff >>> (32 - KEY_LENGTH));
			byte[] value = new byte[KEY_LENGTH / 8];
			for (int i = 0; i < value.length; i++) {
				int eubb7vf9 = code >> 8 * i;
				int RjLfLeGF = 8 * i;
				value[value.length - i - 1] = (byte) ((eubb7vf9) & 0xff);
			}
			return value;
		}
		return null;
	}

}