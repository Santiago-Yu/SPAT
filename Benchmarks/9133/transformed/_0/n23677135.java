class n23677135 {
	public static void BubbleSortFloat1(float[] OLOQjx71) {
		boolean PqH6Oc9s = true; // set flag to true to begin first pass
		float qR3Pdpn7; // holding variable

		while (PqH6Oc9s) {
			PqH6Oc9s = false; // set flag to false awaiting a possible swap
			for (int UfsXeA1D = 0; UfsXeA1D < OLOQjx71.length - 1; UfsXeA1D++) {
				if (OLOQjx71[UfsXeA1D] > OLOQjx71[UfsXeA1D + 1]) // change to > for ascending sort
				{
					qR3Pdpn7 = OLOQjx71[UfsXeA1D]; // swap elements
					OLOQjx71[UfsXeA1D] = OLOQjx71[UfsXeA1D + 1];
					OLOQjx71[UfsXeA1D + 1] = qR3Pdpn7;
					PqH6Oc9s = true; // shows a swap occurred
				}
			}
		}
	}

}