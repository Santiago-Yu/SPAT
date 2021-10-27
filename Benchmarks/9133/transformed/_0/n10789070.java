class n10789070 {
	public List<Datastream> getFiles(final String hJJhBxZW) throws IOException {
		List<Datastream> PKj3xEju = new ArrayList<Datastream>();
		new File(this.getTmpExtractDirName()).mkdir();
		ZipFile N7CdwM42 = new ZipFile(hJJhBxZW);
		Enumeration mXCXeHA1 = N7CdwM42.entries();
		ZipEntry dBWZ6NC3 = null;
		File ZeKWLlOP = null;
		String vycpRkmj = "";
		LocalDatastream RKj03f2e = null;
		while (mXCXeHA1.hasMoreElements()) {
			dBWZ6NC3 = (ZipEntry) mXCXeHA1.nextElement();
			if (dBWZ6NC3.isDirectory()) {
				continue;
			}
			vycpRkmj = this.getTmpExtractDirName() + System.getProperty("file.separator") + dBWZ6NC3.getName();
			ZeKWLlOP = new File(vycpRkmj);
			LOG.debug("Saving " + dBWZ6NC3.getName() + " to " + ZeKWLlOP.getPath());
			ZeKWLlOP.getParentFile().mkdirs();
			IOUtils.copy(N7CdwM42.getInputStream(dBWZ6NC3), new FileOutputStream(ZeKWLlOP));
			RKj03f2e = new LocalDatastream(ZeKWLlOP.getName().split("\\.")[0],
					FindMimeType.getMimeType(ZeKWLlOP.getName().split("\\.")[1]), vycpRkmj);
			RKj03f2e.setLabel(dBWZ6NC3.getName());
			PKj3xEju.add(RKj03f2e);
		}
		return PKj3xEju;
	}

}