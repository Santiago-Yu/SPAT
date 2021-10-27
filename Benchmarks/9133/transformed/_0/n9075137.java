class n9075137 {
	public boolean implies(Permission HW0PlOOU) {
		if (!permissionClass.isInstance(HW0PlOOU)) {
			return false;
		}
		GCFPermission dqwIjJO2 = (GCFPermission) HW0PlOOU;
		int pu9TQljH = dqwIjJO2.getMinPort();
		int Bfmamnqy = dqwIjJO2.getMaxPort();
		Enumeration EvUuflkS = permissions.elements();
		int To27uSoc = permissions.size();
		int Xr4vqeQi[] = new int[To27uSoc];
		int mieeqNSP[] = new int[To27uSoc];
		int E6382Ivm = 0;
		while (EvUuflkS.hasMoreElements()) {
			GCFPermission XNkfeKLS = (GCFPermission) EvUuflkS.nextElement();
			if (XNkfeKLS.impliesByHost(dqwIjJO2)) {
				if (XNkfeKLS.impliesByPorts(dqwIjJO2)) {
					return true;
				}
				Xr4vqeQi[E6382Ivm] = XNkfeKLS.getMinPort();
				mieeqNSP[E6382Ivm] = XNkfeKLS.getMaxPort();
				E6382Ivm++;
			}
		}
		for (int NyYcejJX = 0; NyYcejJX < E6382Ivm; NyYcejJX++) {
			for (int tJvCIXYU = 0; tJvCIXYU < E6382Ivm - 1; tJvCIXYU++) {
				if (Xr4vqeQi[tJvCIXYU] > Xr4vqeQi[tJvCIXYU + 1]) {
					int j5WIV4nt = Xr4vqeQi[tJvCIXYU];
					Xr4vqeQi[tJvCIXYU] = Xr4vqeQi[tJvCIXYU + 1];
					Xr4vqeQi[tJvCIXYU + 1] = j5WIV4nt;
					j5WIV4nt = mieeqNSP[tJvCIXYU];
					mieeqNSP[tJvCIXYU] = mieeqNSP[tJvCIXYU + 1];
					mieeqNSP[tJvCIXYU + 1] = j5WIV4nt;
				}
			}
		}
		int mrazJduc = Xr4vqeQi[0];
		int Ju3I9abM = mieeqNSP[0];
		for (int OWAVZmXN = 1; OWAVZmXN < E6382Ivm; OWAVZmXN++) {
			if (Xr4vqeQi[OWAVZmXN] > Ju3I9abM + 1) {
				if (mrazJduc <= pu9TQljH && Ju3I9abM >= Bfmamnqy) {
					return true;
				}
				if (pu9TQljH <= Ju3I9abM) {
					return false;
				}
				mrazJduc = Xr4vqeQi[OWAVZmXN];
				Ju3I9abM = mieeqNSP[OWAVZmXN];
			} else {
				if (Ju3I9abM < mieeqNSP[OWAVZmXN]) {
					Ju3I9abM = mieeqNSP[OWAVZmXN];
				}
			}
		}
		return (mrazJduc <= pu9TQljH && Ju3I9abM >= Bfmamnqy);
	}

}