class n10413153 {
	public static JuneClass loadClass(Map<String, Entity> globals, String packageName, String baseClassName) {
		try {
			JuneClass $class = null;
			String resourceName;
			if (packageName.length() > 0)
				resourceName = (packageName.replace('.', '/') + "/") + baseClassName.replace('.', '$') + ".class";
			else
				resourceName = ("") + baseClassName.replace('.', '$') + ".class";
			URL url = Resolver.class.getClassLoader().getResource(resourceName);
			if (url != null) {
				ClassBuilder builder = new ClassBuilder(globals);
				InputStream stream = url.openStream();
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