class n6641463 {
	private void LoadLoginInfo() {
		m_PwdList.removeAllElements();
		int iIndex = 0;
		String szTemp = null;
		int iSize = m_UsrList.size();
		for (int i = 0; i < iSize; i++)
			m_PwdList.add("");
		try {
			if ((m_UsrList.size() > 0) && m_bSavePwd) {
				char[] MD5PWD = new char[80];
				java.util.Arrays.fill(MD5PWD, (char) 0);
				String szPath = System.getProperty("user.home");
				java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
				szPath += System.getProperty("file.separator") + "MochaJournal" + System.getProperty("file.separator")
						+ "user.dat";
				java.io.File file = new java.io.File(szPath);
				if (file.exists()) {
					byte[] szEncryptPwd = null;
					java.io.FileInputStream br = new java.io.FileInputStream(file);
					int iLine = 0;
					while (br.available() > 0) {
						md.reset();
						md.update(((String) m_UsrList.get(iLine)).getBytes());
						byte alpha = 0;
						byte[] DESUSR = md.digest();
						iSize = br.read();
						for (int i2 = 0; i2 < DESUSR.length; i2++)
							alpha += DESUSR[i2];
						if (iSize > 0) {
							szEncryptPwd = new byte[iSize];
							br.read(szEncryptPwd);
							char[] cPwd = new char[iSize];
							for (int i = 0; i < iSize; i++) {
								int iChar = (int) szEncryptPwd[i] - (int) alpha;
								if (iChar < 0)
									iChar += 256;
								cPwd[i] = (char) iChar;
							}
							m_PwdList.setElementAt(new String(cPwd), iLine);
						}
						iLine++;
					}
				}
			}
		} catch (java.security.NoSuchAlgorithmException e) {
			System.err.println(e);
		} catch (java.io.IOException e3) {
			System.err.println(e3);
		}
	}

}