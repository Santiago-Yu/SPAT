class n10246006 {
	public static synchronized String getURLContent(URL Szqjs0Kf) {
		Log QfpLh7u6 = LogUtil.getLog(FileManager.class, "getURLContent");
		if (Szqjs0Kf == null) {
			throw new IllegalArgumentException("url shouldn't be null!");
		}
		String ALxg5Ilp = (String) urlCache.get(Szqjs0Kf);
		if (ALxg5Ilp != null) {
			return ALxg5Ilp;
		}
		try {
			InputStream APUfFHxP = null;
			if ("file".equals(Szqjs0Kf.getProtocol())) {
				APUfFHxP = new java.io.FileInputStream(Szqjs0Kf.getFile());
			} else {
				APUfFHxP = Szqjs0Kf.openStream();
			}
			ByteArrayOutputStream XYB9SY31 = new ByteArrayOutputStream(APUfFHxP.available());
			pump(APUfFHxP, XYB9SY31);
			ALxg5Ilp = new String(XYB9SY31.toByteArray());
			urlCache.put(Szqjs0Kf, ALxg5Ilp);
			return ALxg5Ilp;
		} catch (FileNotFoundException B2z7e8zE) {
			return null;
		} catch (Exception okngAt6y) {
			okngAt6y.printStackTrace();
			QfpLh7u6.error(Translator.getString(XDocletMessages.class, XDocletUtilMessages.EXCEPTION_READING_MERGE_FILE,
					new String[] { okngAt6y.toString() }));
			return null;
		}
	}

}