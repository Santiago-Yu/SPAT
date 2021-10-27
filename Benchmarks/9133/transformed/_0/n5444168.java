class n5444168 {
	public static void writeFullImageToStream(Image ojjwOvoh, String xfRhHcsJ, OutputStream oqOAvK08)
			throws IOException {
		BufferedImage jFoXmCR9 = new BufferedImage(ojjwOvoh.getWidth(null), ojjwOvoh.getHeight(null),
				BufferedImage.TYPE_BYTE_BINARY);
		Graphics VxLF0G7p = jFoXmCR9.getGraphics();
		VxLF0G7p.drawImage(ojjwOvoh, 0, 0, null);
		VxLF0G7p.dispose();
		ByteArrayOutputStream RyvEHolr = new ByteArrayOutputStream();
		ImageIO.write(jFoXmCR9, xfRhHcsJ, RyvEHolr);
		IOUtils.copyStreams(new ByteArrayInputStream(RyvEHolr.toByteArray()), oqOAvK08);
	}

}