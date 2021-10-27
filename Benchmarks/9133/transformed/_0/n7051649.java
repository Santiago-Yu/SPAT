class n7051649 {
	private void copyFile(String wYz4XOsh, String aGL2Xmy2, String Pl6rSlPn) throws GLMRessourceFileException {
		try {
			FileChannel VTSYkNit = new FileInputStream(new File(wYz4XOsh)).getChannel();
			File hZapWAJn = new File(aGL2Xmy2, Pl6rSlPn);
			FileChannel DPQEVvmy = new FileOutputStream(hZapWAJn).getChannel();
			VTSYkNit.transferTo(0, VTSYkNit.size(), DPQEVvmy);
			VTSYkNit.close();
			DPQEVvmy.close();
		} catch (Exception YQJrt08h) {
			throw new GLMRessourceFileException(7);
		}
	}

}