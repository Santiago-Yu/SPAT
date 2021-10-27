class n4818089{
    public List<String[]> getCSV(String name) {
        return new ResourceLoader<List<String[]>>(name) {

            @Override
            protected List<String[]> get(URL url) throws Exception {
                CSVReader reader = null;
                try {
                    reader = new CSVReader(new InputStreamReader(url.openStream()));
                    return reader.readAll();
                } finally {
                    IOUtils.closeQuietly(reader);
                }
            }
        }.get();
    }

}