class n12579{
    @Override
    public DataTable generateDataTable(Query query, HttpServletRequest request) throws DataSourceException {
        String url = request.getParameter(URL_PARAM_NAME);
        if (StringUtils.isEmpty(url)) {
            log.error("url parameter not provided.");
            throw new DataSourceException(ReasonType.INVALID_REQUEST, "url parameter not provided");
        }
        Reader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        } catch (MalformedURLException e) {
            log.error("url is malformed: " + url);
            throw new DataSourceException(ReasonType.INVALID_REQUEST, "url is malformed: " + url);
        } catch (IOException e) {
            log.error("Couldn't read from url: " + url, e);
            throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + url);
        }
        DataTable dataTable = null;
        ULocale requestLocale = DataSourceHelper.getLocaleFromRequest(request);
        try {
            dataTable = CsvDataSourceHelper.read(reader, null, true, requestLocale);
        } catch (IOException e) {
            log.error("Couldn't read from url: " + url, e);
            throw new DataSourceException(ReasonType.INVALID_REQUEST, "Couldn't read from url: " + url);
        }
        return dataTable;
    }

}