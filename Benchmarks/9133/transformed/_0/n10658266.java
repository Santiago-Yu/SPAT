class n10658266 {
	public static void copy(File IcOQumtj, File JMsM6xbR) throws IOException {
		FileInputStream ztNOxXAR = null;
		FileOutputStream GaVJf8nw = null;
		try {
			ztNOxXAR = new FileInputStream(IcOQumtj);
			GaVJf8nw = new FileOutputStream(JMsM6xbR);
			final byte[] d7X59bG7 = new byte[4096];
			int kyJIWOlF;
			while ((kyJIWOlF = ztNOxXAR.read(d7X59bG7)) >= 0) {
				GaVJf8nw.write(d7X59bG7, 0, kyJIWOlF);
			}
		} finally {
			try {
				if (ztNOxXAR != null)
					ztNOxXAR.close();
			} catch (IOException QDJeTkJu) {
			}
			try {
				if (GaVJf8nw != null)
					GaVJf8nw.close();
			} catch (IOException dsY3Ik5z) {
			}
		}
	}

}