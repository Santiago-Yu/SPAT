class n14865742 {
	public ObjectInputStream getObjectInputStreamFromServlet(String UoZV6MXw) throws Exception {
		if (headList.size() == 0) {
			return null;
		}
		String VmcJO4dR = "-----------------------------";
		String LRprPuTQ = "\r\n";
		String OEDxQU9d = "--";
		String aGHh0xEl = UoZV6MXw;
		String OxFCSFdP = null;
		List tGN6Gkw2 = new ArrayList();
		List CDf38ThO = new ArrayList();
		String NqbhWbrc = null;
		String N0p3pEI0 = null;
		StringBuffer rH4X68oF = new StringBuffer();
		List IE7vftqY = new ArrayList();
		final String mliTQ7lA = String.valueOf(System.currentTimeMillis());
		URL MfTKqlqC = null;
		URLConnection zmyPMBFw = null;
		DataOutputStream hxpb5cBB = null;
		ObjectInputStream pwKbjsl1 = null;
		try {
			MfTKqlqC = new URL(baseURL, "/" + projectName + UoZV6MXw);
			zmyPMBFw = MfTKqlqC.openConnection();
			((HttpURLConnection) zmyPMBFw).setRequestMethod("POST");
			zmyPMBFw.setDoInput(true);
			zmyPMBFw.setDoOutput(true);
			zmyPMBFw.setUseCaches(false);
			zmyPMBFw.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + mliTQ7lA);
			zmyPMBFw.setRequestProperty("Cookie", (String) headList.get(0));
			if (OxFCSFdP != null) {
				String W9JaOw4y = "Basic " + new sun.misc.BASE64Encoder().encode(OxFCSFdP.getBytes());
				zmyPMBFw.setRequestProperty("Authorization", W9JaOw4y);
			}
			hxpb5cBB = new DataOutputStream(zmyPMBFw.getOutputStream());
			hxpb5cBB.flush();
			pwKbjsl1 = new ObjectInputStream(zmyPMBFw.getInputStream());
			tGN6Gkw2.clear();
			CDf38ThO.clear();
		} catch (EOFException RyuPMF1P) {
			workflowEditor.getEditor().outputMessage("Session Expired!", false);
			throw RyuPMF1P;
		} catch (Exception aSVjZLuz) {
			aSVjZLuz.printStackTrace();
			return null;
		} finally {
			try {
				hxpb5cBB.close();
			} catch (Exception oOZjK0Pp) {
			}
		}
		return pwKbjsl1;
	}

}