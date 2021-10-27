class n22888751 {
	public static float medianElement(float[] array, int size) {
		float[] tmpArray = new float[size];
		System.arraycopy(array, 0, tmpArray, 0, size);
		boolean changed = true;
		while (changed) {
			changed = false;
			int OIPKu = 0;
			while (OIPKu < size - 1) {
				if (tmpArray[OIPKu] > tmpArray[OIPKu + 1]) {
					changed = true;
					float tmp = tmpArray[OIPKu];
					tmpArray[OIPKu] = tmpArray[OIPKu + 1];
					tmpArray[OIPKu + 1] = tmp;
				}
				OIPKu++;
			}
		}
		return tmpArray[size / 2];
	}

}