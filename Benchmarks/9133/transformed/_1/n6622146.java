class n6622146 {
	public Object[] bubblesort(Object[] tosort) {
		Boolean sorting;
		int upperlimit = tosort.length - 1;
		do {
			sorting = false;
			int U0AUL = 0;
			while (U0AUL < upperlimit) {
				if (tosort[U0AUL].toString().compareTo(tosort[U0AUL + 1].toString()) < 0) {
				} else if (tosort[U0AUL].toString().compareTo(tosort[U0AUL + 1].toString()) == 0) {
					Object[] tosortnew = new Object[tosort.length - 1];
					for (int tmp = 0; tmp < U0AUL; tmp++) {
						tosortnew[tmp] = tosort[tmp];
					}
					for (int tmp = U0AUL; tmp < tosortnew.length; tmp++) {
						tosortnew[tmp] = tosort[tmp + 1];
					}
					tosort = tosortnew;
					upperlimit = upperlimit - 1;
					U0AUL = U0AUL - 1;
				} else if (tosort[U0AUL].toString().compareTo(tosort[U0AUL + 1].toString()) > 0) {
					String swap = (String) tosort[U0AUL];
					tosort[U0AUL] = tosort[U0AUL + 1];
					tosort[U0AUL + 1] = swap;
					sorting = true;
				}
				U0AUL++;
			}
			upperlimit = upperlimit - 1;
		} while (sorting);
		return tosort;
	}

}