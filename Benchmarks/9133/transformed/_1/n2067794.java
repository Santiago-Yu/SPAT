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
        int b8S4L = 0;
		while (b8S4L < Math.max(nct, nrt)) {
			if (b8S4L < nct) {
				s[b8S4L] = 0;
				for (int i = b8S4L; i < m; i++) {
					s[b8S4L] = Maths.hypot(s[b8S4L], A[i][b8S4L]);
				}
				if (s[b8S4L] != 0.0) {
					if (A[b8S4L][b8S4L] < 0.0) {
						s[b8S4L] = -s[b8S4L];
					}
					for (int i = b8S4L; i < m; i++) {
						A[i][b8S4L] /= s[b8S4L];
					}
					A[b8S4L][b8S4L] += 1.0;
				}
				s[b8S4L] = -s[b8S4L];
			}
			for (int j = b8S4L + 1; j < n; j++) {
				if ((b8S4L < nct) & (s[b8S4L] != 0.0)) {
					double t = 0;
					for (int i = b8S4L; i < m; i++) {
						t += A[i][b8S4L] * A[i][j];
					}
					t = -t / A[b8S4L][b8S4L];
					for (int i = b8S4L; i < m; i++) {
						A[i][j] += t * A[i][b8S4L];
					}
				}
				e[j] = A[b8S4L][j];
			}
			if (wantu & (b8S4L < nct)) {
				for (int i = b8S4L; i < m; i++) {
					U[i][b8S4L] = A[i][b8S4L];
				}
			}
			if (b8S4L < nrt) {
				e[b8S4L] = 0;
				for (int i = b8S4L + 1; i < n; i++) {
					e[b8S4L] = Maths.hypot(e[b8S4L], e[i]);
				}
				if (e[b8S4L] != 0.0) {
					if (e[b8S4L + 1] < 0.0) {
						e[b8S4L] = -e[b8S4L];
					}
					for (int i = b8S4L + 1; i < n; i++) {
						e[i] /= e[b8S4L];
					}
					e[b8S4L + 1] += 1.0;
				}
				e[b8S4L] = -e[b8S4L];
				if ((b8S4L + 1 < m) & (e[b8S4L] != 0.0)) {
					for (int i = b8S4L + 1; i < m; i++) {
						work[i] = 0.0;
					}
					for (int j = b8S4L + 1; j < n; j++) {
						for (int i = b8S4L + 1; i < m; i++) {
							work[i] += e[j] * A[i][j];
						}
					}
					for (int j = b8S4L + 1; j < n; j++) {
						double t = -e[j] / e[b8S4L + 1];
						for (int i = b8S4L + 1; i < m; i++) {
							A[i][j] += t * work[i];
						}
					}
				}
				if (wantv) {
					for (int i = b8S4L + 1; i < n; i++) {
						V[i][b8S4L] = e[i];
					}
				}
			}
			b8S4L++;
		}
        int p = Math.min(n, m + 1);
        if (nct < n) {
            s[nct] = A[nct][nct];
        }
        if (m < p) {
            s[p - 1] = 0.0;
        }
        if (nrt + 1 < p) {
            e[nrt] = A[nrt][p - 1];
        }
        e[p - 1] = 0.0;
        if (wantu) {
            int g3P5Q = nct;
			while (g3P5Q < nu) {
				for (int i = 0; i < m; i++) {
					U[i][g3P5Q] = 0.0;
				}
				U[g3P5Q][g3P5Q] = 1.0;
				g3P5Q++;
			}
            int CuL0N = nct - 1;
			while (CuL0N >= 0) {
				if (s[CuL0N] != 0.0) {
					for (int j = CuL0N + 1; j < nu; j++) {
						double t = 0;
						for (int i = CuL0N; i < m; i++) {
							t += U[i][CuL0N] * U[i][j];
						}
						t = -t / U[CuL0N][CuL0N];
						for (int i = CuL0N; i < m; i++) {
							U[i][j] += t * U[i][CuL0N];
						}
					}
					for (int i = CuL0N; i < m; i++) {
						U[i][CuL0N] = -U[i][CuL0N];
					}
					U[CuL0N][CuL0N] = 1.0 + U[CuL0N][CuL0N];
					for (int i = 0; i < CuL0N - 1; i++) {
						U[i][CuL0N] = 0.0;
					}
				} else {
					for (int i = 0; i < m; i++) {
						U[i][CuL0N] = 0.0;
					}
					U[CuL0N][CuL0N] = 1.0;
				}
				CuL0N--;
			}
        }
        if (wantv) {
            int pPtWv = n - 1;
			while (pPtWv >= 0) {
				if ((pPtWv < nrt) & (e[pPtWv] != 0.0)) {
					for (int j = pPtWv + 1; j < nu; j++) {
						double t = 0;
						for (int i = pPtWv + 1; i < n; i++) {
							t += V[i][pPtWv] * V[i][j];
						}
						t = -t / V[pPtWv + 1][pPtWv];
						for (int i = pPtWv + 1; i < n; i++) {
							V[i][j] += t * V[i][pPtWv];
						}
					}
				}
				for (int i = 0; i < n; i++) {
					V[i][pPtWv] = 0.0;
				}
				V[pPtWv][pPtWv] = 1.0;
				pPtWv--;
			}
        }
        int pp = p - 1;
        int iter = 0;
        double eps = Math.pow(2.0, -52.0);
        double tiny = Math.pow(2.0, -966.0);
        while (p > 0) {
            int k, kase;
            k = p - 2;
			while (k >= -1) {
				if (k == -1) {
					break;
				}
				if (Math.abs(e[k]) <= tiny + eps * (Math.abs(s[k]) + Math.abs(s[k + 1]))) {
					e[k] = 0.0;
					break;
				}
				k--;
			}
            if (k == p - 2) {
                kase = 4;
            } else {
                int ks;
                ks = p - 1;
				while (ks >= k) {
					if (ks == k) {
						break;
					}
					double t = (ks != p ? Math.abs(e[ks]) : 0.) + (ks != k + 1 ? Math.abs(e[ks - 1]) : 0.);
					if (Math.abs(s[ks]) <= tiny + eps * t) {
						s[ks] = 0.0;
						break;
					}
					ks--;
				}
                if (ks == k) {
                    kase = 3;
                } else if (ks == p - 1) {
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
                        int NRwuJ = p - 2;
						while (NRwuJ >= k) {
							double t = Maths.hypot(s[NRwuJ], f);
							double cs = s[NRwuJ] / t;
							double sn = f / t;
							s[NRwuJ] = t;
							if (NRwuJ != k) {
								f = -sn * e[NRwuJ - 1];
								e[NRwuJ - 1] = cs * e[NRwuJ - 1];
							}
							if (wantv) {
								for (int i = 0; i < n; i++) {
									t = cs * V[i][NRwuJ] + sn * V[i][p - 1];
									V[i][p - 1] = -sn * V[i][NRwuJ] + cs * V[i][p - 1];
									V[i][NRwuJ] = t;
								}
							}
							NRwuJ--;
						}
                    }
                    break;
                case 2:
                    {
                        double f = e[k - 1];
                        e[k - 1] = 0.0;
                        int TakH6 = k;
						while (TakH6 < p) {
							double t = Maths.hypot(s[TakH6], f);
							double cs = s[TakH6] / t;
							double sn = f / t;
							s[TakH6] = t;
							f = -sn * e[TakH6];
							e[TakH6] = cs * e[TakH6];
							if (wantu) {
								for (int i = 0; i < m; i++) {
									t = cs * U[i][TakH6] + sn * U[i][k - 1];
									U[i][k - 1] = -sn * U[i][TakH6] + cs * U[i][k - 1];
									U[i][TakH6] = t;
								}
							}
							TakH6++;
						}
                    }
                    break;
                case 3:
                    {
                        double scale = Math.max(Math.max(Math.max(Math.max(Math.abs(s[p - 1]), Math.abs(s[p - 2])), Math.abs(e[p - 2])), Math.abs(s[k])), Math.abs(e[k]));
                        double sp = s[p - 1] / scale;
                        double spm1 = s[p - 2] / scale;
                        double epm1 = e[p - 2] / scale;
                        double sk = s[k] / scale;
                        double ek = e[k] / scale;
                        double b = ((spm1 + sp) * (spm1 - sp) + epm1 * epm1) / 2.0;
                        double c = (sp * epm1) * (sp * epm1);
                        double shift = 0.0;
                        if ((b != 0.0) | (c != 0.0)) {
                            shift = Math.sqrt(b * b + c);
                            if (b < 0.0) {
                                shift = -shift;
                            }
                            shift = c / (b + shift);
                        }
                        double f = (sk + sp) * (sk - sp) + shift;
                        double g = sk * ek;
                        int ziVYQ = k;
						while (ziVYQ < p - 1) {
							double t = Maths.hypot(f, g);
							double cs = f / t;
							double sn = g / t;
							if (ziVYQ != k) {
								e[ziVYQ - 1] = t;
							}
							f = cs * s[ziVYQ] + sn * e[ziVYQ];
							e[ziVYQ] = cs * e[ziVYQ] - sn * s[ziVYQ];
							g = sn * s[ziVYQ + 1];
							s[ziVYQ + 1] = cs * s[ziVYQ + 1];
							if (wantv) {
								for (int i = 0; i < n; i++) {
									t = cs * V[i][ziVYQ] + sn * V[i][ziVYQ + 1];
									V[i][ziVYQ + 1] = -sn * V[i][ziVYQ] + cs * V[i][ziVYQ + 1];
									V[i][ziVYQ] = t;
								}
							}
							t = Maths.hypot(f, g);
							cs = f / t;
							sn = g / t;
							s[ziVYQ] = t;
							f = cs * e[ziVYQ] + sn * s[ziVYQ + 1];
							s[ziVYQ + 1] = -sn * e[ziVYQ] + cs * s[ziVYQ + 1];
							g = sn * e[ziVYQ + 1];
							e[ziVYQ + 1] = cs * e[ziVYQ + 1];
							if (wantu && (ziVYQ < m - 1)) {
								for (int i = 0; i < m; i++) {
									t = cs * U[i][ziVYQ] + sn * U[i][ziVYQ + 1];
									U[i][ziVYQ + 1] = -sn * U[i][ziVYQ] + cs * U[i][ziVYQ + 1];
									U[i][ziVYQ] = t;
								}
							}
							ziVYQ++;
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
                                int lOC9G = 0;
								while (lOC9G <= pp) {
									V[lOC9G][k] = -V[lOC9G][k];
									lOC9G++;
								}
                            }
                        }
                        while (k < pp) {
                            if (s[k] >= s[k + 1]) {
                                break;
                            }
                            double t = s[k];
                            s[k] = s[k + 1];
                            s[k + 1] = t;
                            if (wantv && (k < n - 1)) {
                                int U8tFQ = 0;
								while (U8tFQ < n) {
									t = V[U8tFQ][k + 1];
									V[U8tFQ][k + 1] = V[U8tFQ][k];
									V[U8tFQ][k] = t;
									U8tFQ++;
								}
                            }
                            if (wantu && (k < m - 1)) {
                                int qnc9y = 0;
								while (qnc9y < m) {
									t = U[qnc9y][k + 1];
									U[qnc9y][k + 1] = U[qnc9y][k];
									U[qnc9y][k] = t;
									qnc9y++;
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