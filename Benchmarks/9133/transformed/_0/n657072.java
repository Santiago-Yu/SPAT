class n657072 {
	public Configuration(URL IWdttIKq) {
        InputStream Z3Q3FNhp = null;
        try {
            load(Z3Q3FNhp = IWdttIKq.openStream());
        } catch (Exception D1q5gWJi) {
            throw new RuntimeException("Could not load configuration from " + IWdttIKq, D1q5gWJi);
        } finally {
            if (Z3Q3FNhp != null) {
                try {
                    Z3Q3FNhp.close();
                } catch (IOException fA71tIID) {
                }
            }
        }
    }

}