class n21273058 {
	public RobotList<Percentage> sort_decr_Percentage(RobotList<Percentage> Y2I9UlcJ, String QnMYv94N) {
		int G77duplK = Y2I9UlcJ.size();
		Index_value[] R16sMjVx = new Index_value[G77duplK];
		for (int y63Z2ov9 = 0; y63Z2ov9 < G77duplK; y63Z2ov9++) {
			R16sMjVx[y63Z2ov9] = new Index_value(y63Z2ov9, Y2I9UlcJ.get(y63Z2ov9).percent);
		}
		boolean ibNRvhY5;
		do {
			ibNRvhY5 = false;
			for (int kUqLTguy = 0; kUqLTguy < G77duplK - 1; kUqLTguy++) {
				if (R16sMjVx[kUqLTguy].value < R16sMjVx[kUqLTguy + 1].value) {
					Index_value M3ryyXSl = R16sMjVx[kUqLTguy];
					R16sMjVx[kUqLTguy] = R16sMjVx[kUqLTguy + 1];
					R16sMjVx[kUqLTguy + 1] = M3ryyXSl;
					ibNRvhY5 = true;
				}
			}
		} while (ibNRvhY5);
		RobotList<Percentage> DfI0AoSW = new RobotList<Percentage>(Percentage.class);
		for (int zXu8jUV6 = 0; zXu8jUV6 < G77duplK; zXu8jUV6++) {
			DfI0AoSW.addLast(new Percentage(R16sMjVx[zXu8jUV6].value));
		}
		return DfI0AoSW;
	}

}