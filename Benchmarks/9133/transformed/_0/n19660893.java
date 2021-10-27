class n19660893 {
	private String load(URL y8arWkja) {
		BufferedReader vV9Jv0hK = null;
		try {
			vV9Jv0hK = new BufferedReader(new InputStreamReader(y8arWkja.openStream()));
			StringBuffer DDRDmvz3 = new StringBuffer();
			while (vV9Jv0hK.ready()) {
				DDRDmvz3.append(vV9Jv0hK.readLine()).append('\n');
			}
			vV9Jv0hK.close();
			return DDRDmvz3.toString();
		} catch (IOException I5UgV5VC) {
			logger.severe("Could not load shader program: " + I5UgV5VC);
			logger.logp(Level.SEVERE, getClass().getName(), "load(URL)", "Exception", I5UgV5VC);
			return null;
		}
	}

}