class n3766029 {
	public String uploadZtree(ArrayList XqMHtymA) {
		try {
			String PaZVdsxl = generateRandomId();
			Iterator FqUMAh3P = XqMHtymA.iterator();
			URL Qkq09u3D = new URL(ZorobotSystem.props.getProperty("zoro.url") + "auplo1.jsp");
			URLConnection IyLodrl0 = Qkq09u3D.openConnection();
			IyLodrl0.setDoOutput(true);
			PrintWriter Y2kchnsX = new PrintWriter(IyLodrl0.getOutputStream());
			Y2kchnsX.print("id=" + PaZVdsxl + "&");
			StringBuffer rL5wFQ0O = new StringBuffer();
			int zdALIEmU = 0;
			while (FqUMAh3P.hasNext()) {
				if (zdALIEmU++ >= 500)
					break;
				String cTEfilj4 = (String) FqUMAh3P.next();
				rL5wFQ0O.append("a=");
				rL5wFQ0O.append(URLEncoder.encode(cTEfilj4, "UTF-8"));
				if (FqUMAh3P.hasNext() && zdALIEmU < 500)
					rL5wFQ0O.append("&");
			}
			Y2kchnsX.println(rL5wFQ0O.toString());
			Y2kchnsX.close();
			BufferedReader YEU1kHjO = new BufferedReader(new InputStreamReader(IyLodrl0.getInputStream()));
			String SCDJPCXU;
			if ((SCDJPCXU = YEU1kHjO.readLine()) != null) {
				if (!SCDJPCXU.equals("OK!") && SCDJPCXU.length() > 3) {
					System.out.println("Not OK: " + SCDJPCXU);
					return "xxxxxxxxxx";
				}
			}
			YEU1kHjO.close();
			return PaZVdsxl;
		} catch (Exception CGTGBBE5) {
			CGTGBBE5.printStackTrace();
		}
		return null;
	}

}