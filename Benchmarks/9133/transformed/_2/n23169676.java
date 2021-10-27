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
			for (int i = 0; i < intersectionFiles.length; i++) {
				if (i > 0) {
					out.write(",");
				}
				out.write(intersectionFiles[i].getFieldId());
			}
			out.write("&points=");
			for (int i = 0; i < points.length; i++) {
				if (i > 0) {
					out.write(",");
				}
				out.write(String.valueOf(points[i][0]));
				out.write(",");
				out.write(String.valueOf(points[i][1]));
			}
			out.close();
			CSVReader csv = new CSVReader(new InputStreamReader(new GZIPInputStream(c.getInputStream())));
			long mid = System.currentTimeMillis();
			ArrayList<StringBuilder> tmpOutput = new ArrayList<StringBuilder>();
			for (int i = 0; i < intersectionFiles.length; i++) {
				tmpOutput.add(new StringBuilder());
			}
			String[] line;
			int row = 0;
			csv.readNext();
			for (; (line = csv.readNext()) != null;) {
				for (int i = 2; i < line.length && i - 2 < tmpOutput.size(); i++) {
					if (row > 0) {
						tmpOutput.get(i - 2).append("\n");
					}
					tmpOutput.get(i - 2).append(line[i]);
				}
				row++;
			}
			csv.close();
			output = new ArrayList<String>();
			for (int i = 0; i < tmpOutput.size(); i++) {
				output.add(tmpOutput.get(i).toString());
				tmpOutput.set(i, null);
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