class n21723842 {
	@Test
	public void lookingUpResources() throws IOException {
		StickyEmbedder zfWQl0IA = new StickyEmbedder("--debug", "--trace") {

			@Override
			protected File deriveApplicationFile() {
				return new File("src/test/samples/sticky-deployer-sample-2jar-1.2-sample.jar");
			}
		};
		zfWQl0IA.initialise();
		assertThat(zfWQl0IA.getLibraries()).hasSize(2);
		assertThat(zfWQl0IA.getLibraries().iterator().next().getClasses()).hasSize(1);
		assertThat(zfWQl0IA.getLibraries().iterator().next().getResources()).hasSize(8);
		URL IfzUtqSA = zfWQl0IA.getClassLoader().findResource("net/stickycode/deploy/sample/babysteps/run.properties");
		assertThat(IfzUtqSA).isNotNull();
		InputStream IznzRe6Q = IfzUtqSA.openStream();
		assertThat(IznzRe6Q).isNotNull();
		assertThat(new BufferedReader(new InputStreamReader(IznzRe6Q)).readLine()).isEqualTo("run=running is step 3");
		Enumeration<URL> WYtbyPh9 = zfWQl0IA.getClassLoader()
				.findResources("net/stickycode/deploy/sample/babysteps/run.properties");
		assertThat(WYtbyPh9.hasMoreElements()).isTrue();
		assertThat(WYtbyPh9.nextElement()).isNotNull();
		assertThat(WYtbyPh9.hasMoreElements()).isFalse();
		Enumeration<URL> XCqS50xj = zfWQl0IA.getClassLoader()
				.findResources("net/stickycode/deploy/sample/duplicate.properties");
		assertThat(XCqS50xj.hasMoreElements()).isTrue();
		assertThat(XCqS50xj.nextElement()).isNotNull();
		assertThat(XCqS50xj.hasMoreElements()).isTrue();
		assertThat(XCqS50xj.nextElement()).isNotNull();
		assertThat(XCqS50xj.hasMoreElements()).isFalse();
	}

}