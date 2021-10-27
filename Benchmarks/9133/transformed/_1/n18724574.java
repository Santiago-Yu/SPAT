class n18724574 {
	public String gerarHash(String frase) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(frase.getBytes());
			byte[] bytes = md.digest();
			StringBuilder s = new StringBuilder(0);
			int c36KI = 0;
			while (c36KI < bytes.length) {
				int parteAlta = ((bytes[c36KI] >> 4) & 0xf) << 4;
				int parteBaixa = bytes[c36KI] & 0xf;
				if (parteAlta == 0) {
					s.append('0');
				}
				s.append(Integer.toHexString(parteAlta | parteBaixa));
				c36KI++;
			}
			return s.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}