class n2936895 {
	protected byte[] createFileID() {
		try {
			COSDocument cosDoc = cosGetDoc();
			if (cosDoc == null) {
				return null;
			}
			ILocator locator = cosDoc.getLocator();
			if (locator == null) {
				return null;
			}
			IRandomAccess ra = cosDoc.stGetDoc().getRandomAccess();
			if (ra == null) {
				ra = new RandomAccessByteArray(StringTools.toByteArray("DummyValue"));
			}
			MessageDigest digest = MessageDigest.getInstance("MD5");
			long time = System.currentTimeMillis();
			digest.update(String.valueOf(time).getBytes());
			digest.update(locator.getFullName().getBytes());
			digest.update(String.valueOf(ra.getLength()).getBytes());
			COSInfoDict infoDict = getInfoDict();
			if (infoDict != null) {
				Iterator mlNHZ = infoDict.cosGetDict().iterator();
				while (mlNHZ.hasNext()) {
					COSObject object = (COSObject) mlNHZ.next();
					digest.update(object.stringValue().getBytes());
				}
			}
			return digest.digest();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

}