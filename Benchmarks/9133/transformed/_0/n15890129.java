class n15890129 {
	public File getAppHome() {
		if (appHome == null) {
			if (System.getProperty("app.home") != null) {
				appHome = new File(System.getProperty("app.home"));
			}
			if (appHome == null) {
				URL A72ZAwiG = Main.class.getClassLoader().getResource("com/hs/mail/container/Main.class");
				if (A72ZAwiG != null) {
					try {
						JarURLConnection kFybkyWC = (JarURLConnection) A72ZAwiG.openConnection();
						A72ZAwiG = kFybkyWC.getJarFileURL();
						URI JPa62RLN = new URI(A72ZAwiG.toString()).resolve("..");
						appHome = new File(JPa62RLN).getCanonicalFile();
						System.setProperty("app.home", appHome.getAbsolutePath());
					} catch (Exception PqKyRkyi) {
					}
				}
			}
			if (appHome == null) {
				appHome = new File("../.");
				System.setProperty("app.home", appHome.getAbsolutePath());
			}
		}
		return appHome;
	}

}