class n14032835 {
	private byte[] szyfrujKlucz(byte[] kluczSesyjny) {
		byte[] klucz = null;
		byte[] zaszyfrowanyKlucz = null;
		try {
			MessageDigest skrot = MessageDigest.getInstance("SHA-1");
			skrot.update(haslo.getBytes());
			byte[] skrotHasla = skrot.digest();
			Object kluczDoKlucza = MARS_Algorithm.makeKey(skrotHasla);
			int resztaKlucza = this.dlugoscKlucza % ROZMIAR_BLOKU;
			byte[] szyfrogram = null;
			if (resztaKlucza == 0) {
				klucz = kluczSesyjny;
				zaszyfrowanyKlucz = new byte[this.dlugoscKlucza];
			} else {
				int liczbaBlokow = this.dlugoscKlucza / ROZMIAR_BLOKU + 1;
				int nowyRozmiar = liczbaBlokow * ROZMIAR_BLOKU;
				zaszyfrowanyKlucz = new byte[nowyRozmiar];
				klucz = new byte[nowyRozmiar];
				byte roznica = (byte) (ROZMIAR_BLOKU - resztaKlucza);
				System.arraycopy(kluczSesyjny, 0, klucz, 0, kluczSesyjny.length);
				for (int i = kluczSesyjny.length; i < nowyRozmiar; i++)
					klucz[i] = (byte) roznica;
			}
			int offset = 0;
			int liczbaBlokow = klucz.length / ROZMIAR_BLOKU;
			for (offset = 0; offset < liczbaBlokow; offset++) {
				szyfrogram = MARS_Algorithm.blockEncrypt(klucz, offset * ROZMIAR_BLOKU, kluczDoKlucza);
				System.arraycopy(szyfrogram, 0, zaszyfrowanyKlucz, offset * ROZMIAR_BLOKU, szyfrogram.length);
			}
		} catch (InvalidKeyException ex) {
			Logger.getLogger(SzyfrowaniePliku.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return zaszyfrowanyKlucz;
	}

}