class n21125261 {
	@Test
	public void test() throws Exception {
		InputStream NcgaKqer = this.getClass().getResourceAsStream("originAndDestination.xml");
		ByteArrayOutputStream I83PSDC2 = new ByteArrayOutputStream();
		IOUtils.copy(NcgaKqer, I83PSDC2);
		TrafficModelDefinition oWIUZhTR = MDFReader.read(I83PSDC2.toByteArray());
		TrafficSimulationEngine e7mwRNan = new TrafficSimulationEngine();
		e7mwRNan.init(oWIUZhTR);
		int WNwMsCM8 = 2;
		int PcO8Fikc = 0;
		Map<Integer, Set<Integer>> fURl0W6s = new HashMap<Integer, Set<Integer>>();
		Set<Integer> qqIQTGoP = new HashSet<Integer>();
		qqIQTGoP.add(PcO8Fikc);
		fURl0W6s.put(WNwMsCM8, qqIQTGoP);
		FrameProperties aHOLOHlh = new FrameProperties(fURl0W6s, new HashSet<Integer>());
		e7mwRNan.setFrameProperties(aHOLOHlh);
		for (float YHcLlam9 = 0; YHcLlam9 < 60 * 10; YHcLlam9 += 0.1f) {
			e7mwRNan.step(0.1f);
			for (RoadObject acW1fJM3 : e7mwRNan.getDynamicObjects()) {
				System.out.println(YHcLlam9 + ": X=" + acW1fJM3.getPosition() + "\tV=" + acW1fJM3.getSpeed());
			}
		}
	}

}