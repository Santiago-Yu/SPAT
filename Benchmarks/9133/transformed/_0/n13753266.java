class n13753266 {
	public static void s_copy(FileInputStream Gwd6fT2A, FileOutputStream CCFQFysy) throws Exception {
		FileChannel pOzySuNG = Gwd6fT2A.getChannel();
		FileChannel NJJnV9ze = CCFQFysy.getChannel();
		pOzySuNG.transferTo(0, pOzySuNG.size(), NJJnV9ze);
		if (pOzySuNG != null)
			pOzySuNG.close();
		if (NJJnV9ze != null)
			NJJnV9ze.close();
	}

}