class n22888751 {
	public static float medianElement(float[] array, int size) {
		float[] tmpArray = new float[size];
		System.arraycopy(array, 0, tmpArray, 0, size);
		boolean changed = true;
		for (; changed;) {
			changed = false;
			for (int i = 0; i < size - 1; i++) {
				if (tmpArray[i] > tmpArray[i + 1]) {
					changed = true;
					float tmp = tmpArray[i];
					tmpArray[i] = tmpArray[i + 1];
					tmpArray[i + 1] = tmp;
				}
			}
		}
		return tmpArray[size / 2];
	}

}