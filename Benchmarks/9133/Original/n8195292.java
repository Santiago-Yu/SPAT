class n8195292{
    @Test
    public void testGetJarInformation() throws Exception {
        final URL url1 = getClass().getResource("/fakejars/something");
        final URL url2 = getClass().getResource("/fakejars/something-else");
        final URL url3 = getClass().getResource("/fakejars/another-thing");
        final Map<String, Date> paths = new HashMap<String, Date>();
        paths.put(SOMETHING_JAR, new Date(url1.openConnection().getLastModified()));
        paths.put(SOMETHING_ELSE_JAR, new Date(url2.openConnection().getLastModified()));
        paths.put(ANOTHER_THING_JAR, new Date(url3.openConnection().getLastModified()));
        paths.put(NOT_A_JAR, null);
        context.checking(new Expectations() {

            {
                one(servletContext).getResourcePaths(WEB_INF_LIB_PATH);
                will(returnValue(paths.keySet()));
                one(servletContext).getResource(SOMETHING_JAR);
                will(returnValue(url1));
                one(servletContext).getResource(SOMETHING_ELSE_JAR);
                will(returnValue(url2));
                one(servletContext).getResource(ANOTHER_THING_JAR);
                will(returnValue(url3));
            }
        });
        final Map<URL, Date> output = new ModulesImpl(servletContext, null, new LoggerProvider()).getJarInformation();
        assertThat(output.size(), is(3));
        for (final URL url : output.keySet()) {
            final String jarName = url.toString();
            final String key = WEB_INF_LIB_PATH + jarName.substring(jarName.lastIndexOf("/") + 1) + ".jar";
            assertThat(output.get(url), is(paths.get(key)));
        }
    }

}