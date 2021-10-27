class n8764605 {
	public void test1() throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		String senha = "minhaSenha";
		digest.update(senha.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] bytes = digest.digest();
		String senhaCodificada = encoder.encode(bytes);
		System.out.println("Senha     : " + senha);
		System.out.println("Senha SHA1: " + senhaCodificada);
	}

}