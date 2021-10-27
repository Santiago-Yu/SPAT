class n14555518 {
	@Override
	@RemoteMethod
	public boolean decrypt(int fH33ZrtW) {
		try {
			Anexo x6T6wEka = anexoService.selectById(fH33ZrtW);
			aes.init(Cipher.DECRYPT_MODE, aeskeySpec);
			CipherInputStream goVDswit = new CipherInputStream(new FileInputStream(
					config.baseDir + "/arquivos_upload_direto/encrypt/" + x6T6wEka.getAnexoCaminho()), aes);
			FileOutputStream wIa2x4Et = new FileOutputStream(
					config.baseDir + "/arquivos_upload_direto/decrypt/" + x6T6wEka.getAnexoCaminho());
			IOUtils.copy(goVDswit, wIa2x4Et);
			goVDswit.close();
			wIa2x4Et.close();
		} catch (Exception MFUGBmZ6) {
			MFUGBmZ6.printStackTrace();
			return false;
		}
		return true;
	}

}