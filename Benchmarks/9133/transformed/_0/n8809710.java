class n8809710 {
	public void salva(UploadedFile mqjhNL7N, Usuario EDl89ani) {
		File RuL4sHX5 = new File(pastaImagens, EDl89ani.getId() + ".imagem");
		try {
			IOUtils.copyLarge(mqjhNL7N.getFile(), new FileOutputStream(RuL4sHX5));
		} catch (IOException cq74S0MB) {
			throw new RuntimeException("Erro ao copiar imagem", cq74S0MB);
		}
	}

}