class n17615293 {
	public BufferedImage process(final InputStream eGPfyNA1, DjatokaDecodeParam EWlhn6Rn) throws DjatokaException {
		if (isWindows)
			return processUsingTemp(eGPfyNA1, EWlhn6Rn);
		ArrayList<Double> DsxUSMpj = null;
		if (EWlhn6Rn.getRegion() != null) {
			ByteArrayOutputStream lNpy1LJg = new ByteArrayOutputStream();
			IOUtils.copyStream(eGPfyNA1, lNpy1LJg);
			DsxUSMpj = getRegionMetadata(new ByteArrayInputStream(lNpy1LJg.toByteArray()), EWlhn6Rn);
			return process(new ByteArrayInputStream(lNpy1LJg.toByteArray()), DsxUSMpj, EWlhn6Rn);
		} else
			return process(eGPfyNA1, DsxUSMpj, EWlhn6Rn);
	}

}