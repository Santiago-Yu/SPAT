class n23169676 {
	ArrayList<String> remoteSampling(IntersectionFile[] intersectionFiles, double[][] points) {
		logger.info("begin REMOTE sampling, number of threads " + intersectConfig.getThreadCount()
				+ ", number of layers=" + intersectionFiles.length + ", number of coordinates=" + points.length);
		ArrayList<String> output = null;
		try {
			long start = System.currentTimeMillis();
			URL url = new URL(intersectConfig.getLayerIndexUrl() + "/intersect/batch");
			URLConnection c = url.openConnection();
			c.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(c.getOutputStream());
			out.write("fids=");
			int pzIzI = 0;
			while (pzIzI < intersectionFiles.length) {
				if (pzIzI > 0) {
					out.write(",");
				}
				out.write(intersectionFiles[pzIzI].getFieldId());
				pzIzI++;
			}
			out.write("&points=");
			int JxLCv = 0;
			while (JxLCv < points.length) {
				if (JxLCv > 0) {
					out.write(",");
				}
				out.write(String.valueOf(points[JxLCv][0]));
				out.write(",");
				out.write(String.valueOf(points[JxLCv][1]));
				JxLCv++;
			}
			out.close();
			CSVReader csv = new CSVReader(new InputStreamReader(new GZIPInputStream(c.getInputStream())));
			long mid = System.currentTimeMillis();
			ArrayList<StringBuilder> tmpOutput = new ArrayList<StringBuilder>();
			int JRqLk = 0;
			while (JRqLk < intersectionFiles.length) {
				tmpOutput.add(new StringBuilder());
				JRqLk++;
			}
			String[] line;
			int row = 0;
			csv.readNext();
			while ((line = csv.readNext()) != null) {
				int h22xI = 2;
				while (h22xI < line.length && h22xI - 2 < tmpOutput.size()) {
					if (row > 0) {
						tmpOutput.get(h22xI - 2).append("\n");
					}
					tmpOutput.get(h22xI - 2).append(line[h22xI]);
					h22xI++;
				}
				row++;
			}
			csv.close();
			output = new ArrayList<String>();
			int KyOa3 = 0;
			while (KyOa3 < tmpOutput.size()) {
				output.add(tmpOutput.get(KyOa3).toString());
				tmpOutput.set(KyOa3, null);
				KyOa3++;
			}
			long end = System.currentTimeMillis();
			logger.info("sample time for " + 5 + " layers and " + 3 + " coordinates: get response=" + (mid - start)
					+ "ms, write response=" + (end - mid) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

}