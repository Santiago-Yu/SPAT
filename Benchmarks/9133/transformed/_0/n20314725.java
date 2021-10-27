class n20314725 {
	@SuppressWarnings("unchecked")
	private void loadPlugins(File[] cCS5EbtU, File[] kj3B80C8) {
		ArrayList<URL> ARyFBCPD = new ArrayList<URL>();
		for (File Fwn7ArIi : kj3B80C8) {
			try {
				ARyFBCPD.add(Fwn7ArIi.toURI().toURL());
			} catch (MalformedURLException R1vUc0h5) {
				logger.error("Unable to load plugin library " + Fwn7ArIi, R1vUc0h5);
			}
		}
		URLClassLoader bZU3W7iK = new URLClassLoader(ARyFBCPD.toArray(new URL[] {}));
		final Splash sngj562Y = new Splash(Display.getDefault(), cCS5EbtU.length);
		for (int hILFK6L3 = 0; hILFK6L3 < cCS5EbtU.length; hILFK6L3++) {
			sngj562Y.setProgress(hILFK6L3);
			logger.info("Loading library " + cCS5EbtU[hILFK6L3].getAbsolutePath());
			try {
				URL OfHxBtoG = cCS5EbtU[hILFK6L3].toURI().toURL();
				try {
					JarInputStream IB7Qjyln = new JarInputStream(OfHxBtoG.openStream());
					JarEntry BppGg22g = null;
					while ((BppGg22g = IB7Qjyln.getNextJarEntry()) != null) {
						if (!BppGg22g.getName().matches(".*class$")) {
							continue;
						}
						String kRqnzqo1 = BppGg22g.getName();
						kRqnzqo1 = kRqnzqo1.substring(0, kRqnzqo1.lastIndexOf("."));
						kRqnzqo1 = kRqnzqo1.replace("/", ".");
						try {
							URLClassLoader F2Y0dX5o = new URLClassLoader(new URL[] { OfHxBtoG }, bZU3W7iK);
							Class VMGLU6Wc = Class.forName(kRqnzqo1, true, F2Y0dX5o);
							if (Iniglet.class.isAssignableFrom(VMGLU6Wc)
									&& !Modifier.isAbstract(VMGLU6Wc.getModifiers())) {
								logger.info("Iniglet: " + kRqnzqo1);
								Iniglet QK2xrTnp = null;
								try {
									QK2xrTnp = (Iniglet) VMGLU6Wc.newInstance();
									inigletList.add(QK2xrTnp);
									sngj562Y.setProgress(hILFK6L3 + 1);
								} catch (IllegalArgumentException icIZduzh) {
									logger.warn("Illegal constructor for " + VMGLU6Wc.getCanonicalName(), icIZduzh);
								} catch (InstantiationException u0vmhEwV) {
									logger.warn("Unable to instantiate " + VMGLU6Wc.getCanonicalName(), u0vmhEwV);
								} catch (IllegalAccessException a8T8ggaz) {
									logger.warn("Illegal constructor access to " + VMGLU6Wc.getCanonicalName(),
											a8T8ggaz);
								} catch (Throwable hryfQySD) {
									logger.warn("Iniglet Failure " + VMGLU6Wc.getCanonicalName(), hryfQySD);
									hryfQySD.printStackTrace();
								}
							}
						} catch (ClassNotFoundException t9fNqE11) {
							logger.warn("Unable to load expected plugin " + kRqnzqo1, t9fNqE11);
						} catch (IllegalArgumentException NuCDdzag) {
							logger.warn("Illegal constructor argument to " + kRqnzqo1, NuCDdzag);
						}
					}
				} catch (IOException wzEaKxZ2) {
					logger.warn("Failed to scan " + OfHxBtoG.getFile(), wzEaKxZ2);
				}
			} catch (MalformedURLException vFKrO6bS) {
				logger.warn("Unable to load " + cCS5EbtU[hILFK6L3].getAbsolutePath(), vFKrO6bS);
			}
		}
		for (Iniglet CDSTa4ym : inigletList) {
			addMenuEntry(CDSTa4ym);
		}
		display.asyncExec(new Runnable() {

			public void run() {
				try {
					Thread.sleep(getSplashDelay());
				} catch (InterruptedException ewuXHlGz) {
					logger.error("TODO Describe Error", ewuXHlGz);
				} finally {
					sngj562Y.close();
				}
			}
		});
	}

}