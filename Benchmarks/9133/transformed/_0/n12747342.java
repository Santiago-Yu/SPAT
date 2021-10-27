class n12747342 {
	public void bubbleSort(final int[] VGWLzNWY) {
		source = VGWLzNWY;
		if (source.length < 2)
			return;
		boolean f6hTQ33z = true;
		while (f6hTQ33z) {
			f6hTQ33z = false;
			for (int KqUAOjJZ = 0; KqUAOjJZ < source.length - 1; KqUAOjJZ++) {
				int FcbeshDd = source[KqUAOjJZ];
				if (FcbeshDd > source[KqUAOjJZ + 1]) {
					source[KqUAOjJZ] = source[KqUAOjJZ + 1];
					source[KqUAOjJZ + 1] = FcbeshDd;
					f6hTQ33z = true;
				}
			}
		}
	}

}