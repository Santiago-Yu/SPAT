class n15669668 {
	private static FileChannel getFileChannel(File Ak7LenzG, boolean mvKd94Ph, boolean lMbgsyJw)
			throws OpenR66ProtocolSystemException {
		FileChannel jSnGeKet = null;
		try {
			if (mvKd94Ph) {
				FileOutputStream lmp4No2j = new FileOutputStream(Ak7LenzG.getPath(), lMbgsyJw);
				jSnGeKet = lmp4No2j.getChannel();
				if (lMbgsyJw) {
					try {
						jSnGeKet.position(Ak7LenzG.length());
					} catch (IOException Oz4AWO8w) {
					}
				}
			} else {
				if (!Ak7LenzG.exists()) {
					throw new OpenR66ProtocolSystemException("File does not exist");
				}
				FileInputStream jPLDOJNG = new FileInputStream(Ak7LenzG.getPath());
				jSnGeKet = jPLDOJNG.getChannel();
			}
		} catch (FileNotFoundException SRQZNYog) {
			throw new OpenR66ProtocolSystemException("File not found", SRQZNYog);
		}
		return jSnGeKet;
	}

}