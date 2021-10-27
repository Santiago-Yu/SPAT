class n1126225 {
	@SuppressWarnings("null")
	public static void copyFile(File oXxsWKTw, File woVGh7xu) throws IOException {
		if (!woVGh7xu.getParentFile().exists()) {
			woVGh7xu.getParentFile().mkdirs();
		}
		woVGh7xu.createNewFile();
		FileChannel ooNWAbMr = null;
		FileChannel z8MRAla8 = null;
		try {
			ooNWAbMr = new FileInputStream(oXxsWKTw).getChannel();
			z8MRAla8 = new FileOutputStream(woVGh7xu).getChannel();
			z8MRAla8.transferFrom(ooNWAbMr, 0, ooNWAbMr.size());
		} finally {
			try {
				if (woVGh7xu != null) {
					z8MRAla8.close();
				}
			} catch (Exception FHJEXruC) {
				FHJEXruC.printStackTrace();
			}
			try {
				if (oXxsWKTw != null) {
					ooNWAbMr.close();
				}
			} catch (Exception ePi24ZRm) {
				ePi24ZRm.printStackTrace();
			}
		}
	}

}