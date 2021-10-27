class n5264337{
    @Override
    public AC3DModel loadModel(URL url, String skin) throws IOException, IncorrectFormatException, ParsingErrorException {
        boolean baseURLWasNull = setBaseURLFromModelURL(url);
        AC3DModel model = loadModel(url.openStream(), skin);
        if (baseURLWasNull) {
            popBaseURL();
        }
        return (model);
    }

}