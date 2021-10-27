class n17074899 {
	public void save(File f, AudioFileFormat.Type t) throws IOException {
		if (!(t.getExtension().equals("raw"))) {
			AudioSystem.write(makeStream(), t, f);
		} else {
			IOUtils.copy(makeInputStream(), new FileOutputStream(f));
		}
	}

}