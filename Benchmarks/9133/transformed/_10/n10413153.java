class n10413153 {
	public static JuneClass loadClass(Map<String, Entity> globals, String packageName, String baseClassName) {
		try {
			String resourceName = (packageName.length() > 0 ? packageName.replace('.', '/') + "/" : "")
					+ baseClassName.replace('.', '$') + ".class";
			JuneClass $class = null;
			URL url = Resolver.class.getClassLoader().getResource(resourceName);
			if (url != null) {
				InputStream stream = url.openStream();
				ClassBuilder builder = new ClassBuilder(globals);
				try {
					new ClassReader(new BufferedInputStream(stream)).accept(builder, ClassReader.SKIP_CODE);
				} finally {
					stream.close();
				}
				$class = builder.$class;
				$class.loaded = true;
			}
			return $class;
		} catch (Exception e) {
			throw Helper.throwAny(e);
		}
	}

}