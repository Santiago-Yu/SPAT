class n4660318 {
	public static void main(String ztYOMcQU[]) {
		Matrix QydGH4jQ, i3E9t4MH, mIuq8uEJ, jE6bY52j, XbOryL2M, ZvqzHYdq, DH9oyfJT, J6QYDKrP, apyPjTHT, sbGArPMK,
				XsshZfOF, MOizYPet, Xbr2Hw8s, u9Gsb8lw, dGkZAxhG;
		int rff6JXAP = 0;
		int nT6VwJjD = 0;
		double JwMcp14q, AjP4r1nn;
		double[] mbaqDUMx = { 1., 2., 3., 4., 5., 6., 7., 8., 9., 10., 11., 12. };
		double[] QheLtnF0 = { 1., 4., 7., 10., 2., 5., 8., 11., 3., 6., 9., 12. };
		double[][] ug9guxUO = { { 1., 4., 7., 10. }, { 2., 5., 8., 11. }, { 3., 6., 9., 12. } };
		double[][] sGjGm7X1 = ug9guxUO;
		double[][] gjwZkdah = { { 1., 2., 3. }, { 4., 5., 6. }, { 7., 8., 9. }, { 10., 11., 12. } };
		double[][] dpBPTiH2 = { { 5., 8., 11. }, { 6., 9., 12. } };
		double[][] VyRuKdkh = { { 1., 4., 7. }, { 2., 5., 8., 11. }, { 3., 6., 9., 12. } };
		double[][] IsMEuDji = { { 1., 1., 1. }, { 1., 2., 3. }, { 1., 3., 6. } };
		double[][] Sv6u9XQE = { { 1., 0., 0., 0. }, { 0., 1., 0., 0. }, { 0., 0., 1., 0. } };
		double[][] luY0NiJE = { { 0., 1., 0., 0. }, { 1., 0., 2.e-7, 0. }, { 0., -2.e-7, 0., 1. }, { 0., 0., 1., 0. } };
		double[][] ICF8L32G = { { 166., 188., 210. }, { 188., 214., 240. }, { 210., 240., 270. } };
		double[][] MI2bfQJM = { { 13. }, { 15. } };
		double[][] wG7Zzwgh = { { 1., 3. }, { 7., 9. } };
		int S2bjPgoz = 3, lJwv6erh = 4;
		int qTeX9UZL = 5;
		int hbMWLbBS = 0;
		int CmTAxlTw = 4;
		int rl03YSnn = 3;
		int vCrHLg3b = 4;
		int LNV7EqRB = 1, t7KG7Kpb = 2, KeVVzhAY = 1, pYVem902 = 3;
		int[] UP3MRlAw = { 1, 2 };
		int[] CxfSZzIT = { 1, 3 };
		int[] EQiKwwYo = { 1, 2, 3 };
		int[] ecvZx1HI = { 1, 2, 4 };
		double m9n1B2Tz = 33.;
		double NxpTLuBv = 30.;
		double qn97UhTe = 15;
		double w1W470Vf = 650;
		print("\nTesting constructors and constructor-like methods...\n");
		try {
			QydGH4jQ = new Matrix(mbaqDUMx, qTeX9UZL);
			rff6JXAP = try_failure(rff6JXAP, "Catch invalid length in packed constructor... ",
					"exception not thrown for invalid input");
		} catch (IllegalArgumentException rkfrxb2m) {
			try_success("Catch invalid length in packed constructor... ", rkfrxb2m.getMessage());
		}
		try {
			QydGH4jQ = new Matrix(VyRuKdkh);
			JwMcp14q = QydGH4jQ.get(hbMWLbBS, CmTAxlTw);
		} catch (IllegalArgumentException REUcuwb3) {
			try_success("Catch ragged input to default constructor... ", REUcuwb3.getMessage());
		} catch (java.lang.ArrayIndexOutOfBoundsException e9BKUENh) {
			rff6JXAP = try_failure(rff6JXAP, "Catch ragged input to constructor... ",
					"exception not thrown in construction...ArrayIndexOutOfBoundsException thrown later");
		}
		try {
			QydGH4jQ = Matrix.constructWithCopy(VyRuKdkh);
			JwMcp14q = QydGH4jQ.get(hbMWLbBS, CmTAxlTw);
		} catch (IllegalArgumentException fPzfsG8M) {
			try_success("Catch ragged input to constructWithCopy... ", fPzfsG8M.getMessage());
		} catch (java.lang.ArrayIndexOutOfBoundsException zGx1DU78) {
			rff6JXAP = try_failure(rff6JXAP, "Catch ragged input to constructWithCopy... ",
					"exception not thrown in construction...ArrayIndexOutOfBoundsException thrown later");
		}
		QydGH4jQ = new Matrix(mbaqDUMx, rl03YSnn);
		i3E9t4MH = new Matrix(ug9guxUO);
		JwMcp14q = i3E9t4MH.get(0, 0);
		ug9guxUO[0][0] = 0.0;
		mIuq8uEJ = i3E9t4MH.minus(QydGH4jQ);
		ug9guxUO[0][0] = JwMcp14q;
		i3E9t4MH = Matrix.constructWithCopy(ug9guxUO);
		JwMcp14q = i3E9t4MH.get(0, 0);
		ug9guxUO[0][0] = 0.0;
		if ((JwMcp14q - i3E9t4MH.get(0, 0)) != 0.0) {
			rff6JXAP = try_failure(rff6JXAP, "constructWithCopy... ", "copy not effected... data visible outside");
		} else {
			try_success("constructWithCopy... ", "");
		}
		ug9guxUO[0][0] = mbaqDUMx[0];
		ZvqzHYdq = new Matrix(Sv6u9XQE);
		try {
			check(ZvqzHYdq, Matrix.identity(3, 4));
			try_success("identity... ", "");
		} catch (java.lang.RuntimeException ikmubjaQ) {
			rff6JXAP = try_failure(rff6JXAP, "identity... ", "identity Matrix not successfully created");
		}
		print("\nTesting access methods...\n");
		i3E9t4MH = new Matrix(ug9guxUO);
		if (i3E9t4MH.getRowDimension() != S2bjPgoz) {
			rff6JXAP = try_failure(rff6JXAP, "getRowDimension... ", "");
		} else {
			try_success("getRowDimension... ", "");
		}
		if (i3E9t4MH.getColumnDimension() != lJwv6erh) {
			rff6JXAP = try_failure(rff6JXAP, "getColumnDimension... ", "");
		} else {
			try_success("getColumnDimension... ", "");
		}
		i3E9t4MH = new Matrix(ug9guxUO);
		double[][] UMppdiCI = i3E9t4MH.getArray();
		if (UMppdiCI != ug9guxUO) {
			rff6JXAP = try_failure(rff6JXAP, "getArray... ", "");
		} else {
			try_success("getArray... ", "");
		}
		UMppdiCI = i3E9t4MH.getArrayCopy();
		if (UMppdiCI == ug9guxUO) {
			rff6JXAP = try_failure(rff6JXAP, "getArrayCopy... ", "data not (deep) copied");
		}
		try {
			check(UMppdiCI, ug9guxUO);
			try_success("getArrayCopy... ", "");
		} catch (java.lang.RuntimeException Qoyrm1TG) {
			rff6JXAP = try_failure(rff6JXAP, "getArrayCopy... ", "data not successfully (deep) copied");
		}
		double[] rQ6tVq5P = i3E9t4MH.getColumnPackedCopy();
		try {
			check(rQ6tVq5P, mbaqDUMx);
			try_success("getColumnPackedCopy... ", "");
		} catch (java.lang.RuntimeException qFO4lir7) {
			rff6JXAP = try_failure(rff6JXAP, "getColumnPackedCopy... ",
					"data not successfully (deep) copied by columns");
		}
		rQ6tVq5P = i3E9t4MH.getRowPackedCopy();
		try {
			check(rQ6tVq5P, QheLtnF0);
			try_success("getRowPackedCopy... ", "");
		} catch (java.lang.RuntimeException kUNIWweX) {
			rff6JXAP = try_failure(rff6JXAP, "getRowPackedCopy... ", "data not successfully (deep) copied by rows");
		}
		try {
			JwMcp14q = i3E9t4MH.get(i3E9t4MH.getRowDimension(), i3E9t4MH.getColumnDimension() - 1);
			rff6JXAP = try_failure(rff6JXAP, "get(int,int)... ", "OutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException KvjnhQpc) {
			try {
				JwMcp14q = i3E9t4MH.get(i3E9t4MH.getRowDimension() - 1, i3E9t4MH.getColumnDimension());
				rff6JXAP = try_failure(rff6JXAP, "get(int,int)... ", "OutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException VQU980l4) {
				try_success("get(int,int)... OutofBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException BzWK4oT8) {
			rff6JXAP = try_failure(rff6JXAP, "get(int,int)... ", "OutOfBoundsException expected but not thrown");
		}
		try {
			if (i3E9t4MH.get(i3E9t4MH.getRowDimension() - 1, i3E9t4MH.getColumnDimension()
					- 1) != ug9guxUO[i3E9t4MH.getRowDimension() - 1][i3E9t4MH.getColumnDimension() - 1]) {
				rff6JXAP = try_failure(rff6JXAP, "get(int,int)... ", "Matrix entry (i,j) not successfully retreived");
			} else {
				try_success("get(int,int)... ", "");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException luglijEU) {
			rff6JXAP = try_failure(rff6JXAP, "get(int,int)... ", "Unexpected ArrayIndexOutOfBoundsException");
		}
		sbGArPMK = new Matrix(dpBPTiH2);
		try {
			XsshZfOF = i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb + i3E9t4MH.getRowDimension() + 1, KeVVzhAY, pYVem902);
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException PT1iOVlG) {
			try {
				XsshZfOF = i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY,
						pYVem902 + i3E9t4MH.getColumnDimension() + 1);
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int,int)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException XEwd5igu) {
				try_success("getMatrix(int,int,int,int)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException KhsJ9EGc) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902);
			try {
				check(sbGArPMK, XsshZfOF);
				try_success("getMatrix(int,int,int,int)... ", "");
			} catch (java.lang.RuntimeException vkr7f7oa) {
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int,int)... ",
						"submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException NkjnskG0) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int,int)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb, ecvZx1HI);
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException R91RE9fd) {
			try {
				XsshZfOF = i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb + i3E9t4MH.getRowDimension() + 1, EQiKwwYo);
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int[])... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException KrnCH9z2) {
				try_success("getMatrix(int,int,int[])... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException yo5kyGZL) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb, EQiKwwYo);
			try {
				check(sbGArPMK, XsshZfOF);
				try_success("getMatrix(int,int,int[])... ", "");
			} catch (java.lang.RuntimeException rXCPRkR7) {
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int[])... ",
						"submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException kaCeaxpL) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int,int,int[])... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(CxfSZzIT, KeVVzhAY, pYVem902);
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException tDEhTqCl) {
			try {
				XsshZfOF = i3E9t4MH.getMatrix(UP3MRlAw, KeVVzhAY, pYVem902 + i3E9t4MH.getColumnDimension() + 1);
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int,int)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException KbaPDnfE) {
				try_success("getMatrix(int[],int,int)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException pDSIVik8) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int,int)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(UP3MRlAw, KeVVzhAY, pYVem902);
			try {
				check(sbGArPMK, XsshZfOF);
				try_success("getMatrix(int[],int,int)... ", "");
			} catch (java.lang.RuntimeException X0pcUWgf) {
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int,int)... ",
						"submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException tKLUAe6Z) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int,int)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(CxfSZzIT, EQiKwwYo);
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException eFlZ0flY) {
			try {
				XsshZfOF = i3E9t4MH.getMatrix(UP3MRlAw, ecvZx1HI);
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int[])... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException yPFVFi5l) {
				try_success("getMatrix(int[],int[])... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException KIKjUyfy) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int[])... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			XsshZfOF = i3E9t4MH.getMatrix(UP3MRlAw, EQiKwwYo);
			try {
				check(sbGArPMK, XsshZfOF);
				try_success("getMatrix(int[],int[])... ", "");
			} catch (java.lang.RuntimeException XEBQWY66) {
				rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int[])... ", "submatrix not successfully retreived");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException ayxgAa22) {
			rff6JXAP = try_failure(rff6JXAP, "getMatrix(int[],int[])... ", "Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			i3E9t4MH.set(i3E9t4MH.getRowDimension(), i3E9t4MH.getColumnDimension() - 1, 0.);
			rff6JXAP = try_failure(rff6JXAP, "set(int,int,double)... ", "OutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException wQK5DkbL) {
			try {
				i3E9t4MH.set(i3E9t4MH.getRowDimension() - 1, i3E9t4MH.getColumnDimension(), 0.);
				rff6JXAP = try_failure(rff6JXAP, "set(int,int,double)... ",
						"OutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException lcbvdTQl) {
				try_success("set(int,int,double)... OutofBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException wlRSNFN5) {
			rff6JXAP = try_failure(rff6JXAP, "set(int,int,double)... ", "OutOfBoundsException expected but not thrown");
		}
		try {
			i3E9t4MH.set(LNV7EqRB, KeVVzhAY, 0.);
			JwMcp14q = i3E9t4MH.get(LNV7EqRB, KeVVzhAY);
			try {
				check(JwMcp14q, 0.);
				try_success("set(int,int,double)... ", "");
			} catch (java.lang.RuntimeException pcNjchAs) {
				rff6JXAP = try_failure(rff6JXAP, "set(int,int,double)... ", "Matrix element not successfully set");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException Jn09MVBP) {
			rff6JXAP = try_failure(rff6JXAP, "set(int,int,double)... ", "Unexpected ArrayIndexOutOfBoundsException");
		}
		XsshZfOF = new Matrix(2, 3, 0.);
		try {
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb + i3E9t4MH.getRowDimension() + 1, KeVVzhAY, pYVem902, XsshZfOF);
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException QGsPYQsd) {
			try {
				i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902 + i3E9t4MH.getColumnDimension() + 1,
						XsshZfOF);
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int,int,Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException tSkOhHAF) {
				try_success("setMatrix(int,int,int,int,Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException ANpiGyjJ) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902, XsshZfOF);
			try {
				check(XsshZfOF.minus(i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902)), XsshZfOF);
				try_success("setMatrix(int,int,int,int,Matrix)... ", "");
			} catch (java.lang.RuntimeException Dxv7I2ne) {
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int,int,Matrix)... ",
						"submatrix not successfully set");
			}
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902, sbGArPMK);
		} catch (java.lang.ArrayIndexOutOfBoundsException ZbzvWst6) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int,int,Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb + i3E9t4MH.getRowDimension() + 1, EQiKwwYo, XsshZfOF);
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException xlnnLhob) {
			try {
				i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, ecvZx1HI, XsshZfOF);
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int[],Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException rxi9wEhx) {
				try_success("setMatrix(int,int,int[],Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException otFMfRTs) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, EQiKwwYo, XsshZfOF);
			try {
				check(XsshZfOF.minus(i3E9t4MH.getMatrix(LNV7EqRB, t7KG7Kpb, EQiKwwYo)), XsshZfOF);
				try_success("setMatrix(int,int,int[],Matrix)... ", "");
			} catch (java.lang.RuntimeException bNlXVXwM) {
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int[],Matrix)... ",
						"submatrix not successfully set");
			}
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902, sbGArPMK);
		} catch (java.lang.ArrayIndexOutOfBoundsException I2poCp4K) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int,int,int[],Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			i3E9t4MH.setMatrix(UP3MRlAw, KeVVzhAY, pYVem902 + i3E9t4MH.getColumnDimension() + 1, XsshZfOF);
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException Dzdzd8ob) {
			try {
				i3E9t4MH.setMatrix(CxfSZzIT, KeVVzhAY, pYVem902, XsshZfOF);
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int,int,Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException a4lcV3Mx) {
				try_success("setMatrix(int[],int,int,Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException cB8pLgPF) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int,int,Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			i3E9t4MH.setMatrix(UP3MRlAw, KeVVzhAY, pYVem902, XsshZfOF);
			try {
				check(XsshZfOF.minus(i3E9t4MH.getMatrix(UP3MRlAw, KeVVzhAY, pYVem902)), XsshZfOF);
				try_success("setMatrix(int[],int,int,Matrix)... ", "");
			} catch (java.lang.RuntimeException BMgN7Pqe) {
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int,int,Matrix)... ",
						"submatrix not successfully set");
			}
			i3E9t4MH.setMatrix(LNV7EqRB, t7KG7Kpb, KeVVzhAY, pYVem902, sbGArPMK);
		} catch (java.lang.ArrayIndexOutOfBoundsException jmg8VO8e) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int,int,Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		try {
			i3E9t4MH.setMatrix(UP3MRlAw, ecvZx1HI, XsshZfOF);
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		} catch (java.lang.ArrayIndexOutOfBoundsException ScUHbyth) {
			try {
				i3E9t4MH.setMatrix(CxfSZzIT, EQiKwwYo, XsshZfOF);
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int[],Matrix)... ",
						"ArrayIndexOutOfBoundsException expected but not thrown");
			} catch (java.lang.ArrayIndexOutOfBoundsException jTwsPdwg) {
				try_success("setMatrix(int[],int[],Matrix)... ArrayIndexOutOfBoundsException... ", "");
			}
		} catch (java.lang.IllegalArgumentException qy1IIrL6) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int[],Matrix)... ",
					"ArrayIndexOutOfBoundsException expected but not thrown");
		}
		try {
			i3E9t4MH.setMatrix(UP3MRlAw, EQiKwwYo, XsshZfOF);
			try {
				check(XsshZfOF.minus(i3E9t4MH.getMatrix(UP3MRlAw, EQiKwwYo)), XsshZfOF);
				try_success("setMatrix(int[],int[],Matrix)... ", "");
			} catch (java.lang.RuntimeException T6ExKUuo) {
				rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int[],Matrix)... ", "submatrix not successfully set");
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException wdXICOG8) {
			rff6JXAP = try_failure(rff6JXAP, "setMatrix(int[],int[],Matrix)... ",
					"Unexpected ArrayIndexOutOfBoundsException");
		}
		print("\nTesting array-like methods...\n");
		J6QYDKrP = new Matrix(mbaqDUMx, vCrHLg3b);
		DH9oyfJT = Matrix.random(QydGH4jQ.getRowDimension(), QydGH4jQ.getColumnDimension());
		QydGH4jQ = DH9oyfJT;
		try {
			J6QYDKrP = QydGH4jQ.minus(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "minus conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException UHZ7CRpJ) {
			try_success("minus conformance check... ", "");
		}
		if (QydGH4jQ.minus(DH9oyfJT).norm1() != 0.) {
			rff6JXAP = try_failure(rff6JXAP, "minus... ",
					"(difference of identical Matrices is nonzero,\nSubsequent use of minus should be suspect)");
		} else {
			try_success("minus... ", "");
		}
		QydGH4jQ = DH9oyfJT.copy();
		QydGH4jQ.minusEquals(DH9oyfJT);
		jE6bY52j = new Matrix(QydGH4jQ.getRowDimension(), QydGH4jQ.getColumnDimension());
		try {
			QydGH4jQ.minusEquals(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "minusEquals conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException bjXUtcQa) {
			try_success("minusEquals conformance check... ", "");
		}
		if (QydGH4jQ.minus(jE6bY52j).norm1() != 0.) {
			rff6JXAP = try_failure(rff6JXAP, "minusEquals... ",
					"(difference of identical Matrices is nonzero,\nSubsequent use of minus should be suspect)");
		} else {
			try_success("minusEquals... ", "");
		}
		QydGH4jQ = DH9oyfJT.copy();
		i3E9t4MH = Matrix.random(QydGH4jQ.getRowDimension(), QydGH4jQ.getColumnDimension());
		mIuq8uEJ = QydGH4jQ.minus(i3E9t4MH);
		try {
			J6QYDKrP = QydGH4jQ.plus(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "plus conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException b8U8R9Xp) {
			try_success("plus conformance check... ", "");
		}
		try {
			check(mIuq8uEJ.plus(i3E9t4MH), QydGH4jQ);
			try_success("plus... ", "");
		} catch (java.lang.RuntimeException OYVJK66t) {
			rff6JXAP = try_failure(rff6JXAP, "plus... ", "(C = A - B, but C + B != A)");
		}
		mIuq8uEJ = QydGH4jQ.minus(i3E9t4MH);
		mIuq8uEJ.plusEquals(i3E9t4MH);
		try {
			QydGH4jQ.plusEquals(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "plusEquals conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException jeWq9T6o) {
			try_success("plusEquals conformance check... ", "");
		}
		try {
			check(mIuq8uEJ, QydGH4jQ);
			try_success("plusEquals... ", "");
		} catch (java.lang.RuntimeException ZSMODIna) {
			rff6JXAP = try_failure(rff6JXAP, "plusEquals... ", "(C = A - B, but C = C + B != A)");
		}
		QydGH4jQ = DH9oyfJT.uminus();
		try {
			check(QydGH4jQ.plus(DH9oyfJT), jE6bY52j);
			try_success("uminus... ", "");
		} catch (java.lang.RuntimeException Gzro1r4M) {
			rff6JXAP = try_failure(rff6JXAP, "uminus... ", "(-A + A != zeros)");
		}
		QydGH4jQ = DH9oyfJT.copy();
		XbOryL2M = new Matrix(QydGH4jQ.getRowDimension(), QydGH4jQ.getColumnDimension(), 1.0);
		mIuq8uEJ = QydGH4jQ.arrayLeftDivide(DH9oyfJT);
		try {
			J6QYDKrP = QydGH4jQ.arrayLeftDivide(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "arrayLeftDivide conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException aNRAtANZ) {
			try_success("arrayLeftDivide conformance check... ", "");
		}
		try {
			check(mIuq8uEJ, XbOryL2M);
			try_success("arrayLeftDivide... ", "");
		} catch (java.lang.RuntimeException bVyz4EqX) {
			rff6JXAP = try_failure(rff6JXAP, "arrayLeftDivide... ", "(M.\\M != ones)");
		}
		try {
			QydGH4jQ.arrayLeftDivideEquals(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "arrayLeftDivideEquals conformance check... ",
					"nonconformance not raised");
		} catch (IllegalArgumentException qGfHhO04) {
			try_success("arrayLeftDivideEquals conformance check... ", "");
		}
		QydGH4jQ.arrayLeftDivideEquals(DH9oyfJT);
		try {
			check(QydGH4jQ, XbOryL2M);
			try_success("arrayLeftDivideEquals... ", "");
		} catch (java.lang.RuntimeException AqbxM7Fe) {
			rff6JXAP = try_failure(rff6JXAP, "arrayLeftDivideEquals... ", "(M.\\M != ones)");
		}
		QydGH4jQ = DH9oyfJT.copy();
		try {
			QydGH4jQ.arrayRightDivide(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "arrayRightDivide conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException M4ZdHrzK) {
			try_success("arrayRightDivide conformance check... ", "");
		}
		mIuq8uEJ = QydGH4jQ.arrayRightDivide(DH9oyfJT);
		try {
			check(mIuq8uEJ, XbOryL2M);
			try_success("arrayRightDivide... ", "");
		} catch (java.lang.RuntimeException Ot0lndSe) {
			rff6JXAP = try_failure(rff6JXAP, "arrayRightDivide... ", "(M./M != ones)");
		}
		try {
			QydGH4jQ.arrayRightDivideEquals(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "arrayRightDivideEquals conformance check... ",
					"nonconformance not raised");
		} catch (IllegalArgumentException Yh9mz5U6) {
			try_success("arrayRightDivideEquals conformance check... ", "");
		}
		QydGH4jQ.arrayRightDivideEquals(DH9oyfJT);
		try {
			check(QydGH4jQ, XbOryL2M);
			try_success("arrayRightDivideEquals... ", "");
		} catch (java.lang.RuntimeException UP4L9VwG) {
			rff6JXAP = try_failure(rff6JXAP, "arrayRightDivideEquals... ", "(M./M != ones)");
		}
		QydGH4jQ = DH9oyfJT.copy();
		i3E9t4MH = Matrix.random(QydGH4jQ.getRowDimension(), QydGH4jQ.getColumnDimension());
		try {
			J6QYDKrP = QydGH4jQ.arrayTimes(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "arrayTimes conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException qX8DMfLQ) {
			try_success("arrayTimes conformance check... ", "");
		}
		mIuq8uEJ = QydGH4jQ.arrayTimes(i3E9t4MH);
		try {
			check(mIuq8uEJ.arrayRightDivideEquals(i3E9t4MH), QydGH4jQ);
			try_success("arrayTimes... ", "");
		} catch (java.lang.RuntimeException z5CeYb4c) {
			rff6JXAP = try_failure(rff6JXAP, "arrayTimes... ", "(A = R, C = A.*B, but C./B != A)");
		}
		try {
			QydGH4jQ.arrayTimesEquals(J6QYDKrP);
			rff6JXAP = try_failure(rff6JXAP, "arrayTimesEquals conformance check... ", "nonconformance not raised");
		} catch (IllegalArgumentException yLMorNTm) {
			try_success("arrayTimesEquals conformance check... ", "");
		}
		QydGH4jQ.arrayTimesEquals(i3E9t4MH);
		try {
			check(QydGH4jQ.arrayRightDivideEquals(i3E9t4MH), DH9oyfJT);
			try_success("arrayTimesEquals... ", "");
		} catch (java.lang.RuntimeException nh4K6nTX) {
			rff6JXAP = try_failure(rff6JXAP, "arrayTimesEquals... ", "(A = R, A = A.*B, but A./B != R)");
		}
		print("\nTesting I/O methods...\n");
		try {
			DecimalFormat ynqdeciU = new DecimalFormat("0.0000E00");
			ynqdeciU.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
			PrintWriter BAD73dx8 = new PrintWriter(new FileOutputStream("JamaTestMatrix.out"));
			QydGH4jQ.print(BAD73dx8, ynqdeciU, 10);
			BAD73dx8.close();
			DH9oyfJT = Matrix.read(new BufferedReader(new FileReader("JamaTestMatrix.out")));
			if (QydGH4jQ.minus(DH9oyfJT).norm1() < .001) {
				try_success("print()/read()...", "");
			} else {
				rff6JXAP = try_failure(rff6JXAP, "print()/read()...",
						"Matrix read from file does not match Matrix printed to file");
			}
		} catch (java.io.IOException enYDr0YA) {
			nT6VwJjD = try_warning(nT6VwJjD, "print()/read()...",
					"unexpected I/O error, unable to run print/read test;  check write permission in current directory and retry");
		} catch (Exception qkhmaUfA) {
			try {
				qkhmaUfA.printStackTrace(System.out);
				nT6VwJjD = try_warning(nT6VwJjD, "print()/read()...",
						"Formatting error... will try JDK1.1 reformulation...");
				DecimalFormat aDnDGbBw = new DecimalFormat("0.0000");
				PrintWriter ibGFbMDY = new PrintWriter(new FileOutputStream("JamaTestMatrix.out"));
				QydGH4jQ.print(ibGFbMDY, aDnDGbBw, 10);
				ibGFbMDY.close();
				DH9oyfJT = Matrix.read(new BufferedReader(new FileReader("JamaTestMatrix.out")));
				if (QydGH4jQ.minus(DH9oyfJT).norm1() < .001) {
					try_success("print()/read()...", "");
				} else {
					rff6JXAP = try_failure(rff6JXAP, "print()/read() (2nd attempt) ...",
							"Matrix read from file does not match Matrix printed to file");
				}
			} catch (java.io.IOException rtsoZmSI) {
				nT6VwJjD = try_warning(nT6VwJjD, "print()/read()...",
						"unexpected I/O error, unable to run print/read test;  check write permission in current directory and retry");
			}
		}
		DH9oyfJT = Matrix.random(QydGH4jQ.getRowDimension(), QydGH4jQ.getColumnDimension());
		String gAhHM9Zb = "TMPMATRIX.serial";
		try {
			ObjectOutputStream iASuvecT = new ObjectOutputStream(new FileOutputStream(gAhHM9Zb));
			iASuvecT.writeObject(DH9oyfJT);
			ObjectInputStream xTdhnbmD = new ObjectInputStream(new FileInputStream(gAhHM9Zb));
			QydGH4jQ = (Matrix) xTdhnbmD.readObject();
			try {
				check(QydGH4jQ, DH9oyfJT);
				try_success("writeObject(Matrix)/readObject(Matrix)...", "");
			} catch (java.lang.RuntimeException Byl5DDoa) {
				rff6JXAP = try_failure(rff6JXAP, "writeObject(Matrix)/readObject(Matrix)...",
						"Matrix not serialized correctly");
			}
		} catch (java.io.IOException n79V0Koq) {
			nT6VwJjD = try_warning(nT6VwJjD, "writeObject()/readObject()...",
					"unexpected I/O error, unable to run serialization test;  check write permission in current directory and retry");
		} catch (Exception KTHNZQrF) {
			rff6JXAP = try_failure(rff6JXAP, "writeObject(Matrix)/readObject(Matrix)...",
					"unexpected error in serialization test");
		}
		print("\nTesting linear algebra methods...\n");
		QydGH4jQ = new Matrix(mbaqDUMx, 3);
		MOizYPet = new Matrix(gjwZkdah);
		MOizYPet = QydGH4jQ.transpose();
		try {
			check(QydGH4jQ.transpose(), MOizYPet);
			try_success("transpose...", "");
		} catch (java.lang.RuntimeException LZX0kMHx) {
			rff6JXAP = try_failure(rff6JXAP, "transpose()...", "transpose unsuccessful");
		}
		QydGH4jQ.transpose();
		try {
			check(QydGH4jQ.norm1(), m9n1B2Tz);
			try_success("norm1...", "");
		} catch (java.lang.RuntimeException InHWY0Pb) {
			rff6JXAP = try_failure(rff6JXAP, "norm1()...", "incorrect norm calculation");
		}
		try {
			check(QydGH4jQ.normInf(), NxpTLuBv);
			try_success("normInf()...", "");
		} catch (java.lang.RuntimeException xAw2ugpb) {
			rff6JXAP = try_failure(rff6JXAP, "normInf()...", "incorrect norm calculation");
		}
		try {
			check(QydGH4jQ.normF(), Math.sqrt(w1W470Vf));
			try_success("normF...", "");
		} catch (java.lang.RuntimeException diLJXeko) {
			rff6JXAP = try_failure(rff6JXAP, "normF()...", "incorrect norm calculation");
		}
		try {
			check(QydGH4jQ.trace(), qn97UhTe);
			try_success("trace()...", "");
		} catch (java.lang.RuntimeException rGTPyDEP) {
			rff6JXAP = try_failure(rff6JXAP, "trace()...", "incorrect trace calculation");
		}
		try {
			check(QydGH4jQ.getMatrix(0, QydGH4jQ.getRowDimension() - 1, 0, QydGH4jQ.getRowDimension() - 1).det(), 0.);
			try_success("det()...", "");
		} catch (java.lang.RuntimeException tc7Fs7Vx) {
			rff6JXAP = try_failure(rff6JXAP, "det()...", "incorrect determinant calculation");
		}
		Xbr2Hw8s = new Matrix(ICF8L32G);
		try {
			check(QydGH4jQ.times(QydGH4jQ.transpose()), Xbr2Hw8s);
			try_success("times(Matrix)...", "");
		} catch (java.lang.RuntimeException iMeJPsst) {
			rff6JXAP = try_failure(rff6JXAP, "times(Matrix)...", "incorrect Matrix-Matrix product calculation");
		}
		try {
			check(QydGH4jQ.times(0.), jE6bY52j);
			try_success("times(double)...", "");
		} catch (java.lang.RuntimeException xU1NQH42) {
			rff6JXAP = try_failure(rff6JXAP, "times(double)...", "incorrect Matrix-scalar product calculation");
		}
		QydGH4jQ = new Matrix(mbaqDUMx, 4);
		QRDecomposition A9Wm0Brq = QydGH4jQ.qr();
		DH9oyfJT = A9Wm0Brq.getR();
		try {
			check(QydGH4jQ, A9Wm0Brq.getQ().times(DH9oyfJT));
			try_success("QRDecomposition...", "");
		} catch (java.lang.RuntimeException yC4zx76m) {
			rff6JXAP = try_failure(rff6JXAP, "QRDecomposition...", "incorrect QR decomposition calculation");
		}
		SingularValueDecomposition NLkFGvVW = QydGH4jQ.svd();
		try {
			check(QydGH4jQ, NLkFGvVW.getU().times(NLkFGvVW.getS().times(NLkFGvVW.getV().transpose())));
			try_success("SingularValueDecomposition...", "");
		} catch (java.lang.RuntimeException G4fiqB4Q) {
			rff6JXAP = try_failure(rff6JXAP, "SingularValueDecomposition...",
					"incorrect singular value decomposition calculation");
		}
		u9Gsb8lw = new Matrix(sGjGm7X1);
		try {
			check(u9Gsb8lw.rank(), Math.min(u9Gsb8lw.getRowDimension(), u9Gsb8lw.getColumnDimension()) - 1);
			try_success("rank()...", "");
		} catch (java.lang.RuntimeException QpI9s5n6) {
			rff6JXAP = try_failure(rff6JXAP, "rank()...", "incorrect rank calculation");
		}
		i3E9t4MH = new Matrix(wG7Zzwgh);
		NLkFGvVW = i3E9t4MH.svd();
		double[] CYwLOfUR = NLkFGvVW.getSingularValues();
		try {
			check(i3E9t4MH.cond(),
					CYwLOfUR[0] / CYwLOfUR[Math.min(i3E9t4MH.getRowDimension(), i3E9t4MH.getColumnDimension()) - 1]);
			try_success("cond()...", "");
		} catch (java.lang.RuntimeException XSDivdRi) {
			rff6JXAP = try_failure(rff6JXAP, "cond()...", "incorrect condition number calculation");
		}
		int E1mXUZgr = QydGH4jQ.getColumnDimension();
		QydGH4jQ = QydGH4jQ.getMatrix(0, E1mXUZgr - 1, 0, E1mXUZgr - 1);
		QydGH4jQ.set(0, 0, 0.);
		LUDecomposition eGZtjqnk = QydGH4jQ.lu();
		try {
			check(QydGH4jQ.getMatrix(eGZtjqnk.getPivot(), 0, E1mXUZgr - 1), eGZtjqnk.getL().times(eGZtjqnk.getU()));
			try_success("LUDecomposition...", "");
		} catch (java.lang.RuntimeException CmitYXLe) {
			rff6JXAP = try_failure(rff6JXAP, "LUDecomposition...", "incorrect LU decomposition calculation");
		}
		apyPjTHT = QydGH4jQ.inverse();
		try {
			check(QydGH4jQ.times(apyPjTHT), Matrix.identity(3, 3));
			try_success("inverse()...", "");
		} catch (java.lang.RuntimeException FJgEu54w) {
			rff6JXAP = try_failure(rff6JXAP, "inverse()...", "incorrect inverse calculation");
		}
		XbOryL2M = new Matrix(sbGArPMK.getRowDimension(), 1, 1.0);
		dGkZAxhG = new Matrix(MI2bfQJM);
		Xbr2Hw8s = sbGArPMK.getMatrix(0, sbGArPMK.getRowDimension() - 1, 0, sbGArPMK.getRowDimension() - 1);
		try {
			check(Xbr2Hw8s.solve(dGkZAxhG), XbOryL2M);
			try_success("solve()...", "");
		} catch (java.lang.IllegalArgumentException WBXnmaAS) {
			rff6JXAP = try_failure(rff6JXAP, "solve()...", WBXnmaAS.getMessage());
		} catch (java.lang.RuntimeException DKxpwbpR) {
			rff6JXAP = try_failure(rff6JXAP, "solve()...", DKxpwbpR.getMessage());
		}
		QydGH4jQ = new Matrix(IsMEuDji);
		CholeskyDecomposition oEECOUpV = QydGH4jQ.chol();
		Matrix XpRMdKlZ = oEECOUpV.getL();
		try {
			check(QydGH4jQ, XpRMdKlZ.times(XpRMdKlZ.transpose()));
			try_success("CholeskyDecomposition...", "");
		} catch (java.lang.RuntimeException ux9fGveM) {
			rff6JXAP = try_failure(rff6JXAP, "CholeskyDecomposition...",
					"incorrect Cholesky decomposition calculation");
		}
		apyPjTHT = oEECOUpV.solve(Matrix.identity(3, 3));
		try {
			check(QydGH4jQ.times(apyPjTHT), Matrix.identity(3, 3));
			try_success("CholeskyDecomposition solve()...", "");
		} catch (java.lang.RuntimeException A1lA0ElS) {
			rff6JXAP = try_failure(rff6JXAP, "CholeskyDecomposition solve()...",
					"incorrect Choleskydecomposition solve calculation");
		}
		EigenvalueDecomposition jp1EVAAM = QydGH4jQ.eig();
		Matrix DGBbIrnQ = jp1EVAAM.getD();
		Matrix y1lsBfQJ = jp1EVAAM.getV();
		try {
			check(QydGH4jQ.times(y1lsBfQJ), y1lsBfQJ.times(DGBbIrnQ));
			try_success("EigenvalueDecomposition (symmetric)...", "");
		} catch (java.lang.RuntimeException m7HgWfz4) {
			rff6JXAP = try_failure(rff6JXAP, "EigenvalueDecomposition (symmetric)...",
					"incorrect symmetric Eigenvalue decomposition calculation");
		}
		QydGH4jQ = new Matrix(luY0NiJE);
		jp1EVAAM = QydGH4jQ.eig();
		DGBbIrnQ = jp1EVAAM.getD();
		y1lsBfQJ = jp1EVAAM.getV();
		try {
			check(QydGH4jQ.times(y1lsBfQJ), y1lsBfQJ.times(DGBbIrnQ));
			try_success("EigenvalueDecomposition (nonsymmetric)...", "");
		} catch (java.lang.RuntimeException scuvLMyB) {
			rff6JXAP = try_failure(rff6JXAP, "EigenvalueDecomposition (nonsymmetric)...",
					"incorrect nonsymmetric Eigenvalue decomposition calculation");
		}
		print("\nTestMatrix completed.\n");
		print("Total errors reported: " + Integer.toString(rff6JXAP) + "\n");
		print("Total warnings reported: " + Integer.toString(nT6VwJjD) + "\n");
	}

}