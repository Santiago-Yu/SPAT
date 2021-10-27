class n338852 {
	public static void sort(float MvNWwzGR[]) {
		float UMfVzEla;
		for (int fcpH4P8N = 0; fcpH4P8N < 7; fcpH4P8N++) {
			for (int XkoK7sOn = 0; XkoK7sOn < 7; XkoK7sOn++) {
				if (MvNWwzGR[XkoK7sOn] > MvNWwzGR[XkoK7sOn + 1]) {
					UMfVzEla = MvNWwzGR[XkoK7sOn];
					MvNWwzGR[XkoK7sOn] = MvNWwzGR[XkoK7sOn + 1];
					MvNWwzGR[XkoK7sOn + 1] = UMfVzEla;
				}
			}
		}
		printFixed(MvNWwzGR[0]);
		print(" ");
		printFixed(MvNWwzGR[1]);
		print(" ");
		printFixed(MvNWwzGR[2]);
		print(" ");
		printFixed(MvNWwzGR[3]);
		print(" ");
		printFixed(MvNWwzGR[4]);
		print(" ");
		printFixed(MvNWwzGR[5]);
		print(" ");
		printFixed(MvNWwzGR[6]);
		print(" ");
		printFixed(MvNWwzGR[7]);
		print("\n");
	}

}