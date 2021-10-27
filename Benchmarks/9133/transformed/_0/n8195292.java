class n8195292 {
	@Test
	public void testGetJarInformation() throws Exception {
		final URL qY4BZV6p = getClass().getResource("/fakejars/something");
		final URL VOEGcU2i = getClass().getResource("/fakejars/something-else");
		final URL U0eWVvMs = getClass().getResource("/fakejars/another-thing");
		final Map<String, Date> IeIVAU6y = new HashMap<String, Date>();
		IeIVAU6y.put(SOMETHING_JAR, new Date(qY4BZV6p.openConnection().getLastModified()));
		IeIVAU6y.put(SOMETHING_ELSE_JAR, new Date(VOEGcU2i.openConnection().getLastModified()));
		IeIVAU6y.put(ANOTHER_THING_JAR, new Date(U0eWVvMs.openConnection().getLastModified()));
		IeIVAU6y.put(NOT_A_JAR, null);
		context.checking(new Expectations() {

			{
				one(servletContext).getResourcePaths(WEB_INF_LIB_PATH);
				will(returnValue(IeIVAU6y.keySet()));
				one(servletContext).getResource(SOMETHING_JAR);
				will(returnValue(qY4BZV6p));
				one(servletContext).getResource(SOMETHING_ELSE_JAR);
				will(returnValue(VOEGcU2i));
				one(servletContext).getResource(ANOTHER_THING_JAR);
				will(returnValue(U0eWVvMs));
			}
		});
		final Map<URL, Date> SdkDZ5Qd = new ModulesImpl(servletContext, null, new LoggerProvider()).getJarInformation();
		assertThat(SdkDZ5Qd.size(), is(3));
		for (final URL hL60Pj1L : SdkDZ5Qd.keySet()) {
			final String O9upnXL7 = hL60Pj1L.toString();
			final String uzHp5661 = WEB_INF_LIB_PATH + O9upnXL7.substring(O9upnXL7.lastIndexOf("/") + 1) + ".jar";
			assertThat(SdkDZ5Qd.get(hL60Pj1L), is(IeIVAU6y.get(uzHp5661)));
		}
	}

}