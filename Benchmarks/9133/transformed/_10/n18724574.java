class n18724574 {
	public String gerarHash(String frase) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(frase.getBytes());
			StringBuilder s = new StringBuilder(0);
			byte[] bytes = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
				if (parteAlta == 0) {
					s.append('0');
				}
				int parteBaixa = bytes[i] & 0xf;
				s.append(Integer.toHexString(parteAlta | parteBaixa));
			}
			return s.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}