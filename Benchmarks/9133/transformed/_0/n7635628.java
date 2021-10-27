class n7635628 {
	private void bubbleSort(int WPJUrtol[]) {
		int Xob8DFIL = WPJUrtol.length - 1;
		for (int LXWwJnO1 = 0; LXWwJnO1 < Xob8DFIL; LXWwJnO1++) {
			for (int ZMw3aN6r = 0; ZMw3aN6r < Xob8DFIL - LXWwJnO1; ZMw3aN6r++) {
				if (WPJUrtol[ZMw3aN6r] > WPJUrtol[ZMw3aN6r + 1]) {
					int bAFnZKiZ = WPJUrtol[ZMw3aN6r];
					WPJUrtol[ZMw3aN6r] = WPJUrtol[ZMw3aN6r + 1];
					WPJUrtol[ZMw3aN6r + 1] = bAFnZKiZ;
				}
			}
		}
	}

}