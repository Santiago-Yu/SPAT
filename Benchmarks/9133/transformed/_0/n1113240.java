class n1113240 {
	public RemotePolicyMigrator createRemotePolicyMigrator() {
		return new RemotePolicyMigrator() {

			public String migratePolicy(InputStream jYrk2hLG, String PZOpAQmB)
					throws ResourceMigrationException, IOException {
				ByteArrayOutputCreator ytBKdR3S = new ByteArrayOutputCreator();
				IOUtils.copyAndClose(jYrk2hLG, ytBKdR3S.getOutputStream());
				return ytBKdR3S.getOutputStream().toString();
			}
		};
	}

}