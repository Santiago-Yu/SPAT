class n23677144 {
	public static void BubbleSortByte2(byte[] cURhn6Qj) {
		int sBw90ewJ;
		int BHoNyCxp = cURhn6Qj.length - 1;
		do {
			sBw90ewJ = 0;
			for (int vhonJnMP = 0; vhonJnMP < cURhn6Qj.length - 1; vhonJnMP++) {
				if (cURhn6Qj[vhonJnMP] > cURhn6Qj[vhonJnMP + 1]) {
					byte Wk5zmRim = cURhn6Qj[vhonJnMP];
					cURhn6Qj[vhonJnMP] = cURhn6Qj[vhonJnMP + 1];
					cURhn6Qj[vhonJnMP + 1] = Wk5zmRim;
					sBw90ewJ = vhonJnMP;
				}
			}
			BHoNyCxp = sBw90ewJ;
		} while (BHoNyCxp > 0);
	}

}