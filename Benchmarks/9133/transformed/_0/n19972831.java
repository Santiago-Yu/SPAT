class n19972831 {
	public static int[] simplex_reverse_sort(int[] Pgc7yzI8) {
		if (Pgc7yzI8.length <= 1)
			return Pgc7yzI8;
		for (int sOAXEQQq = Pgc7yzI8.length - 1; sOAXEQQq > 0; sOAXEQQq--) {
			for (int RTS8eOiO = 0; RTS8eOiO < sOAXEQQq; RTS8eOiO++) {
				if (Pgc7yzI8[RTS8eOiO + 1] > Pgc7yzI8[RTS8eOiO]) {
					int ZMdklCcz = Pgc7yzI8[RTS8eOiO];
					Pgc7yzI8[RTS8eOiO] = Pgc7yzI8[RTS8eOiO + 1];
					Pgc7yzI8[RTS8eOiO + 1] = ZMdklCcz;
				}
			}
		}
		return Pgc7yzI8;
	}

}