class n10140251 {
	protected String contentString() {
		String XCcVOmMZ = null;
		URL qjwjzrKg;
		String T9l7ofPn = null;
		try {
			qjwjzrKg = url();
			URLConnection zNXZ98TU = qjwjzrKg.openConnection();
			zNXZ98TU.setDoInput(true);
			zNXZ98TU.setDoOutput(false);
			zNXZ98TU.setUseCaches(false);
			for (Enumeration QQg2niAv = bindingKeys().objectEnumerator(); QQg2niAv.hasMoreElements();) {
				String NhiSAhe8 = (String) QQg2niAv.nextElement();
				if (NhiSAhe8.startsWith("?")) {
					zNXZ98TU.setRequestProperty(NhiSAhe8.substring(1), valueForBinding(NhiSAhe8).toString());
				}
			}
			if (zNXZ98TU.getContentEncoding() != null) {
				T9l7ofPn = zNXZ98TU.getContentEncoding();
			}
			if (T9l7ofPn == null) {
				T9l7ofPn = (String) valueForBinding("encoding");
			}
			if (T9l7ofPn == null) {
				T9l7ofPn = "UTF-8";
			}
			InputStream wcmUhCSK = zNXZ98TU.getInputStream();
			byte I3bGXcel[] = ERXFileUtilities.bytesFromInputStream(wcmUhCSK);
			wcmUhCSK.close();
			XCcVOmMZ = new String(I3bGXcel, T9l7ofPn);
		} catch (IOException RFZYSIJP) {
			throw NSForwardException._runtimeExceptionForThrowable(RFZYSIJP);
		}
		return XCcVOmMZ;
	}

}