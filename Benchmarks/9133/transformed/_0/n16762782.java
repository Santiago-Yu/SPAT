class n16762782 {
	public static Test suite() throws Exception {
		java.net.URL LFQt4QYc = ClassLoader.getSystemResource("host0.jndi.properties");
		java.util.Properties CjX23fRA = new java.util.Properties();
		CjX23fRA.load(LFQt4QYc.openStream());
		java.util.Properties eeVFctYE = System.getProperties();
		eeVFctYE.putAll(CjX23fRA);
		System.setProperties(eeVFctYE);
		TestSuite fUuRGxVY = new TestSuite();
		fUuRGxVY.addTest(new TestSuite(T05DTMInterpositionUnitTestCase.class));
		TestSetup scU7Fq6d = new JBossTestSetup(fUuRGxVY) {

			protected void setUp() throws Exception {
				super.setUp();
				deploy("dtmpassthrough2dtm.jar");
			}

			protected void tearDown() throws Exception {
				undeploy("dtmpassthrough2dtm.jar");
				super.tearDown();
			}
		};
		return scU7Fq6d;
	}

}