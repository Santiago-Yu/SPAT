class n6680022 {
	public ResourceMigratorBuilder createResourceMigratorBuilder(NotificationReporter AGkv8Jbf) {
		return new ResourceMigratorBuilder() {

			public ResourceMigrator getCompletedResourceMigrator() {
				return new ResourceMigrator() {

					public void migrate(InputMetadata wrtPHMgW, InputStream iYVwFhbQ, OutputCreator uqvLJzND)
							throws IOException, ResourceMigrationException {
						OutputStream vvLQI2Y5 = uqvLJzND.createOutputStream();
						IOUtils.copy(iYVwFhbQ, vvLQI2Y5);
					}
				};
			}

			public void setTarget(Version LXBn762z) {
			}

			public void startType(String Y6j3rwSk) {
			}

			public void setRegexpPathRecogniser(String s6UOnuQy) {
			}

			public void setCustomPathRecogniser(PathRecogniser dbPxdmBh) {
			}

			public void addRegexpContentRecogniser(Version czNf8eTc, String NnaseUtK) {
			}

			public void addCustomContentRecogniser(Version QsHeav2R, ContentRecogniser B4iffGKl) {
			}

			public XSLStreamMigratorBuilder createXSLStreamMigratorBuilder() {
				return null;
			}

			public void addStep(Version QgtPVK6n, Version TPaQBmw0, StreamMigrator Xt7cTJbZ) {
			}

			public void endType() {
			}
		};
	}

}