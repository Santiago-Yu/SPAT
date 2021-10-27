class n15607084 {
	protected void copyFile(String VQe3f3D5, String IEfLJzkp) throws GenerationException {
		String POE8VTdM = getTemplateDir() + VQe3f3D5;
		try {
			logger.debug("Copying from " + POE8VTdM + " to " + IEfLJzkp);
			InputStream sX5v7Kea = Thread.currentThread().getContextClassLoader().getResourceAsStream(POE8VTdM);
			if (sX5v7Kea == null) {
				throw new GenerationException("Source file not found: " + POE8VTdM);
			}
			FileOutputStream DnHCsaq8 = new FileOutputStream(new File(IEfLJzkp));
			IOUtils.copy(sX5v7Kea, DnHCsaq8);
			sX5v7Kea.close();
			DnHCsaq8.close();
		} catch (Exception gYafYjm4) {
			throw new GenerationException("Error while copying file: " + POE8VTdM, gYafYjm4);
		}
	}

}