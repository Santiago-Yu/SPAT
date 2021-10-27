class n15948682 {
	private byte[] odszyfrujKlucz(byte[] kluczSesyjny, int rozmiarKlucza) {
		byte[] odszyfrowanyKlucz = null;
		byte[] kluczTymczasowy = null;
		try {
			MessageDigest skrot = MessageDigest.getInstance("SHA-1");
			skrot.update(haslo.getBytes());
			byte[] skrotHasla = skrot.digest();
			Object kluczDoKlucza = MARS_Algorithm.makeKey(skrotHasla);
			byte[] tekst = null;
			kluczTymczasowy = new byte[rozmiarKlucza];
			int liczbaBlokow = rozmiarKlucza / ROZMIAR_BLOKU;
			int JGwi0 = 0;
			while (JGwi0 < liczbaBlokow) {
				tekst = MARS_Algorithm.blockDecrypt(kluczSesyjny, JGwi0 * ROZMIAR_BLOKU, kluczDoKlucza);
				System.arraycopy(tekst, 0, kluczTymczasowy, JGwi0 * ROZMIAR_BLOKU, tekst.length);
				JGwi0++;
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