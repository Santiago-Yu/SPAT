class n14001795 {
	public static void copyOverWarFile() {
		System.out.println("Copy Over War File:");
		File BsQqvO1x = new File(theAppsDataDir);
		FileFilter vzAYc02q = new WildcardFileFilter("*.war");
		if (BsQqvO1x.listFiles(vzAYc02q).length == 0) {
			BsQqvO1x = new File(System.getProperty("user.dir") + "/war");
			if (BsQqvO1x.exists()) {
				File[] yYPq5HNT = BsQqvO1x.listFiles(vzAYc02q);
				for (File OcRRBYkx : yYPq5HNT) {
					try {
						File FoEZDgeo = new File("" + theAppsDataDir + "/" + OcRRBYkx.getName());
						System.out.println("Creating new file \"" + OcRRBYkx.getAbsolutePath() + "\"");
						FoEZDgeo.createNewFile();
						InputStream vBVGAk46 = new FileInputStream(OcRRBYkx);
						OutputStream YQGNeVo8 = new FileOutputStream(FoEZDgeo);
						IOUtils.copy(vBVGAk46, YQGNeVo8);
						moveUnzipAndExtract(FoEZDgeo);
					} catch (Exception djS96BW9) {
						Logger.getLogger(AppDataDir.class.getName()).log(Level.SEVERE, null, djS96BW9);
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