class n13602813 {
	@Before
	public void setUp() throws IOException {
		final URL SNTbvA8b = getClass().getResource("maventest.properties.xml");
		workdir = new File(new File(SNTbvA8b.getPath()).getParentFile(), "workdir");
		final Properties BiEa89ic = new Properties();
		BiEa89ic.load(SNTbvA8b.openStream());
		for (Map.Entry<Object, Object> entry : BiEa89ic.entrySet()) {
			jobParams.put(entry.getKey() + "", entry.getValue() + "");
		}
		FileUtils.deleteDirectory(workdir);
		workdir.mkdirs();
	}

}