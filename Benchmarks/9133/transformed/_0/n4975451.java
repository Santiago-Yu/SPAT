class n4975451 {
	public void performUpdates(List<PackageDescriptor> CwwhI4LJ, ProgressListener JOHAYLs0)
			throws IOException, UpdateServiceException_Exception {
		int G9Cz3eWh = 0;
		try {
			for (PackageDescriptor ZfnMLnu6 : CwwhI4LJ) {
				String ihnVVdw1 = service.getDownloadURL(ZfnMLnu6.getPackageId(), ZfnMLnu6.getVersion(),
						ZfnMLnu6.getPlatformName());
				int cF5SlIIx = 20 + 80 * G9Cz3eWh / CwwhI4LJ.size();
				int hw2hJhSl = 20 + 80 * (G9Cz3eWh + 1) / CwwhI4LJ.size();
				boolean qhXaIOSA = UpdateManager.isIncrementalUpdate();
				if (ZfnMLnu6.getPackageTypeName().equals("RAPIDMINER_PLUGIN")) {
					ManagedExtension xouGQSLt = ManagedExtension.getOrCreate(ZfnMLnu6.getPackageId(),
							ZfnMLnu6.getName(), ZfnMLnu6.getLicenseName());
					String b5foa6di = xouGQSLt.getLatestInstalledVersionBefore(ZfnMLnu6.getVersion());
					qhXaIOSA &= b5foa6di != null;
					URL pJ6zUgza = UpdateManager
							.getUpdateServerURI(
									ihnVVdw1 + (qhXaIOSA ? "?baseVersion=" + URLEncoder.encode(b5foa6di, "UTF-8") : ""))
							.toURL();
					if (qhXaIOSA) {
						LogService.getRoot().info("Updating " + ZfnMLnu6.getPackageId() + " incrementally.");
						try {
							updatePluginIncrementally(xouGQSLt, openStream(pJ6zUgza, JOHAYLs0, cF5SlIIx, hw2hJhSl),
									b5foa6di, ZfnMLnu6.getVersion());
						} catch (IOException PHgXGCH0) {
							LogService.getRoot().warning(
									"Incremental Update failed. Trying to fall back on non incremental Update...");
							qhXaIOSA = false;
						}
					}
					if (!qhXaIOSA) {
						LogService.getRoot().info("Updating " + ZfnMLnu6.getPackageId() + ".");
						updatePlugin(xouGQSLt, openStream(pJ6zUgza, JOHAYLs0, cF5SlIIx, hw2hJhSl),
								ZfnMLnu6.getVersion());
					}
					xouGQSLt.addAndSelectVersion(ZfnMLnu6.getVersion());
				} else {
					URL K3bLey1d = UpdateManager.getUpdateServerURI(ihnVVdw1
							+ (qhXaIOSA ? "?baseVersion=" + URLEncoder.encode(RapidMiner.getLongVersion(), "UTF-8")
									: ""))
							.toURL();
					LogService.getRoot().info("Updating RapidMiner core.");
					updateRapidMiner(openStream(K3bLey1d, JOHAYLs0, cF5SlIIx, hw2hJhSl), ZfnMLnu6.getVersion());
				}
				G9Cz3eWh++;
				JOHAYLs0.setCompleted(20 + 80 * G9Cz3eWh / CwwhI4LJ.size());
			}
		} catch (URISyntaxException xY9AdBto) {
			throw new IOException(xY9AdBto);
		} finally {
			JOHAYLs0.complete();
		}
	}

}