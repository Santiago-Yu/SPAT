class n21125261 {
	@Test
	public void test() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		InputStream is = this.getClass().getResourceAsStream("originAndDestination.xml");
		IOUtils.copy(is, byteArrayOutputStream);
		TrafficSimulationEngine se = new TrafficSimulationEngine();
		TrafficModelDefinition def = MDFReader.read(byteArrayOutputStream.toByteArray());
		se.init(def);
		int segmentId = 0;
		int linkId = 2;
		Map<Integer, Set<Integer>> linkSegments = new HashMap<Integer, Set<Integer>>();
		Set<Integer> segments = new HashSet<Integer>();
		segments.add(segmentId);
		linkSegments.put(linkId, segments);
		FrameProperties frameProperties = new FrameProperties(linkSegments, new HashSet<Integer>());
		se.setFrameProperties(frameProperties);
		for (float time = 0; time < 60 * 10; time += 0.1f) {
			se.step(0.1f);
			for (RoadObject vehicle : se.getDynamicObjects()) {
				System.out.println(time + ": X=" + vehicle.getPosition() + "\tV=" + vehicle.getSpeed());
			}
		}
	}

}