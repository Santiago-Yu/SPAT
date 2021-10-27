class n20314725 {
	@SuppressWarnings("unchecked")
	private void loadPlugins(File[] jars, File[] libraries) {
		ArrayList<URL> libraryUrls = new ArrayList<URL>();
		for (File library : libraries) {
			try {
				libraryUrls.add(library.toURI().toURL());
			} catch (MalformedURLException e) {
				logger.error("Unable to load plugin library " + library, e);
			}
		}
		URLClassLoader libraryClassLoader = new URLClassLoader(libraryUrls.toArray(new URL[] {}));
		final Splash splash = new Splash(Display.getDefault(), jars.length);
		for (int i = 0; i < jars.length; i++) {
			splash.setProgress(i);
			logger.info("Loading library " + jars[i].getAbsolutePath());
			try {
				URL url = jars[i].toURI().toURL();
				try {
					JarInputStream in = new JarInputStream(url.openStream());
					JarEntry entry = null;
					while ((entry = in.getNextJarEntry()) != null) {
						if (!entry.getName().matches(".*class$")) {
						} else {
							String className = entry.getName();
							className = className.substring(0, className.lastIndexOf("."));
							className = className.replace("/", ".");
							try {
								URLClassLoader classLoader = new URLClassLoader(new URL[] { url }, libraryClassLoader);
								Class instance = Class.forName(className, true, classLoader);
								if (Iniglet.class.isAssignableFrom(instance)
										&& !Modifier.isAbstract(instance.getModifiers())) {
									logger.info("Iniglet: " + className);
									Iniglet iniglet = null;
									try {
										iniglet = (Iniglet) instance.newInstance();
										inigletList.add(iniglet);
										splash.setProgress(i + 1);
									} catch (IllegalArgumentException e) {
										logger.warn("Illegal constructor for " + instance.getCanonicalName(), e);
									} catch (InstantiationException e) {
										logger.warn("Unable to instantiate " + instance.getCanonicalName(), e);
									} catch (IllegalAccessException e) {
										logger.warn("Illegal constructor access to " + instance.getCanonicalName(), e);
									} catch (Throwable t) {
										logger.warn("Iniglet Failure " + instance.getCanonicalName(), t);
										t.printStackTrace();
									}
								}
							} catch (ClassNotFoundException e) {
								logger.warn("Unable to load expected plugin " + className, e);
							} catch (IllegalArgumentException e) {
								logger.warn("Illegal constructor argument to " + className, e);
							}
						}
					}
				} catch (IOException e) {
					logger.warn("Failed to scan " + url.getFile(), e);
				}
			} catch (MalformedURLException e) {
				logger.warn("Unable to load " + jars[i].getAbsolutePath(), e);
			}
		}
		for (Iniglet iniglet : inigletList) {
			addMenuEntry(iniglet);
		}
		display.asyncExec(new Runnable() {

			public void run() {
				try {
					Thread.sleep(getSplashDelay());
				} catch (InterruptedException e) {
					logger.error("TODO Describe Error", e);
				} finally {
					splash.close();
				}
			}
		});
	}

}