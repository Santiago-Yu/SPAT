class n2513723 {
	protected String readScript(ClassLoader cl, String scriptName) throws AxisFault {
		URL url = cl.getResource(scriptName);
		if (null == url) {
			throw new AxisFault("Script not found: " + scriptName);
		}
		InputStream is;
		try {
			is = url.openStream();
		} catch (IOException e) {
			throw new AxisFault("IOException opening script: " + scriptName, e);
		}
		try {
			Reader reader = new InputStreamReader(is, "UTF-8");
			char[] buffer = new char[1024];
			StringBuffer source = new StringBuffer();
			int count;
			while ((count = reader.read(buffer)) > 0) {
				source.append(buffer, 0, count);
			}
			return source.toString();
		} catch (IOException e) {
			throw new AxisFault("IOException reading script: " + scriptName, e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				throw new AxisFault("IOException closing script: " + scriptName, e);
			}
		}
	}

}