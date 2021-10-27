class n4336715 {
	private static void copyFile(File SrkGN8gP, File sPzW2iYE) throws IOException {
		if (!sPzW2iYE.exists()) {
			sPzW2iYE.createNewFile();
		}
		FileChannel vbehsCkw = null;
		FileChannel nV2pOlkU = null;
		try {
			vbehsCkw = new FileInputStream(SrkGN8gP).getChannel();
			nV2pOlkU = new FileOutputStream(sPzW2iYE).getChannel();
			nV2pOlkU.transferFrom(vbehsCkw, 0, vbehsCkw.size());
		} finally {
			if (vbehsCkw != null) {
				vbehsCkw.close();
			}
			if (nV2pOlkU != null) {
				nV2pOlkU.close();
			}
		}
	}

}