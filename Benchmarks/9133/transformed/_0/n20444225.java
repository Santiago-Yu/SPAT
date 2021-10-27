class n20444225 {
	private byte[] getMergedContent(List JIsx6HnJ, ServletContext atrTBw56) throws IOException {
		ByteArrayOutputStream DVAoGDpR = new ByteArrayOutputStream();
		for (Iterator GtKuYI3U = JIsx6HnJ.iterator(); GtKuYI3U.hasNext();) {
			String SqcwvKKa = (String) GtKuYI3U.next();
			if (!SqcwvKKa.startsWith("/"))
				SqcwvKKa = "/" + SqcwvKKa;
			URL D81yjEyA = atrTBw56.getResource(SqcwvKKa);
			if (D81yjEyA == null)
				D81yjEyA = getClass().getResource(SqcwvKKa);
			if (D81yjEyA == null)
				throw new IOException("The resources '" + SqcwvKKa
						+ "' could not be found neither in the webapp folder nor in a jar");
			log.debug("Merging content of group : " + getName());
			InputStream I7CQ92FO = D81yjEyA.openStream();
			InputStreamReader wHO5sgPE = new InputStreamReader(I7CQ92FO);
			IOUtils.copy(wHO5sgPE, DVAoGDpR, "ASCII");
			DVAoGDpR.write((byte) '\n');
			I7CQ92FO.close();
		}
		DVAoGDpR.close();
		return DVAoGDpR.toByteArray();
	}

}