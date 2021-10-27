class n7041871 {
	public static void bubbleSort(int[] KHgtBb59) {
		for (int c9dQ2TZ9 = 0; c9dQ2TZ9 < KHgtBb59.length - 1; c9dQ2TZ9++) {
			for (int TSg8KuJ3 = 0; TSg8KuJ3 < KHgtBb59.length - c9dQ2TZ9 - 1; TSg8KuJ3++) {
				if (KHgtBb59[TSg8KuJ3] > KHgtBb59[TSg8KuJ3 + 1]) {
					int MXjEwQFM = KHgtBb59[TSg8KuJ3];
					KHgtBb59[TSg8KuJ3] = KHgtBb59[TSg8KuJ3 + 1];
					KHgtBb59[TSg8KuJ3 + 1] = MXjEwQFM;
				}
			}
			System.out.println("??" + (c9dQ2TZ9 + 1) + "??????");
			for (int z0oim4yE = 0; z0oim4yE < KHgtBb59.length; z0oim4yE++) {
				System.out.print(KHgtBb59[z0oim4yE] + " ");
			}
			System.out.println();
		}
	}

}