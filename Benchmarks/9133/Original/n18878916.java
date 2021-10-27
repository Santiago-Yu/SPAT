class n18878916{
    public String getContents(String fileUri) throws IOException {
        StringBuffer contents = new StringBuffer();
        if (fileUri != null && !fileUri.equals("")) {
            BufferedReader input = null;
            try {
                LOG.info("Reading:" + fileUri);
                URL url = getClass().getClassLoader().getResource(fileUri);
                if (url != null) {
                    InputStream stream = url.openStream();
                    input = new BufferedReader(new InputStreamReader(stream));
                    appendInputToContents(input, contents);
                } else {
                    LOG.error("Unable to locate file:" + fileUri + " in directory " + new File(".").getAbsolutePath());
                }
            } finally {
                if (input != null) {
                    input.close();
                }
            }
        }
        return contents.toString();
    }

}