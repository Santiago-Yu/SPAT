class n21980807 {
	public void checkAndDownload(String statsUrl, RDFStatsUpdatableModelExt stats, Date lastDownload,
			boolean onlyIfNewer) throws DataSourceMonitorException {
		HttpURLConnection urlConnection;
		if (log.isInfoEnabled())
			log.info("Checking if update required for statistics of " + ds + "...");
		try {
			URL url = new URL(statsUrl);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
			urlConnection.setReadTimeout(READ_TIMEOUT);
			int statusCode = urlConnection.getResponseCode();
			if (statusCode / 100 != 2) {
				String msg = urlConnection.getResponseMessage();
				throw new DataSourceMonitorException(
						statsUrl + " returned HTTP " + statusCode + (msg != null ? msg : "") + ".");
			}
		} catch (Exception e) {
			throw new DataSourceMonitorException("Failed to connect to " + statsUrl + ".", e);
		}
		long lastModified = urlConnection.getLastModified();
		boolean newer = lastDownload == null || lastModified == 0 || lastModified - TIMING_GAP > lastDownload.getTime();
		if (newer || !onlyIfNewer) {
			Model newStats = retrieveModelData(urlConnection, ds);
			Date retrievedTimestamp = Calendar.getInstance().getTime();
			Date modifiedTimestamp = (urlConnection.getLastModified() > 0) ? new Date(urlConnection.getLastModified())
					: null;
			if (log.isInfoEnabled())
				log.info("Attempt to import up-to-date "
						+ ((modifiedTimestamp != null) ? "(from " + modifiedTimestamp + ") " : "") + "statistics for "
						+ ds + ".");
			try {
				if (stats.updateFrom(RDFStatsModelFactory.create(newStats), onlyIfNewer))
					stats.setLastDownload(ds.getSPARQLEndpointURL(), retrievedTimestamp);
			} catch (Exception e) {
				throw new DataSourceMonitorException(
						"Failed to import statistics and set last download for " + ds + ".", e);
			}
		} else {
			if (log.isInfoEnabled())
				log.info("Statistics for " + ds + " are up-to-date"
						+ ((lastDownload != null) ? " (" + lastDownload + ")" : ""));
		}
	}

}