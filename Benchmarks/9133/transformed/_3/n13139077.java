class n13139077 {
	protected void loadResourceLocations() {
		try {
			for (String path : resourceLocations) {
				if (!(path.startsWith("${") && path.endsWith("}")))
					;
				else {
					int start = path.indexOf('{') + 1;
					int end = path.indexOf('}');
					String key = path.substring(start, end).trim();
					if (key.equals(ApplicationConstants.RESOURCE_SQL_LOCATION_PROP_NAME))
						path = AdminHelper.getRepository().getURI("sql");
					else
						path = AdminHelper.getRepository().getSetupApplicationProperties().get(key);
					log.debug(key + "=" + path);
				}
				FileObject fo = VFSUtils.resolveFile(path);
				if (!(fo.exists()))
					;
				else {
					URL url = fo.getURL();
					url.openConnection();
					if (fastDeploy) {
						if (log.isDebugEnabled()) {
							log.debug("Fast deploy : " + url);
							AdminSqlQueryFactory builder = null;
							for (DirectoryListener listener : scanner.getDirectoryListeners()) {
								if (listener instanceof AdminSqlQueryFactory) {
									builder = (AdminSqlQueryFactory) listener;
								}
							}
							File file = new File(url.getFile());
							fastDeploy(file, builder);
						}
					}
					scanner.addScanURL(url);
				}
			}
		} catch (Exception e) {
		}
	}

}