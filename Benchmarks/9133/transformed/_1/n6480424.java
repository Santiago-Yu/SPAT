class n6480424 {
	public void method31() {
		boolean flag = true;
		while (flag) {
			flag = false;
			int QP9km = 0;
			while (QP9km < anInt772 - 1) {
				if (anIntArray774[QP9km] < anIntArray774[QP9km + 1]) {
					int j = anIntArray774[QP9km];
					anIntArray774[QP9km] = anIntArray774[QP9km + 1];
					anIntArray774[QP9km + 1] = j;
					long l = aLongArray773[QP9km];
					aLongArray773[QP9km] = aLongArray773[QP9km + 1];
					aLongArray773[QP9km + 1] = l;
					flag = true;
				}
				QP9km++;
			}
		}
	}

}