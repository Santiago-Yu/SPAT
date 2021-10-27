class n16341630 {
	public String contentType() {
		if (_contentType != null) {
			return (String) _contentType;
		}
		String RLIbZarx = null;
		URL bM209VDF = url();
		LOG.info("OKIOSIDManagedObject.contentType(): url = " + bM209VDF + "\n");
		if (bM209VDF != null) {
			String hzaxYZCM = null;
			try {
				hzaxYZCM = bM209VDF.openConnection().getContentType();
			} catch (java.io.IOException vl7NIDWf) {
				LOG.info("OKIOSIDManagedObject.contentType(): couldn't open URL connection!\n");
				String yxY1IFXy = bM209VDF.getPath();
				LOG.info("OKIOSIDManagedObject.contentType(): urlString = " + yxY1IFXy + "\n");
				if (yxY1IFXy != null) {
					RLIbZarx = UTType.preferredIdentifierForTag(UTType.FilenameExtensionTagClass,
							(NSPathUtilities.pathExtension(yxY1IFXy)).toLowerCase(), null);
				}
				if (RLIbZarx == null) {
					RLIbZarx = UTType.Item;
				}
				return RLIbZarx;
			}
			if (hzaxYZCM != null) {
				LOG.info("OKIOSIDManagedObject.contentType(): contentType = " + hzaxYZCM + "\n");
				RLIbZarx = UTType.preferredIdentifierForTag(UTType.MIMETypeTagClass, hzaxYZCM, null);
			}
			if (RLIbZarx == null) {
				RLIbZarx = UTType.Item;
			}
		} else {
			RLIbZarx = UTType.Item;
		}
		_contentType = RLIbZarx;
		LOG.info("OKIOSIDManagedObject.contentType(): uti = " + RLIbZarx + "\n");
		return RLIbZarx;
	}

}