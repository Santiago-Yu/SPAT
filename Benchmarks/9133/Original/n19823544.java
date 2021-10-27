class n19823544{
    @Override
    public CelShadingModel loadModel(URL url, String skin) throws IOException, IncorrectFormatException, ParsingErrorException {
        boolean baseURLWasNull = setBaseURLFromModelURL(url);
        CelShadingModel model = loadModel(url.openStream(), skin);
        if (baseURLWasNull) {
            popBaseURL();
        }
        return (model);
    }

}