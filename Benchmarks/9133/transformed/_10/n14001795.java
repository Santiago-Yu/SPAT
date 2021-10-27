class n14001795 {
	public static void copyOverWarFile() {
		System.out.println("Copy Over War File:");
		FileFilter ff = new WildcardFileFilter("*.war");
		File dir = new File(theAppsDataDir);
		if (dir.listFiles(ff).length == 0) {
			dir = new File(System.getProperty("user.dir") + "/war");
			if (dir.exists()) {
				File[] files = dir.listFiles(ff);
				for (File f : files) {
					try {
						File newFile = new File("" + theAppsDataDir + "/" + f.getName());
						System.out.println("Creating new file \"" + f.getAbsolutePath() + "\"");
						newFile.createNewFile();
						OutputStream fo = new FileOutputStream(newFile);
						InputStream fi = new FileInputStream(f);
						IOUtils.copy(fi, fo);
						moveUnzipAndExtract(newFile);
					} catch (Exception ex) {
						Logger.getLogger(AppDataDir.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		} else {
			System.out.println("Found a war in the apps data dir, ignoring a fresh copy");
		}
		new JFileChooser().setCurrentDirectory(new File(theAppsDataDir));
		System.setProperty("user.dir", theAppsDataDir);
		System.out.println("User.dir : " + System.getProperty("user.dir"));
	}

}