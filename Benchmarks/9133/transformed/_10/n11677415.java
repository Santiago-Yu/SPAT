class n11677415 {
	@Test
	public void behaveTest() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream is = this.getClass().getResourceAsStream("safetyCaseTest.mdf");
		TrafficSimulationEngine engine = new TrafficSimulationEngine();
		try {
			IOUtils.copy(is, out);
		} catch (IOException e) {
			throw new RuntimeException("Unable to read mdf", e);
		}
		TrafficModelDefinition def = MDFReader.read(out.toByteArray());
		engine.init(def);
		Map<Integer, Set<Integer>> linkSegments = new HashMap<Integer, Set<Integer>>();
		Set<Integer> segments = new HashSet<Integer>();
		segments.add(0);
		linkSegments.put(0, segments);
		FrameProperties frameProperties = new FrameProperties(linkSegments, new HashSet<Integer>());
		engine.setFrameProperties(frameProperties);
		RegularVehicle vehicle = (RegularVehicle) engine.getDynamicObjects().iterator().next();
		CompositeDriver driver = (CompositeDriver) vehicle.getDriver();
		driver.drive(0.1f);
		SafetyCase safety = new SafetyCase(driver);
		RectangleCCRange ccRange = (RectangleCCRange) safety.behave(0.1f);
		HandRange probeRange = new HandRange();
		HandRange turnRange = ccRange.getTurnRange();
		probeRange.remove(Hand.Left);
		assertTrue(turnRange.equals(probeRange));
		assertTrue(ccRange.getPriority() == Priority.SafetyCase);
	}

}