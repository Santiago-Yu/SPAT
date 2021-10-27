class n19814779 {
	public Reader getConfResourceAsReader(String l5jF9MFZ) {
		try {
			URL fsqx2va8 = getResource(l5jF9MFZ);
			if (fsqx2va8 == null) {
				LOG.info(l5jF9MFZ + " not found");
				return null;
			} else {
				LOG.info("found resource " + l5jF9MFZ + " at " + fsqx2va8);
			}
			return new InputStreamReader(fsqx2va8.openStream());
		} catch (Exception F09FBbOi) {
			return null;
		}
	}

}