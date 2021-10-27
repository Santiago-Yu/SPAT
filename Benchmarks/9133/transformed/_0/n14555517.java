class n14555517 {
	@Override
	@RemoteMethod
	public boolean encrypt(int pnfSoUhi) {
		try {
			Anexo VhI6hqD4 = anexoService.selectById(pnfSoUhi);
			aes.init(Cipher.ENCRYPT_MODE, aeskeySpec);
			FileInputStream iMZtlBeZ = new FileInputStream(
					config.baseDir + "/arquivos_upload_direto/" + VhI6hqD4.getAnexoCaminho());
			CipherOutputStream yz7cDRmi = new CipherOutputStream(new FileOutputStream(
					config.baseDir + "/arquivos_upload_direto/encrypt/" + VhI6hqD4.getAnexoCaminho()), aes);
			IOUtils.copy(iMZtlBeZ, yz7cDRmi);
			yz7cDRmi.close();
			iMZtlBeZ.close();
		} catch (Exception VuC9ZpWz) {
			VuC9ZpWz.printStackTrace();
			return false;
		}
		return true;
	}

}