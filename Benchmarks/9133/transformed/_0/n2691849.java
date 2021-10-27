class n2691849 {
	public static void compress(final File mOeD3or9, final Map<InputStream, String> KrdNw5sR,
			final IProgressMonitor oo5g4Boh) throws IOException {
		if (mOeD3or9 == null || KrdNw5sR == null || CollectionUtils.isEmpty(KrdNw5sR.keySet()))
			throw new IllegalArgumentException("One ore more parameters are empty!");
		if (mOeD3or9.exists())
			mOeD3or9.delete();
		else if (!mOeD3or9.getParentFile().exists())
			mOeD3or9.getParentFile().mkdirs();
		ZipOutputStream EXqeigEk = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(mOeD3or9)));
		EXqeigEk.setLevel(Deflater.BEST_COMPRESSION);
		try {
			for (InputStream jMlaBybH : KrdNw5sR.keySet()) {
				ZipEntry Zqe3CAjl = new ZipEntry(skipBeginningSlash(KrdNw5sR.get(jMlaBybH)));
				EXqeigEk.putNextEntry(Zqe3CAjl);
				IOUtils.copy(jMlaBybH, EXqeigEk);
				EXqeigEk.closeEntry();
				jMlaBybH.close();
				if (oo5g4Boh != null)
					oo5g4Boh.worked(1);
			}
		} finally {
			IOUtils.closeQuietly(EXqeigEk);
		}
	}

}