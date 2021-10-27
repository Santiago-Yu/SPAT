class n19944975 {
	public void writeConfiguration(Writer k2RLtloV) throws IOException {
		if (myResource == null) {
			k2RLtloV.append("# Unable to print configuration resource\n");
		} else {
			URL XL5IbjoU = myResource.getUrl();
			InputStream qzQZQYIJ = XL5IbjoU.openStream();
			if (qzQZQYIJ != null) {
				try {
					IOUtils.copy(qzQZQYIJ, k2RLtloV);
				} finally {
					IOUtils.closeQuietly(qzQZQYIJ);
				}
			} else {
				k2RLtloV.append("# Unable to print configuration resource\n");
			}
		}
	}

}