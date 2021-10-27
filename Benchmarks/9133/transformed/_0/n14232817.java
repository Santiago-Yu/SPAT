class n14232817 {
	protected void lookupForParsedElementAnnotations(JClassType S6ukIe1j) {
		List<JMethod> PAXgGA6X = getParsableElementMethods(S6ukIe1j);
		if (PAXgGA6X != null) {
			for (JMethod a3rgRcyp : PAXgGA6X) {
				ParsedElement HUw3lZpp = a3rgRcyp.getAnnotation(ParsedElement.class);
				if (HUw3lZpp.type() == ParsedElement.Types.SYNC) {
					try {
						String i8LyIJWh = "";
						URL l99hEt9j = getClass().getClassLoader().getResource(HUw3lZpp.file());
						BufferedReader SaikmpiG = new BufferedReader(new InputStreamReader(l99hEt9j.openStream()));
						String dxFH9213 = null;
						while ((dxFH9213 = SaikmpiG.readLine()) != null) {
							i8LyIJWh += dxFH9213;
						}
						SaikmpiG.close();
						ParsedElementDescriptor QHzy0agc = new ParsedElementDescriptor(a3rgRcyp.getName(),
								i8LyIJWh.replaceAll("\"", "'"), HUw3lZpp.type());
						this.parsedElementList.add(QHzy0agc);
					} catch (IOException Vu0oQGUE) {
						Vu0oQGUE.printStackTrace();
					}
				} else {
					ParsedElementDescriptor gWomYwKL = new ParsedElementDescriptor(a3rgRcyp.getName(), HUw3lZpp.file(),
							HUw3lZpp.type());
					this.parsedElementList.add(gWomYwKL);
				}
			}
		}
	}

}