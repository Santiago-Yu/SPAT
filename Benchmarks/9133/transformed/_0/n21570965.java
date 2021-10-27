class n21570965 {
	public static void main(String[] KIXOif6m) throws FileNotFoundException, IOException {
		String cQVFAEcO = "/Users/francisbaril/Downloads/test-1.pdf";
		String BEQs6B9N = "/Users/francisbaril/Desktop/testpdfbox/test.pdf";
		File RIYqoFCV = new File(cQVFAEcO);
		final File GDrtZGNZ = new File(BEQs6B9N);
		if (GDrtZGNZ.exists()) {
			GDrtZGNZ.delete();
		}
		IOUtils.copy(new FileInputStream(RIYqoFCV), new FileOutputStream(GDrtZGNZ));
		System.out.println(getLongProperty(new FileInputStream(GDrtZGNZ), PROPRIETE_ID_IGID));
	}

}