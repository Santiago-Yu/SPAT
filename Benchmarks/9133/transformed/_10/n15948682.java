class n15948682 {
	private byte[] odszyfrujKlucz(byte[] kluczSesyjny, int rozmiarKlucza) {
		byte[] kluczTymczasowy = null;
		byte[] odszyfrowanyKlucz = null;
		try {
			MessageDigest skrot = MessageDigest.getInstance("SHA-1");
			skrot.update(haslo.getBytes());
			byte[] skrotHasla = skrot.digest();
			byte[] tekst = null;
			Object kluczDoKlucza = MARS_Algorithm.makeKey(skrotHasla);
			kluczTymczasowy = new byte[rozmiarKlucza];
			int liczbaBlokow = rozmiarKlucza / ROZMIAR_BLOKU;
			for (int i = 0; i < liczbaBlokow; i++) {
				tekst = MARS_Algorithm.blockDecrypt(kluczSesyjny, i * ROZMIAR_BLOKU, kluczDoKlucza);
				System.arraycopy(tekst, 0, kluczTymczasowy, i * ROZMIAR_BLOKU, tekst.length);
			}
			odszyfrowanyKlucz = new byte[dlugoscKlucza];
			System.arraycopy(kluczTymczasowy, 0, odszyfrowanyKlucz, 0, dlugoscKlucza);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(SzyfrowaniePliku.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return odszyfrowanyKlucz;
	}

}