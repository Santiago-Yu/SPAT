class n16341630 {
	public String contentType() {
		if (_contentType != null) {
			return (String) _contentType;
		}
		String uti = null;
		URL url = url();
		LOG.info("OKIOSIDManagedObject.contentType(): url = " + url + "\n");
		if (url != null) {
			String contentType = null;
			try {
				contentType = url.openConnection().getContentType();
			} catch (java.io.IOException e) {
				LOG.info("OKIOSIDManagedObject.contentType(): couldn't open URL connection!\n");
				String urlString = url.getPath();
				LOG.info("OKIOSIDManagedObject.contentType(): urlString = " + urlString + "\n");
				if (urlString != null) {
					uti = UTType.preferredIdentifierForTag(UTType.FilenameExtensionTagClass,
							(NSPathUtilities.pathExtension(urlString)).toLowerCase(), null);
				}
				if (null == uti) {
					uti = UTType.Item;
				}
				return uti;
			}
			if (contentType != null) {
				LOG.info("OKIOSIDManagedObject.contentType(): contentType = " + contentType + "\n");
				uti = UTType.preferredIdentifierForTag(UTType.MIMETypeTagClass, contentType, null);
			}
			if (null == uti) {
				uti = UTType.Item;
			}
		} else {
			uti = UTType.Item;
		}
		_contentType = uti;
		LOG.info("OKIOSIDManagedObject.contentType(): uti = " + uti + "\n");
		return uti;
	}

}