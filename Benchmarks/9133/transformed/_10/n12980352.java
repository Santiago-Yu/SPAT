class n12980352 {
	public List<Class<?>> getImplementingClasses(Class<?> ancestor, boolean searchAllClasspath)
			throws MutableClassLoaderException {
		List<Class<?>> classes = new LinkedList<Class<?>>();
		for (URL url : (searchAllClasspath ? getURLs() : getAddedURLs())) {
			Log.verbose("Checking classpath item " + url);
			if (!url.getPath().toLowerCase().endsWith("/")) {
				try {
					JarEntry je;
					JarInputStream jis = new JarInputStream(url.openStream());
					while ((je = jis.getNextJarEntry()) != null) {
						Log.verbose("Checking resource " + je.getName());
						try {
							if (je.getName().endsWith(".class")) {
								Class<?> c = this
										.loadClass(je.getName().replaceAll("/", ".").replaceAll(".class$", ""));
								if (!Modifier.isAbstract(c.getModifiers()) && !Modifier.isInterface(c.getModifiers())
										&& ancestor.isAssignableFrom(c)) {
									Log.verbose("Found class " + c.getCanonicalName() + " which implements class "
											+ ancestor.getCanonicalName());
									classes.add(c);
								}
							}
						} catch (Error e) {
						} catch (RuntimeException re) {
						} catch (Exception e) {
						}
					}
				} catch (Exception e) {
					Log.error(e);
				}
			} else if (url.getPath().endsWith("/")) {
				File root = new File(url.getPath());
				for (File file : FileFunctions.getFileTree(root)) {
					try {
						if (file.getName().toLowerCase().endsWith(".class")) {
							Class<?> c = this
									.loadClass(file.getAbsolutePath().replaceAll("^" + root.getAbsolutePath() + "/", "")
											.replaceAll("/", ".").replaceAll(".class$", ""));
							if (!Modifier.isAbstract(c.getModifiers()) && !Modifier.isInterface(c.getModifiers())
									&& ancestor.isAssignableFrom(c)) {
								Log.verbose("Found class " + c.getCanonicalName() + " which implements class "
										+ ancestor.getCanonicalName());
								classes.add(c);
							}
						}
					} catch (Exception e) {
						Log.error(e);
					}
				}
			}
		}
		return classes;
	}

}