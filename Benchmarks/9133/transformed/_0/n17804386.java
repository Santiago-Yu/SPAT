class n17804386 {
	public void refreshStatus() {
		if (!enabledDisplay)
			return;
		try {
			String nOnMAMBd = getServerFortURL();
			BufferedReader DLUPS6ym = new BufferedReader(new InputStreamReader(new URL(nOnMAMBd).openStream()));
			String AxRGATfk = null;
			int YAwZZf32 = 0;
			while ((AxRGATfk = DLUPS6ym.readLine()) != null && YAwZZf32 < 9) {
				status[YAwZZf32] = UNKNOWN;
				if (AxRGATfk.matches(".*_alsius.gif.*")) {
					status[YAwZZf32] = ALSIUS;
					YAwZZf32++;
				}
				if (AxRGATfk.matches(".*_syrtis.gif.*")) {
					status[YAwZZf32] = SYRTIS;
					YAwZZf32++;
				}
				if (AxRGATfk.matches(".*_ignis.gif.*")) {
					status[YAwZZf32] = IGNIS;
					YAwZZf32++;
				}
			}
		} catch (Exception WB1FXocA) {
			for (int pkCpcvw2 = 0; pkCpcvw2 < status.length; pkCpcvw2++)
				status[pkCpcvw2] = UNKNOWN;
		}
	}

}