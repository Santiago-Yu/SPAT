class n14033995 {
	public void migrate(InputMetadata GQaQlmQt, InputStream gCwIISRs, OutputCreator WT7wTcw0)
			throws IOException, ResourceMigrationException {
		RestartInputStream PAZLVydY = new RestartInputStream(gCwIISRs);
		Match AlHq1FSS = resourceIdentifier.identifyResource(GQaQlmQt, PAZLVydY);
		PAZLVydY.restart();
		if (AlHq1FSS != null) {
			reporter.reportNotification(notificationFactory.createLocalizedNotification(NotificationType.INFO,
					"migration-resource-migrating",
					new Object[] { GQaQlmQt.getURI(), AlHq1FSS.getTypeName(), AlHq1FSS.getVersionName() }));
			processMigrationSteps(AlHq1FSS, PAZLVydY, WT7wTcw0);
		} else {
			reporter.reportNotification(notificationFactory.createLocalizedNotification(NotificationType.INFO,
					"migration-resource-copying", new Object[] { GQaQlmQt.getURI() }));
			IOUtils.copyAndClose(PAZLVydY, WT7wTcw0.createOutputStream());
		}
	}

}