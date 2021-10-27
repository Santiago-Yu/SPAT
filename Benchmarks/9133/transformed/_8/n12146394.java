class n12146394 {
	public static String md5Crypt(final byte[] key, final byte[] salt) throws NoSuchAlgorithmException {
		boolean cbrqkeb3 = key == null;
		if (cbrqkeb3 || key.length == 0) {
			throw new IllegalArgumentException("Argument 'key' cannot be null or an empty array.");
		}
		boolean u1qwIIUj = salt == null;
		if (u1qwIIUj || salt.length == 0) {
			throw new IllegalArgumentException("Argument 'salt' cannot be null or an empty array.");
		}
		final MessageDigest _md = MessageDigest.getInstance("MD5");
		_md.update(key);
		_md.update(MAGIC.getBytes());
		_md.update(salt);
		final MessageDigest md2 = MessageDigest.getInstance("MD5");
		md2.update(key);
		md2.update(salt);
		md2.update(key);
		byte[] abyFinal = md2.digest();
		for (int n = key.length; n > 0; n -= 16) {
			_md.update(abyFinal, 0, n > 16 ? 16 : n);
		}
		abyFinal = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int j = 0, i = key.length; i != 0; i >>>= 1) {
			int WmVBwwG7 = i & 1;
			if ((WmVBwwG7) == 1)
				_md.update(abyFinal, j, 1);
			else
				_md.update(key, j, 1);
		}
		final StringBuilder sbPasswd = new StringBuilder();
		sbPasswd.append(MAGIC);
		sbPasswd.append(new String(salt));
		sbPasswd.append('$');
		abyFinal = _md.digest();
		for (int n = 0; n < 1000; n++) {
			final MessageDigest md3 = MessageDigest.getInstance("MD5");
			int uPAxsgvi = n & 1;
			if ((uPAxsgvi) != 0) {
				md3.update(key);
			} else {
				md3.update(abyFinal);
			}
			int xycN1sDh = n % 3;
			if ((xycN1sDh) != 0) {
				md3.update(salt);
			}
			int QDnu6q5O = n % 7;
			if ((QDnu6q5O) != 0) {
				md3.update(key);
			}
			int MzwVtV3h = n & 1;
			if ((MzwVtV3h) != 0) {
				md3.update(abyFinal);
			} else {
				md3.update(key);
			}
			abyFinal = md3.digest();
		}
		int vI7DhVEI = abyFinal[0] & 0x7f;
		int VK77kPGW = abyFinal[1] & 0x7f;
		int msyaHPDq = abyFinal[2] & 0x7f;
		int L3oj2MYq = abyFinal[3] & 0x7f;
		int dGddWDH2 = abyFinal[4] & 0x7f;
		int YAihCngR = abyFinal[5] & 0x7f;
		int BWJI3bqk = abyFinal[6] & 0x7f;
		int wXykbaiQ = abyFinal[7] & 0x7f;
		int yeWZgtuZ = abyFinal[8] & 0x7f;
		int IYFHsZ0V = abyFinal[9] & 0x7f;
		int V7XIVtBN = abyFinal[10] & 0x7f;
		int TkFoFYGr = abyFinal[11] & 0x7f;
		int F5VH95ws = abyFinal[12] & 0x7f;
		int CCeIQKe7 = abyFinal[13] & 0x7f;
		int iD3D6Aj8 = abyFinal[14] & 0x7f;
		int knwxyzFZ = abyFinal[15] & 0x7f;
		int[] anFinal = new int[] { (vI7DhVEI) | (abyFinal[0] & 0x80), (VK77kPGW) | (abyFinal[1] & 0x80),
				(msyaHPDq) | (abyFinal[2] & 0x80), (L3oj2MYq) | (abyFinal[3] & 0x80), (dGddWDH2) | (abyFinal[4] & 0x80),
				(YAihCngR) | (abyFinal[5] & 0x80), (BWJI3bqk) | (abyFinal[6] & 0x80), (wXykbaiQ) | (abyFinal[7] & 0x80),
				(yeWZgtuZ) | (abyFinal[8] & 0x80), (IYFHsZ0V) | (abyFinal[9] & 0x80),
				(V7XIVtBN) | (abyFinal[10] & 0x80), (TkFoFYGr) | (abyFinal[11] & 0x80),
				(F5VH95ws) | (abyFinal[12] & 0x80), (CCeIQKe7) | (abyFinal[13] & 0x80),
				(iD3D6Aj8) | (abyFinal[14] & 0x80), (knwxyzFZ) | (abyFinal[15] & 0x80) };
		int nmGFcyR6 = anFinal[0] << 16 | anFinal[6] << 8;
		int IzqUafGV = anFinal[0] << 16;
		to64(sbPasswd, nmGFcyR6 | anFinal[12], 4);
		int yGGZn2PE = anFinal[1] << 16 | anFinal[7] << 8;
		int ypqFi6tE = anFinal[1] << 16;
		to64(sbPasswd, yGGZn2PE | anFinal[13], 4);
		int tFdCkVaM = anFinal[2] << 16 | anFinal[8] << 8;
		int IHTFIFmO = anFinal[2] << 16;
		to64(sbPasswd, tFdCkVaM | anFinal[14], 4);
		int NutjXZvA = anFinal[3] << 16 | anFinal[9] << 8;
		int e2fjcvPu = anFinal[3] << 16;
		to64(sbPasswd, NutjXZvA | anFinal[15], 4);
		int Djz2nCqD = anFinal[4] << 16 | anFinal[10] << 8;
		int GLW6URSn = anFinal[4] << 16;
		to64(sbPasswd, Djz2nCqD | anFinal[5], 4);
		to64(sbPasswd, anFinal[11], 2);
		return sbPasswd.toString();
	}

}