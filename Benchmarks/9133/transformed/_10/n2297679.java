class n2297679 {
	protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		if (name.startsWith("java.")) {
			return super.loadClass(name, resolve);
		}
		Class<?> c = super.findLoadedClass(name);
		String resource = name.replace('.', '/') + ".class";
		if (c != null) {
			return c;
		}
		try {
			URL url = super.getResource(resource);
			File f = new File("build/bin/" + resource);
			if (url == null) {
				throw new ClassNotFoundException(name);
			}
			System.out.println("FileLen:" + f.length() + "  " + f.getName());
			InputStream is = url.openStream();
			try {
				byte[] b = new byte[2048];
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				int count;
				while ((count = is.read(b, 0, 2048)) != -1) {
					os.write(b, 0, count);
				}
				byte[] bytes = os.toByteArray();
				System.err.println("bytes: " + bytes.length + " " + resource);
				return defineClass(name, bytes, 0, bytes.length);
			} finally {
				if (is != null) {
					is.close();
				}
			}
		} catch (SecurityException e) {
			return super.loadClass(name, resolve);
		} catch (IOException e) {
			throw new ClassNotFoundException(name, e);
		}
	}

}