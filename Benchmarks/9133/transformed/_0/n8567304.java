class n8567304 {
	public TapdocContextImpl(Registry DmT8oa37, FileObject nkLcqJ4W, List<String> sz8cp07i, List<String> wLFUADRQ, FileObject Z65bliod, List<String> uNw2hp81, DocumentGenerator mQXSMDsl) {
        this.registry = DmT8oa37;
        this.documentGenerator = mQXSMDsl;
        try {
            if (nkLcqJ4W == null) {
                nkLcqJ4W = Z65bliod.resolveFile("tapdoc-javadom.xml");
            }
            if (!nkLcqJ4W.exists()) {
                nkLcqJ4W.createFile();
                nkLcqJ4W.close();
                IOUtils.copy(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\"?><tapdoc-javadom></tapdoc-javadom>"), nkLcqJ4W.getContent().getOutputStream());
            }
            this.javaDom = nkLcqJ4W;
            this.javadocLinks = sz8cp07i;
            this.tapdocLinks = uNw2hp81;
            this.libraryLocations = wLFUADRQ;
            this.outputDirectory = Z65bliod;
        } catch (Exception VNdAiN20) {
            throw new RuntimeException(VNdAiN20);
        }
    }

}