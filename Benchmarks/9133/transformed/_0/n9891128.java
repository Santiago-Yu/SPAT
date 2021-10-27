class n9891128 {
	private static void readIzvestiyaArticles() throws IOException {
		CsvReader fhgPsnGM = new CsvReader(new InputStreamReader(
				IzvestiyaUtil.class.getClassLoader().getResourceAsStream("mathnet_izvestiya.csv")), ';');
		fhgPsnGM.setTrimWhitespace(true);
		try {
			while (fhgPsnGM.readRecord()) {
				String HmLOG9Ju = fhgPsnGM.get(0);
				String Kz4ajm3u = fhgPsnGM.get(1);
				StringTokenizer ZkECSdDM = new StringTokenizer(Kz4ajm3u, "-.");
				String ZDvvErEC = ZkECSdDM.nextToken();
				String seuHCday = ZkECSdDM.nextToken();
				String Dd8QnLBS = ZkECSdDM.nextToken();
				String v3BLSaNs = ZkECSdDM.nextToken();
				String y3JhF6AP = String.format("%s/%s/%s-%s.%s", Dd8QnLBS,
						seuHCday.length() == 1 ? "0" + seuHCday : seuHCday, ZDvvErEC, seuHCday, v3BLSaNs);
				id2filename.put(HmLOG9Ju, y3JhF6AP);
			}
		} finally {
			fhgPsnGM.close();
		}
		for (Map.Entry<String, String> entry : id2filename.entrySet()) {
			String IxJZqY2W = String.format("%s/%s", INPUT_DIR, entry.getValue());
			IxJZqY2W = new File(IxJZqY2W).exists() ? IxJZqY2W : IxJZqY2W.replace(".tex", ".TEX");
			if (new File(IxJZqY2W).exists()) {
				InputStream qnitN28t = new FileInputStream(IxJZqY2W);
				FileOutputStream w9iYcMQp = new FileOutputStream(String.format("%s/%s.tex", OUTPUT_DIR, entry.getKey()),
						false);
				try {
					org.apache.commons.io.IOUtils.copy(qnitN28t, w9iYcMQp);
				} catch (Exception MMduzQK7) {
					org.apache.commons.io.IOUtils.closeQuietly(qnitN28t);
					org.apache.commons.io.IOUtils.closeQuietly(w9iYcMQp);
				}
			} else {
				logger.log(Level.INFO, "File with the path=" + IxJZqY2W + " doesn't exist");
			}
		}
	}

}