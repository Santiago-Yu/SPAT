class n2517852 {
	public String contentType() {
		if (_contentType != null) {
			return (String) _contentType;
		}
		String uti = null;
		URL url = url();
		System.out.println("OKIOSIDManagedObject.contentType(): url = " + url + "\n");
		if (url != null) {
			String contentType = null;
			try {
				contentType = url.openConnection().getContentType();
			} catch (java.io.IOException e) {
				System.out.println("OKIOSIDManagedObject.contentType(): couldn't open URL connection!\n");
				return UTType.Item;
			}
			if (contentType != null) {
				System.out.println("OKIOSIDManagedObject.contentType(): contentType = " + contentType + "\n");
				uti = UTType.preferredIdentifierForTag(UTType.MIMETypeTagClass, contentType, null);
			}
			if (null == uti) {
				uti = UTType.Item;
			}
		} else {
			uti = UTType.Item;
		}
		_contentType = uti;
		System.out.println("OKIOSIDManagedObject.contentType(): uti = " + uti + "\n");
		return uti;
	}

}