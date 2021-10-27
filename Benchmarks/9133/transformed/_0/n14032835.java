class n14032835 {
	private byte[] szyfrujKlucz(byte[] hzDgqhTl) {
		byte[] Trx4vqtw = null;
		byte[] K2Y3lGi2 = null;
		try {
			MessageDigest TIVLqVwB = MessageDigest.getInstance("SHA-1");
			TIVLqVwB.update(haslo.getBytes());
			byte[] Fq57OMjq = TIVLqVwB.digest();
			Object Dpxp8Ga7 = MARS_Algorithm.makeKey(Fq57OMjq);
			int JTXicvEm = this.dlugoscKlucza % ROZMIAR_BLOKU;
			if (JTXicvEm == 0) {
				K2Y3lGi2 = hzDgqhTl;
				Trx4vqtw = new byte[this.dlugoscKlucza];
			} else {
				int cfVRhWHW = this.dlugoscKlucza / ROZMIAR_BLOKU + 1;
				int PU1Uhwib = cfVRhWHW * ROZMIAR_BLOKU;
				Trx4vqtw = new byte[PU1Uhwib];
				K2Y3lGi2 = new byte[PU1Uhwib];
				byte SjVre3x5 = (byte) (ROZMIAR_BLOKU - JTXicvEm);
				System.arraycopy(hzDgqhTl, 0, K2Y3lGi2, 0, hzDgqhTl.length);
				for (int qJRSGHD6 = hzDgqhTl.length; qJRSGHD6 < PU1Uhwib; qJRSGHD6++)
					K2Y3lGi2[qJRSGHD6] = (byte) SjVre3x5;
			}
			byte[] bMCM4P80 = null;
			int AzaPqW8J = K2Y3lGi2.length / ROZMIAR_BLOKU;
			int NrKIZ1rq = 0;
			for (NrKIZ1rq = 0; NrKIZ1rq < AzaPqW8J; NrKIZ1rq++) {
				bMCM4P80 = MARS_Algorithm.blockEncrypt(K2Y3lGi2, NrKIZ1rq * ROZMIAR_BLOKU, Dpxp8Ga7);
				System.arraycopy(bMCM4P80, 0, Trx4vqtw, NrKIZ1rq * ROZMIAR_BLOKU, bMCM4P80.length);
			}
		} catch (InvalidKeyException jzmKKQN6) {
			Logger.getLogger(SzyfrowaniePliku.class.getName()).log(Level.SEVERE, null, jzmKKQN6);
		} catch (NoSuchAlgorithmException DDI5QJ5g) {
			DDI5QJ5g.printStackTrace();
		}
		return Trx4vqtw;
	}

}