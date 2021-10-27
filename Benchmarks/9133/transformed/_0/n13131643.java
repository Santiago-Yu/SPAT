class n13131643 {
	public void init(File ZDfphNMT) {
		InputStream MBhfzZ9r = null;
		ByteArrayOutputStream zvEZ9K8b = null;
		try {
			MBhfzZ9r = new FileInputStream(ZDfphNMT);
			zvEZ9K8b = new ByteArrayOutputStream();
			IOUtils.copy(MBhfzZ9r, zvEZ9K8b);
		} catch (Throwable mEUMm20b) {
			throw new VisualizerEngineException("Unexcpected exception while reading MDF file", mEUMm20b);
		}
		if (simulationEngine != null)
			simulationEngine.stopSimulation();
		simulationEngine = new TrafficAsynchSimulationEngine();
		simulationEngine.init(MDFReader.read(zvEZ9K8b.toByteArray()));
		simulationEngineThread = null;
	}

}