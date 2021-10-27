class n12102996 {
	@Override
	public Object init() throws Exception {
		if (url != null) {
			BufferedReader SVEaITex = new BufferedReader(new InputStreamReader(url.openStream()));
			ClassLoader BbFxCpUt = getClass().getClassLoader();
			GroovyClassLoader YhMYFWu0 = new GroovyClassLoader(BbFxCpUt);
			Class v3TJUlvj = YhMYFWu0.parseClass(new File(url.getFile()));
			groovyObject = (GroovyObject) v3TJUlvj.newInstance();
			SVEaITex.close();
			initDeclaredMethods();
			return groovyObject;
		} else
			return null;
	}

}