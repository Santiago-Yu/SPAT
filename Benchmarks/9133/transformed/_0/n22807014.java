class n22807014 {
	@Test
	public void test() throws JDOMException, IOException {
		InputStream Z3o9UGf5 = this.getClass().getResourceAsStream("putRegularVehicle.xml");
		ByteArrayOutputStream Z7y9fMdS = new ByteArrayOutputStream();
		IOUtils.copy(Z3o9UGf5, Z7y9fMdS);
		TrafficModelDefinition NPP9v6As = MDFReader.read(Z7y9fMdS.toByteArray());
		TrafficSimulationEngine yUMZWiGr = new TrafficSimulationEngine();
		yUMZWiGr.init(NPP9v6As);
		int wIPsaIPS = 2;
		int qXYhHtRi = 3;
		Map<Integer, Set<Integer>> JkkmkB7j = new HashMap<Integer, Set<Integer>>();
		Set<Integer> cGDGdDuF = new HashSet<Integer>();
		cGDGdDuF.add(qXYhHtRi);
		JkkmkB7j.put(wIPsaIPS, cGDGdDuF);
		FrameProperties nQe9KQ3n = new FrameProperties(JkkmkB7j, new HashSet<Integer>());
		yUMZWiGr.setFrameProperties(nQe9KQ3n);
		for (float rLvTGQfQ = 0; rLvTGQfQ < 60; rLvTGQfQ += 0.1f) {
			yUMZWiGr.step(0.1f);
			System.out.println("*** Time: " + rLvTGQfQ);
			for (RoadObject PEeFEQwC : yUMZWiGr.getDynamicObjects()) {
				Vehicle znmsBWZd = (Vehicle) PEeFEQwC;
				System.out.println(
						znmsBWZd.getVehicleId() + ":\tX=" + znmsBWZd.getPosition() + "\tV=" + znmsBWZd.getSpeed());
			}
		}
	}

}