class n20784778 {
	private boolean checkTypeChange(Class clazz, File wsdlFile) {
		if (!clazz.isPrimitive()) {
			ClassLoader cl = clazz.getClassLoader();
			if (cl instanceof AntClassLoader) {
				if (clazz.isArray())
					return checkTypeChange(getArrayType(clazz), wsdlFile);
				String path = clazz.getName().replace('.', File.separatorChar) + ".class";
				long lastMod = Long.MAX_VALUE;
				File file = new File(builddir, path);
				if (!file.exists()) {
					URL url = cl.getResource(path);
					if (url == null)
						throw new BuildException(
								"Can't get URL for webservice class '" + clazz.getName() + "' from jar file.");
					else {
						try {
							JarURLConnection con = (JarURLConnection) url.openConnection();
							lastMod = con.getJarEntry().getTime();
						} catch (IOException x) {
							throw new BuildException("Can't get modification time for webservice class '"
									+ clazz.getName() + "' from jar file.");
						}
					}
				} else {
					lastMod = file.lastModified();
				}
				if (wsdlFile.lastModified() < lastMod)
					return true;
				if (clazz.isInterface()) {
					Class[] itfs = clazz.getInterfaces();
					for (int i = 0; i < itfs.length; i++) {
						boolean changed = checkTypeChange(itfs[i], wsdlFile);
						if (changed)
							return true;
					}
				} else {
					Class sup = clazz.getSuperclass();
					boolean changed = checkTypeChange(sup, wsdlFile);
					if (changed)
						return true;
				}
			}
		}
		return false;
	}

}