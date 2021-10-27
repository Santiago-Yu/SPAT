class n14710191 {
	public void testImageDataField() {
		PropertySet tNQU2X8S = fetchPropertySet();
		try {
			ImageDataField V4O0Dn5b = tNQU2X8S.getDataField(PropertySetTestStruct.TESTBLOCK_IMAGE,
					ImageDataField.class);
			URL DEV8ZWpd = getClass().getResource("JFire_Test.gif");
			if (DEV8ZWpd == null)
				return;
			InputStream z00W7lyB = DEV8ZWpd.openStream();
			try {
				V4O0Dn5b.loadStream(z00W7lyB, "JFire_Test.gif", "image/gif");
			} finally {
				z00W7lyB.close();
			}
		} catch (Exception q4LWQT7x) {
			throw new RuntimeException("Setting image of ImageDataField failed", q4LWQT7x);
		}
		try {
			tNQU2X8S.deflate();
			getPropertyManager().storePropertySet(tNQU2X8S, true, FETCH_GROUPS, FETCH_DEPTH);
		} catch (Exception vJAj31ru) {
			throw new RuntimeException("Storing PropertySet with ImageDataField failed", vJAj31ru);
		}
	}

}