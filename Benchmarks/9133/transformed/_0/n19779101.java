class n19779101 {
	protected void initGame() {
		try {
			for (File D4TfTSaN : files) {
				String Si8WoBOt = outputDir.getAbsolutePath();
				String G7EgITh4 = System.getProperty("file.separator");
				String j6xQZf8b = D4TfTSaN.getName();
				String zsCd5ORe = j6xQZf8b.substring(0, j6xQZf8b.length() - 3);
				File M5yZfQpi = new File(Si8WoBOt + G7EgITh4 + zsCd5ORe + "jme");
				FileInputStream jQ12ilhp = new FileInputStream(D4TfTSaN);
				OutputStream oekXQopS = new FileOutputStream(M5yZfQpi);
				conversor.setProperty("mtllib", D4TfTSaN.toURL());
				conversor.convert(jQ12ilhp, oekXQopS);
			}
		} catch (FileNotFoundException rHdVrIqi) {
			rHdVrIqi.printStackTrace();
		} catch (IOException EZmMTwDG) {
			EZmMTwDG.printStackTrace();
		}
		super.finish();
	}

}