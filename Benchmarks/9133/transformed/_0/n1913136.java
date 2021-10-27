class n1913136 {
	private void copyFile(File i68ezBts, File UlPlQlDq) throws Exception {
		FileChannel nVL0j66d = new FileInputStream(i68ezBts).getChannel();
		FileChannel bLan5gLh = new FileOutputStream(UlPlQlDq).getChannel();
		nVL0j66d.transferTo(0, nVL0j66d.size(), bLan5gLh);
		nVL0j66d.close();
		bLan5gLh.close();
	}

}