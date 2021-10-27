class n2517852 {
	public String contentType() {
		if (_contentType != null) {
			return (String) _contentType;
		}
		String ATt4S3zL = null;
		URL cDQ5sbhs = url();
		System.out.println("OKIOSIDManagedObject.contentType(): url = " + cDQ5sbhs + "\n");
		if (cDQ5sbhs != null) {
			String EcKUdx2D = null;
			try {
				EcKUdx2D = cDQ5sbhs.openConnection().getContentType();
			} catch (java.io.IOException HRJ6f1WV) {
				System.out.println("OKIOSIDManagedObject.contentType(): couldn't open URL connection!\n");
				return UTType.Item;
			}
			if (EcKUdx2D != null) {
				System.out.println("OKIOSIDManagedObject.contentType(): contentType = " + EcKUdx2D + "\n");
				ATt4S3zL = UTType.preferredIdentifierForTag(UTType.MIMETypeTagClass, EcKUdx2D, null);
			}
			if (ATt4S3zL == null) {
				ATt4S3zL = UTType.Item;
			}
		} else {
			ATt4S3zL = UTType.Item;
		}
		_contentType = ATt4S3zL;
		System.out.println("OKIOSIDManagedObject.contentType(): uti = " + ATt4S3zL + "\n");
		return ATt4S3zL;
	}

}