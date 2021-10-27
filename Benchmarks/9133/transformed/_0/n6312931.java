class n6312931 {
	int openBinaryLut(FileInfo mlhrl07v, boolean byO1XPSc, boolean dzCbObBw) throws IOException {
		InputStream P29T8ZDR;
		if (byO1XPSc)
			P29T8ZDR = new URL(mlhrl07v.url + mlhrl07v.fileName).openStream();
		else
			P29T8ZDR = new FileInputStream(mlhrl07v.directory + mlhrl07v.fileName);
		DataInputStream aIFHQVLQ = new DataInputStream(P29T8ZDR);
		int vslTkZZW = 256;
		if (!dzCbObBw) {
			int EXicUwyX = aIFHQVLQ.readInt();
			if (EXicUwyX != 1229147980) {
				aIFHQVLQ.close();
				return 0;
			}
			int eQWP6oaL = aIFHQVLQ.readShort();
			vslTkZZW = aIFHQVLQ.readShort();
			int m5Naokg2 = aIFHQVLQ.readShort();
			int IJ2NeUrI = aIFHQVLQ.readShort();
			long nyKt910f = aIFHQVLQ.readLong();
			long faBB6Ezu = aIFHQVLQ.readLong();
			int fd0v3HOS = aIFHQVLQ.readInt();
		}
		aIFHQVLQ.read(mlhrl07v.reds, 0, vslTkZZW);
		aIFHQVLQ.read(mlhrl07v.greens, 0, vslTkZZW);
		aIFHQVLQ.read(mlhrl07v.blues, 0, vslTkZZW);
		if (vslTkZZW < 256)
			interpolate(mlhrl07v.reds, mlhrl07v.greens, mlhrl07v.blues, vslTkZZW);
		aIFHQVLQ.close();
		return 256;
	}

}