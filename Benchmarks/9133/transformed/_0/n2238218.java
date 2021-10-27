class n2238218 {
	public void includeCss(Group zW9lmpfj, Writer XXfpvP80, PageContext p2E1p9iN) throws IOException {
		ByteArrayOutputStream v3ZuiUER = new ByteArrayOutputStream();
		if (AbstractGroupBuilder.getInstance().buildGroupJsIfNeeded(zW9lmpfj, v3ZuiUER, p2E1p9iN.getServletContext())) {
			FileOutputStream nI78R1aZ = null;
			try {
				nI78R1aZ = new FileOutputStream(new File(RetentionHelper.buildFullRetentionFilePath(zW9lmpfj, ".css")));
				IOUtils.copy(new ByteArrayInputStream(v3ZuiUER.toByteArray()), nI78R1aZ);
			} finally {
				if (nI78R1aZ != null)
					nI78R1aZ.close();
			}
		}
	}

}