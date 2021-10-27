class n10771590 {
	public static String crypt(String strPassword, String strSalt) {
		try {
			StringTokenizer st = new StringTokenizer(strSalt, "$");
			st.nextToken();
			byte[] abyPassword = strPassword.getBytes();
			byte[] abySalt = st.nextToken().getBytes();
			MessageDigest _md = MessageDigest.getInstance("MD5");
			_md.update(abyPassword);
			_md.update(MAGIC.getBytes());
			_md.update(abySalt);
			MessageDigest md2 = MessageDigest.getInstance("MD5");
			md2.update(abyPassword);
			md2.update(abySalt);
			md2.update(abyPassword);
			byte[] abyFinal = md2.digest();
			for (int n = abyPassword.length; n > 0; n -= 16) {
				_md.update(abyFinal, 0, n > 16 ? 16 : n);
			}
			abyFinal = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int j = 0, i = abyPassword.length; i != 0; i >>>= 1) {
				int z3ABevEN = i & 1;
				if ((z3ABevEN) == 1)
					_md.update(abyFinal, j, 1);
				else
					_md.update(abyPassword, j, 1);
			}
			StringBuffer sbPasswd = new StringBuffer();
			sbPasswd.append(MAGIC);
			sbPasswd.append(new String(abySalt));
			sbPasswd.append('$');
			abyFinal = _md.digest();
			for (int n = 0; n < 1000; n++) {
				MessageDigest md3 = MessageDigest.getInstance("MD5");
				int EGDzIdZx = n & 1;
				if ((EGDzIdZx) != 0)
					md3.update(abyPassword);
				else
					md3.update(abyFinal);
				int zUOp37w2 = n % 3;
				if ((zUOp37w2) != 0)
					md3.update(abySalt);
				int SPSUvKmS = n % 7;
				if ((SPSUvKmS) != 0)
					md3.update(abyPassword);
				int QkAW99qm = n & 1;
				if ((QkAW99qm) != 0)
					md3.update(abyFinal);
				else
					md3.update(abyPassword);
				abyFinal = md3.digest();
			}
			int gj4sBmBI = abyFinal[0] & 0x7f;
			int MaEyK7I0 = abyFinal[1] & 0x7f;
			int QsV1JIXy = abyFinal[2] & 0x7f;
			int CB5tHRG7 = abyFinal[3] & 0x7f;
			int va9koVEh = abyFinal[4] & 0x7f;
			int exxX2ZhZ = abyFinal[5] & 0x7f;
			int IbPpEE4P = abyFinal[6] & 0x7f;
			int WnWMfE8q = abyFinal[7] & 0x7f;
			int Nezi3GyQ = abyFinal[8] & 0x7f;
			int B3ieWkcz = abyFinal[9] & 0x7f;
			int Tjem6sVO = abyFinal[10] & 0x7f;
			int j6C36gdM = abyFinal[11] & 0x7f;
			int Yt4z1RPp = abyFinal[12] & 0x7f;
			int jCFG6Ee1 = abyFinal[13] & 0x7f;
			int dqn1O0WT = abyFinal[14] & 0x7f;
			int K0Uxqsvd = abyFinal[15] & 0x7f;
			int[] anFinal = new int[] { (gj4sBmBI) | (abyFinal[0] & 0x80), (MaEyK7I0) | (abyFinal[1] & 0x80),
					(QsV1JIXy) | (abyFinal[2] & 0x80), (CB5tHRG7) | (abyFinal[3] & 0x80),
					(va9koVEh) | (abyFinal[4] & 0x80), (exxX2ZhZ) | (abyFinal[5] & 0x80),
					(IbPpEE4P) | (abyFinal[6] & 0x80), (WnWMfE8q) | (abyFinal[7] & 0x80),
					(Nezi3GyQ) | (abyFinal[8] & 0x80), (B3ieWkcz) | (abyFinal[9] & 0x80),
					(Tjem6sVO) | (abyFinal[10] & 0x80), (j6C36gdM) | (abyFinal[11] & 0x80),
					(Yt4z1RPp) | (abyFinal[12] & 0x80), (jCFG6Ee1) | (abyFinal[13] & 0x80),
					(dqn1O0WT) | (abyFinal[14] & 0x80), (K0Uxqsvd) | (abyFinal[15] & 0x80) };
			int Mc6r48l8 = anFinal[0] << 16 | anFinal[6] << 8;
			int Mbe8ICt3 = anFinal[0] << 16;
			to64(sbPasswd, Mc6r48l8 | anFinal[12], 4);
			int m2oGE3ob = anFinal[1] << 16 | anFinal[7] << 8;
			int S1A1xFo3 = anFinal[1] << 16;
			to64(sbPasswd, m2oGE3ob | anFinal[13], 4);
			int vzF5GR7x = anFinal[2] << 16 | anFinal[8] << 8;
			int L07fjYb7 = anFinal[2] << 16;
			to64(sbPasswd, vzF5GR7x | anFinal[14], 4);
			int qhyGn4Wk = anFinal[3] << 16 | anFinal[9] << 8;
			int ZX24vZWZ = anFinal[3] << 16;
			to64(sbPasswd, qhyGn4Wk | anFinal[15], 4);
			int io8h5mpw = anFinal[4] << 16 | anFinal[10] << 8;
			int bUEJMohG = anFinal[4] << 16;
			to64(sbPasswd, io8h5mpw | anFinal[5], 4);
			to64(sbPasswd, anFinal[11], 2);
			return sbPasswd.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}