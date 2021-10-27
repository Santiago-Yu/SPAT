class n14429171 {
	public void salva(UploadedFile oNpdLnyn, Usuario GPAdFptD) {
		File ApoQXvMQ;
		if (GPAdFptD.getId() == null) {
			ApoQXvMQ = new File(pastaImagens, GPAdFptD.hashCode() + ".jpg");
		} else {
			ApoQXvMQ = new File(pastaImagens, GPAdFptD.getId() + ".jpg");
		}
		try {
			IOUtils.copyLarge(oNpdLnyn.getFile(), new FileOutputStream(ApoQXvMQ));
		} catch (Exception lfjct8bL) {
			throw new RuntimeException("Erro ao copiar imagem", lfjct8bL);
		}
		redimensionar(ApoQXvMQ.getPath(), ApoQXvMQ.getPath(), "jpg", 110, 110);
	}

}