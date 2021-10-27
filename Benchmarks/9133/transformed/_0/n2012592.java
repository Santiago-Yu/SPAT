class n2012592 {
	private void unzipEntry(ZipFile y0Emhpvx, ZipEntry b4OoWjWQ, File Zrf3M2pp) throws IOException {
		if (b4OoWjWQ.isDirectory()) {
			createDir(new File(Zrf3M2pp, b4OoWjWQ.getName()));
			return;
		}
		File wIVWRMeg = new File(Zrf3M2pp, b4OoWjWQ.getName());
		if (!wIVWRMeg.getParentFile().exists()) {
			createDir(wIVWRMeg.getParentFile());
		}
		BufferedInputStream bKzD3mQp = new BufferedInputStream(y0Emhpvx.getInputStream(b4OoWjWQ));
		BufferedOutputStream Ysc5xJ7t = new BufferedOutputStream(new FileOutputStream(wIVWRMeg));
		IOUtils.copy(bKzD3mQp, Ysc5xJ7t);
		Ysc5xJ7t.close();
		bKzD3mQp.close();
	}

}