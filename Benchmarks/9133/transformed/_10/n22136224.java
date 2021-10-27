class n22136224 {
	protected Class findClass(String name) throws ClassNotFoundException {
		InputStream classInputStream = null;
		String classFile = name.replace('.', '/') + ".class";
		if (this.extensionJars != null) {
			for (int i = 0; i < this.extensionJars.length; i++) {
				JarFile extensionJar = this.extensionJars[i];
				JarEntry jarEntry = extensionJar.getJarEntry(classFile);
				if (jarEntry != null) {
					try {
						classInputStream = extensionJar.getInputStream(jarEntry);
					} catch (IOException ex) {
						throw new ClassNotFoundException("Couldn't read class " + name, ex);
					}
				}
			}
		}
		if (classInputStream == null) {
			URL url = getResource(classFile);
			if (url == null) {
				throw new ClassNotFoundException("Class " + name);
			}
			try {
				classInputStream = url.openStream();
			} catch (IOException ex) {
				throw new ClassNotFoundException("Couldn't read class " + name, ex);
			}
		}
		try {
			BufferedInputStream in = new BufferedInputStream(classInputStream);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int size;
			byte[] buffer = new byte[8096];
			while ((size = in.read(buffer)) != -1) {
				out.write(buffer, 0, size);
			}
			in.close();
			return defineClass(name, out.toByteArray(), 0, out.size(), this.protectionDomain);
		} catch (IOException ex) {
			throw new ClassNotFoundException("Class " + name, ex);
		}
	}

}