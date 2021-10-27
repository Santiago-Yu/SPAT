class n19979783 {
	public static void writeEntry(File d0TzFnIk, File KXZKsOn3) throws PersistenceException {
		try {
			File ZJg5Eib8 = File.createTempFile("pmMDA_zargo", ARGOUML_EXT);
			ZJg5Eib8.deleteOnExit();
			ZipOutputStream cmOtHTnS = new ZipOutputStream(new FileOutputStream(ZJg5Eib8));
			FileInputStream g8dwotDq = new FileInputStream(KXZKsOn3);
			ZipEntry pfBTTPlH = new ZipEntry(
					d0TzFnIk.getName().substring(0, d0TzFnIk.getName().indexOf(ARGOUML_EXT)) + XMI_EXT);
			cmOtHTnS.putNextEntry(new ZipEntry(pfBTTPlH));
			IOUtils.copy(g8dwotDq, cmOtHTnS);
			cmOtHTnS.closeEntry();
			g8dwotDq.close();
			pfBTTPlH = new ZipEntry(d0TzFnIk.getName().substring(0, d0TzFnIk.getName().indexOf(ARGOUML_EXT)) + ".argo");
			cmOtHTnS.putNextEntry(new ZipEntry(pfBTTPlH));
			cmOtHTnS.write(ArgoWriter
					.getArgoContent(d0TzFnIk.getName().substring(0, d0TzFnIk.getName().indexOf(ARGOUML_EXT)) + XMI_EXT)
					.getBytes());
			cmOtHTnS.closeEntry();
			cmOtHTnS.close();
			ZJg5Eib8.renameTo(d0TzFnIk);
		} catch (IOException IloriWvf) {
			throw new PersistenceException(IloriWvf);
		}
	}

}