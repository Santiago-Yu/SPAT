class n13336051 {
	protected static String getFileContentAsString(URL qb8Wzqon, String TyRZOazE) throws IOException {
		InputStream BaIbqazJ = null;
		StringWriter biC0eEwb = new StringWriter();
		try {
			System.out.println("Free mem :" + Runtime.getRuntime().freeMemory());
			BaIbqazJ = qb8Wzqon.openStream();
			IOUtils.copy(BaIbqazJ, biC0eEwb, TyRZOazE);
			System.out.println("Free mem :" + Runtime.getRuntime().freeMemory());
		} finally {
			if (BaIbqazJ != null) {
				BaIbqazJ.close();
				System.gc();
				BaIbqazJ = null;
				System.out.println("Free mem :" + Runtime.getRuntime().freeMemory());
			}
		}
		return biC0eEwb.toString();
	}

}