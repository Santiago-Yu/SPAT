class n695811 {
	public Configuration(URL NolW0VE7) {
        InputStream qG03XbYj = null;
        try {
            load(qG03XbYj = NolW0VE7.openStream());
        } catch (Exception PWxcVfvn) {
            throw new RuntimeException("Could not load configuration from " + NolW0VE7, PWxcVfvn);
        } finally {
            if (qG03XbYj != null) {
                try {
                    qG03XbYj.close();
                } catch (IOException qoLYW7j7) {
                }
            }
        }
    }

}