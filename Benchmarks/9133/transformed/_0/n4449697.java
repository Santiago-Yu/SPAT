class n4449697 {
	private int[] sortNodesToGoal(Graph QXlamDpp, int d2bDcXLw, int z5VFWHJa) {
		float IBgwXQ9r, wFZkDLGf;
		int vS36Oc7k, P2QFEmrG;
		float JS8FsjEv;
		int UfXXMO8x = QXlamDpp.nodeList[d2bDcXLw].edges.length;
		int[] dNAff9fe = new int[UfXXMO8x];
		float[] imsXv2i3 = new float[UfXXMO8x];
		int[] JDxvHgI7 = new int[UfXXMO8x];
		if (UfXXMO8x == 0)
			return null;
		if (UfXXMO8x == 1) {
			JDxvHgI7[0] = 0;
			return JDxvHgI7;
		}
		for (int x3OLffMd = 0; x3OLffMd < UfXXMO8x; x3OLffMd++) {
			dNAff9fe[x3OLffMd] = QXlamDpp.getOtherNode(d2bDcXLw, QXlamDpp.nodeList[d2bDcXLw].edges[x3OLffMd]);
			IBgwXQ9r = QXlamDpp.nodeList[dNAff9fe[x3OLffMd]].x - QXlamDpp.nodeList[z5VFWHJa].x;
			wFZkDLGf = QXlamDpp.nodeList[dNAff9fe[x3OLffMd]].y - QXlamDpp.nodeList[z5VFWHJa].y;
			imsXv2i3[x3OLffMd] = (float) Math.sqrt(IBgwXQ9r * IBgwXQ9r + wFZkDLGf * wFZkDLGf);
			JDxvHgI7[x3OLffMd] = x3OLffMd;
		}
		for (int AuZI6WV6 = UfXXMO8x - 1; AuZI6WV6 >= 0; AuZI6WV6--) {
			for (int emVBnYa9 = 0; emVBnYa9 < AuZI6WV6; emVBnYa9++) {
				if (imsXv2i3[emVBnYa9] > imsXv2i3[emVBnYa9 + 1]) {
					vS36Oc7k = dNAff9fe[emVBnYa9];
					dNAff9fe[emVBnYa9] = dNAff9fe[emVBnYa9 + 1];
					dNAff9fe[emVBnYa9 + 1] = vS36Oc7k;
					JS8FsjEv = imsXv2i3[emVBnYa9];
					imsXv2i3[emVBnYa9] = imsXv2i3[emVBnYa9 + 1];
					imsXv2i3[emVBnYa9 + 1] = JS8FsjEv;
					P2QFEmrG = JDxvHgI7[emVBnYa9];
					JDxvHgI7[emVBnYa9] = JDxvHgI7[emVBnYa9 + 1];
					JDxvHgI7[emVBnYa9 + 1] = P2QFEmrG;
				}
			}
		}
		return JDxvHgI7;
	}

}