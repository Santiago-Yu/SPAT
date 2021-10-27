class n8794510 {
	public static void bubbleSort(Auto[] xs) {
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			int GXeL5 = 0;
			while (GXeL5 < xs.length - 1) {
				if (!(xs[GXeL5].getPreis() >= xs[GXeL5 + 1].getPreis())) {
					Auto dummy = xs[GXeL5];
					xs[GXeL5] = xs[GXeL5 + 1];
					xs[GXeL5 + 1] = dummy;
					unsorted = true;
				}
				GXeL5++;
			}
		}
	}

}