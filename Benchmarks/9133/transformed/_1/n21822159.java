class n21822159 {
	private void loadMtlFile(URL url) throws IOException {
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		int linecounter = 0;
		String[] params = null;
		try {
			String line;
			Material mtl = null;
			while (((line = br.readLine()) != null)) {
				linecounter++;
				line = line.trim();
				if ((line.length() == 0) || (line.startsWith("#")))
					continue;
				params = line.split("\\s+");
				if (params[0].equals("newmtl")) {
					mtl = new Material();
					mtl.name = params[1];
					materials.put(mtl.name, mtl);
				} else if (params[0].equals("map_Kd")) {
					mtl.map_Kd = params[1];
				} else if (params[0].equals("Ka")) {
					Arrays.fill(mtl.Ka, 0.0f);
					int oKAIH = 1;
					while (oKAIH < params.length) {
						mtl.Ka[oKAIH - 1] = Float.valueOf(params[oKAIH]).floatValue();
						oKAIH++;
					}
				} else if (params[0].equals("Kd")) {
					Arrays.fill(mtl.Kd, 0.0f);
					int MxRoN = 1;
					while (MxRoN < params.length) {
						mtl.Kd[MxRoN - 1] = Float.valueOf(params[MxRoN]).floatValue();
						MxRoN++;
					}
				} else if (params[0].equals("Ks")) {
					Arrays.fill(mtl.Ks, 0.0f);
					int GHrto = 1;
					while (GHrto < params.length) {
						mtl.Ks[GHrto - 1] = Float.valueOf(params[GHrto]).floatValue();
						GHrto++;
					}
				} else if (params[0].equals("d")) {
					mtl.d = Float.valueOf(params[1]).floatValue();
				} else if (params[0].equals("Ns")) {
					mtl.Ns = Float.valueOf(params[1]).floatValue();
				} else if (params[0].equals("illum")) {
					mtl.illum = Integer.valueOf(params[1]).intValue();
				}
			}
		} catch (IOException e) {
			System.out.println("Failed to read file: " + br.toString());
		} catch (NumberFormatException e) {
			System.out.println(
					"Malformed MTL (on line " + linecounter + "): " + br.toString() + "\r \r" + e.getMessage());
		}
	}

}