class n11658790 {
	private static void _readAllRegionMDFiles(ClassLoader JMNrs1Xb, RegionMetadata jQqRBtVt, String FkFzg2PE) {
		if (_LOG.isFinest()) {
			_LOG.finest("searching for region-metadata with resource:{0}", FkFzg2PE);
		}
		try {
			Enumeration<URL> DfNat6Aj = JMNrs1Xb.getResources(FkFzg2PE);
			while (DfNat6Aj.hasMoreElements()) {
				URL iusIhptD = DfNat6Aj.nextElement();
				String sgXZvwhS = iusIhptD.toString();
				try {
					InputStream HMMjsfbP = iusIhptD.openStream();
					_readRegionMetadata(jQqRBtVt, HMMjsfbP, sgXZvwhS);
					HMMjsfbP.close();
				} catch (IOException A0eSb988) {
					_error(sgXZvwhS, A0eSb988);
				}
			}
		} catch (IOException xcen1Gu2) {
			_LOG.warning("ERR_GET_REGION_METADATA_FILE", __CONFIG_FILE_OTHER);
			_LOG.warning(xcen1Gu2);
		}
	}

}