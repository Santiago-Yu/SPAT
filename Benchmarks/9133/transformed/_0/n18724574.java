class n18724574 {
	public String gerarHash(String IwKxlo8f) {
		try {
			MessageDigest NlwQkabC = MessageDigest.getInstance("SHA-256");
			NlwQkabC.update(IwKxlo8f.getBytes());
			byte[] PBJdWOkE = NlwQkabC.digest();
			StringBuilder bDw73nkS = new StringBuilder(0);
			for (int VcxF4U4i = 0; VcxF4U4i < PBJdWOkE.length; VcxF4U4i++) {
				int pHcJto1h = ((PBJdWOkE[VcxF4U4i] >> 4) & 0xf) << 4;
				int ZnHXx5uV = PBJdWOkE[VcxF4U4i] & 0xf;
				if (pHcJto1h == 0) {
					bDw73nkS.append('0');
				}
				bDw73nkS.append(Integer.toHexString(pHcJto1h | ZnHXx5uV));
			}
			return bDw73nkS.toString();
		} catch (NoSuchAlgorithmException lAuRB2fG) {
			return null;
		}
	}

}