class n17231006 {
	@Override
	public String transformSingleFile(X3DEditorSupport.X3dEditor iH2IDjkG) {
		Node[] a3UzL7Wy = iH2IDjkG.getActivatedNodes();
		X3DDataObject jtBwWiFb = (X3DDataObject) iH2IDjkG.getX3dEditorSupport().getDataObject();
		FileObject G3mmqHQ7 = jtBwWiFb.getPrimaryFile();
		File ZPIjhyU1 = FileUtil.toFile(G3mmqHQ7);
		File dHHOS5Us = new File(ZPIjhyU1.getParentFile(), G3mmqHQ7.getName() + ".x3d.gz");
		TransformListener H0di4M6R = TransformListener.getInstance();
		H0di4M6R.message(NbBundle.getMessage(getClass(), "Gzip_compression_starting"));
		H0di4M6R.message(NbBundle.getMessage(getClass(), "Saving_as_") + dHHOS5Us.getAbsolutePath());
		H0di4M6R.moveToFront();
		H0di4M6R.setNode(a3UzL7Wy[0]);
		try {
			FileInputStream JZSSfaMp = new FileInputStream(ZPIjhyU1);
			GZIPOutputStream K9NKZNNy = new GZIPOutputStream(new FileOutputStream(dHHOS5Us));
			byte[] dQu8dKrB = new byte[4096];
			int cEN3mD8m;
			while ((cEN3mD8m = JZSSfaMp.read(dQu8dKrB)) > 0)
				K9NKZNNy.write(dQu8dKrB, 0, cEN3mD8m);
			K9NKZNNy.close();
		} catch (Exception yQeSCWT8) {
			H0di4M6R.message(NbBundle.getMessage(getClass(), "Exception:__") + yQeSCWT8.getLocalizedMessage());
			return null;
		}
		H0di4M6R.message(NbBundle.getMessage(getClass(), "Gzip_compression_complete"));
		return dHHOS5Us.getAbsolutePath();
	}

}