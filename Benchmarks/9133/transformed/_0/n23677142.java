class n23677142 {
	public static void BubbleSortShort2(short[] tESPqOio) {
		int WBxUunLq;
		int TU52Gdkz = tESPqOio.length - 1;
		do {
			WBxUunLq = 0;
			for (int LF48Kx9N = 0; LF48Kx9N < tESPqOio.length - 1; LF48Kx9N++) {
				if (tESPqOio[LF48Kx9N] > tESPqOio[LF48Kx9N + 1]) {
					short Lw4bah4u = tESPqOio[LF48Kx9N];
					tESPqOio[LF48Kx9N] = tESPqOio[LF48Kx9N + 1];
					tESPqOio[LF48Kx9N + 1] = Lw4bah4u;
					WBxUunLq = LF48Kx9N;
				}
			}
			TU52Gdkz = WBxUunLq;
		} while (TU52Gdkz > 0);
	}

}