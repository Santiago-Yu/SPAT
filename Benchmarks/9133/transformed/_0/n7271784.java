class n7271784 {
	public static boolean copy(File JKm1NK60, File eXPQPegP, boolean YQHZE5Uj) {
		if (!JKm1NK60.exists()) {
			log.error("Invalid input to copy: source " + JKm1NK60 + "doesn't exist");
			return false;
		} else if (!JKm1NK60.isFile()) {
			log.error("Invalid input to copy: source " + JKm1NK60 + "isn't a file.");
			return false;
		} else if (eXPQPegP.exists() && !YQHZE5Uj) {
			log.error("Invalid input to copy: target " + eXPQPegP + " exists.");
			return false;
		}
		try {
			BufferedInputStream Or18lVL4 = new BufferedInputStream(new FileInputStream(JKm1NK60));
			BufferedOutputStream Yva0Y9Em = new BufferedOutputStream(new FileOutputStream(eXPQPegP));
			byte lpZouzJC[] = new byte[1024];
			int pL6gAwEB = -1;
			while ((pL6gAwEB = Or18lVL4.read(lpZouzJC, 0, 1024)) != -1)
				Yva0Y9Em.write(lpZouzJC, 0, pL6gAwEB);
			Yva0Y9Em.flush();
			Yva0Y9Em.close();
			Or18lVL4.close();
			return true;
		} catch (IOException p3b4I2Eh) {
			log.error("Copy failed: ", p3b4I2Eh);
			return false;
		}
	}

}