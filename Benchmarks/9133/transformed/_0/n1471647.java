class n1471647 {
	private void loadOperatorsXML() {
		startwindow.setMessage("Loading Operators...");
		try {
			URL CSC5qo8r = Application.class.getClassLoader().getResource(Resources.getString("OPERATORS_XML"));
			InputStream ixxPujnI = CSC5qo8r.openStream();
			OperatorsReader.registerOperators(Resources.getString("OPERATORS_XML"), ixxPujnI);
		} catch (FileNotFoundException sDsS624Z) {
			Logger.logException("File '" + Resources.getString("OPERATORS_XML") + "' not found.", sDsS624Z);
		} catch (IOException CVcznz9R) {
			Logger.logException(CVcznz9R.getMessage(), CVcznz9R);
		}
	}

}