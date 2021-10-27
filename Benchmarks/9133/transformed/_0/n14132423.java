class n14132423 {
	public static void bubble_sort(int[] rmUXL5Ld, int H2ZRbsqT) {
		for (int lJlevJBc = H2ZRbsqT; --lJlevJBc >= 0;) {
			boolean WulCbln0 = false;
			for (int uYB9yaJ1 = 0; uYB9yaJ1 < lJlevJBc; uYB9yaJ1++) {
				if (rmUXL5Ld[uYB9yaJ1 + 1] < rmUXL5Ld[uYB9yaJ1]) {
					int ZsWqqPwl = rmUXL5Ld[uYB9yaJ1];
					rmUXL5Ld[uYB9yaJ1] = rmUXL5Ld[uYB9yaJ1 + 1];
					rmUXL5Ld[uYB9yaJ1 + 1] = ZsWqqPwl;
					WulCbln0 = true;
				}
			}
			if (!WulCbln0)
				return;
		}
	}

}