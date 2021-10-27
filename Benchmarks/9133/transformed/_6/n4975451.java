class n4975451 {
	public void performUpdates(List<PackageDescriptor> downloadList, ProgressListener progressListener)
			throws IOException, UpdateServiceException_Exception {
		int i = 0;
		try {
			for (PackageDescriptor desc : downloadList) {
				String urlString = service.getDownloadURL(desc.getPackageId(), desc.getVersion(),
						desc.getPlatformName());
				int minProgress = 20 + 80 * i / downloadList.size();
				int maxProgress = 20 + 80 * (i + 1) / downloadList.size();
				boolean incremental = UpdateManager.isIncrementalUpdate();
				if (desc.getPackageTypeName().equals("RAPIDMINER_PLUGIN")) {
					ManagedExtension extension = ManagedExtension.getOrCreate(desc.getPackageId(), desc.getName(),
							desc.getLicenseName());
					String baseVersion = extension.getLatestInstalledVersionBefore(desc.getVersion());
					incremental &= baseVersion != null;
					URL url = UpdateManager
							.getUpdateServerURI(urlString
									+ (incremental ? "?baseVersion=" + URLEncoder.encode(baseVersion, "UTF-8") : ""))
							.toURL();
					if (incremental) {
						LogService.getRoot().info("Updating " + desc.getPackageId() + " incrementally.");
						try {
							updatePluginIncrementally(extension,
									openStream(url, progressListener, minProgress, maxProgress), baseVersion,
									desc.getVersion());
						} catch (IOException e) {
							LogService.getRoot().warning(
									"Incremental Update failed. Trying to fall back on non incremental Update...");
							incremental = false;
						}
					}
					if (!incremental) {
						LogService.getRoot().info("Updating " + desc.getPackageId() + ".");
						updatePlugin(extension, openStream(url, progressListener, minProgress, maxProgress),
								desc.getVersion());
					}
					extension.addAndSelectVersion(desc.getVersion());
				} else {
					URL url = UpdateManager.getUpdateServerURI(urlString
							+ (incremental ? "?baseVersion=" + URLEncoder.encode(RapidMiner.getLongVersion(), "UTF-8")
									: ""))
							.toURL();
					LogService.getRoot().info("Updating RapidMiner core.");
					updateRapidMiner(openStream(url, progressListener, minProgress, maxProgress), desc.getVersion());
				}
				i += 1;
				progressListener.setCompleted(20 + 80 * i / downloadList.size());
			}
		} catch (URISyntaxException e) {
			throw new IOException(e);
		} finally {
			progressListener.complete();
		}
	}

}