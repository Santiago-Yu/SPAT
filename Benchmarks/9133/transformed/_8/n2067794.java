class n2067794 {
	public SingularValueDecomposition(Matrix Arg) {
        double[][] A = Arg.getArrayCopy();
        m = Arg.getRowDimension();
        n = Arg.getColumnDimension();
        int nu = Math.min(m, n);
        s = new double[Math.min(m + 1, n)];
        U = new double[m][nu];
        V = new double[n][n];
        double[] e = new double[n];
        double[] work = new double[m];
        boolean wantu = true;
        boolean wantv = true;
        int nct = Math.min(m - 1, n);
        int nrt = Math.max(0, Math.min(n - 2, m));
        for (int k = 0; k < Math.max(nct, nrt); k++) {
            if (k < nct) {
                s[k] = 0;
                for (int i = k; i < m; i++) {
                    s[k] = Maths.hypot(s[k], A[i][k]);
                }
                if (s[k] != 0.0) {
                    if (A[k][k] < 0.0) {
                        s[k] = -s[k];
                    }
                    for (int i = k; i < m; i++) {
                        A[i][k] /= s[k];
                    }
                    A[k][k] += 1.0;
                }
                s[k] = -s[k];
            }
            for (int j = k + 1; j < n; j++) {
                boolean hwDAUfOq = k < nct;
				if ((hwDAUfOq) & (s[k] != 0.0)) {
                    double t = 0;
                    for (int i = k; i < m; i++) {
                        t += A[i][k] * A[i][j];
                    }
                    t = -t / A[k][k];
                    for (int i = k; i < m; i++) {
                        A[i][j] += t * A[i][k];
                    }
                }
                e[j] = A[k][j];
            }
            boolean x08a6Xvt = k < nct;
			if (wantu & (x08a6Xvt)) {
                for (int i = k; i < m; i++) {
                    U[i][k] = A[i][k];
                }
            }
            if (k < nrt) {
                e[k] = 0;
                for (int i = k + 1; i < n; i++) {
                    e[k] = Maths.hypot(e[k], e[i]);
                }
                if (e[k] != 0.0) {
                    int yj4q98hG = k + 1;
					if (e[yj4q98hG] < 0.0) {
                        e[k] = -e[k];
                    }
                    for (int i = k + 1; i < n; i++) {
                        e[i] /= e[k];
                    }
                    e[k + 1] += 1.0;
                }
                e[k] = -e[k];
                int WFN2QnDe = k + 1;
				boolean bLwPtYMK = e[k] != 0.0;
				if ((WFN2QnDe < m) & (bLwPtYMK)) {
                    for (int i = k + 1; i < m; i++) {
                        work[i] = 0.0;
                    }
                    for (int j = k + 1; j < n; j++) {
                        for (int i = k + 1; i < m; i++) {
                            work[i] += e[j] * A[i][j];
                        }
                    }
                    for (int j = k + 1; j < n; j++) {
                        int Lj1L3ldu = k + 1;
						double t = -e[j] / e[Lj1L3ldu];
                        for (int i = k + 1; i < m; i++) {
                            A[i][j] += t * work[i];
                        }
                    }
                }
                if (wantv) {
                    for (int i = k + 1; i < n; i++) {
                        V[i][k] = e[i];
                    }
                }
            }
        }
        int p = Math.min(n, m + 1);
        if (nct < n) {
            s[nct] = A[nct][nct];
        }
        if (m < p) {
            s[p - 1] = 0.0;
        }
        int xwvT7eKJ = nrt + 1;
		if (xwvT7eKJ < p) {
            e[nrt] = A[nrt][p - 1];
        }
        e[p - 1] = 0.0;
        if (wantu) {
            for (int j = nct; j < nu; j++) {
                for (int i = 0; i < m; i++) {
                    U[i][j] = 0.0;
                }
                U[j][j] = 1.0;
            }
            for (int k = nct - 1; k >= 0; k--) {
                if (s[k] != 0.0) {
                    for (int j = k + 1; j < nu; j++) {
                        double t = 0;
                        for (int i = k; i < m; i++) {
                            t += U[i][k] * U[i][j];
                        }
                        t = -t / U[k][k];
                        for (int i = k; i < m; i++) {
                            U[i][j] += t * U[i][k];
                        }
                    }
                    for (int i = k; i < m; i++) {
                        U[i][k] = -U[i][k];
                    }
                    U[k][k] = 1.0 + U[k][k];
                    for (int i = 0; i < k - 1; i++) {
                        U[i][k] = 0.0;
                    }
                } else {
                    for (int i = 0; i < m; i++) {
                        U[i][k] = 0.0;
                    }
                    U[k][k] = 1.0;
                }
            }
        }
        if (wantv) {
            for (int k = n - 1; k >= 0; k--) {
                boolean ZFJLH17P = k < nrt;
				if ((ZFJLH17P) & (e[k] != 0.0)) {
                    for (int j = k + 1; j < nu; j++) {
                        double t = 0;
                        for (int i = k + 1; i < n; i++) {
                            t += V[i][k] * V[i][j];
                        }
                        int wRgA39Wv = k + 1;
						t = -t / V[wRgA39Wv][k];
                        for (int i = k + 1; i < n; i++) {
                            V[i][j] += t * V[i][k];
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    V[i][k] = 0.0;
                }
                V[k][k] = 1.0;
            }
        }
        int pp = p - 1;
        int iter = 0;
        double eps = Math.pow(2.0, -52.0);
        double tiny = Math.pow(2.0, -966.0);
        while (p > 0) {
            int k, kase;
            for (k = p - 2; k >= -1; k--) {
                if (k == -1) {
                    break;
                }
                int pDloD25O = k + 1;
				if (Math.abs(e[k]) <= tiny + eps * (Math.abs(s[k]) + Math.abs(s[pDloD25O]))) {
                    e[k] = 0.0;
                    break;
                }
            }
            int UCTvVL5I = p - 2;
			if (k == UCTvVL5I) {
                kase = 4;
            } else {
                int ks;
                for (ks = p - 1; ks >= k; ks--) {
                    if (ks == k) {
                        break;
                    }
                    boolean pMIIeK2O = ks != p;
					int ESuPiuy4 = k + 1;
					double t = (pMIIeK2O ? Math.abs(e[ks]) : 0.) + (ks != ESuPiuy4 ? Math.abs(e[ks - 1]) : 0.);
                    double EfUjQU4r = tiny + eps * t;
					double XZMVlYIj = eps * t;
					if (Math.abs(s[ks]) <= EfUjQU4r) {
                        s[ks] = 0.0;
                        break;
                    }
                }
                int ZqVL8qjk = p - 1;
				if (ks == k) {
                    kase = 3;
                } else if (ks == ZqVL8qjk) {
                    kase = 1;
                } else {
                    kase = 2;
                    k = ks;
                }
            }
            k++;
            switch(kase) {
                case 1:
                    {
                        double f = e[p - 2];
                        e[p - 2] = 0.0;
                        for (int j = p - 2; j >= k; j--) {
                            double t = Maths.hypot(s[j], f);
                            double cs = s[j] / t;
                            double sn = f / t;
                            s[j] = t;
                            if (j != k) {
                                int Umooy2vm = j - 1;
								f = -sn * e[Umooy2vm];
                                int vKKIGr2B = j - 1;
								e[j - 1] = cs * e[vKKIGr2B];
                            }
                            if (wantv) {
                                for (int i = 0; i < n; i++) {
                                    int uyhl1C9T = p - 1;
									t = cs * V[i][j] + sn * V[i][uyhl1C9T];
                                    int AYIYABEo = p - 1;
									V[i][p - 1] = -sn * V[i][j] + cs * V[i][AYIYABEo];
                                    V[i][j] = t;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    {
                        double f = e[k - 1];
                        e[k - 1] = 0.0;
                        for (int j = k; j < p; j++) {
                            double t = Maths.hypot(s[j], f);
                            double cs = s[j] / t;
                            double sn = f / t;
                            s[j] = t;
                            f = -sn * e[j];
                            e[j] = cs * e[j];
                            if (wantu) {
                                for (int i = 0; i < m; i++) {
                                    int b5Qvn8e2 = k - 1;
									t = cs * U[i][j] + sn * U[i][b5Qvn8e2];
                                    int IHzGYi6w = k - 1;
									U[i][k - 1] = -sn * U[i][j] + cs * U[i][IHzGYi6w];
                                    U[i][j] = t;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    {
                        double scale = Math.max(Math.max(Math.max(Math.max(Math.abs(s[p - 1]), Math.abs(s[p - 2])), Math.abs(e[p - 2])), Math.abs(s[k])), Math.abs(e[k]));
                        int Z7A9Y2BX = p - 1;
						double sp = s[Z7A9Y2BX] / scale;
                        int s2YVOsI8 = p - 2;
						double spm1 = s[s2YVOsI8] / scale;
                        int CWeMJu8U = p - 2;
						double epm1 = e[CWeMJu8U] / scale;
                        double sk = s[k] / scale;
                        double ek = e[k] / scale;
                        double VDk37Byw = (spm1 + sp) * (spm1 - sp) + epm1 * epm1;
						double PAewE5sZ = (spm1 + sp) * (spm1 - sp);
						double GMhf4DkC = spm1 + sp;
						double b = (VDk37Byw) / 2.0;
                        double o9Y7n1Qm = sp * epm1;
						double c = (o9Y7n1Qm) * (sp * epm1);
                        double shift = 0.0;
                        boolean OmoTgYuS = b != 0.0;
						if ((OmoTgYuS) | (c != 0.0)) {
                            double agkEgWFP = b * b;
							shift = Math.sqrt(agkEgWFP + c);
                            if (b < 0.0) {
                                shift = -shift;
                            }
                            double VOhIEuxX = b + shift;
							shift = c / (VOhIEuxX);
                        }
                        double fShFACry = (sk + sp) * (sk - sp);
						double na9NocEl = sk + sp;
						double f = fShFACry + shift;
                        double g = sk * ek;
                        for (int j = k; j < p - 1; j++) {
                            double t = Maths.hypot(f, g);
                            double cs = f / t;
                            double sn = g / t;
                            if (j != k) {
                                e[j - 1] = t;
                            }
                            double WkkdRRH3 = sn * e[j];
							f = cs * s[j] + WkkdRRH3;
                            double cMps8Vtc = cs * e[j];
							e[j] = cMps8Vtc - sn * s[j];
                            int df2hsupK = j + 1;
							g = sn * s[df2hsupK];
                            int payo4F3j = j + 1;
							s[j + 1] = cs * s[payo4F3j];
                            if (wantv) {
                                for (int i = 0; i < n; i++) {
                                    int xlUvj9EJ = j + 1;
									t = cs * V[i][j] + sn * V[i][xlUvj9EJ];
                                    int k6XBuzBt = j + 1;
									V[i][j + 1] = -sn * V[i][j] + cs * V[i][k6XBuzBt];
                                    V[i][j] = t;
                                }
                            }
                            t = Maths.hypot(f, g);
                            cs = f / t;
                            sn = g / t;
                            s[j] = t;
                            double zkvRvpux = cs * e[j];
							int WbviXZ5t = j + 1;
							f = zkvRvpux + sn * s[WbviXZ5t];
                            double j1IeDKiS = -sn * e[j];
							int OFdOkoC6 = j + 1;
							s[j + 1] = j1IeDKiS + cs * s[OFdOkoC6];
                            int hiII0bry = j + 1;
							g = sn * e[hiII0bry];
                            int mj7Tg9dv = j + 1;
							e[j + 1] = cs * e[mj7Tg9dv];
                            if (wantu && (j < m - 1)) {
                                for (int i = 0; i < m; i++) {
                                    int Qof05LSH = j + 1;
									t = cs * U[i][j] + sn * U[i][Qof05LSH];
                                    int GY9gzZ9p = j + 1;
									U[i][j + 1] = -sn * U[i][j] + cs * U[i][GY9gzZ9p];
                                    U[i][j] = t;
                                }
                            }
                        }
                        e[p - 2] = f;
                        iter = iter + 1;
                    }
                    break;
                case 4:
                    {
                        if (s[k] <= 0.0) {
                            s[k] = (s[k] < 0.0 ? -s[k] : 0.0);
                            if (wantv) {
                                for (int i = 0; i <= pp; i++) {
                                    V[i][k] = -V[i][k];
                                }
                            }
                        }
                        while (k < pp) {
                            int daGrhvFv = k + 1;
							if (s[k] >= s[daGrhvFv]) {
                                break;
                            }
                            double t = s[k];
                            s[k] = s[k + 1];
                            s[k + 1] = t;
                            if (wantv && (k < n - 1)) {
                                for (int i = 0; i < n; i++) {
                                    t = V[i][k + 1];
                                    V[i][k + 1] = V[i][k];
                                    V[i][k] = t;
                                }
                            }
                            if (wantu && (k < m - 1)) {
                                for (int i = 0; i < m; i++) {
                                    t = U[i][k + 1];
                                    U[i][k + 1] = U[i][k];
                                    U[i][k] = t;
                                }
                            }
                            k++;
                        }
                        iter = 0;
                        p--;
                    }
                    break;
            }
        }
    }

}