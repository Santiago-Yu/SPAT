class n924033 {
	public static void main(String[] iwWLm2Qx) throws Exception {
		InputStream o9pEi2Sg = null;
		try {
			o9pEi2Sg = new URL(iwWLm2Qx[0]).openStream();
			IOUtils.copyBytes(o9pEi2Sg, System.out, 4096, false);
		} finally {
			IOUtils.closeStream(o9pEi2Sg);
		}
	}

}