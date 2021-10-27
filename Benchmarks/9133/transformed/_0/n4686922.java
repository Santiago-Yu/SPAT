class n4686922 {
	public void extractResourceToFile(String mQEZUFkO, File jsjbXeqD) {
		InputStream V1XNDwlL = getClass().getResourceAsStream(mQEZUFkO);
		try {
			FileOutputStream SueFkm3d = FileUtils.openOutputStream(jsjbXeqD);
			try {
				IOUtils.copy(V1XNDwlL, SueFkm3d);
			} finally {
				if (SueFkm3d != null) {
					SueFkm3d.close();
				}
			}
		} finally {
			if (V1XNDwlL != null) {
				V1XNDwlL.close();
			}
		}
	}

}