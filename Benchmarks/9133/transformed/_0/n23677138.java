class n23677138 {
	public static void BubbleSortDouble2(double[] McpO05g1) {
		int cHwOQAdz;
		int OrOA9byF = McpO05g1.length - 1;
		do {
			cHwOQAdz = 0;
			for (int GLBvEboF = 0; GLBvEboF < McpO05g1.length - 1; GLBvEboF++) {
				if (McpO05g1[GLBvEboF] > McpO05g1[GLBvEboF + 1]) {
					double gaHKO8pG = McpO05g1[GLBvEboF];
					McpO05g1[GLBvEboF] = McpO05g1[GLBvEboF + 1];
					McpO05g1[GLBvEboF + 1] = gaHKO8pG;
					cHwOQAdz = GLBvEboF;
				}
			}
			OrOA9byF = cHwOQAdz;
		} while (OrOA9byF > 0);
	}

}