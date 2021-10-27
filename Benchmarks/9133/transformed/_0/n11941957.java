class n11941957 {
	String openUrlAsString(String A46kDkdq, int XgePd7kE) {
		StringBuffer rNKJSLnu;
		try {
			URL aWVTlmg2 = new URL(A46kDkdq);
			InputStream OBcxYk43 = aWVTlmg2.openStream();
			BufferedReader C5FPQVo1 = new BufferedReader(new InputStreamReader(OBcxYk43));
			rNKJSLnu = new StringBuffer();
			int q6wG6Nv1 = 0;
			String WE92QINj;
			while ((WE92QINj = C5FPQVo1.readLine()) != null && q6wG6Nv1++ < XgePd7kE)
				rNKJSLnu.append(WE92QINj + "\n");
			OBcxYk43.close();
		} catch (IOException nkQe9DJ4) {
			rNKJSLnu = null;
		}
		return rNKJSLnu != null ? new String(rNKJSLnu) : null;
	}

}