class n21214234 {
	private PluginInfo loadPluginInfo(URL exluTdxO) throws PluginNotFoundException {
		if (exluTdxO == null)
			return null;
		BufferedReader PLXiiVdP = null;
		InputStream h0i1uXy1 = null;
		String JXGqhosd = null;
		String sTIioAIS = exluTdxO.toString();
		PluginInfo SbCemRDN = new PluginInfo();
		URL yYvlylP2;
		try {
			yYvlylP2 = new URL("jar:" + sTIioAIS + "!/");
		} catch (MalformedURLException wNMGK0rO) {
			throw new PluginNotFoundException(wNMGK0rO);
		}
		SbCemRDN.setURL(exluTdxO);
		HashMap rRiLFm0R = new HashMap();
		boolean sesxWAEo = false;
		for (int gOkxBkDt = 0; (gOkxBkDt <= 5) && (!sesxWAEo); gOkxBkDt++) {
			try {
				JarURLConnection wOl8KCDr = (JarURLConnection) yYvlylP2.openConnection();
				wOl8KCDr.setUseCaches(false);
				JarFile rfLr9WrP = wOl8KCDr.getJarFile();
				h0i1uXy1 = rfLr9WrP.getInputStream(rfLr9WrP.getJarEntry("META-INF/MANIFEST.MF"));
				PLXiiVdP = new BufferedReader(new InputStreamReader(h0i1uXy1));
				String ROTUeQcg;
				while ((ROTUeQcg = PLXiiVdP.readLine()) != null) {
					if (ROTUeQcg.startsWith("Frostplugin-Main-Class: ")) {
						JXGqhosd = ROTUeQcg.substring("Frostplugin-Main-Class: ".length()).trim();
						SbCemRDN.setMainClass(JXGqhosd);
						logger.log(Level.SEVERE, "Found plugin main class " + JXGqhosd + " from manifest");
					}
				}
				h0i1uXy1 = rfLr9WrP.getInputStream(rfLr9WrP.getJarEntry("pluginname.properties"));
				PLXiiVdP = new BufferedReader(new InputStreamReader(h0i1uXy1));
				while ((ROTUeQcg = PLXiiVdP.readLine()) != null) {
					if (ROTUeQcg.startsWith("#")) {
						continue;
					}
					if (ROTUeQcg.length() == 0) {
						continue;
					}
					String[] IkY4He2F = ROTUeQcg.split("=", 2);
					rRiLFm0R.put(IkY4He2F[0], IkY4He2F[1]);
					SbCemRDN.setPluginNames(rRiLFm0R);
				}
				sesxWAEo = true;
			} catch (Exception CMw95z7H) {
				if (gOkxBkDt >= 5)
					throw new PluginNotFoundException("Initialization error:" + exluTdxO, CMw95z7H);
				try {
					Thread.sleep(100);
				} catch (Exception Rryk3W9t) {
				}
			} finally {
				try {
					if (h0i1uXy1 != null)
						h0i1uXy1.close();
					if (PLXiiVdP != null)
						PLXiiVdP.close();
				} catch (IOException KYhH83XH) {
				}
			}
		}
		return SbCemRDN;
	}

}