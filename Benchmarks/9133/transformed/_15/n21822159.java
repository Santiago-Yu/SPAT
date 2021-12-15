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
				if ("newmtl".equals(params[0])) {
					mtl = new Material();
					mtl.name = params[1];
					materials.put(mtl.name, mtl);
				} else if ("map_Kd".equals(params[0])) {
					mtl.map_Kd = params[1];
				} else if ("Ka".equals(params[0])) {
					Arrays.fill(mtl.Ka, 0.0f);
					for (int i = 1; i < params.length; i++) {
						mtl.Ka[i - 1] = Float.valueOf(params[i]).floatValue();
					}
				} else if ("Kd".equals(params[0])) {
					Arrays.fill(mtl.Kd, 0.0f);
					for (int i = 1; i < params.length; i++) {
						mtl.Kd[i - 1] = Float.valueOf(params[i]).floatValue();
					}
				} else if ("Ks".equals(params[0])) {
					Arrays.fill(mtl.Ks, 0.0f);
					for (int i = 1; i < params.length; i++) {
						mtl.Ks[i - 1] = Float.valueOf(params[i]).floatValue();
					}
				} else if ("d".equals(params[0])) {
					mtl.d = Float.valueOf(params[1]).floatValue();
				} else if ("Ns".equals(params[0])) {
					mtl.Ns = Float.valueOf(params[1]).floatValue();
				} else if ("illum".equals(params[0])) {
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