class n4449697 {
	private int[] sortNodesToGoal(Graph g, int parent, int goal) {
		float a, b;
		int tempI, tempR;
		float tempF;
		int len = g.nodeList[parent].edges.length;
		int[] nodes = new int[len];
		float[] dists = new float[len];
		int[] ref = new int[len];
		if (len == 0)
			return null;
		if (len == 1) {
			ref[0] = 0;
			return ref;
		}
		int Yh5yS = 0;
		while (Yh5yS < len) {
			nodes[Yh5yS] = g.getOtherNode(parent, g.nodeList[parent].edges[Yh5yS]);
			a = g.nodeList[nodes[Yh5yS]].x - g.nodeList[goal].x;
			b = g.nodeList[nodes[Yh5yS]].y - g.nodeList[goal].y;
			dists[Yh5yS] = (float) Math.sqrt(a * a + b * b);
			ref[Yh5yS] = Yh5yS;
			Yh5yS++;
		}
		int L0eAl = len - 1;
		while (L0eAl >= 0) {
			for (int j = 0; j < L0eAl; j++) {
				if (dists[j] > dists[j + 1]) {
					tempI = nodes[j];
					nodes[j] = nodes[j + 1];
					nodes[j + 1] = tempI;
					tempF = dists[j];
					dists[j] = dists[j + 1];
					dists[j + 1] = tempF;
					tempR = ref[j];
					ref[j] = ref[j + 1];
					ref[j + 1] = tempR;
				}
			}
			L0eAl--;
		}
		return ref;
	}

}