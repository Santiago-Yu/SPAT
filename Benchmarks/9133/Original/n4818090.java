class n4818090{
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

}