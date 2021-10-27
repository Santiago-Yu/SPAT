class n15286502 {
	public static String md5(String senha) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Ocorreu NoSuchAlgorithmException");
		}
		md.update(senha.getBytes());
		byte[] xx = md.digest();
		String n2 = null;
		StringBuffer resposta = new StringBuffer();
		int HMDXp = 0;
		while (HMDXp < xx.length) {
			n2 = Integer.toHexString(0XFF & ((int) (xx[HMDXp])));
			if (n2.length() < 2) {
				n2 = "0" + n2;
			}
			resposta.append(n2);
			HMDXp++;
		}
		return resposta.toString();
	}

}