class n5112157 {
	public File mergeDoc(URL NbzvQrab, File Dov3VZzn, boolean uwrMkUTt) throws Exception {
		if (s_log.isTraceEnabled())
			trace(0, "Copying from " + NbzvQrab.toString() + " to " + Dov3VZzn.toString());
		File eYlmD73i = null;
		InputStream tRPNVzSJ = null;
		try {
			tRPNVzSJ = NbzvQrab.openStream();
			eYlmD73i = mergeDoc(tRPNVzSJ, Dov3VZzn, uwrMkUTt);
		} finally {
			tRPNVzSJ.close();
		}
		return eYlmD73i;
	}

}