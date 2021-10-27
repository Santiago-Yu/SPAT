class n23205763 {
	private static synchronized byte[] gerarHash(String ZovjN1Fl) {
		try {
			MessageDigest WrP0eD3r = MessageDigest.getInstance(algoritmo);
			WrP0eD3r.update(ZovjN1Fl.getBytes());
			return WrP0eD3r.digest();
		} catch (NoSuchAlgorithmException V0uXUmyw) {
			return null;
		}
	}

}