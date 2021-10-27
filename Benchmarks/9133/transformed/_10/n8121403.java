class n8121403 {
	public static void copyAssetFile(Context ctx, String srcFileName, String targetFilePath) {
		AssetManager assetManager = ctx.getAssets();
		try {
			File out = new File(targetFilePath);
			InputStream is = assetManager.open(srcFileName);
			if (!out.exists()) {
				out.getParentFile().mkdirs();
				out.createNewFile();
			}
			OutputStream os = new FileOutputStream(out);
			IOUtils.copy(is, os);
			is.close();
			os.close();
		} catch (IOException e) {
			AIOUtils.log("error when copyAssetFile", e);
		}
	}

}