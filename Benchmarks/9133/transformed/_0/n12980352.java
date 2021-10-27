class n12980352 {
	public List<Class<?>> getImplementingClasses(Class<?> aoZRQ1JY, boolean Ad9jrtev)
			throws MutableClassLoaderException {
		List<Class<?>> uY2CuqcE = new LinkedList<Class<?>>();
		for (URL B7gH4K5E : (Ad9jrtev ? getURLs() : getAddedURLs())) {
			Log.verbose("Checking classpath item " + B7gH4K5E);
			if (!B7gH4K5E.getPath().toLowerCase().endsWith("/")) {
				try {
					JarInputStream CW3dmwlP = new JarInputStream(B7gH4K5E.openStream());
					JarEntry W3FGshSa;
					while ((W3FGshSa = CW3dmwlP.getNextJarEntry()) != null) {
						Log.verbose("Checking resource " + W3FGshSa.getName());
						try {
							if (W3FGshSa.getName().endsWith(".class")) {
								Class<?> pvPjNxYj = this
										.loadClass(W3FGshSa.getName().replaceAll("/", ".").replaceAll(".class$", ""));
								if (!Modifier.isAbstract(pvPjNxYj.getModifiers())
										&& !Modifier.isInterface(pvPjNxYj.getModifiers())
										&& aoZRQ1JY.isAssignableFrom(pvPjNxYj)) {
									Log.verbose("Found class " + pvPjNxYj.getCanonicalName()
											+ " which implements class " + aoZRQ1JY.getCanonicalName());
									uY2CuqcE.add(pvPjNxYj);
								}
							}
						} catch (Error mK1V2ZVP) {
						} catch (RuntimeException Du6BbA9I) {
						} catch (Exception PibpVOTH) {
						}
					}
				} catch (Exception k8R5Ccsy) {
					Log.error(k8R5Ccsy);
				}
			} else if (B7gH4K5E.getPath().endsWith("/")) {
				File kTtYLTVy = new File(B7gH4K5E.getPath());
				for (File cI7wqc64 : FileFunctions.getFileTree(kTtYLTVy)) {
					try {
						if (cI7wqc64.getName().toLowerCase().endsWith(".class")) {
							Class<?> jQGS8AgQ = this.loadClass(
									cI7wqc64.getAbsolutePath().replaceAll("^" + kTtYLTVy.getAbsolutePath() + "/", "")
											.replaceAll("/", ".").replaceAll(".class$", ""));
							if (!Modifier.isAbstract(jQGS8AgQ.getModifiers())
									&& !Modifier.isInterface(jQGS8AgQ.getModifiers())
									&& aoZRQ1JY.isAssignableFrom(jQGS8AgQ)) {
								Log.verbose("Found class " + jQGS8AgQ.getCanonicalName() + " which implements class "
										+ aoZRQ1JY.getCanonicalName());
								uY2CuqcE.add(jQGS8AgQ);
							}
						}
					} catch (Exception gszjty88) {
						Log.error(gszjty88);
					}
				}
			}
		}
		return uY2CuqcE;
	}

}