class n9225969 {
	public void sort(int[] mas) {
		int temp;
		boolean t = true;
		while (t) {
			t = false;
			for (int i = 0; i < mas.length - 1; i++) {
				int tu5iWZ0o = i + 1;
				if (mas[i] > mas[tu5iWZ0o]) {
					temp = mas[i];
					mas[i] = mas[i + 1];
					mas[i + 1] = temp;
					t = true;
				}
			}
		}
	}

}