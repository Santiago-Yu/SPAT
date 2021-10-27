class n7427550 {
	public void process(int dlmKUg8B, int pWQh8DaS) {
		Pattern Cur3k8jI = Pattern.compile("<DIV class=\"treeline\">([^<]*)");
		Pattern pIT3y0zV = Pattern.compile("<a href=\"javascript:checkBranch\\(([0-9]+), 'true'\\)\">([^<]*)</a>");
		Matcher ONdIxMDm, sRpcbVB0;
		URL Fmaee39a;
		HttpURLConnection iVY8QNXt;
		try {
			Fmaee39a = new URL("http://cri-srv-ade.insa-toulouse.fr:8080/ade/standard/gui/tree.jsp?branchId=" + dlmKUg8B
					+ "&expand=false&forceLoad=false&reload=false&scroll=0");
			iVY8QNXt = (HttpURLConnection) Fmaee39a.openConnection();
			iVY8QNXt.setRequestMethod("GET");
			iVY8QNXt.setDoOutput(true);
			iVY8QNXt.setDoInput(true);
			iVY8QNXt.setRequestProperty("Cookie", sessionId);
			BufferedReader CiE5tRih = new BufferedReader(new InputStreamReader(iVY8QNXt.getInputStream()));
			String be4Z5tuf;
			boolean eLcJXWja = false;
			while ((be4Z5tuf = CiE5tRih.readLine()) != null) {
				sRpcbVB0 = Cur3k8jI.matcher(be4Z5tuf);
				ONdIxMDm = pIT3y0zV.matcher(be4Z5tuf);
				if (sRpcbVB0.find()) {
					if (sRpcbVB0.group(1).equals(createIdent(pWQh8DaS))) {
						eLcJXWja = true;
					} else {
						eLcJXWja = false;
					}
				}
				if (ONdIxMDm.find()) {
					if (eLcJXWja) {
						trainee.add(new Node(Integer.parseInt(ONdIxMDm.group(1)), ONdIxMDm.group(2)));
						System.out.println(ONdIxMDm.group(1) + " - " + ONdIxMDm.group(2));
					}
				}
			}
			Fmaee39a = new URL("http://cri-srv-ade.insa-toulouse.fr:8080/ade/standard/gui/tree.jsp?branchId=" + dlmKUg8B
					+ "&expand=false&forceLoad=false&reload=false&scroll=0");
		} catch (Exception s6JPtyI4) {
			s6JPtyI4.printStackTrace();
		}
	}

}