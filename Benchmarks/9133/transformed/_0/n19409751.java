class n19409751 {
	public static void compress(final File Wo5ynJO4, final Map<InputStream, String> hmBw9XKW) throws IOException {
		if (Wo5ynJO4 == null || hmBw9XKW == null || CollectionUtils.isEmpty(hmBw9XKW.keySet()))
			throw new IllegalArgumentException("One ore more parameters are empty!");
		if (Wo5ynJO4.exists())
			Wo5ynJO4.delete();
		else if (!Wo5ynJO4.getParentFile().exists())
			Wo5ynJO4.getParentFile().mkdirs();
		ZipOutputStream nDddvKuV = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(Wo5ynJO4)));
		nDddvKuV.setLevel(Deflater.BEST_COMPRESSION);
		InputStream Titm7a9R = null;
		try {
			for (InputStream wtHZ81cX : hmBw9XKW.keySet()) {
				Titm7a9R = wtHZ81cX;
				ZipEntry EkaxPNmy = new ZipEntry(skipBeginningSlash(hmBw9XKW.get(Titm7a9R)));
				nDddvKuV.putNextEntry(EkaxPNmy);
				IOUtils.copy(Titm7a9R, nDddvKuV);
				nDddvKuV.closeEntry();
				Titm7a9R.close();
			}
		} finally {
			IOUtils.closeQuietly(Titm7a9R);
			IOUtils.closeQuietly(nDddvKuV);
		}
	}

}