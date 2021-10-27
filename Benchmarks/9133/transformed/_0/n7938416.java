class n7938416 {
	@Override
	@RemoteMethod
	public synchronized boolean copy(int KRlBYeMz) {
		try {
			Anexo WeGnoi5j = selectById(KRlBYeMz);
			Authentication UnPQFPRr = SecurityContextHolder.getContext().getAuthentication();
			Usuario rL2qKHoC = (Usuario) UnPQFPRr.getPrincipal();
			if (WeGnoi5j.getAssinado() == 1 && WeGnoi5j.getIdAssinadoPor() != rL2qKHoC.getIdUsuario()) {
				deleteAnexoFromTemp(WeGnoi5j);
				return false;
			}
			Carteira UGhdNwOc = carteiraService.selectById(rL2qKHoC.getIdCarteira());
			DocumentoDetalhes T0jepVk0 = WeGnoi5j.getDocumentoDetalhes();
			Set<Documento> Lk0nofqx = T0jepVk0.getDocumentosByCarteira();
			boolean tvnYWsVz = false;
			for (Documento I9kwIuu3 : Lk0nofqx) {
				Carteira YgbXpzSd = I9kwIuu3.getCarteira();
				if (YgbXpzSd != null) {
					if (YgbXpzSd.getIdCarteira() == UGhdNwOc.getIdCarteira()) {
						tvnYWsVz = true;
						System.out.println("tem permisssao: " + tvnYWsVz);
						break;
					}
				}
			}
			if (!tvnYWsVz) {
				System.out.println("N?o tem permissao.");
				return false;
			}
			FileInputStream dJrrH3u0 = new FileInputStream(
					new File(config.baseDir + "/temp/" + WeGnoi5j.getAnexoCaminho()));
			FileOutputStream HmMyh7QG = new FileOutputStream(
					new File(config.baseDir + "/arquivos_upload_direto/" + WeGnoi5j.getAnexoCaminho()));
			IOUtils.copy(dJrrH3u0, HmMyh7QG);
			String iDzu1P7T = "(Edi??o) -" + WeGnoi5j.getAnexoNome() + "-";
			iDzu1P7T += rL2qKHoC.getUsuLogin();
			Historico CoXdF9Cb = new Historico();
			CoXdF9Cb.setCarteira(UGhdNwOc);
			CoXdF9Cb.setDataHoraHistorico(new Date());
			CoXdF9Cb.setHistorico(iDzu1P7T);
			CoXdF9Cb.setDocumentoDetalhes(T0jepVk0);
			CoXdF9Cb.setUsuario(rL2qKHoC);
			historicoService.save(CoXdF9Cb);
			return deleteAnexoFromTemp(WeGnoi5j);
		} catch (FileNotFoundException KAZPhwhB) {
			System.out.println("FileNotFoundException");
			KAZPhwhB.printStackTrace();
			return false;
		} catch (IOException yWhXwzit) {
			System.out.println("IOException");
			yWhXwzit.printStackTrace();
			return false;
		} catch (Exception LOETLiVP) {
			System.out.println("AnexoServiceImpl.copy ERRO DESCONHECIDO");
			LOETLiVP.printStackTrace();
			return false;
		}
	}

}