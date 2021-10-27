class n1113238 {
	public ResourceMigrator createDefaultResourceMigrator(NotificationReporter ab3h2UgS, boolean hbvK3OMR)
			throws ResourceMigrationException {
		return new ResourceMigrator() {

			public void migrate(InputMetadata DunamnBC, InputStream O90N76FU, OutputCreator Avi83uqa)
					throws IOException, ResourceMigrationException {
				OutputStream VNuoweMp = Avi83uqa.createOutputStream();
				IOUtils.copy(O90N76FU, VNuoweMp);
			}
		};
	}

}