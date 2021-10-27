class n914073 {
	public Configuration(URL HuxLhEmL) {
        InputStream hrgDHpLl = null;
        try {
            load(hrgDHpLl = HuxLhEmL.openStream());
        } catch (Exception EjfnWLWd) {
            throw new RuntimeException("Could not load configuration from " + HuxLhEmL, EjfnWLWd);
        } finally {
            if (hrgDHpLl != null) {
                try {
                    hrgDHpLl.close();
                } catch (IOException AOQ6roZD) {
                }
            }
        }
    }

}