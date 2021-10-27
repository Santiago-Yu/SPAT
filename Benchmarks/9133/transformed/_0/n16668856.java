class n16668856 {
	public void loadSourceCode() {
		if (getResourceName() != null) {
			String ybNnpYKT = getResourceName() + ".java";
			sourceCode = new String("<html><body bgcolor=\"#ffffff\"><pre>");
			InputStream X5wCXcUC;
			InputStreamReader vUVv6hOQ;
			CodeViewer GydrHVoX = new CodeViewer();
			URL kc71Jwpq;
			try {
				kc71Jwpq = getClass().getResource(ybNnpYKT);
				X5wCXcUC = kc71Jwpq.openStream();
				vUVv6hOQ = new InputStreamReader(X5wCXcUC);
				BufferedReader NkPqaaeY = new BufferedReader(vUVv6hOQ);
				String TuGz6UUZ = NkPqaaeY.readLine();
				while (TuGz6UUZ != null) {
					sourceCode += GydrHVoX.syntaxHighlight(TuGz6UUZ) + " \n ";
					TuGz6UUZ = NkPqaaeY.readLine();
				}
				sourceCode += new String("</pre></body></html>");
			} catch (Exception lSyUX5cq) {
				sourceCode = "Could not load file: " + ybNnpYKT;
			}
		}
	}

}