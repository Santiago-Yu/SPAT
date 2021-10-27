class n20085210 {
	public static void copyFile(File YQENBv4z, File i40aqu04) throws IOException {
		if (!i40aqu04.exists()) {
			i40aqu04.createNewFile();
		}
		FileChannel ahAYDTXr = null;
		FileChannel T6zoscIp = null;
		try {
			ahAYDTXr = new FileInputStream(YQENBv4z).getChannel();
			T6zoscIp = new FileOutputStream(i40aqu04).getChannel();
			T6zoscIp.transferFrom(ahAYDTXr, 0, ahAYDTXr.size());
		} finally {
			if (ahAYDTXr != null) {
				ahAYDTXr.close();
			}
			if (T6zoscIp != null) {
				T6zoscIp.close();
			}
		}
	}

}