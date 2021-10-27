class n22807014 {
	@Test
	public void test() throws JDOMException, IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		InputStream is = this.getClass().getResourceAsStream("putRegularVehicle.xml");
		IOUtils.copy(is, byteArrayOutputStream);
		TrafficSimulationEngine se = new TrafficSimulationEngine();
		TrafficModelDefinition def = MDFReader.read(byteArrayOutputStream.toByteArray());
		se.init(def);
		int segmentId = 3;
		int linkId = 2;
		Map<Integer, Set<Integer>> linkSegments = new HashMap<Integer, Set<Integer>>();
		Set<Integer> segments = new HashSet<Integer>();
		segments.add(segmentId);
		linkSegments.put(linkId, segments);
		FrameProperties frameProperties = new FrameProperties(linkSegments, new HashSet<Integer>());
		se.setFrameProperties(frameProperties);
		for (float time = 0; time < 60; time += 0.1f) {
			se.step(0.1f);
			System.out.println("*** Time: " + time);
			for (RoadObject roadObject : se.getDynamicObjects()) {
				Vehicle vehicle = (Vehicle) roadObject;
				System.out.println(
						vehicle.getVehicleId() + ":\tX=" + vehicle.getPosition() + "\tV=" + vehicle.getSpeed());
			}
		}
	}

}