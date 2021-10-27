class n22079999 {
	public static SubstanceSkin.ColorSchemes getColorSchemes(URL ndbpIici) {
		List<SubstanceColorScheme> xrVy7K1Y = new ArrayList<SubstanceColorScheme>();
		BufferedReader u3UYc4fd = null;
		Color HTzslszQ = null;
		Color l5j1R3LS = null;
		Color hj3VfHd5 = null;
		Color Iuf9Mh7N = null;
		Color fl5QxmuW = null;
		Color XSmLa2vU = null;
		Color pNAAYKp7 = null;
		String ByfAJGEP = null;
		ColorSchemeKind UB7C2gsO = null;
		boolean yOOwnWdI = false;
		try {
			u3UYc4fd = new BufferedReader(new InputStreamReader(ndbpIici.openStream()));
			while (true) {
				String Kszeogml = u3UYc4fd.readLine();
				if (Kszeogml == null)
					break;
				Kszeogml = Kszeogml.trim();
				if (Kszeogml.length() == 0)
					continue;
				if (Kszeogml.startsWith("#")) {
					continue;
				}
				if (Kszeogml.indexOf("{") >= 0) {
					if (yOOwnWdI) {
						throw new IllegalArgumentException("Already in color scheme definition");
					}
					yOOwnWdI = true;
					ByfAJGEP = Kszeogml.substring(0, Kszeogml.indexOf("{")).trim();
					continue;
				}
				if (Kszeogml.indexOf("}") >= 0) {
					if (!yOOwnWdI) {
						throw new IllegalArgumentException("Not in color scheme definition");
					}
					yOOwnWdI = false;
					if ((ByfAJGEP == null) || (UB7C2gsO == null) || (HTzslszQ == null) || (l5j1R3LS == null)
							|| (hj3VfHd5 == null) || (Iuf9Mh7N == null) || (fl5QxmuW == null) || (XSmLa2vU == null)
							|| (pNAAYKp7 == null)) {
						throw new IllegalArgumentException("Incomplete specification");
					}
					Color[] Lhk9AquC = new Color[] { HTzslszQ, l5j1R3LS, hj3VfHd5, Iuf9Mh7N, fl5QxmuW, XSmLa2vU,
							pNAAYKp7 };
					if (UB7C2gsO == ColorSchemeKind.LIGHT) {
						xrVy7K1Y.add(getLightColorScheme(ByfAJGEP, Lhk9AquC));
					} else {
						xrVy7K1Y.add(getDarkColorScheme(ByfAJGEP, Lhk9AquC));
					}
					ByfAJGEP = null;
					UB7C2gsO = null;
					HTzslszQ = null;
					l5j1R3LS = null;
					hj3VfHd5 = null;
					Iuf9Mh7N = null;
					fl5QxmuW = null;
					XSmLa2vU = null;
					pNAAYKp7 = null;
					continue;
				}
				String[] Y9ragLc0 = Kszeogml.split("=");
				if (Y9ragLc0.length != 2) {
					throw new IllegalArgumentException("Unsupported format in line " + Kszeogml);
				}
				String Bn2oRXOc = Y9ragLc0[0].trim();
				String wWbTxRTn = Y9ragLc0[1].trim();
				if ("kind".equals(Bn2oRXOc)) {
					if (UB7C2gsO == null) {
						if ("Light".equals(wWbTxRTn)) {
							UB7C2gsO = ColorSchemeKind.LIGHT;
							continue;
						}
						if ("Dark".equals(wWbTxRTn)) {
							UB7C2gsO = ColorSchemeKind.DARK;
							continue;
						}
						throw new IllegalArgumentException("Unsupported format in line " + Kszeogml);
					}
					throw new IllegalArgumentException("'kind' should only be defined once");
				}
				if ("colorUltraLight".equals(Bn2oRXOc)) {
					if (HTzslszQ == null) {
						HTzslszQ = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'ultraLight' should only be defined once");
				}
				if ("colorExtraLight".equals(Bn2oRXOc)) {
					if (l5j1R3LS == null) {
						l5j1R3LS = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'extraLight' should only be defined once");
				}
				if ("colorLight".equals(Bn2oRXOc)) {
					if (hj3VfHd5 == null) {
						hj3VfHd5 = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'light' should only be defined once");
				}
				if ("colorMid".equals(Bn2oRXOc)) {
					if (Iuf9Mh7N == null) {
						Iuf9Mh7N = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'mid' should only be defined once");
				}
				if ("colorDark".equals(Bn2oRXOc)) {
					if (fl5QxmuW == null) {
						fl5QxmuW = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'dark' should only be defined once");
				}
				if ("colorUltraDark".equals(Bn2oRXOc)) {
					if (XSmLa2vU == null) {
						XSmLa2vU = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'ultraDark' should only be defined once");
				}
				if ("colorForeground".equals(Bn2oRXOc)) {
					if (pNAAYKp7 == null) {
						pNAAYKp7 = Color.decode(wWbTxRTn);
						continue;
					}
					throw new IllegalArgumentException("'foreground' should only be defined once");
				}
				throw new IllegalArgumentException("Unsupported format in line " + Kszeogml);
			}
			;
		} catch (IOException Zf4W3rfY) {
			throw new IllegalArgumentException(Zf4W3rfY);
		} finally {
			if (u3UYc4fd != null) {
				try {
					u3UYc4fd.close();
				} catch (IOException DE8uDrOV) {
				}
			}
		}
		return new SubstanceSkin.ColorSchemes(xrVy7K1Y);
	}

}