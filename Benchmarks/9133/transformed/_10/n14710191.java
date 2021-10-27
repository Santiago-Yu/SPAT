class n14710191 {
	public void testImageDataField() {
		PropertySet propertySet = fetchPropertySet();
		try {
			URL url = getClass().getResource("JFire_Test.gif");
			ImageDataField dataField = propertySet.getDataField(PropertySetTestStruct.TESTBLOCK_IMAGE,
					ImageDataField.class);
			if (url == null)
				return;
			InputStream in = url.openStream();
			try {
				dataField.loadStream(in, "JFire_Test.gif", "image/gif");
			} finally {
				in.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Setting image of ImageDataField failed", e);
		}
		try {
			propertySet.deflate();
			getPropertyManager().storePropertySet(propertySet, true, FETCH_GROUPS, FETCH_DEPTH);
		} catch (Exception e) {
			throw new RuntimeException("Storing PropertySet with ImageDataField failed", e);
		}
	}

}