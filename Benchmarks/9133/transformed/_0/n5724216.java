class n5724216 {
	protected static void copyOrMove(File QC9uoZTw, File nFPUgs8N, boolean Lh3YMNdO) throws IOException {
		String[] dtKpSNf7;
		int UXaxkaOz;
		InputStream HsFGvNW7;
		OutputStream j91QKSfi;
		byte[] iiZChirR;
		int iDDqHyVg;
		if (QC9uoZTw.isDirectory()) {
			if (!nFPUgs8N.exists())
				nFPUgs8N.mkdir();
			dtKpSNf7 = QC9uoZTw.list();
			for (UXaxkaOz = 0; UXaxkaOz < dtKpSNf7.length; UXaxkaOz++) {
				copyOrMove(new File(QC9uoZTw, dtKpSNf7[UXaxkaOz]), new File(nFPUgs8N, dtKpSNf7[UXaxkaOz]), Lh3YMNdO);
			}
			if (Lh3YMNdO)
				QC9uoZTw.delete();
		} else {
			HsFGvNW7 = new FileInputStream(QC9uoZTw);
			if (nFPUgs8N.isDirectory())
				j91QKSfi = new FileOutputStream(nFPUgs8N.getAbsolutePath() + File.separator + QC9uoZTw.getName());
			else
				j91QKSfi = new FileOutputStream(nFPUgs8N);
			iiZChirR = new byte[1024];
			while ((iDDqHyVg = HsFGvNW7.read(iiZChirR)) > 0)
				j91QKSfi.write(iiZChirR, 0, iDDqHyVg);
			HsFGvNW7.close();
			j91QKSfi.close();
			if (Lh3YMNdO)
				QC9uoZTw.delete();
		}
	}

}