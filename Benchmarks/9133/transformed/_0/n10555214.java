class n10555214 {
	public static Test suite() throws Exception {
		java.net.URL IaJA4Uaj = ClassLoader.getSystemResource("host0.jndi.properties");
		java.util.Properties hPbEWtNO = new java.util.Properties();
		hPbEWtNO.load(IaJA4Uaj.openStream());
		java.util.Properties fFK5SoJT = System.getProperties();
		fFK5SoJT.putAll(hPbEWtNO);
		System.setProperties(fFK5SoJT);
		TestSuite uhFqz8kt = new TestSuite();
		uhFqz8kt.addTest(new TestSuite(T06OTSInterpositionUnitTestCase.class));
		TestSetup mAGw1IDg = new JBossTestSetup(uhFqz8kt) {

			protected void setUp() throws Exception {
				super.setUp();
				deploy("dtmpassthrough2ots.jar");
			}

			protected void tearDown() throws Exception {
				undeploy("dtmpassthrough2ots.jar");
				super.tearDown();
			}
		};
		return mAGw1IDg;
	}

}