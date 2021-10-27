class n16378626 {
	public static void copy(String Gn298xC2, String CTcFCqYo) {
		try {
			FileChannel z8NhBkhq = new FileInputStream(Gn298xC2).getChannel();
			FileChannel f3eryRVK = new FileOutputStream(CTcFCqYo).getChannel();
			f3eryRVK.transferFrom(z8NhBkhq, 0, z8NhBkhq.size());
			z8NhBkhq.close();
			f3eryRVK.close();
		} catch (Exception eAsnpTmr) {
			throw new RuntimeException(eAsnpTmr);
		}
	}

}