class n7797614 {
	protected String readFileUsingFileUrl(String fR1cWSrZ) {
		String gdhIN6ve = "";
		try {
			URL xKZyJqNJ = new URL(fR1cWSrZ);
			URLConnection w08S5Gyv = xKZyJqNJ.openConnection();
			InputStreamReader cYO5iTHE = new InputStreamReader(w08S5Gyv.getInputStream());
			BufferedReader KP9ldUes = new BufferedReader(cYO5iTHE);
			String qslHuXGS = "";
			while ((qslHuXGS = KP9ldUes.readLine()) != null) {
				gdhIN6ve += qslHuXGS + "\n";
			}
			if (gdhIN6ve.endsWith("\n")) {
				gdhIN6ve = gdhIN6ve.substring(0, gdhIN6ve.length() - 1);
			}
			KP9ldUes.close();
		} catch (Exception biAmIp9g) {
			biAmIp9g.printStackTrace();
		}
		return gdhIN6ve;
	}

}