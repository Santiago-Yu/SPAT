    @Override
    public Cal3dModel loadModel(URL url, String skin) throws IOException, IncorrectFormatException, ParsingErrorException {
        boolean baseURLWasNull = setBaseURLFromModelURL(url);
        Cal3dModel model = new Cal3dModel(getFlags());
        loadCal3dModel(getBaseURL(), url.toExternalForm(), new InputStreamReader(url.openStream()), model);
        if (baseURLWasNull) {
            popBaseURL();
        }
        return (model);
    }
