class n15948682 {
	private byte[] odszyfrujKlucz(byte[] SswxhgsT, int SiJo1NWC) {
		byte[] P40R6nJZ = null;
		byte[] EiDBRjID = null;
		try {
			MessageDigest COyhaAuR = MessageDigest.getInstance("SHA-1");
			COyhaAuR.update(haslo.getBytes());
			byte[] Wvq3qhrh = COyhaAuR.digest();
			Object iubHS2RJ = MARS_Algorithm.makeKey(Wvq3qhrh);
			byte[] R6iFlqNx = null;
			EiDBRjID = new byte[SiJo1NWC];
			int tPam0Ung = SiJo1NWC / ROZMIAR_BLOKU;
			for (int YOYO3PQD = 0; YOYO3PQD < tPam0Ung; YOYO3PQD++) {
				R6iFlqNx = MARS_Algorithm.blockDecrypt(SswxhgsT, YOYO3PQD * ROZMIAR_BLOKU, iubHS2RJ);
				System.arraycopy(R6iFlqNx, 0, EiDBRjID, YOYO3PQD * ROZMIAR_BLOKU, R6iFlqNx.length);
			}
			P40R6nJZ = new byte[dlugoscKlucza];
			System.arraycopy(EiDBRjID, 0, P40R6nJZ, 0, dlugoscKlucza);
		} catch (InvalidKeyException cl43Cm7y) {
			Logger.getLogger(SzyfrowaniePliku.class.getName()).log(Level.SEVERE, null, cl43Cm7y);
		} catch (NoSuchAlgorithmException AWqtAR1d) {
			AWqtAR1d.printStackTrace();
		}
		return P40R6nJZ;
	}

}