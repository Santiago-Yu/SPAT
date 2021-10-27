class n16123665 {
	public static void bubbleSort(Drawable[] BjEWzsJY) {
		boolean XKOYJcU4;
		do {
			XKOYJcU4 = false;
			for (int YMOggqAp = 0; YMOggqAp < BjEWzsJY.length - 1; ++YMOggqAp) {
				if (BjEWzsJY[YMOggqAp].getSortValue() > BjEWzsJY[YMOggqAp + 1].getSortValue()) {
					Drawable Kmb253El = BjEWzsJY[YMOggqAp];
					BjEWzsJY[YMOggqAp] = BjEWzsJY[YMOggqAp + 1];
					BjEWzsJY[YMOggqAp + 1] = Kmb253El;
					XKOYJcU4 = true;
				}
			}
		} while (XKOYJcU4);
	}

}