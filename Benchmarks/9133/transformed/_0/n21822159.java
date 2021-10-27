class n21822159 {
	private void loadMtlFile(URL wt7rMGRT) throws IOException {
		InputStream UYqCy7ZZ = wt7rMGRT.openStream();
		BufferedReader RZlJqLjO = new BufferedReader(new InputStreamReader(UYqCy7ZZ));
		int t1SqbWtD = 0;
		String[] sdLosdgg = null;
		try {
			String P0bRCxhI;
			Material S62maPJG = null;
			while (((P0bRCxhI = RZlJqLjO.readLine()) != null)) {
				t1SqbWtD++;
				P0bRCxhI = P0bRCxhI.trim();
				if ((P0bRCxhI.length() == 0) || (P0bRCxhI.startsWith("#")))
					continue;
				sdLosdgg = P0bRCxhI.split("\\s+");
				if (sdLosdgg[0].equals("newmtl")) {
					S62maPJG = new Material();
					S62maPJG.name = sdLosdgg[1];
					materials.put(S62maPJG.name, S62maPJG);
				} else if (sdLosdgg[0].equals("map_Kd")) {
					S62maPJG.map_Kd = sdLosdgg[1];
				} else if (sdLosdgg[0].equals("Ka")) {
					Arrays.fill(S62maPJG.Ka, 0.0f);
					for (int qSD0eTWf = 1; qSD0eTWf < sdLosdgg.length; qSD0eTWf++) {
						S62maPJG.Ka[qSD0eTWf - 1] = Float.valueOf(sdLosdgg[qSD0eTWf]).floatValue();
					}
				} else if (sdLosdgg[0].equals("Kd")) {
					Arrays.fill(S62maPJG.Kd, 0.0f);
					for (int zSt0PrYS = 1; zSt0PrYS < sdLosdgg.length; zSt0PrYS++) {
						S62maPJG.Kd[zSt0PrYS - 1] = Float.valueOf(sdLosdgg[zSt0PrYS]).floatValue();
					}
				} else if (sdLosdgg[0].equals("Ks")) {
					Arrays.fill(S62maPJG.Ks, 0.0f);
					for (int LZmyq8XL = 1; LZmyq8XL < sdLosdgg.length; LZmyq8XL++) {
						S62maPJG.Ks[LZmyq8XL - 1] = Float.valueOf(sdLosdgg[LZmyq8XL]).floatValue();
					}
				} else if (sdLosdgg[0].equals("d")) {
					S62maPJG.d = Float.valueOf(sdLosdgg[1]).floatValue();
				} else if (sdLosdgg[0].equals("Ns")) {
					S62maPJG.Ns = Float.valueOf(sdLosdgg[1]).floatValue();
				} else if (sdLosdgg[0].equals("illum")) {
					S62maPJG.illum = Integer.valueOf(sdLosdgg[1]).intValue();
				}
			}
		} catch (IOException b6JvOVda) {
			System.out.println("Failed to read file: " + RZlJqLjO.toString());
		} catch (NumberFormatException cWRgFqwF) {
			System.out.println("Malformed MTL (on line " + t1SqbWtD + "): " + RZlJqLjO.toString() + "\r \r"
					+ cWRgFqwF.getMessage());
		}
	}

}