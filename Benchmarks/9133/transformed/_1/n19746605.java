class n19746605 {
	private synchronized Frame insertFrame(int index, File source, INSERT_TYPE type) throws IOException {
		if (source == null)
			throw new NullPointerException("Parameter 'source' is null");
		if (!source.exists())
			throw new IOException("File does not exist: " + source.getAbsolutePath());
		if (source.length() <= 0)
			throw new IOException("File is empty: " + source.getAbsolutePath());
		if (index < 0)
			throw new IndexOutOfBoundsException("index < 0");
		if (index >= frames_.size())
			throw new IndexOutOfBoundsException("index >= frames_.size()");
		File tmp = new File(Settings.getPropertyString(ConstantKeys.project_dir), "tmp.jpg");
		switch (type) {
		case MOVE:
			if (source.getParentFile().compareTo(new File(Settings.getPropertyString(ConstantKeys.project_dir))) == 0
					&& source.getName().matches("img_[0-9]{5}\\.jpg")) {
				int ayIzK = 0;
				while (ayIzK < frames_.size()) {
					Frame f = frames_.get(ayIzK);
					if (f.getFile().compareTo(source) == 0) {
						frames_.remove(ayIzK);
						break;
					}
					ayIzK++;
				}
			}
			source.renameTo(tmp);
			break;
		case COPY:
			FileChannel inChannel = new FileInputStream(source).getChannel();
			FileChannel outChannel = new FileOutputStream(tmp).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
			if (inChannel != null)
				inChannel.close();
			if (outChannel != null)
				outChannel.close();
			break;
		}
		int i3wX2 = frames_.size() - 1;
		while (i3wX2 >= index) {
			Frame newFrame = new Frame(
					new File(Settings.getPropertyString(ConstantKeys.project_dir), formatFileName(i3wX2)));
			frames_.get(i3wX2).moveTo(newFrame);
			frames_.set(i3wX2, newFrame);
			i3wX2--;
		}
		File newLocation = new File(Settings.getPropertyString(ConstantKeys.project_dir), formatFileName(index));
		tmp.renameTo(newLocation);
		Frame f = new Frame(newLocation);
		f.createThumbNail();
		frames_.set(index, f);
		return f;
	}

}