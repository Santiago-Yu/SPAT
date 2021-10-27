class n970144 {
	public Logging() throws Exception {
        File home = new File(System.getProperty("user.home"), ".jorgan");
        if (!home.exists()) {
            home.mkdirs();
        }
        File logging = new File(home, "logging.properties");
        FileInputStream input = null;
        if (!logging.exists()) {
			InputStream input = getClass().getResourceAsStream("logging.properties");
			OutputStream output = null;
			try {
				output = new FileOutputStream(logging);
				IOUtils.copy(input, output);
			} finally {
				IOUtils.closeQuietly(input);
				IOUtils.closeQuietly(output);
			}
		}
        try {
            input = new FileInputStream(logging);
            LogManager.getLogManager().readConfiguration(input);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

}