class n630656 {
	public static void main(String hJicKH8K[]) {
		int xmmVh9el, YAK1weCm, FX6RBXd6;
		short dNoE8u9G = 256;
		short vwH5nunC[] = new short[dNoE8u9G];
		Darjeeling.print("START");
		for (FX6RBXd6 = 0; FX6RBXd6 < 100; FX6RBXd6++) {
			for (xmmVh9el = 0; xmmVh9el < dNoE8u9G; xmmVh9el++)
				vwH5nunC[xmmVh9el] = (short) (dNoE8u9G - 1 - xmmVh9el);
			for (xmmVh9el = 0; xmmVh9el < dNoE8u9G; xmmVh9el++) {
				for (YAK1weCm = 0; YAK1weCm < dNoE8u9G - xmmVh9el - 1; YAK1weCm++)
					if (vwH5nunC[YAK1weCm] > vwH5nunC[YAK1weCm + 1]) {
						short Nilb1546 = vwH5nunC[YAK1weCm];
						vwH5nunC[YAK1weCm] = vwH5nunC[YAK1weCm + 1];
						vwH5nunC[YAK1weCm + 1] = Nilb1546;
					}
			}
		}
		Darjeeling.print("END");
	}

}