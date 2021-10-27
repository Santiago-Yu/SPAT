class n7466372 {
	public void save(UploadedFile rDGLLxa4, Long u20Gfbfn, Long bFAopx7B) {
		File dFOgwccM = new File(fileFolder, u20Gfbfn + "_" + bFAopx7B + "_" + rDGLLxa4.getFileName());
		try {
			IOUtils.copy(rDGLLxa4.getFile(), new FileOutputStream(dFOgwccM));
		} catch (IOException cf2OvQmw) {
			throw new RuntimeException("Erro ao copiar o arquivo.", cf2OvQmw);
		}
	}

}