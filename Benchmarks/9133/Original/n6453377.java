class n6453377{
    @Override
    public TDSModel loadModel(URL url, String skin) throws IOException, IncorrectFormatException, ParsingErrorException {
        boolean baseURLWasNull = setBaseURLFromModelURL(url);
        TDSModel model = loadModel(url.openStream(), skin);
        if (baseURLWasNull) {
            popBaseURL();
        }
        return (model);
    }

}