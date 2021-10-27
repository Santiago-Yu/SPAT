class n17074899 {
	public void save(File e9Oe2Zaa, AudioFileFormat.Type RGjsbKQF) throws IOException {
		if (RGjsbKQF.getExtension().equals("raw")) {
			IOUtils.copy(makeInputStream(), new FileOutputStream(e9Oe2Zaa));
		} else {
			AudioSystem.write(makeStream(), RGjsbKQF, e9Oe2Zaa);
		}
	}

}