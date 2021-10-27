class n2736184 {
	public static String getURLContent(String q2DKFD3t, String hMLpbwgd, String tTKcQYAH) {
		BufferedReader ZAy4aSfx = null;
		HttpURLConnection oPmDJXUG = null;
		StringBuffer jKlgiBxX = new StringBuffer();
		OutputStreamWriter eBpbKRwL = null;
		try {
			URL t863Mvj1 = new URL(q2DKFD3t);
			oPmDJXUG = (HttpURLConnection) t863Mvj1.openConnection();
			oPmDJXUG.setRequestMethod("POST");
			oPmDJXUG.setDoOutput(true);
			oPmDJXUG.setUseCaches(false);
			oPmDJXUG.setDefaultUseCaches(false);
			oPmDJXUG.setConnectTimeout(10000);
			oPmDJXUG.setReadTimeout(60000);
			eBpbKRwL = new OutputStreamWriter(oPmDJXUG.getOutputStream(), tTKcQYAH);
			eBpbKRwL.write(hMLpbwgd);
			eBpbKRwL.flush();
			int I0wtlqd7 = oPmDJXUG.getResponseCode();
			if (I0wtlqd7 == 200) {
				int jCG7UTcx = 0;
				char[] w3xVDckm = new char[1024];
				BufferedReader sIG23EDm = new BufferedReader(
						new InputStreamReader(oPmDJXUG.getInputStream(), tTKcQYAH));
				while ((jCG7UTcx = sIG23EDm.read(w3xVDckm)) != -1) {
					jKlgiBxX.append(w3xVDckm, 0, jCG7UTcx);
				}
			}
		} catch (Exception FeDkFng1) {
			logger.error("", FeDkFng1);
		} finally {
			try {
				if (eBpbKRwL != null) {
					eBpbKRwL.close();
				}
				if (ZAy4aSfx != null) {
					ZAy4aSfx.close();
				}
				if (oPmDJXUG != null) {
					oPmDJXUG.disconnect();
				}
			} catch (Exception UoM3Qjw5) {
			}
		}
		return jKlgiBxX.toString();
	}

}