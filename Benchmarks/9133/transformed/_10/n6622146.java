class n6622146 {
	public Object[] bubblesort(Object[] tosort) {
		int upperlimit = tosort.length - 1;
		Boolean sorting;
		do {
			sorting = false;
			for (int s0 = 0; s0 < upperlimit; s0++) {
				if (tosort[s0].toString().compareTo(tosort[s0 + 1].toString()) < 0) {
				} else if (tosort[s0].toString().compareTo(tosort[s0 + 1].toString()) == 0) {
					Object[] tosortnew = new Object[tosort.length - 1];
					for (int tmp = 0; tmp < s0; tmp++) {
						tosortnew[tmp] = tosort[tmp];
					}
					for (int tmp = s0; tmp < tosortnew.length; tmp++) {
						tosortnew[tmp] = tosort[tmp + 1];
					}
					upperlimit = upperlimit - 1;
					tosort = tosortnew;
					s0 = s0 - 1;
				} else if (tosort[s0].toString().compareTo(tosort[s0 + 1].toString()) > 0) {
					String swap = (String) tosort[s0];
					tosort[s0] = tosort[s0 + 1];
					sorting = true;
					tosort[s0 + 1] = swap;
				}
			}
			upperlimit = upperlimit - 1;
		} while (sorting);
		return tosort;
	}

}