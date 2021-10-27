class n4471154 {
	private static void copier(FichierElectronique i1A2DTo2, FichierElectronique t6RdVM2B) throws IOException {
		t6RdVM2B.setNom(i1A2DTo2.getNom());
		t6RdVM2B.setTaille(i1A2DTo2.getTaille());
		t6RdVM2B.setTypeMime(i1A2DTo2.getTypeMime());
		t6RdVM2B.setSoumetteur(i1A2DTo2.getSoumetteur());
		t6RdVM2B.setDateDerniereModification(i1A2DTo2.getDateDerniereModification());
		t6RdVM2B.setEmprunteur(i1A2DTo2.getEmprunteur());
		t6RdVM2B.setDateEmprunt(i1A2DTo2.getDateEmprunt());
		t6RdVM2B.setNumeroVersion(i1A2DTo2.getNumeroVersion());
		InputStream mjHcjHzI = i1A2DTo2.getInputStream();
		OutputStream MfHXswSD = t6RdVM2B.getOutputStream();
		try {
			IOUtils.copy(mjHcjHzI, MfHXswSD);
		} finally {
			try {
				mjHcjHzI.close();
			} finally {
				MfHXswSD.close();
			}
			if (i1A2DTo2 instanceof FichierElectroniqueDefaut) {
				FichierElectroniqueDefaut RgOe1uqn = (FichierElectroniqueDefaut) i1A2DTo2;
				RgOe1uqn.deleteTemp();
			}
		}
	}

}