class n14232817 {
	protected void lookupForParsedElementAnnotations(JClassType t) {
		List<JMethod> methods = getParsableElementMethods(t);
		if (methods != null) {
			for (JMethod method : methods) {
				ParsedElement elementAnnotation = method.getAnnotation(ParsedElement.class);
				if (elementAnnotation.type() == ParsedElement.Types.SYNC) {
					try {
						URL url = getClass().getClassLoader().getResource(elementAnnotation.file());
						String contents = "";
						String line = null;
						BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
						while ((line = reader.readLine()) != null) {
							contents += line;
						}
						reader.close();
						ParsedElementDescriptor elementDescriptor = new ParsedElementDescriptor(method.getName(),
								contents.replaceAll("\"", "'"), elementAnnotation.type());
						this.parsedElementList.add(elementDescriptor);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					ParsedElementDescriptor elementDescriptor = new ParsedElementDescriptor(method.getName(),
							elementAnnotation.file(), elementAnnotation.type());
					this.parsedElementList.add(elementDescriptor);
				}
			}
		}
	}

}