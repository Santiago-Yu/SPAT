class n13362846 {
	public static void setContenu(ContenuFichierElectronique fK7pxsCr, FichierElectronique P2P3d0wL,
			UtilisateurIFGD paLO0Vgt) throws IOException, DocumentVideException {
		if (fK7pxsCr != null) {
			SupportDocument BzrCKCvi = P2P3d0wL.getSupport();
			BzrCKCvi.setFichierElectronique(P2P3d0wL);
			FicheDocument nEFCjtjG = BzrCKCvi.getFicheDocument();
			String M30FqXJP = fK7pxsCr.getNomFichier();
			String jKFXfnUV = FilenameUtils.getExtension(M30FqXJP);
			if (nEFCjtjG.getFichierElectronique(M30FqXJP) != null) {
				FichierElectronique opu4AWQp = nEFCjtjG.getFichierElectronique(M30FqXJP);
				if (opu4AWQp.getId() != null && !opu4AWQp.getId().equals(P2P3d0wL.getId())) {
					throw new FichierElectroniqueExistantException(M30FqXJP, nEFCjtjG);
				}
			}
			if (P2P3d0wL.getId() == null) {
				if (OfficeDocumentPropertiesUtil.canWriteIdIGID(jKFXfnUV)) {
					Long R1KIp2B1 = OfficeDocumentPropertiesUtil.getIdIGID(fK7pxsCr);
					if (R1KIp2B1 != null) {
						throw new FichierElectroniqueExistantException(M30FqXJP, R1KIp2B1, nEFCjtjG);
					}
				}
			}
			InputStream AIFohu7X = fK7pxsCr.getInputStream();
			OutputStream hJh333s2 = P2P3d0wL.getOutputStream();
			try {
				IOUtils.copy(AIFohu7X, hJh333s2);
			} finally {
				try {
					AIFohu7X.close();
				} finally {
					hJh333s2.close();
				}
			}
			String AKwNu1iN = fK7pxsCr.getContentType();
			long KUGTVojz = fK7pxsCr.getTailleFichier();
			Date D2k4hrIk = new Date();
			P2P3d0wL.setNom(M30FqXJP);
			P2P3d0wL.setTypeMime(jKFXfnUV);
			creerFormatSiNecessaire(AKwNu1iN, jKFXfnUV);
			P2P3d0wL.setTaille(KUGTVojz);
			P2P3d0wL.setDateDerniereModification(D2k4hrIk);
			P2P3d0wL.setSoumetteur(paLO0Vgt);
			if (jKFXfnUV.endsWith("msg")) {
				CourrielUtils.peuplerMetadonneesCourriel(P2P3d0wL.getNom(), nEFCjtjG, fK7pxsCr.getInputStream(),
						paLO0Vgt);
			} else if (jKFXfnUV.endsWith("eml")) {
				Map<String, Object> dcWydOcn = new GestionnaireProprietesMimeMessageParser()
						.parseMsg(fK7pxsCr.getInputStream());
				CourrielUtils.peuplerMetadonneesCourriel(P2P3d0wL.getNom(), nEFCjtjG, dcWydOcn, paLO0Vgt);
			} else {
				FGDProprietesDocumentUtils.copierMetadonneesProprietes(P2P3d0wL, nEFCjtjG);
			}
		}
	}

}