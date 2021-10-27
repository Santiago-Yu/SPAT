class n21723842{
    @Test
    public void lookingUpResources() throws IOException {
        StickyEmbedder b = new StickyEmbedder("--debug", "--trace") {

            @Override
            protected File deriveApplicationFile() {
                return new File("src/test/samples/sticky-deployer-sample-2jar-1.2-sample.jar");
            }
        };
        b.initialise();
        assertThat(b.getLibraries()).hasSize(2);
        assertThat(b.getLibraries().iterator().next().getClasses()).hasSize(1);
        assertThat(b.getLibraries().iterator().next().getResources()).hasSize(8);
        URL url = b.getClassLoader().findResource("net/stickycode/deploy/sample/babysteps/run.properties");
        assertThat(url).isNotNull();
        InputStream i = url.openStream();
        assertThat(i).isNotNull();
        assertThat(new BufferedReader(new InputStreamReader(i)).readLine()).isEqualTo("run=running is step 3");
        Enumeration<URL> e = b.getClassLoader().findResources("net/stickycode/deploy/sample/babysteps/run.properties");
        assertThat(e.hasMoreElements()).isTrue();
        assertThat(e.nextElement()).isNotNull();
        assertThat(e.hasMoreElements()).isFalse();
        Enumeration<URL> manifests = b.getClassLoader().findResources("net/stickycode/deploy/sample/duplicate.properties");
        assertThat(manifests.hasMoreElements()).isTrue();
        assertThat(manifests.nextElement()).isNotNull();
        assertThat(manifests.hasMoreElements()).isTrue();
        assertThat(manifests.nextElement()).isNotNull();
        assertThat(manifests.hasMoreElements()).isFalse();
    }

}