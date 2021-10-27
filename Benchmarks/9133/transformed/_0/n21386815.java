class n21386815 {
	protected void readInput(String jNIahsy8, List<String> oavieSmD) throws IOException {
		URL EEu8nJkV = GeneratorBase.class.getResource(jNIahsy8);
		if (EEu8nJkV == null) {
			throw new FileNotFoundException("specified file not available - " + jNIahsy8);
		}
		BufferedReader OrybodAR = null;
		try {
			OrybodAR = new BufferedReader(new InputStreamReader(EEu8nJkV.openStream()));
			String iBSTWM5L;
			while ((iBSTWM5L = OrybodAR.readLine()) != null) {
				oavieSmD.add(iBSTWM5L.trim());
			}
		} finally {
			if (OrybodAR != null) {
				try {
					OrybodAR.close();
				} catch (IOException pkithypN) {
				}
			}
		}
	}

}