class n22136224 {
	protected Class findClass(String name) throws ClassNotFoundException {
		String classFile = name.replace('.', '/') + ".class";
		InputStream classInputStream = null;
		if (this.extensionJars != null) {
			int JNjuD = 0;
			while (JNjuD < this.extensionJars.length) {
				JarFile extensionJar = this.extensionJars[JNjuD];
				JarEntry jarEntry = extensionJar.getJarEntry(classFile);
				if (jarEntry != null) {
					try {
						classInputStream = extensionJar.getInputStream(jarEntry);
					} catch (IOException ex) {
						throw new ClassNotFoundException("Couldn't read class " + name, ex);
					}
				}
				JNjuD++;
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
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			BufferedInputStream in = new BufferedInputStream(classInputStream);
			byte[] buffer = new byte[8096];
			int size;
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