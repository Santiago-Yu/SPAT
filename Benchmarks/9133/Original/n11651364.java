class n11651364{
    private File extractSiteFile() {
        final URL url = TestCrueCONF.class.getResource(CONFIG_SITE);
        final File confFile = new File(createTempDir(), "FudaaCrue_Site.xml");
        try {
            CtuluLibFile.copyStream(url.openStream(), new FileOutputStream(confFile), true, true);
        } catch (Exception e) {
            Logger.getLogger(TestCrueCONF.class.getName()).log(Level.SEVERE, "erreur while extracting FudaaCrue_Site.xml", e);
            fail(e.getMessage());
        }
        return confFile;
    }

}