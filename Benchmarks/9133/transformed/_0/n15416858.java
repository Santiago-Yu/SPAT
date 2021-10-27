class n15416858 {
	private void download(File KEJThtKE, File cu1kvrJD, URL JHnkv5bD, IProgressMonitor iE7JjqrF) throws IOException {
		iE7JjqrF.subTask("download " + JHnkv5bD.toString());
		InputStream QLlgNwnF = null;
		FileOutputStream J7d5zHEI = null;
		URLConnection duWC65Wj = null;
		try {
			duWC65Wj = JHnkv5bD.openConnection();
			Writer jEgISpTH = null;
			try {
				Date iOKfF2BA = new Date(duWC65Wj.getLastModified());
				jEgISpTH = new FileWriter(cu1kvrJD);
				jEgISpTH.write(this.FORMAT.format(iOKfF2BA));
			} catch (IOException AsTy9im5) {
				cu1kvrJD.delete();
			} finally {
				IOUtils.closeQuietly(jEgISpTH);
			}
			QLlgNwnF = duWC65Wj.getInputStream();
			J7d5zHEI = new FileOutputStream(KEJThtKE);
			IOUtils.copy(QLlgNwnF, J7d5zHEI);
		} finally {
			IOUtils.closeQuietly(QLlgNwnF);
			IOUtils.closeQuietly(J7d5zHEI);
		}
	}

}