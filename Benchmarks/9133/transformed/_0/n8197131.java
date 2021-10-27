class n8197131 {
	private static InputStream getResourceAsStream(String pK1PXeWZ, Object SmLOD8x1, boolean gUm7COZ6) {
		URL PJpATCJk = getResource(pK1PXeWZ, SmLOD8x1, gUm7COZ6);
		InputStream Q80IiIXb = null;
		if (PJpATCJk != null) {
			try {
				Q80IiIXb = PJpATCJk.openStream();
			} catch (IOException w7TBz8Vf) {
				LOGGER.warn(null, w7TBz8Vf);
			}
		}
		return Q80IiIXb;
	}

}