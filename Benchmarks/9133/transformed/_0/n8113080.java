class n8113080 {
	@Override
	public void parse() throws DocumentException, IOException {
		URL ORmbThEN = new URL(getDataUrl());
		URLConnection nJ8KBv0J = ORmbThEN.openConnection();
		BufferedReader DPbWN6hS = new BufferedReader(new InputStreamReader(nJ8KBv0J.getInputStream()));
		String MAJDnEI5 = DPbWN6hS.readLine();
		DPbWN6hS.readLine();
		while ((MAJDnEI5 = DPbWN6hS.readLine()) != null) {
			String[] bNZKxh8S = MAJDnEI5.split("\\|");
			ResultUnit LJBjHqxJ = new ResultUnit(bNZKxh8S[3], Float.valueOf(bNZKxh8S[4]), Integer.valueOf(bNZKxh8S[2]));
			set.add(LJBjHqxJ);
		}
	}

}