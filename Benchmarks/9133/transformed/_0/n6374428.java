class n6374428 {
	public String getTags(String V8xhMR8m) {
		StringBuffer eZmuUVOD = new StringBuffer();
		OutputStreamWriter axJZf2Mi = null;
		BufferedReader SNnCZmxC = null;
		try {
			String eZ7OO1nM = URLEncoder.encode(paramName, "UTF-8") + "=" + URLEncoder.encode(V8xhMR8m, "UTF-8");
			URL TrvsUrGa = new URL(cmdUrl);
			URLConnection l6Rfzxv0 = TrvsUrGa.openConnection();
			l6Rfzxv0.setDoOutput(true);
			l6Rfzxv0.connect();
			axJZf2Mi = new OutputStreamWriter(l6Rfzxv0.getOutputStream());
			axJZf2Mi.write(eZ7OO1nM);
			axJZf2Mi.flush();
			SNnCZmxC = new BufferedReader(new InputStreamReader(l6Rfzxv0.getInputStream()));
			String XZoAUdFS = null;
			while ((XZoAUdFS = SNnCZmxC.readLine()) != null) {
				eZmuUVOD.append(XZoAUdFS);
			}
		} catch (IOException VfN3EejY) {
			VfN3EejY.printStackTrace();
		} finally {
			try {
				if (axJZf2Mi != null) {
					axJZf2Mi.close();
				}
				if (SNnCZmxC != null) {
					SNnCZmxC.close();
				}
			} catch (IOException PxcO5mGT) {
				PxcO5mGT.printStackTrace();
			}
		}
		return eZmuUVOD.toString();
	}

}