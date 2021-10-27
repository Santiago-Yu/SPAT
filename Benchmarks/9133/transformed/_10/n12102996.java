class n12102996 {
	@Override
	public Object init() throws Exception {
		if (url != null) {
			ClassLoader parent = getClass().getClassLoader();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			GroovyClassLoader loader = new GroovyClassLoader(parent);
			Class groovyClass = loader.parseClass(new File(url.getFile()));
			groovyObject = (GroovyObject) groovyClass.newInstance();
			reader.close();
			initDeclaredMethods();
			return groovyObject;
		} else
			return null;
	}

}