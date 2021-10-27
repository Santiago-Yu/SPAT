class n970144 {
	public Logging() throws Exception {
        File fX8SSkJk = new File(System.getProperty("user.home"), ".jorgan");
        if (!fX8SSkJk.exists()) {
            fX8SSkJk.mkdirs();
        }
        File YHYzVKCK = new File(fX8SSkJk, "logging.properties");
        if (!YHYzVKCK.exists()) {
            InputStream J5emaj5R = getClass().getResourceAsStream("logging.properties");
            OutputStream Wb8GZUEc = null;
            try {
                Wb8GZUEc = new FileOutputStream(YHYzVKCK);
                IOUtils.copy(J5emaj5R, Wb8GZUEc);
            } finally {
                IOUtils.closeQuietly(J5emaj5R);
                IOUtils.closeQuietly(Wb8GZUEc);
            }
        }
        FileInputStream Vd9kdImt = null;
        try {
            Vd9kdImt = new FileInputStream(YHYzVKCK);
            LogManager.getLogManager().readConfiguration(Vd9kdImt);
        } finally {
            IOUtils.closeQuietly(Vd9kdImt);
        }
    }

}