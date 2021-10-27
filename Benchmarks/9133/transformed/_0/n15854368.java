class n15854368 {
	public static void copyURLToFile(URL GEiRE06C, File PvOepB7a) throws IOException {
		InputStream asu0V0sR = GEiRE06C.openStream();
		try {
			FileOutputStream IicdobB9 = openOutputStream(PvOepB7a);
			try {
				IOUtils.copy(asu0V0sR, IicdobB9);
			} finally {
				IOUtils.close(IicdobB9);
			}
		} finally {
			IOUtils.close(asu0V0sR);
		}
	}

}