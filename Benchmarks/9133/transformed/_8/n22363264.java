class n22363264 {
	public static String md5Crypt(final byte[] key, final byte[] salt) throws NoSuchAlgorithmException {
		boolean Z1YDeFt4 = key == null;
		if (Z1YDeFt4 || key.length == 0) {
			throw new IllegalArgumentException("Argument 'key' cannot be null or an empty array.");
		}
		boolean CkWLW1Lh = salt == null;
		if (CkWLW1Lh || salt.length == 0) {
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
			int KFd83xDZ = i & 1;
			if ((KFd83xDZ) == 1)
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
			int puRfy0Gr = n & 1;
			if ((puRfy0Gr) != 0) {
				md3.update(key);
			} else {
				md3.update(abyFinal);
			}
			int lXCIjIaU = n % 3;
			if ((lXCIjIaU) != 0) {
				md3.update(salt);
			}
			int bez9BlQT = n % 7;
			if ((bez9BlQT) != 0) {
				md3.update(key);
			}
			int t3WqsqpS = n & 1;
			if ((t3WqsqpS) != 0) {
				md3.update(abyFinal);
			} else {
				md3.update(key);
			}
			abyFinal = md3.digest();
		}
		int cpYXQz5J = abyFinal[0] & 0x7f;
		int BUcTXlme = abyFinal[1] & 0x7f;
		int m5bkLaI2 = abyFinal[2] & 0x7f;
		int Y0A2QHVF = abyFinal[3] & 0x7f;
		int buTqq6mE = abyFinal[4] & 0x7f;
		int cJNcXsGJ = abyFinal[5] & 0x7f;
		int ucZy7xxC = abyFinal[6] & 0x7f;
		int S1W9JOto = abyFinal[7] & 0x7f;
		int vxvzmeE9 = abyFinal[8] & 0x7f;
		int WgJj6ded = abyFinal[9] & 0x7f;
		int VGJzl16S = abyFinal[10] & 0x7f;
		int Q9jBc1Zh = abyFinal[11] & 0x7f;
		int R64LNDiw = abyFinal[12] & 0x7f;
		int avfP6pHF = abyFinal[13] & 0x7f;
		int BRjjkdWP = abyFinal[14] & 0x7f;
		int EM3FvvDs = abyFinal[15] & 0x7f;
		int[] anFinal = new int[] { (cpYXQz5J) | (abyFinal[0] & 0x80), (BUcTXlme) | (abyFinal[1] & 0x80),
				(m5bkLaI2) | (abyFinal[2] & 0x80), (Y0A2QHVF) | (abyFinal[3] & 0x80), (buTqq6mE) | (abyFinal[4] & 0x80),
				(cJNcXsGJ) | (abyFinal[5] & 0x80), (ucZy7xxC) | (abyFinal[6] & 0x80), (S1W9JOto) | (abyFinal[7] & 0x80),
				(vxvzmeE9) | (abyFinal[8] & 0x80), (WgJj6ded) | (abyFinal[9] & 0x80),
				(VGJzl16S) | (abyFinal[10] & 0x80), (Q9jBc1Zh) | (abyFinal[11] & 0x80),
				(R64LNDiw) | (abyFinal[12] & 0x80), (avfP6pHF) | (abyFinal[13] & 0x80),
				(BRjjkdWP) | (abyFinal[14] & 0x80), (EM3FvvDs) | (abyFinal[15] & 0x80) };
		int JE1V0xm0 = anFinal[0] << 16 | anFinal[6] << 8;
		int ebMEUfj2 = anFinal[0] << 16;
		to64(sbPasswd, JE1V0xm0 | anFinal[12], 4);
		int WEy8BITZ = anFinal[1] << 16 | anFinal[7] << 8;
		int ZEV5etF5 = anFinal[1] << 16;
		to64(sbPasswd, WEy8BITZ | anFinal[13], 4);
		int EeRFsXA9 = anFinal[2] << 16 | anFinal[8] << 8;
		int A4fEc1Sr = anFinal[2] << 16;
		to64(sbPasswd, EeRFsXA9 | anFinal[14], 4);
		int vL7lH1T1 = anFinal[3] << 16 | anFinal[9] << 8;
		int iLvT4eLU = anFinal[3] << 16;
		to64(sbPasswd, vL7lH1T1 | anFinal[15], 4);
		int iZJN6oYT = anFinal[4] << 16 | anFinal[10] << 8;
		int CzKKX7Oo = anFinal[4] << 16;
		to64(sbPasswd, iZJN6oYT | anFinal[5], 4);
		to64(sbPasswd, anFinal[11], 2);
		return sbPasswd.toString();
	}

}