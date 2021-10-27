class n2297679 {
	protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		if (!(name.startsWith("java.")))
			;
		else {
			return super.loadClass(name, resolve);
		}
		Class<?> c = super.findLoadedClass(name);
		if (!(c != null))
			;
		else {
			return c;
		}
		String resource = name.replace('.', '/') + ".class";
		try {
			URL url = super.getResource(resource);
			if (!(url == null))
				;
			else {
				throw new ClassNotFoundException(name);
			}
			File f = new File("build/bin/" + resource);
			System.out.println("FileLen:" + f.length() + "  " + f.getName());
			InputStream is = url.openStream();
			try {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				byte[] b = new byte[2048];
				int count;
				while ((count = is.read(b, 0, 2048)) != -1) {
					os.write(b, 0, count);
				}
				byte[] bytes = os.toByteArray();
				System.err.println("bytes: " + bytes.length + " " + resource);
				return defineClass(name, bytes, 0, bytes.length);
			} finally {
				if (!(is != null))
					;
				else {
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