class n6085930 {
	public void update() {
		if (!updatable) {
			Main.fenetre().erreur(Fenetre.OLD_VERSION);
			return;
		}
		try {
			Main.fenetre().update();
			Element id0i5LOQ = new SAXBuilder().build(xml).getRootElement();
			addPackages = new HashMap<Integer, PackageVersion>();
			Iterator<?> wGlD0oXa = id0i5LOQ.getChildren().iterator();
			while (wGlD0oXa.hasNext()) {
				PackageVersion cKyYXc70 = new PackageVersion((Element) wGlD0oXa.next());
				addPackages.put(cKyYXc70.id(), cKyYXc70);
			}
			removePackages = new HashMap<Integer, PackageVersion>();
			wGlD0oXa = root.getChildren("package").iterator();
			while (wGlD0oXa.hasNext()) {
				PackageVersion LsX8DecK = new PackageVersion((Element) wGlD0oXa.next());
				int oU8lnb8m = LsX8DecK.id();
				if (!addPackages.containsKey(oU8lnb8m)) {
					removePackages.put(oU8lnb8m, LsX8DecK);
				} else if (addPackages.get(oU8lnb8m).version().equals(LsX8DecK.version())) {
					addPackages.remove(oU8lnb8m);
				} else {
					addPackages.get(oU8lnb8m).ecrase();
				}
			}
			Iterator<PackageVersion> TeeJHGaS = addPackages.values().iterator();
			while (TeeJHGaS.hasNext()) {
				install(TeeJHGaS.next());
			}
			TeeJHGaS = removePackages.values().iterator();
			while (TeeJHGaS.hasNext()) {
				remove(TeeJHGaS.next());
			}
			if (offline) {
				Runtime.getRuntime().addShutdownHook(new AddPackage(xml, "versions.xml"));
				Main.fenetre().erreur(Fenetre.UPDATE_TERMINE_RESTART);
			} else {
				File BdU6tT5K = new File("versions.xml");
				BdU6tT5K.delete();
				BdU6tT5K.createNewFile();
				FileChannel jIELWm6f = new FileOutputStream(BdU6tT5K).getChannel();
				FileChannel NvzRKXwW = new FileInputStream(xml).getChannel();
				NvzRKXwW.transferTo(0, NvzRKXwW.size(), jIELWm6f);
				NvzRKXwW.close();
				jIELWm6f.close();
				xml.delete();
				if (restart) {
					Main.fenetre().erreur(Fenetre.UPDATE_TERMINE_RESTART);
				} else {
					Main.updateVersion();
				}
			}
		} catch (Exception Z0SqWW0I) {
			Main.fenetre().erreur(Fenetre.ERREUR_UPDATE, Z0SqWW0I);
		}
	}

}