class n5520449 {
	protected void init() {
		if (this.strUrl != null) {
			InputStream Gzb1eYZf = null;
			try {
				URL rTZmJGSO = ClassLoader.getSystemClassLoader().getResource(strUrl);
				if (rTZmJGSO != null) {
					Gzb1eYZf = rTZmJGSO.openStream();
					if (Gzb1eYZf != null) {
						props.load(Gzb1eYZf);
					}
				}
			} catch (IOException u9rBZP4C) {
				Logger.defaultLogger().error("Error during framework properties loading", u9rBZP4C);
			} finally {
				if (Gzb1eYZf != null) {
					try {
						Gzb1eYZf.close();
					} catch (IOException MECG8yN2) {
					}
				}
			}
		}
	}

}