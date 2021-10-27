class n17542340 {
	public GEItem lookup(final int ivyy2Ov1) {
		try {
			URL z4Nb1n8A = new URL(GrandExchange.HOST + GrandExchange.GET + ivyy2Ov1);
			BufferedReader DsZxtZPL = new BufferedReader(new InputStreamReader(z4Nb1n8A.openStream()));
			String UZEeoPb2;
			boolean dKR3P65e = false;
			int J0gAX4wl = 0;
			double[] ms6PR0rP = new double[4];
			String ZRgBrK31 = "", iBKbJVE6 = "";
			while ((UZEeoPb2 = DsZxtZPL.readLine()) != null) {
				if (UZEeoPb2.contains("<div class=\"brown_box main_ge_page") && !dKR3P65e) {
					if (!UZEeoPb2.contains("vertically_spaced")) {
						return null;
					}
					dKR3P65e = true;
					DsZxtZPL.readLine();
					DsZxtZPL.readLine();
					ZRgBrK31 = DsZxtZPL.readLine();
				} else if (UZEeoPb2.contains("<img id=\"item_image\" src=\"")) {
					iBKbJVE6 = DsZxtZPL.readLine();
				} else if (UZEeoPb2.matches("(?i).+ (price|days):</b> .+")) {
					ms6PR0rP[J0gAX4wl] = parse(UZEeoPb2);
					J0gAX4wl++;
				} else if (UZEeoPb2.matches("<div id=\"legend\">"))
					break;
			}
			return new GEItem(ZRgBrK31, iBKbJVE6, ivyy2Ov1, ms6PR0rP);
		} catch (IOException ch6SfRiq) {
		}
		return null;
	}

}