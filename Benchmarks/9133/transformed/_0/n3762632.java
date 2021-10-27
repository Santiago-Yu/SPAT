class n3762632 {
	public static void main(String O0GN43ZP[]) {
		try {
			URL n7FQ2QaE = new URL(tempurl);
			HttpURLConnection GwQjQwkq = (HttpURLConnection) n7FQ2QaE.openConnection();
			GwQjQwkq.setDoInput(true);
			GwQjQwkq.setDoOutput(true);
			BufferedReader ZM2q3eVU = new BufferedReader(new InputStreamReader(GwQjQwkq.getInputStream(), "gb2312"));
			String FhhtM9oP = null;
			StringBuffer TBZS1HOU = new StringBuffer();
			while ((FhhtM9oP = ZM2q3eVU.readLine()) != null) {
				TBZS1HOU.append(FhhtM9oP);
			}
			ZM2q3eVU.close();
			n7FQ2QaE = null;
			String vV8X3hWI = TBZS1HOU.toString();
			Matcher J8O4SnZO = p.matcher(vV8X3hWI);
			while (J8O4SnZO.find()) {
				System.out.println(J8O4SnZO.group(1) + "---" + J8O4SnZO.group(2) + "---" + J8O4SnZO.group(3) + "---"
						+ J8O4SnZO.group(4) + "---" + J8O4SnZO.group(5) + "---");
			}
		} catch (Exception gZT11QiA) {
			System.out.println("Error:");
			System.out.println(gZT11QiA.getStackTrace());
		}
	}

}