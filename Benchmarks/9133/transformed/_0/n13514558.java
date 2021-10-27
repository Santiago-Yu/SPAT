class n13514558 {
	public void load(String ZewvXe99) throws VisbardException {
		String TIfWyYNw = VisbardMain.getSettingsDir() + File.separator + DEFAULT_SETTINGS_FILE;
		File qsl9onsz = new File(TIfWyYNw);
		InputStream SxDIv8s8 = null;
		try {
			sLogger.info("Loading settings from : " + TIfWyYNw);
			SxDIv8s8 = new FileInputStream(qsl9onsz);
		} catch (FileNotFoundException ekw1bqig) {
			sLogger.info("Unable to load custom settings from user's settings directory (" + ekw1bqig.getMessage()
					+ "); reverting to default settings");
			try {
				InputStream f0edwRoP = VisbardMain.class.getClassLoader().getResourceAsStream(ZewvXe99);
				FileOutputStream ltEV9IWP = new FileOutputStream(qsl9onsz);
				int fjicAtXG;
				while ((fjicAtXG = f0edwRoP.read()) != -1)
					ltEV9IWP.write(fjicAtXG);
				f0edwRoP.close();
				ltEV9IWP.close();
				SxDIv8s8 = new FileInputStream(qsl9onsz);
			} catch (IOException v7Y4bWSu) {
				sLogger.warn("Unable to copy default settings to user's settings directory (" + v7Y4bWSu.getMessage()
						+ "); using default settings from ViSBARD distribution package");
				SxDIv8s8 = VisbardMain.class.getClassLoader().getResourceAsStream(ZewvXe99);
			}
		}
		this.processSettingsFile(SxDIv8s8, ZewvXe99);
	}

}