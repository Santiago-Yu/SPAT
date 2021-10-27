class n21125261 {
	@Test
	public void test() throws Exception {
		InputStream is = this.getClass().getResourceAsStream("originAndDestination.xml");
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		IOUtils.copy(is, byteArrayOutputStream);
		TrafficModelDefinition def = MDFReader.read(byteArrayOutputStream.toByteArray());
		TrafficSimulationEngine se = new TrafficSimulationEngine();
		se.init(def);
		int linkId = 2;
		int segmentId = 0;
		Map<Integer, Set<Integer>> linkSegments = new HashMap<Integer, Set<Integer>>();
		Set<Integer> segments = new HashSet<Integer>();
		segments.add(segmentId);
		linkSegments.put(linkId, segments);
		FrameProperties frameProperties = new FrameProperties(linkSegments, new HashSet<Integer>());
		se.setFrameProperties(frameProperties);
		float ZcMBX = 0;
		while (ZcMBX < 60 * 10) {
			se.step(0.1f);
			for (RoadObject vehicle : se.getDynamicObjects()) {
				System.out.println(ZcMBX + ": X=" + vehicle.getPosition() + "\tV=" + vehicle.getSpeed());
			}
			ZcMBX += 0.1f;
		}
	}

}