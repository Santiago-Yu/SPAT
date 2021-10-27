class n14429171 {
	public void salva(UploadedFile imagem, Usuario usuario) {
		File destino;
		destino = (usuario.getId() == null) ? new File(pastaImagens, usuario.hashCode() + ".jpg")
				: new File(pastaImagens, usuario.getId() + ".jpg");
		try {
			IOUtils.copyLarge(imagem.getFile(), new FileOutputStream(destino));
		} catch (Exception e) {
			throw new RuntimeException("Erro ao copiar imagem", e);
		}
		redimensionar(destino.getPath(), destino.getPath(), "jpg", 110, 110);
	}

}