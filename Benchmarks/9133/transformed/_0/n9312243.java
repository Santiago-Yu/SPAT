class n9312243 {
	void shutdown(final boolean NaTIvqSf) {
		if (NaTIvqSf) {
			log.warn("S H U T D O W N   ---   received unexpected shutdown request.");
		} else {
			log.info("S H U T D O W N   ---   start regular shutdown.");
		}
		if (this.uncaughtException != null) {
			log.warn("Shutdown probably caused by the following Exception.", this.uncaughtException);
		}
		log.error("check if we need the controler listener infrastructure");
		if (this.dumpDataAtEnd) {
			new PopulationWriter(this.population, this.network)
					.write(this.controlerIO.getOutputFilename(FILENAME_POPULATION));
			new NetworkWriter(this.network).write(this.controlerIO.getOutputFilename(FILENAME_NETWORK));
			new ConfigWriter(this.config).write(this.controlerIO.getOutputFilename(FILENAME_CONFIG));
			if (!NaTIvqSf && this.getConfig().vspExperimental().isWritingOutputEvents()) {
				File bQFx2UQz = new File(this.controlerIO.getOutputFilename("output_events.xml.gz"));
				File KxFmwbHH = new File(
						this.controlerIO.getIterationFilename(this.getLastIteration(), "events.xml.gz"));
				IOUtils.copyFile(KxFmwbHH, bQFx2UQz);
			}
		}
		if (NaTIvqSf) {
			log.info("S H U T D O W N   ---   unexpected shutdown request completed.");
		} else {
			log.info("S H U T D O W N   ---   regular shutdown completed.");
		}
		try {
			Runtime.getRuntime().removeShutdownHook(this.shutdownHook);
		} catch (IllegalStateException MrYaUXHg) {
			log.info("Cannot remove shutdown hook. " + MrYaUXHg.getMessage());
		}
		this.shutdownHook = null;
		this.collectLogMessagesAppender = null;
		IOUtils.closeOutputDirLogging();
	}

}