class n13131643 {
	public void init(File file) {
		ByteArrayOutputStream os = null;
		InputStream is = null;
		try {
			os = new ByteArrayOutputStream();
			is = new FileInputStream(file);
			IOUtils.copy(is, os);
		} catch (Throwable e) {
			throw new VisualizerEngineException("Unexcpected exception while reading MDF file", e);
		}
		if (simulationEngine != null)
			simulationEngine.stopSimulation();
		simulationEngine = new TrafficAsynchSimulationEngine();
		simulationEngine.init(MDFReader.read(os.toByteArray()));
		simulationEngineThread = null;
	}

}