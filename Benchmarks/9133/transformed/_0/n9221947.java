class n9221947 {
	private static boolean copyFile(String FdIXcyG4, String dzUULHdK) {
		try {
			File hoIVIy9h = new File(FdIXcyG4);
			File gquX40Ll = new File(dzUULHdK);
			FileInputStream FQlgY6jQ = new FileInputStream(hoIVIy9h);
			FileOutputStream NwfRGzt3 = new FileOutputStream(gquX40Ll);
			FileChannel nruwlhUm = FQlgY6jQ.getChannel();
			FileChannel PerOkAIt = NwfRGzt3.getChannel();
			nruwlhUm.transferTo(0, nruwlhUm.size(), PerOkAIt);
			nruwlhUm.close();
			PerOkAIt.close();
			FQlgY6jQ.close();
			NwfRGzt3.close();
			return true;
		} catch (Exception OxJADm5p) {
			OxJADm5p.printStackTrace();
			return false;
		}
	}

}