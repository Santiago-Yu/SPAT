class n1881370 {
	public InputStream getFileStream(String ecFBA3LB) {
		if (this.inJar) {
			try {
				URL EqKz0CNs = getClassResourceUrl(this.getClass(), ecFBA3LB);
				if (EqKz0CNs != null) {
					return EqKz0CNs.openStream();
				}
			} catch (IOException B6ZEeiRe) {
				Debug.signal(Debug.ERROR, this, B6ZEeiRe);
			}
		} else {
			try {
				return new FileInputStream(ecFBA3LB);
			} catch (FileNotFoundException OXNNWFtz) {
				Debug.signal(Debug.ERROR, this, OXNNWFtz);
			}
		}
		return null;
	}

}