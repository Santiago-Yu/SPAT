class n18898823 {
	public String getHttpText() {
		URL C1M8rBb3 = null;
		try {
			C1M8rBb3 = new URL(getUrl());
		} catch (MalformedURLException aBptm94I) {
			log.error(aBptm94I.getMessage());
		}
		StringBuffer FgxIOcTU = new StringBuffer();
		HttpURLConnection NgvrF10V = null;
		try {
			NgvrF10V = (HttpURLConnection) C1M8rBb3.openConnection();
			NgvrF10V.setRequestMethod(getRequestMethod());
			NgvrF10V.setDoOutput(true);
			if (getRequestProperty() != null && "".equals(getRequestProperty())) {
				NgvrF10V.setRequestProperty("Accept", getRequestProperty());
			}
			PrintWriter GuFS602N = new PrintWriter(new OutputStreamWriter(NgvrF10V.getOutputStream(), getCharset()));
			GuFS602N.println(getParam());
			GuFS602N.close();
			BufferedReader I28yqhRZ = new BufferedReader(
					new InputStreamReader(NgvrF10V.getInputStream(), getCharset()));
			String hIuEInpL;
			int FtrN9ITd = 1;
			while ((hIuEInpL = I28yqhRZ.readLine()) != null) {
				if (getStartLine() == 0 && getEndLine() == 0) {
					FgxIOcTU.append(hIuEInpL).append("\n");
				} else {
					if (getEndLine() > 0) {
						if (FtrN9ITd >= getStartLine() && FtrN9ITd <= getEndLine()) {
							FgxIOcTU.append(hIuEInpL).append("\n");
						}
					} else {
						if (FtrN9ITd >= getStartLine()) {
							FgxIOcTU.append(hIuEInpL).append("\n");
						}
					}
				}
				FtrN9ITd++;
			}
			I28yqhRZ.close();
		} catch (IOException blQUF4dF) {
			log.error(blQUF4dF.getMessage());
		} finally {
			if (NgvrF10V != null) {
				NgvrF10V.disconnect();
			}
		}
		return FgxIOcTU.toString();
	}

}