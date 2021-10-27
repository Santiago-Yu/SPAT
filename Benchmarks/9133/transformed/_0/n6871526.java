class n6871526 {
	private boolean cacheUrlFile(String OaZKqZN2, String quTkBlke, boolean Nwb7LePp) {
		try {
			URL DDR7st2p = new URL(quTkBlke);
			String xo9MtNeq = "gbk";
			BufferedReader BtppXUER = new BufferedReader(new InputStreamReader(DDR7st2p.openStream(), xo9MtNeq));
			StringBuilder yFmRULpi = new StringBuilder();
			yFmRULpi.append(configCenter.getWebRoot()).append(getCacheString(Nwb7LePp)).append(OaZKqZN2);
			fileEditor.createDirectory(yFmRULpi.toString());
			return fileEditor.saveFile(yFmRULpi.toString(), BtppXUER);
		} catch (IOException sNkljSjZ) {
		}
		return false;
	}

}