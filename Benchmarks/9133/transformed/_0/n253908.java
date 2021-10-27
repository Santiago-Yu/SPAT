class n253908 {
	public static void main(String Q9PUdGA0[]) {
		int EKLyzHBp, nRjEU90E, sdwPbgLc;
		short XwAVbhmk = 256;
		short MEi2Ii5a[] = new short[XwAVbhmk];
		Darjeeling.print("START");
		for (sdwPbgLc = 0; sdwPbgLc < 100; sdwPbgLc++) {
			for (EKLyzHBp = 0; EKLyzHBp < XwAVbhmk; EKLyzHBp++)
				MEi2Ii5a[EKLyzHBp] = (short) (XwAVbhmk - 1 - EKLyzHBp);
			for (EKLyzHBp = 0; EKLyzHBp < XwAVbhmk; EKLyzHBp++) {
				for (nRjEU90E = 0; nRjEU90E < XwAVbhmk - EKLyzHBp - 1; nRjEU90E++)
					if (MEi2Ii5a[nRjEU90E] > MEi2Ii5a[nRjEU90E + 1]) {
						short dK0Q1xdQ = MEi2Ii5a[nRjEU90E];
						MEi2Ii5a[nRjEU90E] = MEi2Ii5a[nRjEU90E + 1];
						MEi2Ii5a[nRjEU90E + 1] = dK0Q1xdQ;
					}
			}
		}
		Darjeeling.print("END");
	}

}