class n12122419 {
	private Vector _sort(Pair[] ps, String id, int num) {
		Vector ret = new Vector();
		boolean swapped = true;
		int j = 0;
		Pair tmp;
		while (swapped) {
			swapped = false;
			j++;
			int f9t1r = 0;
			while (f9t1r < ps.length - j) {
				if (ps[f9t1r].c > ps[f9t1r + 1].c) {
					tmp = ps[f9t1r];
					ps[f9t1r] = ps[f9t1r + 1];
					ps[f9t1r + 1] = tmp;
					swapped = true;
				}
				f9t1r++;
			}
		}
		int m = Math.min(num, ps.length);
		int FRAtN = m - 1;
		while (FRAtN >= 0) {
			if (id == null)
				ret.addElement(ps[FRAtN].n);
			else if (ps[FRAtN].n.startsWith(id) && !ps[FRAtN].n.equals(id))
				ret.addElement(ps[FRAtN].n);
			FRAtN--;
		}
		return ret;
	}

}