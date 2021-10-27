class n2247987 {
	public static void main(String SimT453Y[]) {
		Matrix LDJMMmEh, INyczM6C, Lvij4epp, CHRR0kUa, hW7E3Z19, tOf5vGyy, GMtCUluj, Eo0gMqn6, cVn8yccg, JRrVnPMU,
				nU6dz8ws, sXDGGRSs, fu2QS4br, c3wRoRR3, AZ6r5Qzj;
		int zQfUEztG = 0;
		int f8QzHAUa = 0;
		double ATLxOaUs, j2OftYyc;
		double[] cdOH1Plg = { 1., 2., 3., 4., 5., 6., 7., 8., 9., 10., 11., 12. };
		double[] xZtc3cH8 = { 1., 4., 7., 10., 2., 5., 8., 11., 3., 6., 9., 12. };
		double[][] foDTN9Gw = { { 1., 4., 7., 10. }, { 2., 5., 8., 11. }, { 3., 6., 9., 12. } };
		double[][] ZozwGhut = foDTN9Gw;
		double[][] HIbMzqGc = { { 1., 2., 3. }, { 4., 5., 6. }, { 7., 8., 9. }, { 10., 11., 12. } };
		double[][] O5H9MtH8 = { { 5., 8., 11. }, { 6., 9., 12. } };
		double[][] X2nG2yPo = { { 1., 4., 7. }, { 2., 5., 8., 11. }, { 3., 6., 9., 12. } };
		double[][] PnCOY5io = { { 4., 1., 1. }, { 1., 2., 3. }, { 1., 3., 6. } };
		double[][] uOrChi4N = { { 1., 0., 0., 0. }, { 0., 1., 0., 0. }, { 0., 0., 1., 0. } };
		double[][] CbfPlTyb = { { 0., 1., 0., 0. }, { 1., 0., 2.e-7, 0. }, { 0., -2.e-7, 0., 1. }, { 0., 0., 1., 0. } };
		double[][] XW2x0Xnz = { { 166., 188., 210. }, { 188., 214., 240. }, { 210., 240., 270. } };
		double[][] XUDsPcof = { { 13. }, { 15. } };
		double[][] osxrZT03 = { { 1., 3. }, { 7., 9. } };
		int zblC1XSk = 3, hkuJOLWu = 4;
		int ejtNxlXk = 5;
		int HQZdbR7w = 0;
		int kQXtZskt = 4;
		int ngeKvyQB = 3;
		int IqaUdviz = 4;
		int ziDqaLLN = 1, g1oqXXB9 = 2, bz0NTbRy = 1, Vq9YBo3d = 3;
		int[] MXeeEASk = { 1, 2 };
		int[] PsWQjYWm = { 1, 3 };
		int[] w1Qq9OMj = { 1, 2, 3 };
		int[] dygopIyV = { 1, 2, 4 };
		double fLcapnQy = 33.;
		double TV8yFdMM = 30.;
		double J2dtELs3 = 15;
		double YCo6lOQb = 650;
		print("\nTesting constructors and constructor-like methods...\n");
		try {
			LDJMMmEh = new Matrix(cdOH1Plg, ejtNxlXk);
			zQfUEztG = try_failure(zQfUEztG, "Catch invalid length in packed constructor... ",
					"exception not thrown for invalid input");
		} catch (IllegalArgumentException C0u6i7N0) {
			try_success("Catch invalid length in packed constructor... ", C0u6i7N0.getMessage());
		}
		try {
			LDJMMmEh = new Matrix(X2nG2yPo);
			ATLxOaUs = LDJMMmEh.get(HQZdbR7w, kQXtZskt);
		} catch (IllegalArgumentException mUE54VkS) {
			try_success("Catch ragged input to default constructor... ", mUE54VkS.getMessage());
		} catch (java.lang.ArrayIndexOutOfBoundsException rtLaXxcp) {
			zQfUEztG = try_failure(zQfUEztG, "Catch ragged input to constructor... ",
					"exception not thrown in construction...ArrayIndexOutOfBoundsException thrown later");
		}
		try {
			LDJMMmEh = Matrix.constructWithCopy(X2nG2yPo);
			ATLxOaUs = LDJMMmEh.get(HQZdbR7w, kQXtZskt);
		} catch (IllegalArgumentException yzlwKQxd) {
			try_success("Catch ragged input to constructWithCopy... ", yzlwKQxd.getMessage());
		} catch (java.lang.ArrayIndexOutOfBoundsException bvf2UXrn) {
			zQfUEztG = try_failure(zQfUEztG, "Catch ragged input to constructWithCopy... ",
					"exception not thrown in construction...ArrayIndexOutOfBoundsException thrown later");
		}
		LDJMMmEh = new Matrix(cdOH1Plg, ngeKvyQB);
		INyczM6C = new Matrix(foDTN9Gw);
		ATLxOaUs = INyczM6C.get(0, 0);
		foDTN9Gw[0][0] = 0.0;
		Lvij4epp = INyczM6C.minus(LDJMMmEh);
		foDTN9Gw[0][0] = ATLxOaUs;
		INyczM6C = Matrix.constructWithCopy(foDTN9Gw);
		ATLxOaUs = INyczM6C.get(0, 0);
		foDTN9Gw[0][0] = 0.0;
		if ((ATLxOaUs - INyczM6C.get(0, 0)) != 0.0) {
			zQfUEztG = try_failure(zQfUEztG, "constructWithCopy... ", "copy not effected... data visible outside");
		} else {
			try_success("constructWithCopy... ", "");
		}
		foDTN9Gw[0][0] = cdOH1Plg[0];
		tOf5vGyy = new Matrix(uOrChi4N);
		try {
			check(tOf5vGyy, Matrix.identity(3, 4));
			try_success("identity... ", "");
		} catch (java.lang.RuntimeException mP3hHKol) {
			zQfUEztG = try_failure(zQfUEztG, "identity... ", "identity Matrix not successfully created");
		}
		print("\nTesting access methods...\n");
		INyczM6C = new Matrix(foDTN9Gw);
		if (INyczM6C.getRowDimension() != zblC1XSk) {
			zQfUEztG = try_failure(zQfUEztG, "getRowDimension... ", "");
		} else {
			try_success("getRowDimension... ", "");
		}
		if (INyczM6C.getColumnDimension() != hkuJOLWu) {
			zQfUEztG = try_failure(zQfUEztG, "getColumnDimension... ", "");
		} else {
			try_success("getColumnDimension... ", "");
		}
		INyczM6C = new Matrix(foDTN9Gw);
		double[][] xHrgDNvJ = INyczM6C.getArray();
		if (xHrgDNvJ != foDTN9Gw) {
			zQfUEztG = try_failure(zQfUEztG, "getArray... ", "");
		} else {
			try_success("getArray... ", "");
		}
		xHrgDNvJ = INyczM6C.getArrayCopy();
		if (xHrgDNvJ == foDTN9Gw) {
			zQfUEztG = try_failure(zQfUEztG, "getArrayCopy... ", "data not (deep) copied");
		}
		try {
			check(xHrgDNvJ, foDTN9Gw);
			try_success("getArrayCopy... ", "");
		} catch (java.lang.RuntimeException Yw6irGql) {
			zQfUEztG = try_failure(zQfUEztG, "getArrayCopy... ", "data not successfully (deep) copied");
		}
		double[] r9nxmEcz = INyczM6C.getColumnPackedCopy();
		try {
			check(r9nxmEcz, cdOH1Plg);
			try_success("getColumnPackedCopy... ", "");
		} catch (java.lang.RuntimeException WJNHGkbZ) {
			zQfUEztG = try_failure(zQfUEztG, "getColumnPackedCopy... ",
					"data not successfully (deep) copied by columns");
		}
		r9nxmEcz = INyczM6C.getRowPackedCopy();
		try {
			check(r9nxmEcz, xZtc3cH8);
			try_success("getRowPackedCopy... ", "");
		} catch (java.lang.RuntimeException u82dIJtk) {
			zQfUEztG = try_failure(zQfUEztG, "getRowPackedCopy... ", "data not successfully (deep) copied by rows");
		}
		try {
			ATLxOaUs = INyczM6C.get(INyczM6C.getRowDimension(), INyczM6C.getColumnDimension() - 1);
			zQfUEztG = try_failure(zQfUEztG, "get(int,int)... ", "OutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException jMvu7wyt) {
			try {
				ATLxOaUs = INyczM6C.get(INyczM6C.getRowDimension() - 1, INyczM6C.getColumnDimension());
				zQfUEztG = try_failure(zQfUEztG, "get(int,int)... ", "OutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException dlTY9vBI) {
				try_success("get(int,int)... OutofBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException v8uDKQP7) {
			zQfUEztG = try_failure(zQfUEztG, "get(int,int)... ", "OutOfBoundsException expected but not thrown");
		}
		try {
			if (INyczM6C.get(INyczM6C.getRowDimension() - 1, INyczM6C.getColumnDimension()
					- 1) != foDTN9Gw[INyczM6C.getRowDimension() - 1][INyczM6C.getColumnDimension() - 1]) {
				zQfUEztG = try_failure(zQfUEztG, "get(int,int)... ", "Matrix entry (i,j) not successfully retreived");
			} else {
				try_success("get(int,int)... ", "");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException Ak4ngr1x) {
			zQfUEztG = try_failure(zQfUEztG, "get(int,int)... ", "Unexpected ArrayIndexOutOfBoundsException");
		}
		JRrVnPMU = new Matrix(O5H9MtH8);
		try {
			nU6dz8ws = INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9 + INyczM6C.getRowDimension() + 1, bz0NTbRy, Vq9YBo3d);
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException vzJXiBOC) {
			try {
				nU6dz8ws = INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy,
						Vq9YBo3d + INyczM6C.getColumnDimension() + 1);
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int,int)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException QSnfDnlF) {
				try_success("getMatrix(int,int,int,int)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException OhuiHaG1) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d);
			try {
				check(JRrVnPMU, nU6dz8ws);
				try_success("getMatrix(int,int,int,int)... ", "");
			} catch (java.lang.RuntimeException XnVfOU2p) {
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int,int)... ",
						"submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException G9cgudFR) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int,int)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9, dygopIyV);
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException QecHAeZC) {
			try {
				nU6dz8ws = INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9 + INyczM6C.getRowDimension() + 1, w1Qq9OMj);
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int[])... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException H2GQLyct) {
				try_success("getMatrix(int,int,int[])... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException QrD0qVfo) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9, w1Qq9OMj);
			try {
				check(JRrVnPMU, nU6dz8ws);
				try_success("getMatrix(int,int,int[])... ", "");
			} catch (java.lang.RuntimeException AG0Sa85r) {
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int[])... ",
						"submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException Xsgw7B8I) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int,int,int[])... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(PsWQjYWm, bz0NTbRy, Vq9YBo3d);
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException Cxjuh6pK) {
			try {
				nU6dz8ws = INyczM6C.getMatrix(MXeeEASk, bz0NTbRy, Vq9YBo3d + INyczM6C.getColumnDimension() + 1);
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int,int)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException sCBGayrA) {
				try_success("getMatrix(int[],int,int)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException OKSiKSFr) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(MXeeEASk, bz0NTbRy, Vq9YBo3d);
			try {
				check(JRrVnPMU, nU6dz8ws);
				try_success("getMatrix(int[],int,int)... ", "");
			} catch (java.lang.RuntimeException mJZuPfDy) {
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int,int)... ",
						"submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException PZne7DI4) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int,int)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(PsWQjYWm, w1Qq9OMj);
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException vDtzTnP7) {
			try {
				nU6dz8ws = INyczM6C.getMatrix(MXeeEASk, dygopIyV);
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int[])... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException Bsq46iDM) {
				try_success("getMatrix(int[],int[])... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException Er46qenV) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			nU6dz8ws = INyczM6C.getMatrix(MXeeEASk, w1Qq9OMj);
			try {
				check(JRrVnPMU, nU6dz8ws);
				try_success("getMatrix(int[],int[])... ", "");
			} catch (java.lang.RuntimeException SItdinZ3) {
				zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int[])... ", "submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException S9Xzn4AD) {
			zQfUEztG = try_failure(zQfUEztG, "getMatrix(int[],int[])... ", "Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			INyczM6C.set(INyczM6C.getRowDimension(), INyczM6C.getColumnDimension() - 1, 0.);
			zQfUEztG = try_failure(zQfUEztG, "set(int,int,double)... ", "OutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException MTfemMVq) {
			try {
				INyczM6C.set(INyczM6C.getRowDimension() - 1, INyczM6C.getColumnDimension(), 0.);
				zQfUEztG = try_failure(zQfUEztG, "set(int,int,double)... ",
						"OutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException HmnjYHWA) {
				try_success("set(int,int,double)... OutofBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException i6eho5a3) {
			zQfUEztG = try_failure(zQfUEztG, "set(int,int,double)... ", "OutOfBoundsException expected but not thrown");
		}
		try {
			INyczM6C.set(ziDqaLLN, bz0NTbRy, 0.);
			ATLxOaUs = INyczM6C.get(ziDqaLLN, bz0NTbRy);
			try {
				check(ATLxOaUs, 0.);
				try_success("set(int,int,double)... ", "");
			} catch (java.lang.RuntimeException ITAK6gxm) {
				zQfUEztG = try_failure(zQfUEztG, "set(int,int,double)... ", "Matrix element not successfully set");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException DW0AhD2w) {
			zQfUEztG = try_failure(zQfUEztG, "set(int,int,double)... ", "Unexpected ArrayIndexOutOfBoundsException");
		}
		nU6dz8ws = new Matrix(2, 3, 0.);
		try {
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9 + INyczM6C.getRowDimension() + 1, bz0NTbRy, Vq9YBo3d, nU6dz8ws);
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException hfDynl8l) {
			try {
				INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d + INyczM6C.getColumnDimension() + 1,
						nU6dz8ws);
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int,int,Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException xekZVvpI) {
				try_success("setMatrix(int,int,int,int,Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException DCmPX695) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d, nU6dz8ws);
			try {
				check(nU6dz8ws.minus(INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d)), nU6dz8ws);
				try_success("setMatrix(int,int,int,int,Matrix)... ", "");
			} catch (java.lang.RuntimeException hcaQ22IL) {
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int,int,Matrix)... ",
						"submatrix not successfully set");
			}
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d, JRrVnPMU);
		} catch (java.lang.ArrayIndexOutOfBoundsException lRHsCtvV) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int,int,Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9 + INyczM6C.getRowDimension() + 1, w1Qq9OMj, nU6dz8ws);
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException tsSRa6H9) {
			try {
				INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, dygopIyV, nU6dz8ws);
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int[],Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException YeRV0AS3) {
				try_success("setMatrix(int,int,int[],Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException DOa1olSl) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, w1Qq9OMj, nU6dz8ws);
			try {
				check(nU6dz8ws.minus(INyczM6C.getMatrix(ziDqaLLN, g1oqXXB9, w1Qq9OMj)), nU6dz8ws);
				try_success("setMatrix(int,int,int[],Matrix)... ", "");
			} catch (java.lang.RuntimeException GnCK2GO1) {
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int[],Matrix)... ",
						"submatrix not successfully set");
			}
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d, JRrVnPMU);
		} catch (java.lang.ArrayIndexOutOfBoundsException cID6tEMg) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int,int,int[],Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			INyczM6C.setMatrix(MXeeEASk, bz0NTbRy, Vq9YBo3d + INyczM6C.getColumnDimension() + 1, nU6dz8ws);
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException gEpO7Me7) {
			try {
				INyczM6C.setMatrix(PsWQjYWm, bz0NTbRy, Vq9YBo3d, nU6dz8ws);
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int,int,Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException F6kNfU5r) {
				try_success("setMatrix(int[],int,int,Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException BuRsRUTg) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			INyczM6C.setMatrix(MXeeEASk, bz0NTbRy, Vq9YBo3d, nU6dz8ws);
			try {
				check(nU6dz8ws.minus(INyczM6C.getMatrix(MXeeEASk, bz0NTbRy, Vq9YBo3d)), nU6dz8ws);
				try_success("setMatrix(int[],int,int,Matrix)... ", "");
			} catch (java.lang.RuntimeException Whf9il4w) {
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int,int,Matrix)... ",
						"submatrix not successfully set");
			}
			INyczM6C.setMatrix(ziDqaLLN, g1oqXXB9, bz0NTbRy, Vq9YBo3d, JRrVnPMU);
		} catch (java.lang.ArrayIndexOutOfBoundsException d88kjVLn) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int,int,Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			INyczM6C.setMatrix(MXeeEASk, dygopIyV, nU6dz8ws);
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException s7tbd6j7) {
			try {
				INyczM6C.setMatrix(PsWQjYWm, w1Qq9OMj, nU6dz8ws);
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int[],Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException JmCU3vTC) {
				try_success("setMatrix(int[],int[],Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException lzO0Oe7v) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			INyczM6C.setMatrix(MXeeEASk, w1Qq9OMj, nU6dz8ws);
			try {
				check(nU6dz8ws.minus(INyczM6C.getMatrix(MXeeEASk, w1Qq9OMj)), nU6dz8ws);
				try_success("setMatrix(int[],int[],Matrix)... ", "");
			} catch (java.lang.RuntimeException Tn1Hm3Ok) {
				zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int[],Matrix)... ", "submatrix not successfully set");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException CGAZfDvA) {
			zQfUEztG = try_failure(zQfUEztG, "setMatrix(int[],int[],Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		print("\nTesting array-like methods...\n");
		Eo0gMqn6 = new Matrix(cdOH1Plg, IqaUdviz);
		GMtCUluj = Matrix.random(LDJMMmEh.getRowDimension(), LDJMMmEh.getColumnDimension());
		LDJMMmEh = GMtCUluj;
		try {
			Eo0gMqn6 = LDJMMmEh.minus(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "minus conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException eiUof6RR) {
			try_success("minus conformance check... ", "");
		}
		if (LDJMMmEh.minus(GMtCUluj).norm1() != 0.) {
			zQfUEztG = try_failure(zQfUEztG, "minus... ",
					"(difference of identical Matrices is nonzero,\nSubsequent use of minus should be suspect)");
		} else {
			try_success("minus... ", "");
		}
		LDJMMmEh = GMtCUluj.copy();
		LDJMMmEh.minusEquals(GMtCUluj);
		CHRR0kUa = new Matrix(LDJMMmEh.getRowDimension(), LDJMMmEh.getColumnDimension());
		try {
			LDJMMmEh.minusEquals(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "minusEquals conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException bNLm3I1w) {
			try_success("minusEquals conformance check... ", "");
		}
		if (LDJMMmEh.minus(CHRR0kUa).norm1() != 0.) {
			zQfUEztG = try_failure(zQfUEztG, "minusEquals... ",
					"(difference of identical Matrices is nonzero,\nSubsequent use of minus should be suspect)");
		} else {
			try_success("minusEquals... ", "");
		}
		LDJMMmEh = GMtCUluj.copy();
		INyczM6C = Matrix.random(LDJMMmEh.getRowDimension(), LDJMMmEh.getColumnDimension());
		Lvij4epp = LDJMMmEh.minus(INyczM6C);
		try {
			Eo0gMqn6 = LDJMMmEh.plus(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "plus conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException TBRMS9YA) {
			try_success("plus conformance check... ", "");
		}
		try {
			check(Lvij4epp.plus(INyczM6C), LDJMMmEh);
			try_success("plus... ", "");
		} catch (java.lang.RuntimeException yfYcs2hD) {
			zQfUEztG = try_failure(zQfUEztG, "plus... ", "(C = A - B, but C + B != A)");
		}
		Lvij4epp = LDJMMmEh.minus(INyczM6C);
		Lvij4epp.plusEquals(INyczM6C);
		try {
			LDJMMmEh.plusEquals(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "plusEquals conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException Gk6kfCmT) {
			try_success("plusEquals conformance check... ", "");
		}
		try {
			check(Lvij4epp, LDJMMmEh);
			try_success("plusEquals... ", "");
		} catch (java.lang.RuntimeException B6u3ZdbH) {
			zQfUEztG = try_failure(zQfUEztG, "plusEquals... ", "(C = A - B, but C = C + B != A)");
		}
		LDJMMmEh = GMtCUluj.uminus();
		try {
			check(LDJMMmEh.plus(GMtCUluj), CHRR0kUa);
			try_success("uminus... ", "");
		} catch (java.lang.RuntimeException WKNYayIl) {
			zQfUEztG = try_failure(zQfUEztG, "uminus... ", "(-A + A != zeros)");
		}
		LDJMMmEh = GMtCUluj.copy();
		hW7E3Z19 = new Matrix(LDJMMmEh.getRowDimension(), LDJMMmEh.getColumnDimension(), 1.0);
		Lvij4epp = LDJMMmEh.arrayLeftDivide(GMtCUluj);
		try {
			Eo0gMqn6 = LDJMMmEh.arrayLeftDivide(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "arrayLeftDivide conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException TuaE7aez) {
			try_success("arrayLeftDivide conformance check... ", "");
		}
		try {
			check(Lvij4epp, hW7E3Z19);
			try_success("arrayLeftDivide... ", "");
		} catch (java.lang.RuntimeException N9jsOWWV) {
			zQfUEztG = try_failure(zQfUEztG, "arrayLeftDivide... ", "(M.\\M != ones)");
		}
		try {
			LDJMMmEh.arrayLeftDivideEquals(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "arrayLeftDivideEquals conformance check... ",
					"nonconformance not raised");
		} catch (IllegalArgumentException thTlpmMC) {
			try_success("arrayLeftDivideEquals conformance check... ", "");
		}
		LDJMMmEh.arrayLeftDivideEquals(GMtCUluj);
		try {
			check(LDJMMmEh, hW7E3Z19);
			try_success("arrayLeftDivideEquals... ", "");
		} catch (java.lang.RuntimeException dta9nNdd) {
			zQfUEztG = try_failure(zQfUEztG, "arrayLeftDivideEquals... ", "(M.\\M != ones)");
		}
		LDJMMmEh = GMtCUluj.copy();
		try {
			LDJMMmEh.arrayRightDivide(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "arrayRightDivide conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException gJgCQTgq) {
			try_success("arrayRightDivide conformance check... ", "");
		}
		Lvij4epp = LDJMMmEh.arrayRightDivide(GMtCUluj);
		try {
			check(Lvij4epp, hW7E3Z19);
			try_success("arrayRightDivide... ", "");
		} catch (java.lang.RuntimeException XTdRZsz2) {
			zQfUEztG = try_failure(zQfUEztG, "arrayRightDivide... ", "(M./M != ones)");
		}
		try {
			LDJMMmEh.arrayRightDivideEquals(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "arrayRightDivideEquals conformance check... ",
					"nonconformance not raised");
		} catch (IllegalArgumentException LrCEAxGV) {
			try_success("arrayRightDivideEquals conformance check... ", "");
		}
		LDJMMmEh.arrayRightDivideEquals(GMtCUluj);
		try {
			check(LDJMMmEh, hW7E3Z19);
			try_success("arrayRightDivideEquals... ", "");
		} catch (java.lang.RuntimeException h3GGr3j2) {
			zQfUEztG = try_failure(zQfUEztG, "arrayRightDivideEquals... ", "(M./M != ones)");
		}
		LDJMMmEh = GMtCUluj.copy();
		INyczM6C = Matrix.random(LDJMMmEh.getRowDimension(), LDJMMmEh.getColumnDimension());
		try {
			Eo0gMqn6 = LDJMMmEh.arrayTimes(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "arrayTimes conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException counJizW) {
			try_success("arrayTimes conformance check... ", "");
		}
		Lvij4epp = LDJMMmEh.arrayTimes(INyczM6C);
		try {
			check(Lvij4epp.arrayRightDivideEquals(INyczM6C), LDJMMmEh);
			try_success("arrayTimes... ", "");
		} catch (java.lang.RuntimeException O6fqeWXS) {
			zQfUEztG = try_failure(zQfUEztG, "arrayTimes... ", "(A = R, C = A.*B, but C./B != A)");
		}
		try {
			LDJMMmEh.arrayTimesEquals(Eo0gMqn6);
			zQfUEztG = try_failure(zQfUEztG, "arrayTimesEquals conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException bAqdY8ue) {
			try_success("arrayTimesEquals conformance check... ", "");
		}
		LDJMMmEh.arrayTimesEquals(INyczM6C);
		try {
			check(LDJMMmEh.arrayRightDivideEquals(INyczM6C), GMtCUluj);
			try_success("arrayTimesEquals... ", "");
		} catch (java.lang.RuntimeException KSTCNmMk) {
			zQfUEztG = try_failure(zQfUEztG, "arrayTimesEquals... ", "(A = R, A = A.*B, but A./B != R)");
		}
		print("\nTesting I/O methods...\n");
		try {
			DecimalFormat FO8Og8QS = new DecimalFormat("0.0000E00");
			FO8Og8QS.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
			PrintWriter Hvxz1FKk = new PrintWriter(new FileOutputStream("JamaTestMatrix.out"));
			LDJMMmEh.print(Hvxz1FKk, FO8Og8QS, 10);
			Hvxz1FKk.close();
			GMtCUluj = Matrix.read(new BufferedReader(new FileReader("JamaTestMatrix.out")));
			if (LDJMMmEh.minus(GMtCUluj).norm1() < .001) {
				try_success("print()/read()...", "");
			} else {
				zQfUEztG = try_failure(zQfUEztG, "print()/read()...",
						"Matrix read from file does not match Matrix printed to file");
			}
		} catch (java.io.IOException Ozt8WQRR) {
			f8QzHAUa = try_warning(f8QzHAUa, "print()/read()...",
					"unexpected I/O error, unable to run print/read test;  check write permission in current directory and retry");
		} catch (Exception WbO39QRq) {
			try {
				WbO39QRq.printStackTrace(System.out);
				f8QzHAUa = try_warning(f8QzHAUa, "print()/read()...",
						"Formatting error... will try JDK1.1 reformulation...");
				DecimalFormat pL75jhQ3 = new DecimalFormat("0.0000");
				PrintWriter NKzpNNYQ = new PrintWriter(new FileOutputStream("JamaTestMatrix.out"));
				LDJMMmEh.print(NKzpNNYQ, pL75jhQ3, 10);
				NKzpNNYQ.close();
				GMtCUluj = Matrix.read(new BufferedReader(new FileReader("JamaTestMatrix.out")));
				if (LDJMMmEh.minus(GMtCUluj).norm1() < .001) {
					try_success("print()/read()...", "");
				} else {
					zQfUEztG = try_failure(zQfUEztG, "print()/read() (2nd attempt) ...",
							"Matrix read from file does not match Matrix printed to file");
				}
			} catch (java.io.IOException WyFFc7Pe) {
				f8QzHAUa = try_warning(f8QzHAUa, "print()/read()...",
						"unexpected I/O error, unable to run print/read test;  check write permission in current directory and retry");
			}
		}
		GMtCUluj = Matrix.random(LDJMMmEh.getRowDimension(), LDJMMmEh.getColumnDimension());
		String lwEZ7eJc = "TMPMATRIX.serial";
		try {
			ObjectOutputStream auRt1DLV = new ObjectOutputStream(new FileOutputStream(lwEZ7eJc));
			auRt1DLV.writeObject(GMtCUluj);
			ObjectInputStream DPojaqRp = new ObjectInputStream(new FileInputStream(lwEZ7eJc));
			LDJMMmEh = (Matrix) DPojaqRp.readObject();
			try {
				check(LDJMMmEh, GMtCUluj);
				try_success("writeObject(Matrix)/readObject(Matrix)...", "");
			} catch (java.lang.RuntimeException xZ5vwYRU) {
				zQfUEztG = try_failure(zQfUEztG, "writeObject(Matrix)/readObject(Matrix)...",
						"Matrix not serialized correctly");
			}
		} catch (java.io.IOException cgRQFdgy) {
			f8QzHAUa = try_warning(f8QzHAUa, "writeObject()/readObject()...",
					"unexpected I/O error, unable to run serialization test;  check write permission in current directory and retry");
		} catch (Exception iDITaVVh) {
			zQfUEztG = try_failure(zQfUEztG, "writeObject(Matrix)/readObject(Matrix)...",
					"unexpected error in serialization test");
		}
		print("\nTesting linear algebra methods...\n");
		LDJMMmEh = new Matrix(cdOH1Plg, 3);
		sXDGGRSs = new Matrix(HIbMzqGc);
		sXDGGRSs = LDJMMmEh.transpose();
		try {
			check(LDJMMmEh.transpose(), sXDGGRSs);
			try_success("transpose...", "");
		} catch (java.lang.RuntimeException ivWqDzTU) {
			zQfUEztG = try_failure(zQfUEztG, "transpose()...", "transpose unsuccessful");
		}
		LDJMMmEh.transpose();
		try {
			check(LDJMMmEh.norm1(), fLcapnQy);
			try_success("norm1...", "");
		} catch (java.lang.RuntimeException V9iY4RSK) {
			zQfUEztG = try_failure(zQfUEztG, "norm1()...", "incorrect norm calculation");
		}
		try {
			check(LDJMMmEh.normInf(), TV8yFdMM);
			try_success("normInf()...", "");
		} catch (java.lang.RuntimeException wryIe2Lb) {
			zQfUEztG = try_failure(zQfUEztG, "normInf()...", "incorrect norm calculation");
		}
		try {
			check(LDJMMmEh.normF(), Math.sqrt(YCo6lOQb));
			try_success("normF...", "");
		} catch (java.lang.RuntimeException B9qyaHhJ) {
			zQfUEztG = try_failure(zQfUEztG, "normF()...", "incorrect norm calculation");
		}
		try {
			check(LDJMMmEh.trace(), J2dtELs3);
			try_success("trace()...", "");
		} catch (java.lang.RuntimeException LHman4iI) {
			zQfUEztG = try_failure(zQfUEztG, "trace()...", "incorrect trace calculation");
		}
		try {
			check(LDJMMmEh.getMatrix(0, LDJMMmEh.getRowDimension() - 1, 0, LDJMMmEh.getRowDimension() - 1).det(), 0.);
			try_success("det()...", "");
		} catch (java.lang.RuntimeException e9ouEpzo) {
			zQfUEztG = try_failure(zQfUEztG, "det()...", "incorrect determinant calculation");
		}
		fu2QS4br = new Matrix(XW2x0Xnz);
		try {
			check(LDJMMmEh.times(LDJMMmEh.transpose()), fu2QS4br);
			try_success("times(Matrix)...", "");
		} catch (java.lang.RuntimeException Sr6I4N7e) {
			zQfUEztG = try_failure(zQfUEztG, "times(Matrix)...", "incorrect Matrix-Matrix product calculation");
		}
		try {
			check(LDJMMmEh.times(0.), CHRR0kUa);
			try_success("times(double)...", "");
		} catch (java.lang.RuntimeException aLxOoP2c) {
			zQfUEztG = try_failure(zQfUEztG, "times(double)...", "incorrect Matrix-scalar product calculation");
		}
		LDJMMmEh = new Matrix(cdOH1Plg, 4);
		QRDecomposition FQSb14RK = LDJMMmEh.qr();
		GMtCUluj = FQSb14RK.getR();
		try {
			check(LDJMMmEh, FQSb14RK.getQ().times(GMtCUluj));
			try_success("QRDecomposition...", "");
		} catch (java.lang.RuntimeException Lele6ggB) {
			zQfUEztG = try_failure(zQfUEztG, "QRDecomposition...", "incorrect QR decomposition calculation");
		}
		SingularValueDecomposition cKoQPjj1 = LDJMMmEh.svd();
		try {
			check(LDJMMmEh, cKoQPjj1.getU().times(cKoQPjj1.getS().times(cKoQPjj1.getV().transpose())));
			try_success("SingularValueDecomposition...", "");
		} catch (java.lang.RuntimeException T7EjCiJE) {
			zQfUEztG = try_failure(zQfUEztG, "SingularValueDecomposition...",
					"incorrect singular value decomposition calculation");
		}
		c3wRoRR3 = new Matrix(ZozwGhut);
		try {
			check(c3wRoRR3.rank(), Math.min(c3wRoRR3.getRowDimension(), c3wRoRR3.getColumnDimension()) - 1);
			try_success("rank()...", "");
		} catch (java.lang.RuntimeException qh9EZ0Bu) {
			zQfUEztG = try_failure(zQfUEztG, "rank()...", "incorrect rank calculation");
		}
		INyczM6C = new Matrix(osxrZT03);
		cKoQPjj1 = INyczM6C.svd();
		double[] UQtkFHUs = cKoQPjj1.getSingularValues();
		try {
			check(INyczM6C.cond(),
					UQtkFHUs[0] / UQtkFHUs[Math.min(INyczM6C.getRowDimension(), INyczM6C.getColumnDimension()) - 1]);
			try_success("cond()...", "");
		} catch (java.lang.RuntimeException TlUlUjGM) {
			zQfUEztG = try_failure(zQfUEztG, "cond()...", "incorrect condition number calculation");
		}
		int eSwVL0iG = LDJMMmEh.getColumnDimension();
		LDJMMmEh = LDJMMmEh.getMatrix(0, eSwVL0iG - 1, 0, eSwVL0iG - 1);
		LDJMMmEh.set(0, 0, 0.);
		LUDecomposition xJRQfW9G = LDJMMmEh.lu();
		try {
			check(LDJMMmEh.getMatrix(xJRQfW9G.getPivot(), 0, eSwVL0iG - 1), xJRQfW9G.getL().times(xJRQfW9G.getU()));
			try_success("LUDecomposition...", "");
		} catch (java.lang.RuntimeException CGMW6fWS) {
			zQfUEztG = try_failure(zQfUEztG, "LUDecomposition...", "incorrect LU decomposition calculation");
		}
		cVn8yccg = LDJMMmEh.inverse();
		try {
			check(LDJMMmEh.times(cVn8yccg), Matrix.identity(3, 3));
			try_success("inverse()...", "");
		} catch (java.lang.RuntimeException skccIwfv) {
			zQfUEztG = try_failure(zQfUEztG, "inverse()...", "incorrect inverse calculation");
		}
		hW7E3Z19 = new Matrix(JRrVnPMU.getRowDimension(), 1, 1.0);
		AZ6r5Qzj = new Matrix(XUDsPcof);
		fu2QS4br = JRrVnPMU.getMatrix(0, JRrVnPMU.getRowDimension() - 1, 0, JRrVnPMU.getRowDimension() - 1);
		try {
			check(fu2QS4br.solve(AZ6r5Qzj), hW7E3Z19);
			try_success("solve()...", "");
		} catch (java.lang.IllegalArgumentException lLm5rjQi) {
			zQfUEztG = try_failure(zQfUEztG, "solve()...", lLm5rjQi.getMessage());
		} catch (java.lang.RuntimeException ebu8Vfxx) {
			zQfUEztG = try_failure(zQfUEztG, "solve()...", ebu8Vfxx.getMessage());
		}
		LDJMMmEh = new Matrix(PnCOY5io);
		CholeskyDecomposition rZdKxgIj = LDJMMmEh.chol();
		Matrix EfoLVKrD = rZdKxgIj.getL();
		try {
			check(LDJMMmEh, EfoLVKrD.times(EfoLVKrD.transpose()));
			try_success("CholeskyDecomposition...", "");
		} catch (java.lang.RuntimeException j12SScYu) {
			zQfUEztG = try_failure(zQfUEztG, "CholeskyDecomposition...",
					"incorrect Cholesky decomposition calculation");
		}
		cVn8yccg = rZdKxgIj.solve(Matrix.identity(3, 3));
		try {
			check(LDJMMmEh.times(cVn8yccg), Matrix.identity(3, 3));
			try_success("CholeskyDecomposition solve()...", "");
		} catch (java.lang.RuntimeException qPEr65YA) {
			zQfUEztG = try_failure(zQfUEztG, "CholeskyDecomposition solve()...",
					"incorrect Choleskydecomposition solve calculation");
		}
		EigenvalueDecomposition lU5yCbbv = LDJMMmEh.eig();
		Matrix H9jSf8WK = lU5yCbbv.getD();
		Matrix BxGp0nos = lU5yCbbv.getV();
		try {
			check(LDJMMmEh.times(BxGp0nos), BxGp0nos.times(H9jSf8WK));
			try_success("EigenvalueDecomposition (symmetric)...", "");
		} catch (java.lang.RuntimeException UqmAkpZx) {
			zQfUEztG = try_failure(zQfUEztG, "EigenvalueDecomposition (symmetric)...",
					"incorrect symmetric Eigenvalue decomposition calculation");
		}
		LDJMMmEh = new Matrix(CbfPlTyb);
		lU5yCbbv = LDJMMmEh.eig();
		H9jSf8WK = lU5yCbbv.getD();
		BxGp0nos = lU5yCbbv.getV();
		try {
			check(LDJMMmEh.times(BxGp0nos), BxGp0nos.times(H9jSf8WK));
			try_success("EigenvalueDecomposition (nonsymmetric)...", "");
		} catch (java.lang.RuntimeException t6MkVe6b) {
			zQfUEztG = try_failure(zQfUEztG, "EigenvalueDecomposition (nonsymmetric)...",
					"incorrect nonsymmetric Eigenvalue decomposition calculation");
		}
		print("\nTestMatrix completed.\n");
		print("Total errors reported: " + Integer.toString(zQfUEztG) + "\n");
		print("Total warnings reported: " + Integer.toString(f8QzHAUa) + "\n");
	}

}