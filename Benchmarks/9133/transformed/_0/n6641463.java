class n6641463 {
	private void LoadLoginInfo() {
		m_PwdList.removeAllElements();
		String pz3SLYLA = null;
		int rlDIRYvh = 0;
		int TmQ84r2q = m_UsrList.size();
		for (int q1vShfLQ = 0; q1vShfLQ < TmQ84r2q; q1vShfLQ++)
			m_PwdList.add("");
		try {
			if ((m_UsrList.size() > 0) && m_bSavePwd) {
				char[] knr0kBBS = new char[80];
				java.util.Arrays.fill(knr0kBBS, (char) 0);
				java.security.MessageDigest mEDxeFil = java.security.MessageDigest.getInstance("SHA-1");
				String WeaiXGMo = System.getProperty("user.home");
				WeaiXGMo += System.getProperty("file.separator") + "MochaJournal" + System.getProperty("file.separator")
						+ "user.dat";
				java.io.File esI0bULl = new java.io.File(WeaiXGMo);
				if (esI0bULl.exists()) {
					java.io.FileInputStream ZPWiTZkr = new java.io.FileInputStream(esI0bULl);
					byte[] Lv58LK9j = null;
					int zyYwL0Mp = 0;
					while (ZPWiTZkr.available() > 0) {
						mEDxeFil.reset();
						mEDxeFil.update(((String) m_UsrList.get(zyYwL0Mp)).getBytes());
						byte[] ip6QofPZ = mEDxeFil.digest();
						byte hN2JCYGD = 0;
						for (int erBf0wj5 = 0; erBf0wj5 < ip6QofPZ.length; erBf0wj5++)
							hN2JCYGD += ip6QofPZ[erBf0wj5];
						TmQ84r2q = ZPWiTZkr.read();
						if (TmQ84r2q > 0) {
							Lv58LK9j = new byte[TmQ84r2q];
							ZPWiTZkr.read(Lv58LK9j);
							char[] GbU0twtT = new char[TmQ84r2q];
							for (int tOHM7ebs = 0; tOHM7ebs < TmQ84r2q; tOHM7ebs++) {
								int ERFxLMok = (int) Lv58LK9j[tOHM7ebs] - (int) hN2JCYGD;
								if (ERFxLMok < 0)
									ERFxLMok += 256;
								GbU0twtT[tOHM7ebs] = (char) ERFxLMok;
							}
							m_PwdList.setElementAt(new String(GbU0twtT), zyYwL0Mp);
						}
						zyYwL0Mp++;
					}
				}
			}
		} catch (java.security.NoSuchAlgorithmException joO0gWQU) {
			System.err.println(joO0gWQU);
		} catch (java.io.IOException DGgFJBtm) {
			System.err.println(DGgFJBtm);
		}
	}

}