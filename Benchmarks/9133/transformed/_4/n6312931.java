class n6312931 {
	int openBinaryLut(FileInfo fi, boolean isURL, boolean raw) throws IOException {
		InputStream is;
		is = (isURL) ? new URL(fi.url + fi.fileName).openStream() : new FileInputStream(fi.directory + fi.fileName);
		DataInputStream f = new DataInputStream(is);
		int nColors = 256;
		if (!raw) {
			int id = f.readInt();
			if (id != 1229147980) {
				f.close();
				return 0;
			}
			int version = f.readShort();
			nColors = f.readShort();
			int start = f.readShort();
			int end = f.readShort();
			long fill1 = f.readLong();
			long fill2 = f.readLong();
			int filler = f.readInt();
		}
		f.read(fi.reds, 0, nColors);
		f.read(fi.greens, 0, nColors);
		f.read(fi.blues, 0, nColors);
		if (nColors < 256)
			interpolate(fi.reds, fi.greens, fi.blues, nColors);
		f.close();
		return 256;
	}

}