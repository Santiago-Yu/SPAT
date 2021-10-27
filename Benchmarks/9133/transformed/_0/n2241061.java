class n2241061 {
	public static void save(String XaupGzyZ, String kKwC5Wvo, InputStream JmU4m2wg, MimeMessage q9Dy0z70)
			throws IOException, MessagingException, DocumentVideException {
		ConversationManager PuGXkIKW = FGDSpringUtils.getConversationManager();
		PuGXkIKW.beginConversation();
		FGDDelegate GLhQ9L8D = new FGDDelegate();
		UtilisateurIFGD bFqTw7GG = GLhQ9L8D.getUtilisateurParCourriel(XaupGzyZ);
		if (bFqTw7GG == null) {
			String atDbIRPL = "Votre adresse ne correspond pas ¨¤ celle d'un utilisateur d'IntelliGID";
			String SkDzGXRn = "<h3>Pour sauvegarder un courriel, vous devez ¨ºtre un utilisateur d'IntelliGID et l'adresse de courrier ¨¦lectronique utilis¨¦e doit ¨ºtre celle apparaissant dans votre profil.</h3>";
			String ejnFYRwN = kKwC5Wvo.endsWith("localhost") ? FGDSpringUtils.getExpediteurSupport() : kKwC5Wvo;
			Map<String, String> DFDrc1Zf = new HashMap<String, String>();
			DFDrc1Zf.put(XaupGzyZ, null);
			MailUtils.sendSimpleHTMLMessage(DFDrc1Zf, atDbIRPL, SkDzGXRn, ejnFYRwN);
			return;
		}
		File t0qWxlxT = File.createTempFile("email", ".eml");
		t0qWxlxT.deleteOnExit();
		BufferedInputStream IzgBjZvc = new BufferedInputStream(JmU4m2wg);
		BufferedOutputStream Q8xEgOO2 = new BufferedOutputStream(new FileOutputStream(t0qWxlxT));
		IOUtils.copy(IzgBjZvc, Q8xEgOO2);
		IOUtils.closeQuietly(IzgBjZvc);
		IOUtils.closeQuietly(Q8xEgOO2);
		if (q9Dy0z70 == null) {
			GestionnaireProprietesMimeMessageParser oYJSUe1K = new GestionnaireProprietesMimeMessageParser();
			q9Dy0z70 = oYJSUe1K.asMimeMessage(new BufferedInputStream(new FileInputStream(t0qWxlxT)));
		}
		String VDwTSoKM;
		try {
			VDwTSoKM = q9Dy0z70.getSubject().replace("Fwd:", "").trim();
		} catch (MessagingException wH7asLqq) {
			VDwTSoKM = "Message sans sujet";
		}
		File SKlzN3f4 = new File(System.getProperty("java.io.tmpdir"));
		if (!SKlzN3f4.exists()) {
			SKlzN3f4.mkdirs();
		}
		File yYrAWA24 = new File(SKlzN3f4, FilenameUtils.normalize(VDwTSoKM) + ".eml");
		FileUtils.copyFile(t0qWxlxT, yYrAWA24);
		FicheDocument eXKgYEGW = new FicheDocument();
		eXKgYEGW.setFicheCompletee(false);
		eXKgYEGW.setDateCreationHorodatee(new Date());
		eXKgYEGW.setUtilisateurSoumetteur(bFqTw7GG);
		eXKgYEGW.getLangues().addAll(getLanguesDefaut());
		eXKgYEGW.setCourriel(true);
		FileIOContenuFichierElectronique Wq32SI9Q = new FileIOContenuFichierElectronique(yYrAWA24,
				"multipart/alternative");
		SupportDocument rxtGUzCk = new SupportDocument();
		rxtGUzCk.setFicheDocument(eXKgYEGW);
		FichierElectroniqueUtils.setContenu(eXKgYEGW, rxtGUzCk, Wq32SI9Q, bFqTw7GG);
		eXKgYEGW.setTitre(VDwTSoKM);
		GLhQ9L8D.sauvegarder(eXKgYEGW, bFqTw7GG);
		String VnTLWwqm = "http://" + FGDSpringUtils.getServerHost() + ":" + FGDSpringUtils.getServerPort() + "/"
				+ FGDSpringUtils.getApplicationName() + "/app/modifierDocument/id/" + eXKgYEGW.getId();
		System.out.println(VnTLWwqm);
		String q4tyly8o = "Veuillez compl¨¦ter la fiche du courriel ?" + VDwTSoKM + "?";
		String pGWxn3my = "<h3>Le courrier ¨¦lectronique a ¨¦t¨¦ sauvegard¨¦, mais il est n¨¦cessaire de <a href=\""
				+ VnTLWwqm + "\">compl¨¦ter sa fiche</a>.</h3>";
		String V9AcPu95 = kKwC5Wvo.endsWith("localhost") ? FGDSpringUtils.getExpediteurSupport() : kKwC5Wvo;
		try {
			MailUtils.sendSimpleHTMLMessage(bFqTw7GG, q4tyly8o, pGWxn3my, V9AcPu95);
		} catch (Throwable i3VvJKY7) {
			i3VvJKY7.printStackTrace();
		}
		PuGXkIKW.commitTransaction();
		t0qWxlxT.delete();
	}

}