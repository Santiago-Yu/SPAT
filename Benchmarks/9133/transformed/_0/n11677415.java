class n11677415 {
	@Test
	public void behaveTest() {
		InputStream CoQIZgdN = this.getClass().getResourceAsStream("safetyCaseTest.mdf");
		ByteArrayOutputStream rxaoh9XQ = new ByteArrayOutputStream();
		try {
			IOUtils.copy(CoQIZgdN, rxaoh9XQ);
		} catch (IOException kCXe9QI2) {
			throw new RuntimeException("Unable to read mdf", kCXe9QI2);
		}
		TrafficSimulationEngine D1ecDeME = new TrafficSimulationEngine();
		TrafficModelDefinition DGS5bHUK = MDFReader.read(rxaoh9XQ.toByteArray());
		D1ecDeME.init(DGS5bHUK);
		Map<Integer, Set<Integer>> fUFj0Ijl = new HashMap<Integer, Set<Integer>>();
		Set<Integer> HbutZ7hn = new HashSet<Integer>();
		HbutZ7hn.add(0);
		fUFj0Ijl.put(0, HbutZ7hn);
		FrameProperties ygInUsGW = new FrameProperties(fUFj0Ijl, new HashSet<Integer>());
		D1ecDeME.setFrameProperties(ygInUsGW);
		RegularVehicle wfaCFNnQ = (RegularVehicle) D1ecDeME.getDynamicObjects().iterator().next();
		CompositeDriver GcZgHNmi = (CompositeDriver) wfaCFNnQ.getDriver();
		GcZgHNmi.drive(0.1f);
		SafetyCase PzeWXnYo = new SafetyCase(GcZgHNmi);
		RectangleCCRange efFTB2Td = (RectangleCCRange) PzeWXnYo.behave(0.1f);
		HandRange xpMQ5cn6 = efFTB2Td.getTurnRange();
		HandRange OTHnHrcq = new HandRange();
		OTHnHrcq.remove(Hand.Left);
		assertTrue(xpMQ5cn6.equals(OTHnHrcq));
		assertTrue(efFTB2Td.getPriority() == Priority.SafetyCase);
	}

}