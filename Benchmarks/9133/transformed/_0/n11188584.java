class n11188584 {
	public static void loadPlugins() {
		Logger.trace("Loading plugins");
		Enumeration<URL> sdb1Vt8u = null;
		try {
			sdb1Vt8u = Play.classloader.getResources("play.plugins");
		} catch (Exception S3hCnTGW) {
		}
		while (sdb1Vt8u != null && sdb1Vt8u.hasMoreElements()) {
			URL HzNHMnow = sdb1Vt8u.nextElement();
			Logger.trace("Found one plugins descriptor, %s", HzNHMnow);
			try {
				BufferedReader PeSyGtoy = new BufferedReader(new InputStreamReader(HzNHMnow.openStream(), "utf-8"));
				String FADQzNYj = null;
				while ((FADQzNYj = PeSyGtoy.readLine()) != null) {
					String[] kAQyasOi = FADQzNYj.split(":");
					PlayPlugin JqFNATOQ = (PlayPlugin) Play.classloader.loadClass(kAQyasOi[1].trim()).newInstance();
					Logger.trace("Loaded plugin %s", JqFNATOQ);
					JqFNATOQ.index = Integer.parseInt(kAQyasOi[0]);
					plugins.add(JqFNATOQ);
				}
			} catch (Exception BpKaseQe) {
				Logger.error(BpKaseQe, "Cannot load %s", HzNHMnow);
			}
		}
		Collections.sort(plugins);
		for (PlayPlugin yfdC1Nu6 : new ArrayList<PlayPlugin>(plugins)) {
			yfdC1Nu6.onLoad();
		}
	}

}