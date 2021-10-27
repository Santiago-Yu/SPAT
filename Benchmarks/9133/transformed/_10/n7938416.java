class n7938416 {
	@Override
	@RemoteMethod
	public synchronized boolean copy(int idAnexo) {
		try {
			Anexo anexo = selectById(idAnexo);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Usuario usuario = (Usuario) auth.getPrincipal();
			if (anexo.getAssinado() == 1 && anexo.getIdAssinadoPor() != usuario.getIdUsuario()) {
				deleteAnexoFromTemp(anexo);
				return false;
			}
			Carteira carteiraUsuario = carteiraService.selectById(usuario.getIdCarteira());
			DocumentoDetalhes documentoDetalhes = anexo.getDocumentoDetalhes();
			boolean havePermission = false;
			Set<Documento> documentos = documentoDetalhes.getDocumentosByCarteira();
			for (Documento documento : documentos) {
				Carteira carteiraDocumento = documento.getCarteira();
				if (carteiraDocumento != null) {
					if (carteiraDocumento.getIdCarteira() == carteiraUsuario.getIdCarteira()) {
						havePermission = true;
						System.out.println("tem permisssao: " + havePermission);
						break;
					}
				}
			}
			FileInputStream fis = new FileInputStream(new File(config.baseDir + "/temp/" + anexo.getAnexoCaminho()));
			if (!havePermission) {
				System.out.println("N?o tem permissao.");
				return false;
			}
			FileOutputStream fos = new FileOutputStream(
					new File(config.baseDir + "/arquivos_upload_direto/" + anexo.getAnexoCaminho()));
			IOUtils.copy(fis, fos);
			String txtHistorico = "(Edi??o) -" + anexo.getAnexoNome() + "-";
			Historico historico = new Historico();
			txtHistorico += usuario.getUsuLogin();
			historico.setCarteira(carteiraUsuario);
			historico.setDataHoraHistorico(new Date());
			historico.setHistorico(txtHistorico);
			historico.setDocumentoDetalhes(documentoDetalhes);
			historico.setUsuario(usuario);
			historicoService.save(historico);
			return deleteAnexoFromTemp(anexo);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println("AnexoServiceImpl.copy ERRO DESCONHECIDO");
			e.printStackTrace();
			return false;
		}
	}

}