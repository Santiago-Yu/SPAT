class n23677145 {
	public static <T extends Comparable<T>> void BubbleSortComparable1(T[] e0oZ4BIa) {
		int P77t3omq;
		boolean SqjsavvQ = true; // set flag to true to begin first pass
		T kGHVjhGD; // holding variable

		while (SqjsavvQ) {
			SqjsavvQ = false; // set flag to false awaiting a possible swap
			for (P77t3omq = 0; P77t3omq < e0oZ4BIa.length - 1; P77t3omq++) {
				if (e0oZ4BIa[P77t3omq].compareTo(e0oZ4BIa[P77t3omq + 1]) > 0) // change to > for ascending sort
				{
					kGHVjhGD = e0oZ4BIa[P77t3omq]; // swap elements
					e0oZ4BIa[P77t3omq] = e0oZ4BIa[P77t3omq + 1];
					e0oZ4BIa[P77t3omq + 1] = kGHVjhGD;
					SqjsavvQ = true; // shows a swap occurred
				}
			}
		}
	}

}