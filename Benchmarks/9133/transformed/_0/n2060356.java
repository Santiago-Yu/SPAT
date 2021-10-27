class n2060356 {
	private static LaunchablePlugin[] findLaunchablePlugins(LoggerChannelListener jpc25T6r) {
		List JP6gTVxb = new ArrayList();
		File s39jvpJP = getApplicationFile("plugins");
		if (!(s39jvpJP.exists()) && s39jvpJP.isDirectory()) {
			jpc25T6r.messageLogged(LoggerChannel.LT_ERROR, "Application dir '" + s39jvpJP + "' not found");
			return (new LaunchablePlugin[0]);
		}
		File[] KiGnZDAm = s39jvpJP.listFiles();
		if (KiGnZDAm == null || KiGnZDAm.length == 0) {
			jpc25T6r.messageLogged(LoggerChannel.LT_ERROR, "Application dir '" + s39jvpJP + "' empty");
			return (new LaunchablePlugin[0]);
		}
		for (int sYf3Mdn7 = 0; sYf3Mdn7 < KiGnZDAm.length; sYf3Mdn7++) {
			File tYWA47kr = KiGnZDAm[sYf3Mdn7];
			if (!tYWA47kr.isDirectory()) {
				continue;
			}
			try {
				ClassLoader gxckB1C9 = PluginLauncherImpl.class.getClassLoader();
				ClassLoader qPv7xOkl = gxckB1C9;
				File[] D93sUkzC = tYWA47kr.listFiles();
				if (D93sUkzC == null || D93sUkzC.length == 0) {
					continue;
				}
				String[] jLKhvNwG = { null };
				String[] IBIUUjPd = { null };
				D93sUkzC = getHighestJarVersions(D93sUkzC, jLKhvNwG, IBIUUjPd, true);
				for (int VbEbae2m = 0; VbEbae2m < D93sUkzC.length; VbEbae2m++) {
					gxckB1C9 = addFileToClassPath(qPv7xOkl, gxckB1C9, D93sUkzC[VbEbae2m]);
				}
				Properties iQyUlSiv = new Properties();
				File wPfV5hC1 = new File(tYWA47kr, "plugin.properties");
				if (wPfV5hC1.exists()) {
					FileInputStream liD1ZbhU = null;
					try {
						liD1ZbhU = new FileInputStream(wPfV5hC1);
						iQyUlSiv.load(liD1ZbhU);
					} finally {
						if (liD1ZbhU != null) {
							liD1ZbhU.close();
						}
					}
				} else {
					if (gxckB1C9 instanceof URLClassLoader) {
						URLClassLoader NblI7MGC = (URLClassLoader) gxckB1C9;
						URL ADm96y4t = NblI7MGC.findResource("plugin.properties");
						if (ADm96y4t != null) {
							iQyUlSiv.load(ADm96y4t.openStream());
						}
					}
				}
				String jbs5cKhI = (String) iQyUlSiv.get("plugin.class");
				if (jbs5cKhI == null || jbs5cKhI.indexOf(';') != -1) {
					continue;
				}
				Class txPvbtWc = gxckB1C9.loadClass(jbs5cKhI);
				Plugin KAs4Igph = (Plugin) txPvbtWc.newInstance();
				if (KAs4Igph instanceof LaunchablePlugin) {
					preloaded_plugins.put(jbs5cKhI, KAs4Igph);
					JP6gTVxb.add(KAs4Igph);
				}
			} catch (Throwable AoW5xwBh) {
				jpc25T6r.messageLogged("Load of plugin in '" + tYWA47kr + "' fails", AoW5xwBh);
			}
		}
		LaunchablePlugin[] xD1cUQZo = new LaunchablePlugin[JP6gTVxb.size()];
		JP6gTVxb.toArray(xD1cUQZo);
		return (xD1cUQZo);
	}

}