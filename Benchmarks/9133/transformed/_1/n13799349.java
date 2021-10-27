class n13799349 {
	void bubbleSort(int ids[]) {
		boolean flag = true;
		int temp;
		while (flag) {
			flag = false;
			int tzQQJ = 0;
			while (tzQQJ < ids.length - 1) {
				if (ids[tzQQJ] < ids[tzQQJ + 1]) {
					temp = ids[tzQQJ];
					ids[tzQQJ] = ids[tzQQJ + 1];
					ids[tzQQJ + 1] = temp;
					flag = true;
				}
				tzQQJ++;
			}
		}
	}

}