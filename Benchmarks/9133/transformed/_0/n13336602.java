class n13336602 {
	private final boolean verifyMatch(String n8LMdpsg, String RELu3G8r) {
		try {
			URL l5j2QCgl;
			URLConnection WzfX2JY9;
			DataOutputStream ctdw7HxN;
			BufferedReader C5R3aj9e;
			l5j2QCgl = new URL("http://www.amazon.com/exec/obidos/ASIN/" + n8LMdpsg);
			WzfX2JY9 = l5j2QCgl.openConnection();
			WzfX2JY9.setDoInput(true);
			WzfX2JY9.setDoOutput(true);
			WzfX2JY9.setUseCaches(false);
			WzfX2JY9.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			C5R3aj9e = new BufferedReader(new InputStreamReader(WzfX2JY9.getInputStream()));
			String GMtNPve0;
			boolean PPXvHjbT = false;
			boolean XGEVXfaT = false;
			while (null != ((GMtNPve0 = C5R3aj9e.readLine()))) {
				String R9IUfcss = RELu3G8r.toUpperCase();
				int eAD8rsGY = GMtNPve0.toUpperCase().indexOf((R9IUfcss));
				if (eAD8rsGY > 0) {
					if (GMtNPve0.toUpperCase().endsWith(RELu3G8r.toUpperCase())) {
						PPXvHjbT = true;
					} else {
						XGEVXfaT = true;
					}
				}
			}
			C5R3aj9e.close();
			if (PPXvHjbT) {
				status.append("Exact Match. ");
				return true;
			} else if (XGEVXfaT) {
				status.append("Inexact Match. ");
				return true;
			}
		} catch (Exception xmdeDJ7F) {
			xmdeDJ7F.printStackTrace();
		}
		return true;
	}

}