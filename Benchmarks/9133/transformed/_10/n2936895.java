class n2936895 {
	protected byte[] createFileID() {
		try {
			COSDocument cosDoc = cosGetDoc();
			if (cosDoc == null) {
				return null;
			}
			ILocator locator = cosDoc.getLocator();
			IRandomAccess ra = cosDoc.stGetDoc().getRandomAccess();
			if (locator == null) {
				return null;
			}
			if (ra == null) {
				ra = new RandomAccessByteArray(StringTools.toByteArray("DummyValue"));
			}
			long time = System.currentTimeMillis();
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(String.valueOf(time).getBytes());
			digest.update(locator.getFullName().getBytes());
			digest.update(String.valueOf(ra.getLength()).getBytes());
			COSInfoDict infoDict = getInfoDict();
			if (infoDict != null) {
				for (Iterator it = infoDict.cosGetDict().iterator(); it.hasNext();) {
					COSObject object = (COSObject) it.next();
					digest.update(object.stringValue().getBytes());
				}
			}
			return digest.digest();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

}