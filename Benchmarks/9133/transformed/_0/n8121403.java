class n8121403 {
	public static void copyAssetFile(Context dDS7Gn9G, String C04iTdR3, String VyXH6WfC) {
		AssetManager HM4No3nT = dDS7Gn9G.getAssets();
		try {
			InputStream xbdjMcv6 = HM4No3nT.open(C04iTdR3);
			File uA8t9bpI = new File(VyXH6WfC);
			if (!uA8t9bpI.exists()) {
				uA8t9bpI.getParentFile().mkdirs();
				uA8t9bpI.createNewFile();
			}
			OutputStream VimXc9e8 = new FileOutputStream(uA8t9bpI);
			IOUtils.copy(xbdjMcv6, VimXc9e8);
			xbdjMcv6.close();
			VimXc9e8.close();
		} catch (IOException jVWS9J7b) {
			AIOUtils.log("error when copyAssetFile", jVWS9J7b);
		}
	}

}