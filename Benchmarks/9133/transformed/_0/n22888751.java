class n22888751 {
	public static float medianElement(float[] lGuSGA99, int A0NeusCD) {
		float[] SnyKoi0z = new float[A0NeusCD];
		System.arraycopy(lGuSGA99, 0, SnyKoi0z, 0, A0NeusCD);
		boolean Rn3K3g8d = true;
		while (Rn3K3g8d) {
			Rn3K3g8d = false;
			for (int RVNh3mft = 0; RVNh3mft < A0NeusCD - 1; RVNh3mft++) {
				if (SnyKoi0z[RVNh3mft] > SnyKoi0z[RVNh3mft + 1]) {
					Rn3K3g8d = true;
					float XMZbeklo = SnyKoi0z[RVNh3mft];
					SnyKoi0z[RVNh3mft] = SnyKoi0z[RVNh3mft + 1];
					SnyKoi0z[RVNh3mft + 1] = XMZbeklo;
				}
			}
		}
		return SnyKoi0z[A0NeusCD / 2];
	}

}