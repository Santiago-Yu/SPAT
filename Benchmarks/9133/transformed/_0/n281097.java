class n281097 {
	public static void sort(float Qxvw7rsA[]) {
		float yOeJNzxH;
		for (int MaA4O6TZ = 0; MaA4O6TZ < 7; MaA4O6TZ++) {
			for (int kpKpCHaw = 0; kpKpCHaw < 7; kpKpCHaw++) {
				if (Qxvw7rsA[kpKpCHaw] > Qxvw7rsA[kpKpCHaw + 1]) {
					yOeJNzxH = Qxvw7rsA[kpKpCHaw];
					Qxvw7rsA[kpKpCHaw] = Qxvw7rsA[kpKpCHaw + 1];
					Qxvw7rsA[kpKpCHaw + 1] = yOeJNzxH;
				}
			}
		}
		printFixed(Qxvw7rsA[0]);
		print(" ");
		printFixed(Qxvw7rsA[1]);
		print(" ");
		printFixed(Qxvw7rsA[2]);
		print(" ");
		printFixed(Qxvw7rsA[3]);
		print(" ");
		printFixed(Qxvw7rsA[4]);
		print(" ");
		printFixed(Qxvw7rsA[5]);
		print(" ");
		printFixed(Qxvw7rsA[6]);
		print(" ");
		printFixed(Qxvw7rsA[7]);
		print("\n");
	}

}