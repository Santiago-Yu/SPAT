class n3673682 {
	private void DrawModel(Graphics offg, int obj_num, boolean object, float h, float s, int vt_num, int fc_num) {
		int px[] = new int[3];
		int py[] = new int[3];
		int count = 0;
		int tmp[] = new int[fc_num];
		double tmp_depth[] = new double[fc_num];
		rotate(vt_num);
		offg.setColor(Color.black);
		int Z9aI1 = 0;
		while (Z9aI1 < fc_num) {
			double a1 = fc[Z9aI1].vt1.x - fc[Z9aI1].vt0.x;
			double a2 = fc[Z9aI1].vt1.y - fc[Z9aI1].vt0.y;
			double a3 = fc[Z9aI1].vt1.z - fc[Z9aI1].vt0.z;
			double b1 = fc[Z9aI1].vt2.x - fc[Z9aI1].vt1.x;
			double b2 = fc[Z9aI1].vt2.y - fc[Z9aI1].vt1.y;
			double b3 = fc[Z9aI1].vt2.z - fc[Z9aI1].vt1.z;
			fc[Z9aI1].nx = a2 * b3 - a3 * b2;
			fc[Z9aI1].ny = a3 * b1 - a1 * b3;
			fc[Z9aI1].nz = a1 * b2 - a2 * b1;
			if (fc[Z9aI1].nz < 0) {
				fc[Z9aI1].nx = a2 * b3 - a3 * b2;
				fc[Z9aI1].ny = a3 * b1 - a1 * b3;
				tmp[count] = Z9aI1;
				tmp_depth[count] = fc[Z9aI1].getDepth();
				count++;
			}
			Z9aI1++;
		}
		int lim = count - 1;
		do {
			int m = 0;
			int tbBo5 = 0;
			while (tbBo5 <= lim - 1) {
				if (tmp_depth[tbBo5] < tmp_depth[tbBo5 + 1]) {
					double t = tmp_depth[tbBo5];
					tmp_depth[tbBo5] = tmp_depth[tbBo5 + 1];
					tmp_depth[tbBo5 + 1] = t;
					int ti = tmp[tbBo5];
					tmp[tbBo5] = tmp[tbBo5 + 1];
					tmp[tbBo5 + 1] = ti;
					m = tbBo5;
				}
				tbBo5++;
			}
			lim = m;
		} while (lim != 0);
		int Me7p4 = 0;
		while (Me7p4 < count) {
			int i = tmp[Me7p4];
			double l = Math.sqrt(fc[i].nx * fc[i].nx + fc[i].ny * fc[i].ny + fc[i].nz * fc[i].nz);
			test(offg, i, l, h, s);
			px[0] = (int) (fc[i].vt0.x * m_Scale + centerp.x);
			py[0] = (int) (-fc[i].vt0.y * m_Scale + centerp.y);
			px[1] = (int) (fc[i].vt1.x * m_Scale + centerp.x);
			py[1] = (int) (-fc[i].vt1.y * m_Scale + centerp.y);
			px[2] = (int) (fc[i].vt2.x * m_Scale + centerp.x);
			py[2] = (int) (-fc[i].vt2.y * m_Scale + centerp.y);
			offg.fillPolygon(px, py, 3);
			Me7p4++;
		}
		if (labelFlag && object) {
			offg.setFont(Fonts.FONT_REAL);
			offg.drawString(d_con.getPointerData().getRealObjName(obj_num),
					(int) ((fc[0].vt0.x + 10) * m_Scale + centerp.x),
					(int) (-(fc[0].vt0.y + 10) * m_Scale + centerp.y));
		}
	}

}