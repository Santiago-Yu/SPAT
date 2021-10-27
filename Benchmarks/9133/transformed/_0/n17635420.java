class n17635420 {
	public static void verifierSiDerniereVersionDesPluginsMenus(ControleurDeMenu KbFz2jKS) {
		if (KbFz2jKS.getURLFichierInfoDerniereVersion() == null || KbFz2jKS.getURLFichierInfoDerniereVersion() == "") {
			System.err.println("Evenements.java:verifierSiDerniereVersionDesPluginsMenus impossible:\n"
					+ "pour le plugin chargeur de menu :" + KbFz2jKS.getNomPlugin());
		}
		if (KbFz2jKS.getVersionPlugin() == 0) {
			System.err.println(
					"version non renseignee pour :" + KbFz2jKS.getNomPlugin() + " on continue sur le plugin suivant");
			return;
		}
		URL QscW27eU;
		try {
			QscW27eU = new URL(KbFz2jKS.getURLFichierInfoDerniereVersion());
		} catch (MalformedURLException jBqEuqSY) {
			System.err
					.println("impossible d'ouvrir l'URL (url mal formee)" + KbFz2jKS.getURLFichierInfoDerniereVersion()
							+ "\n lors de la recuperation des informations de version sur " + KbFz2jKS.getNomPlugin());
			return;
		}
		InputStream P5OsDi9H;
		try {
			P5OsDi9H = QscW27eU.openStream();
		} catch (IOException Unz6YiNb) {
			System.err.println(
					"impossible d'ouvrir l'URL (destination inaccessible)" + KbFz2jKS.getURLFichierInfoDerniereVersion()
							+ "\n lors de la recuperation des informations de version sur " + KbFz2jKS.getNomPlugin());
			return;
		}
		File eD9x6ftG;
		try {
			eD9x6ftG = File.createTempFile("SimplexeReseau" + compteurDeFichiersTemporaires, ".buf");
		} catch (IOException tpDyx07I) {
			System.err.println(
					"impossible de creer le fichier temporaire\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		compteurDeFichiersTemporaires++;
		eD9x6ftG.deleteOnExit();
		java.io.InputStream EOOvmVy7 = null;
		java.io.FileOutputStream MQmYFFUk = null;
		try {
			eD9x6ftG.createNewFile();
		} catch (IOException aLCKdPQG) {
			System.err.println(
					"impossible de creer un fichier temporaire\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		EOOvmVy7 = P5OsDi9H;
		try {
			MQmYFFUk = new FileOutputStream(eD9x6ftG);
		} catch (FileNotFoundException iGqP12Nt) {
			System.err.println(
					"impossible d'ouvrir le flux reseau\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		byte U5jyK830[] = new byte[512 * 1024];
		int n1ovOPMS;
		try {
			while ((n1ovOPMS = EOOvmVy7.read(U5jyK830)) != -1) {
				MQmYFFUk.write(U5jyK830, 0, n1ovOPMS);
			}
		} catch (IOException Foz1GVXw) {
			System.err.println(
					"impossible d'ecrire dans le fichier temporaire\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		try {
			EOOvmVy7.close();
			MQmYFFUk.close();
		} catch (IOException gI1CP0Fy) {
			System.err.println(
					"impossible de fermer le fichier temporaire ou le flux reseau\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		BufferedReader ydT2i7c2 = null;
		String qFulLgr4;
		try {
			ydT2i7c2 = new BufferedReader(new FileReader(eD9x6ftG));
		} catch (FileNotFoundException joKU6UWQ) {
			System.err.println(
					"impossible d'ouvrir le fichier temporaire apres sa creation (contacter un developpeur)\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		try {
			boolean elg5hp9x = true;
			String NkFMx21k = null;
			while ((qFulLgr4 = ydT2i7c2.readLine()) != null) {
				if (qFulLgr4.startsWith("version:")) {
					if (qFulLgr4.equals("version:" + KbFz2jKS.getVersionPlugin())) {
					} else {
						System.err.println("la version pour " + KbFz2jKS.getNomPlugin() + " est depassee ("
								+ KbFz2jKS.getVersionPlugin() + " alors que la " + qFulLgr4 + "est disponible)");
						elg5hp9x = false;
					}
				}
				if (qFulLgr4.startsWith("url:")) {
					NkFMx21k = qFulLgr4.substring(4, qFulLgr4.length());
				}
			}
			if (!elg5hp9x && NkFMx21k != null) {
				TelechargerPluginEtCharger(KbFz2jKS, NkFMx21k);
			} else {
				System.out.println("on est a la derniere version du plugin " + KbFz2jKS.getNomPlugin());
			}
		} catch (IOException ukdOoExO) {
			System.err.println(
					"impossible de lire le fichier temporaire apres sa creation\n lors de la recuperation des informations de version sur "
							+ KbFz2jKS.getNomPlugin());
			return;
		}
		try {
			ydT2i7c2.close();
		} catch (IOException Jp0agD7p) {
			return;
		}
	}

}