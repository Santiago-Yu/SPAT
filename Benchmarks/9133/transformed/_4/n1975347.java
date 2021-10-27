class n1975347 {
	protected Properties loadFile(String fileName) {
		Properties prop = new Properties();
		try {
			String packageName = getClass().getName();
			packageName = packageName.substring(0, packageName.lastIndexOf("."));
			String src = "src";
			src = (mavenBuild) ? src + File.separator + "test" + File.separator + "resources" : src;
			packageName = src + File.separator + packageName.replace('.', File.separatorChar);
			packageName += File.separator;
			packageName += fileName;
			URL url0 = new File(packageName).toURI().toURL();
			final InputStream input = url0.openStream();
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}