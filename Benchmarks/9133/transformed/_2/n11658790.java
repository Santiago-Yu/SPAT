class n11658790 {
	private static void _readAllRegionMDFiles(ClassLoader loader, RegionMetadata bean, String regionMDFile) {
		if (_LOG.isFinest()) {
			_LOG.finest("searching for region-metadata with resource:{0}", regionMDFile);
		}
		try {
			Enumeration<URL> files = loader.getResources(regionMDFile);
			for (; files.hasMoreElements();) {
				URL url = files.nextElement();
				String publicId = url.toString();
				try {
					InputStream in = url.openStream();
					_readRegionMetadata(bean, in, publicId);
					in.close();
				} catch (IOException e) {
					_error(publicId, e);
				}
			}
		} catch (IOException e) {
			_LOG.warning("ERR_GET_REGION_METADATA_FILE", __CONFIG_FILE_OTHER);
			_LOG.warning(e);
		}
	}

}