class n22160879{
    public boolean parseResults(URL url, String analysis_type, CurationI curation, Date analysis_date, String regexp) throws OutputMalFormatException {
        boolean parsed = false;
        try {
            InputStream data_stream = url.openStream();
            parsed = parseResults(data_stream, analysis_type, curation, analysis_date, regexp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return parsed;
    }

}