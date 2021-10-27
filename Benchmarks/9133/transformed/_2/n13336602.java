class n13336602 {
	private final boolean verifyMatch(String disc_id, String title) {
		try {
			URL url;
			URLConnection urlConn;
			DataOutputStream printout;
			BufferedReader input;
			url = new URL("http://www.amazon.com/exec/obidos/ASIN/" + disc_id);
			urlConn = url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
			urlConn.setUseCaches(false);
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			input = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String str;
			boolean goodMatch = false;
			boolean match = false;
			for (; null != ((str = input.readLine()));) {
				String keyword = title.toUpperCase();
				int idStart = str.toUpperCase().indexOf((keyword));
				if (idStart > 0) {
					if (str.toUpperCase().endsWith(title.toUpperCase())) {
						goodMatch = true;
					} else {
						match = true;
					}
				}
			}
			input.close();
			if (goodMatch) {
				status.append("Exact Match. ");
				return true;
			} else if (match) {
				status.append("Inexact Match. ");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}