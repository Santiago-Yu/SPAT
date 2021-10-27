class n17542340 {
	public GEItem lookup(final int itemID) {
		try {
			URL url = new URL(GrandExchange.HOST + GrandExchange.GET + itemID);
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			int i = 0;
			boolean exists = false;
			String name = "", examine = "";
			double[] values = new double[4];
			while ((input = br.readLine()) != null) {
				if (input.contains("<div class=\"brown_box main_ge_page") && !exists) {
					exists = true;
					if (!input.contains("vertically_spaced")) {
						return null;
					}
					br.readLine();
					br.readLine();
					name = br.readLine();
				} else if (input.contains("<img id=\"item_image\" src=\"")) {
					examine = br.readLine();
				} else if (input.matches("(?i).+ (price|days):</b> .+")) {
					values[i] = parse(input);
					i++;
				} else if (input.matches("<div id=\"legend\">"))
					break;
			}
			return new GEItem(name, examine, itemID, values);
		} catch (IOException ignore) {
		}
		return null;
	}

}