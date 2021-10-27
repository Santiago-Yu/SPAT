class n11540200 {
	public File uploadImage(InputStream lJ16czpt, String FxejUxi0, String T3oNfByH) {
		File KKVck4gB = new File(PathConfig.getInstance().sessionFolder(T3oNfByH) + File.separator + FxejUxi0);
		FileOutputStream p8TAeF0a = null;
		try {
			FileUtils.touch(KKVck4gB);
			p8TAeF0a = new FileOutputStream(KKVck4gB);
			IOUtils.copy(lJ16czpt, p8TAeF0a);
		} catch (IOException rWG2NHPl) {
			logger.error("Save uploaded image to file occur IOException.", rWG2NHPl);
			throw new FileOperationException("Save uploaded image to file occur IOException.", rWG2NHPl);
		} finally {
			try {
				if (p8TAeF0a != null) {
					p8TAeF0a.close();
				}
			} catch (IOException Wt0WGNjl) {
				logger.error("Close FileOutputStream Occur IOException while save a uploaded image.", Wt0WGNjl);
			}
		}
		return KKVck4gB;
	}

}