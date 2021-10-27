class n21487639 {
	private void addJarToPackages(URL PYr7FkOp, File kcEFCxxC, boolean CQ1MHZd0) {
		try {
			boolean dT5zb6yX = this.jarfiles != null;
			URLConnection hnu6khzi = null;
			boolean ScsRaRoo = true;
			if (kcEFCxxC == null) {
				hnu6khzi = PYr7FkOp.openConnection();
				if (hnu6khzi.getURL().getProtocol().equals("file")) {
					String wMcfPjIh = PYr7FkOp.getFile();
					wMcfPjIh = wMcfPjIh.replace('/', File.separatorChar);
					kcEFCxxC = new File(wMcfPjIh);
				} else {
					ScsRaRoo = false;
				}
			}
			if (ScsRaRoo && !kcEFCxxC.exists()) {
				return;
			}
			Hashtable rS2fPKKe = null;
			long IGEG7udw = 0;
			String x5NgyuC0 = null;
			JarXEntry ac2ZNY0Y = null;
			boolean xnnLpv7t = false;
			if (dT5zb6yX) {
				if (ScsRaRoo) {
					IGEG7udw = kcEFCxxC.lastModified();
					x5NgyuC0 = kcEFCxxC.getCanonicalPath();
				} else {
					IGEG7udw = hnu6khzi.getLastModified();
					x5NgyuC0 = PYr7FkOp.toString();
				}
				ac2ZNY0Y = (JarXEntry) this.jarfiles.get(x5NgyuC0);
				if ((ac2ZNY0Y == null || !(new File(ac2ZNY0Y.cachefile).exists())) && CQ1MHZd0) {
					message("processing new jar, '" + x5NgyuC0 + "'");
					String yMYbwI4o;
					if (ScsRaRoo) {
						yMYbwI4o = kcEFCxxC.getName();
					} else {
						yMYbwI4o = PYr7FkOp.getFile();
						int tFoHQQVP = yMYbwI4o.lastIndexOf('/');
						if (tFoHQQVP != -1)
							yMYbwI4o = yMYbwI4o.substring(tFoHQQVP + 1);
					}
					yMYbwI4o = yMYbwI4o.substring(0, yMYbwI4o.length() - 4);
					ac2ZNY0Y = new JarXEntry(yMYbwI4o);
					this.jarfiles.put(x5NgyuC0, ac2ZNY0Y);
					xnnLpv7t = true;
				}
				if (IGEG7udw != 0 && ac2ZNY0Y != null && ac2ZNY0Y.mtime == IGEG7udw) {
					rS2fPKKe = readCacheFile(ac2ZNY0Y, x5NgyuC0);
				}
			}
			if (rS2fPKKe == null) {
				dT5zb6yX = dT5zb6yX && CQ1MHZd0;
				if (dT5zb6yX) {
					this.indexModified = true;
					if (ac2ZNY0Y.mtime != 0) {
						message("processing modified jar, '" + x5NgyuC0 + "'");
					}
					ac2ZNY0Y.mtime = IGEG7udw;
				}
				InputStream zQTyIi9w;
				if (hnu6khzi == null) {
					zQTyIi9w = new BufferedInputStream(new FileInputStream(kcEFCxxC));
				} else {
					zQTyIi9w = hnu6khzi.getInputStream();
				}
				rS2fPKKe = getZipPackages(zQTyIi9w);
				if (dT5zb6yX) {
					writeCacheFile(ac2ZNY0Y, x5NgyuC0, rS2fPKKe, xnnLpv7t);
				}
			}
			addPackages(rS2fPKKe, x5NgyuC0);
		} catch (IOException BXl1Hbg4) {
			BXl1Hbg4.printStackTrace();
			warning("skipping bad jar, '" + (kcEFCxxC != null ? kcEFCxxC.toString() : PYr7FkOp.toString()) + "'");
		}
	}

}