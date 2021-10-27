class n9806128 {
	private void _readValuesFromNetwork() {
		if (_intrinsicValuesByAttribute == null) {
			NSMutableDictionary<String, Object> bNadT0Sf = new NSMutableDictionary<String, Object>(3);
			bNadT0Sf.setObjectForKey(Boolean.FALSE, "NetworkFailure");
			try {
				URLConnection ccIiqKiT = url().openConnection();
				if (ccIiqKiT instanceof HttpURLConnection) {
					HttpURLConnection QIeyNKCr = (HttpURLConnection) ccIiqKiT;
					QIeyNKCr.setRequestMethod("HEAD");
					switch (QIeyNKCr.getResponseCode()) {
					case HttpURLConnection.HTTP_OK:
					case HttpURLConnection.HTTP_MOVED_PERM:
					case HttpURLConnection.HTTP_MOVED_TEMP:
					case HttpURLConnection.HTTP_NOT_MODIFIED:
						bNadT0Sf.setObjectForKey(Boolean.TRUE, MD.FSExists);
						break;
					default:
						bNadT0Sf.setObjectForKey(Boolean.FALSE, MD.FSExists);
					}
					LOG.info("_readValuesFromNetwork: " + QIeyNKCr.toString());
					bNadT0Sf.setObjectForKey(new NSTimestamp(QIeyNKCr.getLastModified()), MD.FSContentChangeDate);
					bNadT0Sf.setObjectForKey(new Integer(QIeyNKCr.getContentLength()), MD.FSSize);
				} else {
					bNadT0Sf.setObjectForKey(Boolean.FALSE, MD.FSExists);
				}
			} catch (Exception lD2tWn9A) {
				bNadT0Sf.setObjectForKey(Boolean.FALSE, MD.FSExists);
				bNadT0Sf.setObjectForKey(Boolean.TRUE, "NetworkFailure");
			}
			_intrinsicValuesByAttribute = bNadT0Sf;
		}
	}

}