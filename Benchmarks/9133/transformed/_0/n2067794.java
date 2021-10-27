class n2067794 {
	public SingularValueDecomposition(Matrix tj0MuSLK) {
        double[][] GUYZCpcd = tj0MuSLK.getArrayCopy();
        m = tj0MuSLK.getRowDimension();
        n = tj0MuSLK.getColumnDimension();
        int mjNO6khG = Math.min(m, n);
        s = new double[Math.min(m + 1, n)];
        U = new double[m][mjNO6khG];
        V = new double[n][n];
        double[] ZsQ65cB5 = new double[n];
        double[] sLWxPDg8 = new double[m];
        boolean PjlvLDOu = true;
        boolean m08eF8vb = true;
        int jHO2GVgz = Math.min(m - 1, n);
        int B6bKnfcC = Math.max(0, Math.min(n - 2, m));
        for (int vyIazyRZ = 0; vyIazyRZ < Math.max(jHO2GVgz, B6bKnfcC); vyIazyRZ++) {
            if (vyIazyRZ < jHO2GVgz) {
                s[vyIazyRZ] = 0;
                for (int BdMlaMci = vyIazyRZ; BdMlaMci < m; BdMlaMci++) {
                    s[vyIazyRZ] = Maths.hypot(s[vyIazyRZ], GUYZCpcd[BdMlaMci][vyIazyRZ]);
                }
                if (s[vyIazyRZ] != 0.0) {
                    if (GUYZCpcd[vyIazyRZ][vyIazyRZ] < 0.0) {
                        s[vyIazyRZ] = -s[vyIazyRZ];
                    }
                    for (int LL6cANAm = vyIazyRZ; LL6cANAm < m; LL6cANAm++) {
                        GUYZCpcd[LL6cANAm][vyIazyRZ] /= s[vyIazyRZ];
                    }
                    GUYZCpcd[vyIazyRZ][vyIazyRZ] += 1.0;
                }
                s[vyIazyRZ] = -s[vyIazyRZ];
            }
            for (int SoNhs3OW = vyIazyRZ + 1; SoNhs3OW < n; SoNhs3OW++) {
                if ((vyIazyRZ < jHO2GVgz) & (s[vyIazyRZ] != 0.0)) {
                    double Ky2pULBQ = 0;
                    for (int GccTwqwO = vyIazyRZ; GccTwqwO < m; GccTwqwO++) {
                        Ky2pULBQ += GUYZCpcd[GccTwqwO][vyIazyRZ] * GUYZCpcd[GccTwqwO][SoNhs3OW];
                    }
                    Ky2pULBQ = -Ky2pULBQ / GUYZCpcd[vyIazyRZ][vyIazyRZ];
                    for (int DD3q3MUM = vyIazyRZ; DD3q3MUM < m; DD3q3MUM++) {
                        GUYZCpcd[DD3q3MUM][SoNhs3OW] += Ky2pULBQ * GUYZCpcd[DD3q3MUM][vyIazyRZ];
                    }
                }
                ZsQ65cB5[SoNhs3OW] = GUYZCpcd[vyIazyRZ][SoNhs3OW];
            }
            if (PjlvLDOu & (vyIazyRZ < jHO2GVgz)) {
                for (int XbtPu4Gg = vyIazyRZ; XbtPu4Gg < m; XbtPu4Gg++) {
                    U[XbtPu4Gg][vyIazyRZ] = GUYZCpcd[XbtPu4Gg][vyIazyRZ];
                }
            }
            if (vyIazyRZ < B6bKnfcC) {
                ZsQ65cB5[vyIazyRZ] = 0;
                for (int qfP9EtTq = vyIazyRZ + 1; qfP9EtTq < n; qfP9EtTq++) {
                    ZsQ65cB5[vyIazyRZ] = Maths.hypot(ZsQ65cB5[vyIazyRZ], ZsQ65cB5[qfP9EtTq]);
                }
                if (ZsQ65cB5[vyIazyRZ] != 0.0) {
                    if (ZsQ65cB5[vyIazyRZ + 1] < 0.0) {
                        ZsQ65cB5[vyIazyRZ] = -ZsQ65cB5[vyIazyRZ];
                    }
                    for (int Nl2zlF9H = vyIazyRZ + 1; Nl2zlF9H < n; Nl2zlF9H++) {
                        ZsQ65cB5[Nl2zlF9H] /= ZsQ65cB5[vyIazyRZ];
                    }
                    ZsQ65cB5[vyIazyRZ + 1] += 1.0;
                }
                ZsQ65cB5[vyIazyRZ] = -ZsQ65cB5[vyIazyRZ];
                if ((vyIazyRZ + 1 < m) & (ZsQ65cB5[vyIazyRZ] != 0.0)) {
                    for (int xdGLnrcB = vyIazyRZ + 1; xdGLnrcB < m; xdGLnrcB++) {
                        sLWxPDg8[xdGLnrcB] = 0.0;
                    }
                    for (int b1xCkkpe = vyIazyRZ + 1; b1xCkkpe < n; b1xCkkpe++) {
                        for (int GsPZh5XI = vyIazyRZ + 1; GsPZh5XI < m; GsPZh5XI++) {
                            sLWxPDg8[GsPZh5XI] += ZsQ65cB5[b1xCkkpe] * GUYZCpcd[GsPZh5XI][b1xCkkpe];
                        }
                    }
                    for (int Nfgp9zog = vyIazyRZ + 1; Nfgp9zog < n; Nfgp9zog++) {
                        double jOuWS09m = -ZsQ65cB5[Nfgp9zog] / ZsQ65cB5[vyIazyRZ + 1];
                        for (int vlgNDF1i = vyIazyRZ + 1; vlgNDF1i < m; vlgNDF1i++) {
                            GUYZCpcd[vlgNDF1i][Nfgp9zog] += jOuWS09m * sLWxPDg8[vlgNDF1i];
                        }
                    }
                }
                if (m08eF8vb) {
                    for (int f1Dl948O = vyIazyRZ + 1; f1Dl948O < n; f1Dl948O++) {
                        V[f1Dl948O][vyIazyRZ] = ZsQ65cB5[f1Dl948O];
                    }
                }
            }
        }
        int y6G57A5s = Math.min(n, m + 1);
        if (jHO2GVgz < n) {
            s[jHO2GVgz] = GUYZCpcd[jHO2GVgz][jHO2GVgz];
        }
        if (m < y6G57A5s) {
            s[y6G57A5s - 1] = 0.0;
        }
        if (B6bKnfcC + 1 < y6G57A5s) {
            ZsQ65cB5[B6bKnfcC] = GUYZCpcd[B6bKnfcC][y6G57A5s - 1];
        }
        ZsQ65cB5[y6G57A5s - 1] = 0.0;
        if (PjlvLDOu) {
            for (int OnDrhqnI = jHO2GVgz; OnDrhqnI < mjNO6khG; OnDrhqnI++) {
                for (int WwEMvGvV = 0; WwEMvGvV < m; WwEMvGvV++) {
                    U[WwEMvGvV][OnDrhqnI] = 0.0;
                }
                U[OnDrhqnI][OnDrhqnI] = 1.0;
            }
            for (int Iy1IDfsY = jHO2GVgz - 1; Iy1IDfsY >= 0; Iy1IDfsY--) {
                if (s[Iy1IDfsY] != 0.0) {
                    for (int KrYamF3C = Iy1IDfsY + 1; KrYamF3C < mjNO6khG; KrYamF3C++) {
                        double voOpKWmx = 0;
                        for (int JEkU7L1b = Iy1IDfsY; JEkU7L1b < m; JEkU7L1b++) {
                            voOpKWmx += U[JEkU7L1b][Iy1IDfsY] * U[JEkU7L1b][KrYamF3C];
                        }
                        voOpKWmx = -voOpKWmx / U[Iy1IDfsY][Iy1IDfsY];
                        for (int AjrW2xtb = Iy1IDfsY; AjrW2xtb < m; AjrW2xtb++) {
                            U[AjrW2xtb][KrYamF3C] += voOpKWmx * U[AjrW2xtb][Iy1IDfsY];
                        }
                    }
                    for (int IWuSWFdn = Iy1IDfsY; IWuSWFdn < m; IWuSWFdn++) {
                        U[IWuSWFdn][Iy1IDfsY] = -U[IWuSWFdn][Iy1IDfsY];
                    }
                    U[Iy1IDfsY][Iy1IDfsY] = 1.0 + U[Iy1IDfsY][Iy1IDfsY];
                    for (int pnWePuc6 = 0; pnWePuc6 < Iy1IDfsY - 1; pnWePuc6++) {
                        U[pnWePuc6][Iy1IDfsY] = 0.0;
                    }
                } else {
                    for (int RRm4MNUd = 0; RRm4MNUd < m; RRm4MNUd++) {
                        U[RRm4MNUd][Iy1IDfsY] = 0.0;
                    }
                    U[Iy1IDfsY][Iy1IDfsY] = 1.0;
                }
            }
        }
        if (m08eF8vb) {
            for (int pftvkFVQ = n - 1; pftvkFVQ >= 0; pftvkFVQ--) {
                if ((pftvkFVQ < B6bKnfcC) & (ZsQ65cB5[pftvkFVQ] != 0.0)) {
                    for (int iJR6006C = pftvkFVQ + 1; iJR6006C < mjNO6khG; iJR6006C++) {
                        double bME7ProU = 0;
                        for (int ZGDQo52v = pftvkFVQ + 1; ZGDQo52v < n; ZGDQo52v++) {
                            bME7ProU += V[ZGDQo52v][pftvkFVQ] * V[ZGDQo52v][iJR6006C];
                        }
                        bME7ProU = -bME7ProU / V[pftvkFVQ + 1][pftvkFVQ];
                        for (int XtEaTVTf = pftvkFVQ + 1; XtEaTVTf < n; XtEaTVTf++) {
                            V[XtEaTVTf][iJR6006C] += bME7ProU * V[XtEaTVTf][pftvkFVQ];
                        }
                    }
                }
                for (int thdLvaDV = 0; thdLvaDV < n; thdLvaDV++) {
                    V[thdLvaDV][pftvkFVQ] = 0.0;
                }
                V[pftvkFVQ][pftvkFVQ] = 1.0;
            }
        }
        int b40Kv3lH = y6G57A5s - 1;
        int rGb1ZeAY = 0;
        double wrPgdfuF = Math.pow(2.0, -52.0);
        double Yzb2fCni = Math.pow(2.0, -966.0);
        while (y6G57A5s > 0) {
            int b3NhkZzq, hrZAEzXx;
            for (b3NhkZzq = y6G57A5s - 2; b3NhkZzq >= -1; b3NhkZzq--) {
                if (b3NhkZzq == -1) {
                    break;
                }
                if (Math.abs(ZsQ65cB5[b3NhkZzq]) <= Yzb2fCni + wrPgdfuF * (Math.abs(s[b3NhkZzq]) + Math.abs(s[b3NhkZzq + 1]))) {
                    ZsQ65cB5[b3NhkZzq] = 0.0;
                    break;
                }
            }
            if (b3NhkZzq == y6G57A5s - 2) {
                hrZAEzXx = 4;
            } else {
                int HKyvQFlx;
                for (HKyvQFlx = y6G57A5s - 1; HKyvQFlx >= b3NhkZzq; HKyvQFlx--) {
                    if (HKyvQFlx == b3NhkZzq) {
                        break;
                    }
                    double FN7SDBMz = (HKyvQFlx != y6G57A5s ? Math.abs(ZsQ65cB5[HKyvQFlx]) : 0.) + (HKyvQFlx != b3NhkZzq + 1 ? Math.abs(ZsQ65cB5[HKyvQFlx - 1]) : 0.);
                    if (Math.abs(s[HKyvQFlx]) <= Yzb2fCni + wrPgdfuF * FN7SDBMz) {
                        s[HKyvQFlx] = 0.0;
                        break;
                    }
                }
                if (HKyvQFlx == b3NhkZzq) {
                    hrZAEzXx = 3;
                } else if (HKyvQFlx == y6G57A5s - 1) {
                    hrZAEzXx = 1;
                } else {
                    hrZAEzXx = 2;
                    b3NhkZzq = HKyvQFlx;
                }
            }
            b3NhkZzq++;
            switch(hrZAEzXx) {
                case 1:
                    {
                        double mPpnGQCL = ZsQ65cB5[y6G57A5s - 2];
                        ZsQ65cB5[y6G57A5s - 2] = 0.0;
                        for (int p5JhzXdA = y6G57A5s - 2; p5JhzXdA >= b3NhkZzq; p5JhzXdA--) {
                            double ZZMxoKBX = Maths.hypot(s[p5JhzXdA], mPpnGQCL);
                            double GdrIPmAG = s[p5JhzXdA] / ZZMxoKBX;
                            double z6c8FBM1 = mPpnGQCL / ZZMxoKBX;
                            s[p5JhzXdA] = ZZMxoKBX;
                            if (p5JhzXdA != b3NhkZzq) {
                                mPpnGQCL = -z6c8FBM1 * ZsQ65cB5[p5JhzXdA - 1];
                                ZsQ65cB5[p5JhzXdA - 1] = GdrIPmAG * ZsQ65cB5[p5JhzXdA - 1];
                            }
                            if (m08eF8vb) {
                                for (int Wx90pMs2 = 0; Wx90pMs2 < n; Wx90pMs2++) {
                                    ZZMxoKBX = GdrIPmAG * V[Wx90pMs2][p5JhzXdA] + z6c8FBM1 * V[Wx90pMs2][y6G57A5s - 1];
                                    V[Wx90pMs2][y6G57A5s - 1] = -z6c8FBM1 * V[Wx90pMs2][p5JhzXdA] + GdrIPmAG * V[Wx90pMs2][y6G57A5s - 1];
                                    V[Wx90pMs2][p5JhzXdA] = ZZMxoKBX;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    {
                        double Dr9XPVs3 = ZsQ65cB5[b3NhkZzq - 1];
                        ZsQ65cB5[b3NhkZzq - 1] = 0.0;
                        for (int bmfhcP3z = b3NhkZzq; bmfhcP3z < y6G57A5s; bmfhcP3z++) {
                            double cu0mCM1G = Maths.hypot(s[bmfhcP3z], Dr9XPVs3);
                            double PCNwSqP3 = s[bmfhcP3z] / cu0mCM1G;
                            double wquDrcp5 = Dr9XPVs3 / cu0mCM1G;
                            s[bmfhcP3z] = cu0mCM1G;
                            Dr9XPVs3 = -wquDrcp5 * ZsQ65cB5[bmfhcP3z];
                            ZsQ65cB5[bmfhcP3z] = PCNwSqP3 * ZsQ65cB5[bmfhcP3z];
                            if (PjlvLDOu) {
                                for (int DrUqzmhq = 0; DrUqzmhq < m; DrUqzmhq++) {
                                    cu0mCM1G = PCNwSqP3 * U[DrUqzmhq][bmfhcP3z] + wquDrcp5 * U[DrUqzmhq][b3NhkZzq - 1];
                                    U[DrUqzmhq][b3NhkZzq - 1] = -wquDrcp5 * U[DrUqzmhq][bmfhcP3z] + PCNwSqP3 * U[DrUqzmhq][b3NhkZzq - 1];
                                    U[DrUqzmhq][bmfhcP3z] = cu0mCM1G;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    {
                        double WT2wdOtc = Math.max(Math.max(Math.max(Math.max(Math.abs(s[y6G57A5s - 1]), Math.abs(s[y6G57A5s - 2])), Math.abs(ZsQ65cB5[y6G57A5s - 2])), Math.abs(s[b3NhkZzq])), Math.abs(ZsQ65cB5[b3NhkZzq]));
                        double l4q80JlO = s[y6G57A5s - 1] / WT2wdOtc;
                        double Ryk40BFm = s[y6G57A5s - 2] / WT2wdOtc;
                        double o1PvsXhq = ZsQ65cB5[y6G57A5s - 2] / WT2wdOtc;
                        double ZjtvALUF = s[b3NhkZzq] / WT2wdOtc;
                        double zsgxiDKF = ZsQ65cB5[b3NhkZzq] / WT2wdOtc;
                        double DnuGrWms = ((Ryk40BFm + l4q80JlO) * (Ryk40BFm - l4q80JlO) + o1PvsXhq * o1PvsXhq) / 2.0;
                        double oKNlYmSo = (l4q80JlO * o1PvsXhq) * (l4q80JlO * o1PvsXhq);
                        double GfRNAt4m = 0.0;
                        if ((DnuGrWms != 0.0) | (oKNlYmSo != 0.0)) {
                            GfRNAt4m = Math.sqrt(DnuGrWms * DnuGrWms + oKNlYmSo);
                            if (DnuGrWms < 0.0) {
                                GfRNAt4m = -GfRNAt4m;
                            }
                            GfRNAt4m = oKNlYmSo / (DnuGrWms + GfRNAt4m);
                        }
                        double Lpexhy1A = (ZjtvALUF + l4q80JlO) * (ZjtvALUF - l4q80JlO) + GfRNAt4m;
                        double nMgQRIiz = ZjtvALUF * zsgxiDKF;
                        for (int Kke6WD3Z = b3NhkZzq; Kke6WD3Z < y6G57A5s - 1; Kke6WD3Z++) {
                            double iz4rbAxk = Maths.hypot(Lpexhy1A, nMgQRIiz);
                            double mvs7rU8J = Lpexhy1A / iz4rbAxk;
                            double fI9uLhDV = nMgQRIiz / iz4rbAxk;
                            if (Kke6WD3Z != b3NhkZzq) {
                                ZsQ65cB5[Kke6WD3Z - 1] = iz4rbAxk;
                            }
                            Lpexhy1A = mvs7rU8J * s[Kke6WD3Z] + fI9uLhDV * ZsQ65cB5[Kke6WD3Z];
                            ZsQ65cB5[Kke6WD3Z] = mvs7rU8J * ZsQ65cB5[Kke6WD3Z] - fI9uLhDV * s[Kke6WD3Z];
                            nMgQRIiz = fI9uLhDV * s[Kke6WD3Z + 1];
                            s[Kke6WD3Z + 1] = mvs7rU8J * s[Kke6WD3Z + 1];
                            if (m08eF8vb) {
                                for (int AOifxXqv = 0; AOifxXqv < n; AOifxXqv++) {
                                    iz4rbAxk = mvs7rU8J * V[AOifxXqv][Kke6WD3Z] + fI9uLhDV * V[AOifxXqv][Kke6WD3Z + 1];
                                    V[AOifxXqv][Kke6WD3Z + 1] = -fI9uLhDV * V[AOifxXqv][Kke6WD3Z] + mvs7rU8J * V[AOifxXqv][Kke6WD3Z + 1];
                                    V[AOifxXqv][Kke6WD3Z] = iz4rbAxk;
                                }
                            }
                            iz4rbAxk = Maths.hypot(Lpexhy1A, nMgQRIiz);
                            mvs7rU8J = Lpexhy1A / iz4rbAxk;
                            fI9uLhDV = nMgQRIiz / iz4rbAxk;
                            s[Kke6WD3Z] = iz4rbAxk;
                            Lpexhy1A = mvs7rU8J * ZsQ65cB5[Kke6WD3Z] + fI9uLhDV * s[Kke6WD3Z + 1];
                            s[Kke6WD3Z + 1] = -fI9uLhDV * ZsQ65cB5[Kke6WD3Z] + mvs7rU8J * s[Kke6WD3Z + 1];
                            nMgQRIiz = fI9uLhDV * ZsQ65cB5[Kke6WD3Z + 1];
                            ZsQ65cB5[Kke6WD3Z + 1] = mvs7rU8J * ZsQ65cB5[Kke6WD3Z + 1];
                            if (PjlvLDOu && (Kke6WD3Z < m - 1)) {
                                for (int eHE9JdTg = 0; eHE9JdTg < m; eHE9JdTg++) {
                                    iz4rbAxk = mvs7rU8J * U[eHE9JdTg][Kke6WD3Z] + fI9uLhDV * U[eHE9JdTg][Kke6WD3Z + 1];
                                    U[eHE9JdTg][Kke6WD3Z + 1] = -fI9uLhDV * U[eHE9JdTg][Kke6WD3Z] + mvs7rU8J * U[eHE9JdTg][Kke6WD3Z + 1];
                                    U[eHE9JdTg][Kke6WD3Z] = iz4rbAxk;
                                }
                            }
                        }
                        ZsQ65cB5[y6G57A5s - 2] = Lpexhy1A;
                        rGb1ZeAY = rGb1ZeAY + 1;
                    }
                    break;
                case 4:
                    {
                        if (s[b3NhkZzq] <= 0.0) {
                            s[b3NhkZzq] = (s[b3NhkZzq] < 0.0 ? -s[b3NhkZzq] : 0.0);
                            if (m08eF8vb) {
                                for (int Z6ZSf5va = 0; Z6ZSf5va <= b40Kv3lH; Z6ZSf5va++) {
                                    V[Z6ZSf5va][b3NhkZzq] = -V[Z6ZSf5va][b3NhkZzq];
                                }
                            }
                        }
                        while (b3NhkZzq < b40Kv3lH) {
                            if (s[b3NhkZzq] >= s[b3NhkZzq + 1]) {
                                break;
                            }
                            double fX5NYJqf = s[b3NhkZzq];
                            s[b3NhkZzq] = s[b3NhkZzq + 1];
                            s[b3NhkZzq + 1] = fX5NYJqf;
                            if (m08eF8vb && (b3NhkZzq < n - 1)) {
                                for (int KPrNogUj = 0; KPrNogUj < n; KPrNogUj++) {
                                    fX5NYJqf = V[KPrNogUj][b3NhkZzq + 1];
                                    V[KPrNogUj][b3NhkZzq + 1] = V[KPrNogUj][b3NhkZzq];
                                    V[KPrNogUj][b3NhkZzq] = fX5NYJqf;
                                }
                            }
                            if (PjlvLDOu && (b3NhkZzq < m - 1)) {
                                for (int F40WxdZT = 0; F40WxdZT < m; F40WxdZT++) {
                                    fX5NYJqf = U[F40WxdZT][b3NhkZzq + 1];
                                    U[F40WxdZT][b3NhkZzq + 1] = U[F40WxdZT][b3NhkZzq];
                                    U[F40WxdZT][b3NhkZzq] = fX5NYJqf;
                                }
                            }
                            b3NhkZzq++;
                        }
                        rGb1ZeAY = 0;
                        y6G57A5s--;
                    }
                    break;
            }
        }
    }

}