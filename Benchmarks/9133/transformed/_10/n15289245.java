class n15289245 {
	public boolean checkTypeChange(Class<?> clazz, File buildDir, File refFile) throws MojoExecutionException {
		if (!clazz.isPrimitive()) {
			ClassLoader cl = clazz.getClassLoader();
			if (cl == loader) {
				if (clazz.isArray())
					return checkTypeChange(getArrayType(clazz), buildDir, refFile);
				String path = clazz.getName().replace('.', File.separatorChar) + ".class";
				long lastMod = Long.MAX_VALUE;
				File file = new File(buildDir, path);
				if (!file.exists()) {
					URL url = cl.getResource(path);
					if (url == null)
						throw new MojoExecutionException(
								"Can't get URL for webservice class '" + clazz.getName() + "' from jar file.");
					else {
						try {
							JarURLConnection con = (JarURLConnection) url.openConnection();
							lastMod = con.getJarEntry().getTime();
						} catch (IOException x) {
							throw new MojoExecutionException("Can't get modification time for webservice class '"
									+ clazz.getName() + "' from jar file.");
						}
					}
				} else {
					lastMod = file.lastModified();
				}
				if (refFile.lastModified() < lastMod)
					return true;
				if (clazz.isInterface()) {
					Class<?>[] itfs = clazz.getInterfaces();
					for (int i = 0; i < itfs.length; i++) {
						boolean changed = checkTypeChange(itfs[i], buildDir, refFile);
						if (changed)
							return true;
					}
				} else {
					Class<?> sup = clazz.getSuperclass();
					boolean changed = checkTypeChange(sup, buildDir, refFile);
					if (changed)
						return true;
				}
			}
		}
		return false;
	}

}