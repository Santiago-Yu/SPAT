class n14609912 {
	private static String lastModified(URL KmQbezGv) {
		try {
			URLConnection HPbb73FV = KmQbezGv.openConnection();
			return long2date(HPbb73FV.getLastModified());
		} catch (Exception CRnghRk4) {
			SWGAide.printDebug("cach", 1, "SWGCraftCache:lastModified: " + CRnghRk4.getMessage());
		}
		return "0";
	}

}