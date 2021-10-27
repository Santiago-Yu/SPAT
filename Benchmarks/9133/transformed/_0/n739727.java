class n739727 {
	private static String fetch(String suwoMHgr, String DjpVaqK2) {
		try {
			URL BQor40RP = new URL(suwoMHgr);
			HttpURLConnection e0NtvIKm = (HttpURLConnection) BQor40RP.openConnection();
			InputStream rMxXor5k = BQor40RP.openStream();
			String ccPzfA0c = new Scanner(rMxXor5k).useDelimiter("\\A").next();
			Pattern xXEGa9XL = Pattern.compile("form action=\"(.*)\" method=\"post\"");
			Matcher u6XnGTHp = xXEGa9XL.matcher(ccPzfA0c);
			if (!u6XnGTHp.find())
				return "";
			suwoMHgr = u6XnGTHp.group(1);
			BQor40RP = new URL(suwoMHgr);
			e0NtvIKm = (HttpURLConnection) BQor40RP.openConnection();
			e0NtvIKm.setRequestProperty("Cookie", DjpVaqK2);
			e0NtvIKm.setRequestMethod("POST");
			e0NtvIKm.setDoOutput(true);
			OutputStreamWriter ZtluFVcM = new OutputStreamWriter(e0NtvIKm.getOutputStream());
			ZtluFVcM.write("dl.start=PREMIUM");
			ZtluFVcM.flush();
			BufferedReader mtxhVelp = new BufferedReader(new InputStreamReader(e0NtvIKm.getInputStream()));
			StringBuffer WjHod8Ge = new StringBuffer();
			while ((ccPzfA0c = mtxhVelp.readLine()) != null)
				WjHod8Ge.append(ccPzfA0c + System.getProperty("line.separator"));
			ccPzfA0c = suwoMHgr.substring(suwoMHgr.lastIndexOf("/") + 1);
			xXEGa9XL = Pattern.compile("<tr><td><a href=\"(.*?)" + ccPzfA0c);
			u6XnGTHp = xXEGa9XL.matcher(WjHod8Ge.toString());
			ccPzfA0c = (u6XnGTHp.find()) ? (u6XnGTHp.group(1) + ccPzfA0c + System.getProperty("line.separator")) : "";
			return ccPzfA0c;
		} catch (Exception cMzbySgn) {
			return "";
		}
	}

}