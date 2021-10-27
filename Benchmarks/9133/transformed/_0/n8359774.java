class n8359774 {
	public static void bubbleSort(int[] Q5RaxXjy) {
		if (Q5RaxXjy == null) {
			throw new IllegalArgumentException("Null-pointed array");
		}
		int OrDETnOv = Q5RaxXjy.length - 1;
		int eQVEFIZR = 0;
		while (OrDETnOv > 0) {
			eQVEFIZR = 0;
			for (int wi4O9Ky5 = 0; wi4O9Ky5 <= OrDETnOv - 1; wi4O9Ky5++) {
				if (Q5RaxXjy[wi4O9Ky5] > Q5RaxXjy[wi4O9Ky5 + 1]) {
					eQVEFIZR = wi4O9Ky5;
					int RxIQjnxF = Q5RaxXjy[wi4O9Ky5];
					Q5RaxXjy[wi4O9Ky5] = Q5RaxXjy[wi4O9Ky5 + 1];
					Q5RaxXjy[wi4O9Ky5 + 1] = RxIQjnxF;
				}
			}
			OrDETnOv = eQVEFIZR;
		}
	}

}