    @Override
    public OBJModel loadModel(URL url, String skin) throws IOException, IncorrectFormatException, ParsingErrorException {
        boolean baseURLWasNull = setBaseURLFromModelURL(url);
        OBJModel model = loadModel(url.openStream(), skin);
        if (baseURLWasNull) {
            popBaseURL();
        }
        return (model);
    }
