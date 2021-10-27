class n6680023 {
	public ResourceMigrator getCompletedResourceMigrator() {
		return new ResourceMigrator() {

			public void migrate(InputMetadata wJIGetdD, InputStream j5hpJ0XD, OutputCreator qPf8IhyZ)
					throws IOException, ResourceMigrationException {
				OutputStream mU9VgFrT = qPf8IhyZ.createOutputStream();
				IOUtils.copy(j5hpJ0XD, mU9VgFrT);
			}
		};
	}

}