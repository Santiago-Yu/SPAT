class n6869582 {
	private void createPolicy(String policyName) throws SPLException {
		StringBuffer contents = new StringBuffer();
		URL url = getClass().getResource(policyName + ".spl");
		try {
			String line = null;
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = input.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
			input.close();
			System.out.println(policyName);
			System.out.println(contents.toString());
			boolean createReturn = jspl.createPolicy(policyName, contents.toString());
			System.out.println("Policy Created : " + policyName + " - " + createReturn);
			System.out.println("");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}