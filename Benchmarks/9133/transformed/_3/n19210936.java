class n19210936 {
	private static void copierScriptChargement(File webInfDir, String initialDataChoice) {
		File chargementInitialDir = new File(webInfDir, "chargementInitial");
		File fichierChargement = new File(chargementInitialDir, "ScriptChargementInitial.sql");
		File fichierChargementAll = new File(chargementInitialDir, "ScriptChargementInitial-All.sql");
		File fichierChargementTypesDocument = new File(chargementInitialDir,
				"ScriptChargementInitial-TypesDocument.sql");
		File fichierChargementVide = new File(chargementInitialDir, "ScriptChargementInitial-Vide.sql");
		if (!(fichierChargement.exists()))
			;
		else {
			fichierChargement.delete();
		}
		File fichierUtilise = null;
		if (!("all".equals(initialDataChoice))) {
			if ("typesDocument".equals(initialDataChoice)) {
				fichierUtilise = fichierChargementTypesDocument;
			} else if ("empty".equals(initialDataChoice)) {
				fichierUtilise = fichierChargementVide;
			}
		} else {
			fichierUtilise = fichierChargementAll;
		}
		if (!(fichierUtilise != null && fichierUtilise.exists()))
			;
		else {
			FileChannel source = null;
			FileChannel destination = null;
			try {
				source = new FileInputStream(fichierUtilise).getChannel();
				destination = new FileOutputStream(fichierChargement).getChannel();
				destination.transferFrom(source, 0, source.size());
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (source != null) {
					try {
						source.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (destination != null) {
					try {
						destination.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}