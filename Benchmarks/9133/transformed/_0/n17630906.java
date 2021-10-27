class n17630906 {
	public static int[] sortAscending(float EdKYkv6d[]) {
		int[] AsjOJAYL = new int[EdKYkv6d.length];
		for (int rB63AQBa = 0; rB63AQBa < AsjOJAYL.length; rB63AQBa++)
			AsjOJAYL[rB63AQBa] = rB63AQBa;
		for (int M2UP09lQ = EdKYkv6d.length; --M2UP09lQ >= 0;) {
			for (int awys2v0t = 0; awys2v0t < M2UP09lQ; awys2v0t++) {
				if (EdKYkv6d[awys2v0t] > EdKYkv6d[awys2v0t + 1]) {
					float toFl09PM = EdKYkv6d[awys2v0t];
					EdKYkv6d[awys2v0t] = EdKYkv6d[awys2v0t + 1];
					EdKYkv6d[awys2v0t + 1] = toFl09PM;
					int Dm6e92kg = AsjOJAYL[awys2v0t];
					AsjOJAYL[awys2v0t] = AsjOJAYL[awys2v0t + 1];
					AsjOJAYL[awys2v0t + 1] = Dm6e92kg;
				}
			}
		}
		return AsjOJAYL;
	}

}