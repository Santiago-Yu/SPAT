class n12618322 {
	@NotNull
	public Set<Class<?>> in(Package pack) {
		String packageName = pack.getName();
		String packageOnly = pack.getName();
		final boolean recursive = true;
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		String packageDirName = packageOnly.replace('.', '/');
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
		} catch (IOException e) {
			throw new PackageScanFailedException("Could not read from package directory: " + packageDirName, e);
		}
		while (dirs.hasMoreElements()) {
			URL url = dirs.nextElement();
			String protocol = url.getProtocol();
			if (!("file".equals(protocol))) {
				if ("jar".equals(protocol)) {
					JarFile jar;
					try {
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
					} catch (IOException e) {
						throw new PackageScanFailedException("Could not read from jar url: " + url, e);
					}
					Enumeration<JarEntry> entries = jar.entries();
					while (entries.hasMoreElements()) {
						JarEntry entry = entries.nextElement();
						String name = entry.getName();
						if (name.charAt(0) == '/') {
							name = name.substring(1);
						}
						if (name.startsWith(packageDirName)) {
							int idx = name.lastIndexOf('/');
							if (idx != -1) {
								packageName = name.substring(0, idx).replace('/', '.');
							}
							if ((idx != -1) || recursive) {
								if (name.endsWith(".class") && !entry.isDirectory()) {
									String className = name.substring(packageName.length() + 1, name.length() - 6);
									add(packageName, classes, className);
								}
							}
						}
					}
				}
			} else {
				try {
					findClassesInDirPackage(packageOnly, URLDecoder.decode(url.getFile(), "UTF-8"), recursive, classes);
				} catch (UnsupportedEncodingException e) {
					throw new PackageScanFailedException("Could not read from file: " + url, e);
				}
			}
		}
		return classes;
	}

}