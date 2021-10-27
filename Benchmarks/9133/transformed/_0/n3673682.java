class n3673682 {
	private void DrawModel(Graphics V2MDaCJ8, int XZDrnMLD, boolean Q9ujqY8N, float NaGrIFLD, float n8uYvDsg,
			int MuVrwxSt, int xle7gfPp) {
		int SVxqA1iO[] = new int[3];
		int kP0Q4wLY[] = new int[3];
		int Me15ibfz = 0;
		int TxxAEICs[] = new int[xle7gfPp];
		double eUSosJi4[] = new double[xle7gfPp];
		rotate(MuVrwxSt);
		V2MDaCJ8.setColor(Color.black);
		for (int gz5Juku2 = 0; gz5Juku2 < xle7gfPp; gz5Juku2++) {
			double ys4HRsMq = fc[gz5Juku2].vt1.x - fc[gz5Juku2].vt0.x;
			double ybyVnrcZ = fc[gz5Juku2].vt1.y - fc[gz5Juku2].vt0.y;
			double XWitxCVX = fc[gz5Juku2].vt1.z - fc[gz5Juku2].vt0.z;
			double xngkkrRB = fc[gz5Juku2].vt2.x - fc[gz5Juku2].vt1.x;
			double mHyeyBm2 = fc[gz5Juku2].vt2.y - fc[gz5Juku2].vt1.y;
			double M821ozti = fc[gz5Juku2].vt2.z - fc[gz5Juku2].vt1.z;
			fc[gz5Juku2].nx = ybyVnrcZ * M821ozti - XWitxCVX * mHyeyBm2;
			fc[gz5Juku2].ny = XWitxCVX * xngkkrRB - ys4HRsMq * M821ozti;
			fc[gz5Juku2].nz = ys4HRsMq * mHyeyBm2 - ybyVnrcZ * xngkkrRB;
			if (fc[gz5Juku2].nz < 0) {
				fc[gz5Juku2].nx = ybyVnrcZ * M821ozti - XWitxCVX * mHyeyBm2;
				fc[gz5Juku2].ny = XWitxCVX * xngkkrRB - ys4HRsMq * M821ozti;
				TxxAEICs[Me15ibfz] = gz5Juku2;
				eUSosJi4[Me15ibfz] = fc[gz5Juku2].getDepth();
				Me15ibfz++;
			}
		}
		int fLBH488p = Me15ibfz - 1;
		do {
			int f4vjEG8o = 0;
			for (int jKMLhDXT = 0; jKMLhDXT <= fLBH488p - 1; jKMLhDXT++) {
				if (eUSosJi4[jKMLhDXT] < eUSosJi4[jKMLhDXT + 1]) {
					double bUKaMkqi = eUSosJi4[jKMLhDXT];
					eUSosJi4[jKMLhDXT] = eUSosJi4[jKMLhDXT + 1];
					eUSosJi4[jKMLhDXT + 1] = bUKaMkqi;
					int cc1DEUAY = TxxAEICs[jKMLhDXT];
					TxxAEICs[jKMLhDXT] = TxxAEICs[jKMLhDXT + 1];
					TxxAEICs[jKMLhDXT + 1] = cc1DEUAY;
					f4vjEG8o = jKMLhDXT;
				}
			}
			fLBH488p = f4vjEG8o;
		} while (fLBH488p != 0);
		for (int Bx81PLNO = 0; Bx81PLNO < Me15ibfz; Bx81PLNO++) {
			int Ao3ibhks = TxxAEICs[Bx81PLNO];
			double qNQcI41j = Math.sqrt(fc[Ao3ibhks].nx * fc[Ao3ibhks].nx + fc[Ao3ibhks].ny * fc[Ao3ibhks].ny
					+ fc[Ao3ibhks].nz * fc[Ao3ibhks].nz);
			test(V2MDaCJ8, Ao3ibhks, qNQcI41j, NaGrIFLD, n8uYvDsg);
			SVxqA1iO[0] = (int) (fc[Ao3ibhks].vt0.x * m_Scale + centerp.x);
			kP0Q4wLY[0] = (int) (-fc[Ao3ibhks].vt0.y * m_Scale + centerp.y);
			SVxqA1iO[1] = (int) (fc[Ao3ibhks].vt1.x * m_Scale + centerp.x);
			kP0Q4wLY[1] = (int) (-fc[Ao3ibhks].vt1.y * m_Scale + centerp.y);
			SVxqA1iO[2] = (int) (fc[Ao3ibhks].vt2.x * m_Scale + centerp.x);
			kP0Q4wLY[2] = (int) (-fc[Ao3ibhks].vt2.y * m_Scale + centerp.y);
			V2MDaCJ8.fillPolygon(SVxqA1iO, kP0Q4wLY, 3);
		}
		if (labelFlag && Q9ujqY8N) {
			V2MDaCJ8.setFont(Fonts.FONT_REAL);
			V2MDaCJ8.drawString(d_con.getPointerData().getRealObjName(XZDrnMLD),
					(int) ((fc[0].vt0.x + 10) * m_Scale + centerp.x),
					(int) (-(fc[0].vt0.y + 10) * m_Scale + centerp.y));
		}
	}

}