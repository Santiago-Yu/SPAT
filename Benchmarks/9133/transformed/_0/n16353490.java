class n16353490 {
	private String executePost(String bpEqg7V8, String JJPEsBDF) {
		URL tKPn83Lb;
		HttpURLConnection V7j3r9GR = null;
		try {
			tKPn83Lb = new URL(bpEqg7V8);
			V7j3r9GR = (HttpURLConnection) tKPn83Lb.openConnection();
			V7j3r9GR.setRequestMethod("POST");
			V7j3r9GR.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			V7j3r9GR.setRequestProperty("Content-Length", "" + Integer.toString(JJPEsBDF.getBytes().length));
			V7j3r9GR.setRequestProperty("Content-Language", "en-US");
			V7j3r9GR.setUseCaches(false);
			V7j3r9GR.setDoInput(true);
			V7j3r9GR.setDoOutput(true);
			DataOutputStream gGwCErky = new DataOutputStream(V7j3r9GR.getOutputStream());
			gGwCErky.writeBytes(JJPEsBDF);
			gGwCErky.flush();
			gGwCErky.close();
			InputStream sNosqJHY = V7j3r9GR.getInputStream();
			BufferedReader OZYFSfTq = new BufferedReader(new InputStreamReader(sNosqJHY));
			String MMSm0P4P;
			StringBuffer nEEVnCai = new StringBuffer();
			while ((MMSm0P4P = OZYFSfTq.readLine()) != null) {
				nEEVnCai.append(MMSm0P4P);
				nEEVnCai.append('\r');
			}
			OZYFSfTq.close();
			return nEEVnCai.toString();
		} catch (Exception XUELnJie) {
			XUELnJie.printStackTrace();
			return null;
		} finally {
			if (V7j3r9GR != null) {
				V7j3r9GR.disconnect();
			}
		}
	}

}