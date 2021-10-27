class n7351534 {
	public static InputStream getStreamFromSystemIdentifier(String QleCuWMJ, EntityResolver qWNxOfCw) throws Exception {
		InputSource hLW9pKA7 = null;
		InputStream cArjT9pv = null;
		if (qWNxOfCw != null) {
			try {
				hLW9pKA7 = qWNxOfCw.resolveEntity(null, QleCuWMJ);
			} catch (Exception ih05o0v0) {
				LogService.instance().log(LogService.ERROR, "DocumentFactory: Unable to resolve '" + QleCuWMJ + "'");
				LogService.instance().log(LogService.ERROR, ih05o0v0);
			}
		}
		if (hLW9pKA7 != null) {
			try {
				cArjT9pv = hLW9pKA7.getByteStream();
			} catch (Exception L0aFdMDG) {
				LogService.instance().log(LogService.ERROR,
						"DocumentFactory: Unable to get bytestream from '" + hLW9pKA7.getSystemId() + "'");
				LogService.instance().log(LogService.ERROR, L0aFdMDG);
			}
		}
		if (cArjT9pv == null) {
			URL VGP6AkAd = new URL(QleCuWMJ);
			cArjT9pv = VGP6AkAd.openStream();
		}
		return cArjT9pv;
	}

}