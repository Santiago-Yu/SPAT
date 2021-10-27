class n14787421 {
	private void saveStateAsLast(URL url) {
		OutputStream destinationStream = null;
		InputStream sourceStream = null;
		File lastBundlesTxt = getLastBundleInfo();
		try {
			try {
				sourceStream = url.openStream();
				destinationStream = new FileOutputStream(lastBundlesTxt);
				SimpleConfiguratorUtils.transferStreams(sourceStream, destinationStream);
			} finally {
				if (destinationStream != null)
					destinationStream.close();
				if (sourceStream != null)
					sourceStream.close();
			}
		} catch (IOException e) {
		}
	}

}