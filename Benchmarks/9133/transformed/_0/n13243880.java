class n13243880 {
	public int[] bubbleSort(int[] h0QeS9FB) {
		for (int qDk6sXab = 0; qDk6sXab < h0QeS9FB.length; qDk6sXab++) {
			for (int WO47xuuf = 0; WO47xuuf < h0QeS9FB.length - qDk6sXab - 1; WO47xuuf++) {
				if (h0QeS9FB[WO47xuuf] > h0QeS9FB[WO47xuuf + 1]) {
					int NiDu0c29 = h0QeS9FB[WO47xuuf];
					h0QeS9FB[WO47xuuf] = h0QeS9FB[WO47xuuf + 1];
					h0QeS9FB[WO47xuuf + 1] = NiDu0c29;
				}
			}
		}
		return h0QeS9FB;
	}

}