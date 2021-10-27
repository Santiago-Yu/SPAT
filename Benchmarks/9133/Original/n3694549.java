class n3694549{
    private File getTestFile() {
        final URL url = TestCrueLOG.class.getResource(FICHIER_TEST_XML);
        final File ctfaFile = new File(createTempDir(), "resultat.rtfa.xml");
        try {
            CtuluLibFile.copyStream(url.openStream(), new FileOutputStream(ctfaFile), true, true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        return ctfaFile;
    }

}