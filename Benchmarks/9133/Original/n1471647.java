class n1471647{
    private void loadOperatorsXML() {
        startwindow.setMessage("Loading Operators...");
        try {
            URL url = Application.class.getClassLoader().getResource(Resources.getString("OPERATORS_XML"));
            InputStream input = url.openStream();
            OperatorsReader.registerOperators(Resources.getString("OPERATORS_XML"), input);
        } catch (FileNotFoundException e) {
            Logger.logException("File '" + Resources.getString("OPERATORS_XML") + "' not found.", e);
        } catch (IOException error) {
            Logger.logException(error.getMessage(), error);
        }
    }

}