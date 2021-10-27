class n15527452 {
	public static void copy(File TEKVNrAU, File l9MP6B5o) throws IOException {
		if (l9MP6B5o.isDirectory()) {
			l9MP6B5o = new File(l9MP6B5o + File.separator + TEKVNrAU.getName());
		}
		FileChannel M1dvpAUi = null, K4NFSm8I = null;
		try {
			M1dvpAUi = new FileInputStream(TEKVNrAU).getChannel();
			K4NFSm8I = new FileOutputStream(l9MP6B5o).getChannel();
			long gObZnAU1 = M1dvpAUi.size();
			MappedByteBuffer bQOJNDMK = M1dvpAUi.map(FileChannel.MapMode.READ_ONLY, 0, gObZnAU1);
			K4NFSm8I.write(bQOJNDMK);
		} finally {
			if (M1dvpAUi != null)
				M1dvpAUi.close();
			if (K4NFSm8I != null)
				K4NFSm8I.close();
		}
	}

}