class n23169676 {
	ArrayList<String> remoteSampling(IntersectionFile[] khmAG4Sw, double[][] tYnCh9Eo) {
		logger.info("begin REMOTE sampling, number of threads " + intersectConfig.getThreadCount()
				+ ", number of layers=" + khmAG4Sw.length + ", number of coordinates=" + tYnCh9Eo.length);
		ArrayList<String> eUYhmu2Y = null;
		try {
			long EIXmVjjH = System.currentTimeMillis();
			URL SGtuEwHf = new URL(intersectConfig.getLayerIndexUrl() + "/intersect/batch");
			URLConnection MYuQH4HD = SGtuEwHf.openConnection();
			MYuQH4HD.setDoOutput(true);
			OutputStreamWriter VWv9sf6U = new OutputStreamWriter(MYuQH4HD.getOutputStream());
			VWv9sf6U.write("fids=");
			for (int BMtMamQI = 0; BMtMamQI < khmAG4Sw.length; BMtMamQI++) {
				if (BMtMamQI > 0) {
					VWv9sf6U.write(",");
				}
				VWv9sf6U.write(khmAG4Sw[BMtMamQI].getFieldId());
			}
			VWv9sf6U.write("&points=");
			for (int agoF3sGI = 0; agoF3sGI < tYnCh9Eo.length; agoF3sGI++) {
				if (agoF3sGI > 0) {
					VWv9sf6U.write(",");
				}
				VWv9sf6U.write(String.valueOf(tYnCh9Eo[agoF3sGI][0]));
				VWv9sf6U.write(",");
				VWv9sf6U.write(String.valueOf(tYnCh9Eo[agoF3sGI][1]));
			}
			VWv9sf6U.close();
			CSVReader syV7Okd3 = new CSVReader(new InputStreamReader(new GZIPInputStream(MYuQH4HD.getInputStream())));
			long ONVQnpoQ = System.currentTimeMillis();
			ArrayList<StringBuilder> bkqxfBhI = new ArrayList<StringBuilder>();
			for (int L66X6Nwr = 0; L66X6Nwr < khmAG4Sw.length; L66X6Nwr++) {
				bkqxfBhI.add(new StringBuilder());
			}
			String[] JKNzvf8b;
			int m8TrdoEZ = 0;
			syV7Okd3.readNext();
			while ((JKNzvf8b = syV7Okd3.readNext()) != null) {
				for (int w1i48Uw1 = 2; w1i48Uw1 < JKNzvf8b.length && w1i48Uw1 - 2 < bkqxfBhI.size(); w1i48Uw1++) {
					if (m8TrdoEZ > 0) {
						bkqxfBhI.get(w1i48Uw1 - 2).append("\n");
					}
					bkqxfBhI.get(w1i48Uw1 - 2).append(JKNzvf8b[w1i48Uw1]);
				}
				m8TrdoEZ++;
			}
			syV7Okd3.close();
			eUYhmu2Y = new ArrayList<String>();
			for (int xoriNI79 = 0; xoriNI79 < bkqxfBhI.size(); xoriNI79++) {
				eUYhmu2Y.add(bkqxfBhI.get(xoriNI79).toString());
				bkqxfBhI.set(xoriNI79, null);
			}
			long peiqRJY4 = System.currentTimeMillis();
			logger.info("sample time for " + 5 + " layers and " + 3 + " coordinates: get response="
					+ (ONVQnpoQ - EIXmVjjH) + "ms, write response=" + (peiqRJY4 - ONVQnpoQ) + "ms");
		} catch (Exception cueDI9aw) {
			cueDI9aw.printStackTrace();
		}
		return eUYhmu2Y;
	}

}