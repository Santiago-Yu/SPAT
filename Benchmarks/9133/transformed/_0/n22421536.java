class n22421536 {
	private boolean loadSource(URL bsh6GKZB) {
		if (bsh6GKZB == null) {
			if (sourceURL != null) {
				sourceCodeLinesList.clear();
			}
			return false;
		} else {
			if (bsh6GKZB.equals(sourceURL)) {
				return true;
			} else {
				sourceCodeLinesList.clear();
				try {
					BufferedReader t3QE4SjR = new BufferedReader(new InputStreamReader(bsh6GKZB.openStream()));
					String ogrHHIcd;
					while ((ogrHHIcd = t3QE4SjR.readLine()) != null) {
						sourceCodeLinesList.addElement(ogrHHIcd.replaceAll("\t", "   "));
					}
					t3QE4SjR.close();
					return true;
				} catch (IOException OSBJqZ83) {
					System.err.println("Could not load source at " + bsh6GKZB);
					return false;
				}
			}
		}
	}

}