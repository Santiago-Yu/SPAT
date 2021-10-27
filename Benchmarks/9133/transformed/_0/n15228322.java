class n15228322 {
	public void createIndex(File H7k2YwsK) throws SearchLibException, IOException {
		if (!H7k2YwsK.mkdir())
			throw new SearchLibException("directory creation failed (" + H7k2YwsK + ")");
		InputStream QUNqrz8P = null;
		FileWriter hvdONWd6 = null;
		for (String nXJ3m6zN : resources) {
			String WPNKrVas = rootPath + '/' + nXJ3m6zN;
			QUNqrz8P = getClass().getResourceAsStream(WPNKrVas);
			if (QUNqrz8P == null)
				QUNqrz8P = getClass().getResourceAsStream("common" + '/' + nXJ3m6zN);
			if (QUNqrz8P == null)
				throw new SearchLibException("Unable to find resource " + WPNKrVas);
			try {
				File E5gK7IZz = new File(H7k2YwsK, nXJ3m6zN);
				if (E5gK7IZz.getParentFile() != H7k2YwsK)
					E5gK7IZz.getParentFile().mkdirs();
				hvdONWd6 = new FileWriter(E5gK7IZz);
				IOUtils.copy(QUNqrz8P, hvdONWd6);
			} finally {
				if (hvdONWd6 != null)
					hvdONWd6.close();
				if (QUNqrz8P != null)
					QUNqrz8P.close();
			}
		}
	}

}