class n7749347 {
	public static String ReadURLStringAndWrite(URL UYtBOMkw, String PP0PvM5d) throws Exception {
		String kmM4Wqj8 = URLEncoder.encode(PP0PvM5d, "UTF-8");
		URLConnection VH6LpMgt = UYtBOMkw.openConnection();
		VH6LpMgt.setDoOutput(true);
		OutputStreamWriter AL9wTg1w = new OutputStreamWriter(VH6LpMgt.getOutputStream());
		AL9wTg1w.write(kmM4Wqj8);
		AL9wTg1w.close();
		BufferedReader xIpWRBBU = new BufferedReader(new InputStreamReader(VH6LpMgt.getInputStream()));
		String UqoV4hSN;
		String jGMvXe0m = "";
		while ((UqoV4hSN = xIpWRBBU.readLine()) != null) {
			jGMvXe0m += UqoV4hSN + "\n";
		}
		xIpWRBBU.close();
		return jGMvXe0m;
	}

}