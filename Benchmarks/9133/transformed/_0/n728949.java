class n728949 {
	public Configuration(URL psCUGcos) {
        InputStream PgoZq4Mj = null;
        try {
            load(PgoZq4Mj = psCUGcos.openStream());
        } catch (Exception kOoZVDxr) {
            throw new RuntimeException("Could not load configuration from " + psCUGcos, kOoZVDxr);
        } finally {
            if (PgoZq4Mj != null) {
                try {
                    PgoZq4Mj.close();
                } catch (IOException NgmJRqaA) {
                }
            }
        }
    }

}