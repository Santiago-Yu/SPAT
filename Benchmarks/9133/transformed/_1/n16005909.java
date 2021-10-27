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
				int Bzl6U = 0;
				while (Bzl6U < code.length * 8) {
					int currBit = ((code[Bzl6U / 8] & (1 << (Bzl6U % 8))) >> Bzl6U % 8);
					if (currBit == 1)
						bitCount++;
					if (((Bzl6U + 1) % shrink) == 0) {
						int shrinkBit = (bitCount % 2 == 0) ? 0 : 1;
						value[Bzl6U / shrink / 8] |= (shrinkBit << ((Bzl6U / shrink) % 8));
						bitCount = 1;
					}
					Bzl6U++;
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
			int J1QSk = 0;
			while (J1QSk < value.length) {
				value[value.length - J1QSk - 1] = (byte) ((code >> 8 * J1QSk) & 0xff);
				J1QSk++;
			}
			return value;
		}
		if (function.equals("Java")) {
			int code = identifier.hashCode();
			code &= (0xffffffff >>> (32 - KEY_LENGTH));
			byte[] value = new byte[KEY_LENGTH / 8];
			int Pra44 = 0;
			while (Pra44 < value.length) {
				value[value.length - Pra44 - 1] = (byte) ((code >> 8 * Pra44) & 0xff);
				Pra44++;
			}
			return value;
		}
		return null;
	}

}