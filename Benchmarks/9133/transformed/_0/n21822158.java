class n21822158 {
	private void loadObject(URL DeqaEona) throws IOException {
		InputStream Y2L6RXna = DeqaEona.openStream();
		BufferedReader le8CoEHq = new BufferedReader(new InputStreamReader(Y2L6RXna));
		int wEhfhh33 = 0;
		try {
			String v4l4bQsF;
			boolean oAhP3IRc = true;
			String[] i1sfsd96;
			Material nph166rG = null;
			while (((v4l4bQsF = le8CoEHq.readLine()) != null)) {
				wEhfhh33++;
				v4l4bQsF = v4l4bQsF.trim();
				if (v4l4bQsF.length() > 0) {
					if (v4l4bQsF.startsWith("mtllib")) {
						String kTFrpvBh = v4l4bQsF.substring(6).trim();
						loadMtlFile(new URL(DeqaEona, kTFrpvBh));
					} else if (v4l4bQsF.startsWith("usemtl")) {
						String YrvVJ4aE = v4l4bQsF.substring(6).trim();
						nph166rG = (Material) materials.get(YrvVJ4aE);
					} else if (v4l4bQsF.charAt(0) == 'v' && v4l4bQsF.charAt(1) == ' ') {
						float[] SjnnpRGf = new float[4];
						i1sfsd96 = v4l4bQsF.split("\\s+");
						for (int Ko71BeDF = 1; Ko71BeDF < i1sfsd96.length; Ko71BeDF++) {
							SjnnpRGf[Ko71BeDF - 1] = Float.valueOf(i1sfsd96[Ko71BeDF]).floatValue();
						}
						if (oAhP3IRc) {
							rightpoint = SjnnpRGf[0];
							leftpoint = SjnnpRGf[0];
							toppoint = SjnnpRGf[1];
							bottompoint = SjnnpRGf[1];
							nearpoint = SjnnpRGf[2];
							farpoint = SjnnpRGf[2];
							oAhP3IRc = false;
						}
						if (SjnnpRGf[0] > rightpoint) {
							rightpoint = SjnnpRGf[0];
						}
						if (SjnnpRGf[0] < leftpoint) {
							leftpoint = SjnnpRGf[0];
						}
						if (SjnnpRGf[1] > toppoint) {
							toppoint = SjnnpRGf[1];
						}
						if (SjnnpRGf[1] < bottompoint) {
							bottompoint = SjnnpRGf[1];
						}
						if (SjnnpRGf[2] > nearpoint) {
							nearpoint = SjnnpRGf[2];
						}
						if (SjnnpRGf[2] < farpoint) {
							farpoint = SjnnpRGf[2];
						}
						vertexsets.add(SjnnpRGf);
					} else if (v4l4bQsF.charAt(0) == 'v' && v4l4bQsF.charAt(1) == 't') {
						float[] UicS8uIM = new float[4];
						i1sfsd96 = v4l4bQsF.split("\\s+");
						for (int yqIpPZSx = 1; yqIpPZSx < i1sfsd96.length; yqIpPZSx++) {
							UicS8uIM[yqIpPZSx - 1] = Float.valueOf(i1sfsd96[yqIpPZSx]).floatValue();
						}
						vertexsetstexs.add(UicS8uIM);
					} else if (v4l4bQsF.charAt(0) == 'v' && v4l4bQsF.charAt(1) == 'n') {
						float[] niigRHGW = new float[4];
						i1sfsd96 = v4l4bQsF.split("\\s+");
						for (int jJPdIaNP = 1; jJPdIaNP < i1sfsd96.length; jJPdIaNP++) {
							niigRHGW[jJPdIaNP - 1] = Float.valueOf(i1sfsd96[jJPdIaNP]).floatValue();
						}
						vertexsetsnorms.add(niigRHGW);
					} else if (v4l4bQsF.charAt(0) == 'f' && v4l4bQsF.charAt(1) == ' ') {
						i1sfsd96 = v4l4bQsF.split("\\s+");
						int[] Nb10hZAP = new int[i1sfsd96.length - 1];
						int[] huHjUyYb = new int[i1sfsd96.length - 1];
						int[] iUpUMQub = new int[i1sfsd96.length - 1];
						for (int wI6bmqyp = 1; wI6bmqyp < i1sfsd96.length; wI6bmqyp++) {
							String CkOPvVs6 = i1sfsd96[wI6bmqyp].replaceAll("//", "/0/");
							String[] JchReVSY = CkOPvVs6.split("/");
							Nb10hZAP[wI6bmqyp - 1] = Integer.valueOf(JchReVSY[0]).intValue();
							if (JchReVSY.length > 1) {
								huHjUyYb[wI6bmqyp - 1] = Integer.valueOf(JchReVSY[1]).intValue();
							} else {
								huHjUyYb[wI6bmqyp - 1] = 0;
							}
							if (JchReVSY.length > 2) {
								iUpUMQub[wI6bmqyp - 1] = Integer.valueOf(JchReVSY[2]).intValue();
							} else {
								iUpUMQub[wI6bmqyp - 1] = 0;
							}
						}
						Face BOow9BSQ = new Face(Nb10hZAP, huHjUyYb, iUpUMQub, nph166rG);
						faces.add(BOow9BSQ);
					}
				}
			}
		} catch (IOException C9xqmbKk) {
			System.out.println("Failed to read file: " + le8CoEHq.toString());
		} catch (NumberFormatException mnMLGO62) {
			System.out.println("Malformed OBJ (on line " + wEhfhh33 + "): " + le8CoEHq.toString() + "\r \r"
					+ mnMLGO62.getMessage());
		}
	}

}