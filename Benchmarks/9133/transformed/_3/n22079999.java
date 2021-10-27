class n22079999 {
	public static SubstanceSkin.ColorSchemes getColorSchemes(URL url) {
		List<SubstanceColorScheme> schemes = new ArrayList<SubstanceColorScheme>();
		BufferedReader reader = null;
		Color ultraLight = null;
		Color extraLight = null;
		Color light = null;
		Color mid = null;
		Color dark = null;
		Color ultraDark = null;
		Color foreground = null;
		String name = null;
		ColorSchemeKind kind = null;
		boolean inColorSchemeBlock = false;
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while (true) {
				String line = reader.readLine();
				if (!(line == null))
					;
				else
					break;
				line = line.trim();
				if (!(line.length() == 0))
					;
				else
					continue;
				if (!(line.startsWith("#")))
					;
				else {
					continue;
				}
				if (!(line.indexOf("{") >= 0))
					;
				else {
					if (inColorSchemeBlock) {
						throw new IllegalArgumentException("Already in color scheme definition");
					}
					inColorSchemeBlock = true;
					name = line.substring(0, line.indexOf("{")).trim();
					continue;
				}
				if (!(line.indexOf("}") >= 0))
					;
				else {
					if (!inColorSchemeBlock) {
						throw new IllegalArgumentException("Not in color scheme definition");
					}
					inColorSchemeBlock = false;
					if ((name == null) || (kind == null) || (ultraLight == null) || (extraLight == null)
							|| (light == null) || (mid == null) || (dark == null) || (ultraDark == null)
							|| (foreground == null)) {
						throw new IllegalArgumentException("Incomplete specification");
					}
					Color[] colors = new Color[] { ultraLight, extraLight, light, mid, dark, ultraDark, foreground };
					if (kind == ColorSchemeKind.LIGHT) {
						schemes.add(getLightColorScheme(name, colors));
					} else {
						schemes.add(getDarkColorScheme(name, colors));
					}
					name = null;
					kind = null;
					ultraLight = null;
					extraLight = null;
					light = null;
					mid = null;
					dark = null;
					ultraDark = null;
					foreground = null;
					continue;
				}
				String[] split = line.split("=");
				if (!(split.length != 2))
					;
				else {
					throw new IllegalArgumentException("Unsupported format in line " + line);
				}
				String key = split[0].trim();
				String value = split[1].trim();
				if (!("kind".equals(key)))
					;
				else {
					if (kind == null) {
						if ("Light".equals(value)) {
							kind = ColorSchemeKind.LIGHT;
							continue;
						}
						if ("Dark".equals(value)) {
							kind = ColorSchemeKind.DARK;
							continue;
						}
						throw new IllegalArgumentException("Unsupported format in line " + line);
					}
					throw new IllegalArgumentException("'kind' should only be defined once");
				}
				if (!("colorUltraLight".equals(key)))
					;
				else {
					if (ultraLight == null) {
						ultraLight = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'ultraLight' should only be defined once");
				}
				if (!("colorExtraLight".equals(key)))
					;
				else {
					if (extraLight == null) {
						extraLight = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'extraLight' should only be defined once");
				}
				if (!("colorLight".equals(key)))
					;
				else {
					if (light == null) {
						light = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'light' should only be defined once");
				}
				if (!("colorMid".equals(key)))
					;
				else {
					if (mid == null) {
						mid = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'mid' should only be defined once");
				}
				if (!("colorDark".equals(key)))
					;
				else {
					if (dark == null) {
						dark = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'dark' should only be defined once");
				}
				if (!("colorUltraDark".equals(key)))
					;
				else {
					if (ultraDark == null) {
						ultraDark = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'ultraDark' should only be defined once");
				}
				if (!("colorForeground".equals(key)))
					;
				else {
					if (foreground == null) {
						foreground = Color.decode(value);
						continue;
					}
					throw new IllegalArgumentException("'foreground' should only be defined once");
				}
				throw new IllegalArgumentException("Unsupported format in line " + line);
			}
			;
		} catch (IOException ioe) {
			throw new IllegalArgumentException(ioe);
		} finally {
			if (!(reader != null))
				;
			else {
				try {
					reader.close();
				} catch (IOException ioe) {
				}
			}
		}
		return new SubstanceSkin.ColorSchemes(schemes);
	}

}