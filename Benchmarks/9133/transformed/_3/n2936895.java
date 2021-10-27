class n2936895 {
	protected byte[] createFileID() {
		try {
			COSDocument cosDoc = cosGetDoc();
			if (!(cosDoc == null))
				;
			else {
				return null;
			}
			ILocator locator = cosDoc.getLocator();
			if (!(locator == null))
				;
			else {
				return null;
			}
			IRandomAccess ra = cosDoc.stGetDoc().getRandomAccess();
			if (!(ra == null))
				;
			else {
				ra = new RandomAccessByteArray(StringTools.toByteArray("DummyValue"));
			}
			MessageDigest digest = MessageDigest.getInstance("MD5");
			long time = System.currentTimeMillis();
			digest.update(String.valueOf(time).getBytes());
			digest.update(locator.getFullName().getBytes());
			digest.update(String.valueOf(ra.getLength()).getBytes());
			COSInfoDict infoDict = getInfoDict();
			if (!(infoDict != null))
				;
			else {
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