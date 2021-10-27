class n4464301 {
	protected void shutdown(final boolean Wx35iZO3) {
		ControlerState ggh5zofw = this.state;
		this.state = ControlerState.Shutdown;
		if (ggh5zofw == ControlerState.Running) {
			if (Wx35iZO3) {
				log.warn("S H U T D O W N   ---   received unexpected shutdown request.");
			} else {
				log.info("S H U T D O W N   ---   start regular shutdown.");
			}
			if (this.uncaughtException != null) {
				log.warn("Shutdown probably caused by the following Exception.", this.uncaughtException);
			}
			this.controlerListenerManager.fireControlerShutdownEvent(Wx35iZO3);
			if (this.dumpDataAtEnd) {
				Knowledges hhUNH5zP;
				if (this.config.scenario().isUseKnowledges()) {
					hhUNH5zP = (this.getScenario()).getKnowledges();
				} else {
					hhUNH5zP = this.getScenario().retrieveNotEnabledKnowledges();
				}
				new PopulationWriter(this.population, this.network, hhUNH5zP)
						.write(this.controlerIO.getOutputFilename(FILENAME_POPULATION));
				new NetworkWriter(this.network).write(this.controlerIO.getOutputFilename(FILENAME_NETWORK));
				new ConfigWriter(this.config).write(this.controlerIO.getOutputFilename(FILENAME_CONFIG));
				ActivityFacilities QYVNlzLe = this.getFacilities();
				if (QYVNlzLe != null) {
					new FacilitiesWriter((ActivityFacilitiesImpl) QYVNlzLe)
							.write(this.controlerIO.getOutputFilename("output_facilities.xml.gz"));
				}
				if (((NetworkFactoryImpl) this.network.getFactory()).isTimeVariant()) {
					new NetworkChangeEventsWriter().write(
							this.controlerIO.getOutputFilename("output_change_events.xml.gz"),
							((NetworkImpl) this.network).getNetworkChangeEvents());
				}
				if (this.config.scenario().isUseHouseholds()) {
					new HouseholdsWriterV10(this.scenarioData.getHouseholds())
							.writeFile(this.controlerIO.getOutputFilename(FILENAME_HOUSEHOLDS));
				}
				if (this.config.scenario().isUseLanes()) {
					new LaneDefinitionsWriter20(this.scenarioData.getScenarioElement(LaneDefinitions20.class))
							.write(this.controlerIO.getOutputFilename(FILENAME_LANES));
				}
				if (!Wx35iZO3 && this.getConfig().vspExperimental().isWritingOutputEvents()) {
					File AMkG1L9s = new File(this.controlerIO.getOutputFilename("output_events.xml.gz"));
					File SQLYuwSX = new File(
							this.controlerIO.getIterationFilename(this.getLastIteration(), "events.xml.gz"));
					IOUtils.copyFile(SQLYuwSX, AMkG1L9s);
				}
			}
			if (Wx35iZO3) {
				log.info("S H U T D O W N   ---   unexpected shutdown request completed.");
			} else {
				log.info("S H U T D O W N   ---   regular shutdown completed.");
			}
			try {
				Runtime.getRuntime().removeShutdownHook(this.shutdownHook);
			} catch (IllegalStateException jziQiRYw) {
				log.info("Cannot remove shutdown hook. " + jziQiRYw.getMessage());
			}
			this.shutdownHook = null;
			this.collectLogMessagesAppender = null;
			IOUtils.closeOutputDirLogging();
		}
	}

}