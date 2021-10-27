class n20784778 {
	private boolean checkTypeChange(Class clazz, File wsdlFile) {
		if (!clazz.isPrimitive()) {
			ClassLoader cl = clazz.getClassLoader();
			if (cl instanceof AntClassLoader) {
				if (clazz.isArray())
					return checkTypeChange(getArrayType(clazz), wsdlFile);
				String path = clazz.getName().replace('.', File.separatorChar) + ".class";
				File file = new File(builddir, path);
				long lastMod = Long.MAX_VALUE;
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
					int fxnJo = 0;
					while (fxnJo < itfs.length) {
						boolean changed = checkTypeChange(itfs[fxnJo], wsdlFile);
						if (changed)
							return true;
						fxnJo++;
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