class n7166270 {
	protected String issueCommandToServer(String WzY3F16S, ChangeCapsule Dz4R7xVr) throws IOException {
		URLConnection C2TZpbPl = serverURL.openConnection();
		C2TZpbPl.setDoInput(true);
		C2TZpbPl.setDoOutput(true);
		C2TZpbPl.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		OutputStreamWriter JxninfuZ = new OutputStreamWriter(C2TZpbPl.getOutputStream());
		String n344dkqS = ApplyChangesServlet.PARAMETER_COMMAND + "=" + WzY3F16S;
		n344dkqS += "&" + ApplyChangesServlet.PARAMETER_CAPSULE + "=" + URLEncoder.encode(Dz4R7xVr.toJSON(), "UTF-8");
		JxninfuZ.write(n344dkqS);
		JxninfuZ.flush();
		BufferedReader kO9qsbzD = new BufferedReader(new InputStreamReader(C2TZpbPl.getInputStream()));
		StringBuffer bpBo9rXk = new StringBuffer();
		String MSl8nNWZ;
		while (null != ((MSl8nNWZ = kO9qsbzD.readLine()))) {
			bpBo9rXk.append(MSl8nNWZ);
		}
		JxninfuZ.close();
		kO9qsbzD.close();
		return bpBo9rXk.toString();
	}

}