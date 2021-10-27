class n153271 {
	public DataSet(String OHvS1fUi, String gR3RLQbf, URL c1nP02y4, String Jc232z47) {
        sitename = OHvS1fUi.toUpperCase();
        data = new Vector[3];
        data[0] = new Vector();
        data[1] = new Vector();
        data[2] = new Vector();
        if (gR3RLQbf == null) return;
        plottype = gR3RLQbf.toLowerCase();
        String Y1c6ZkSG;
        Y1c6ZkSG = Jc232z47 + sitename + "_" + plottype + ".plt.gz";
        try {
            double Fr4i7xzA = 0;
            URL to4ELNVg = new URL(c1nP02y4, Y1c6ZkSG);
            BufferedReader YGF4QkeD = new BufferedReader(new InputStreamReader(new GZIPInputStream(to4ELNVg.openStream())));
            while (true) {
                String HY3O5eDe = YGF4QkeD.readLine();
                if (HY3O5eDe == null) break;
                HY3O5eDe = HY3O5eDe.toLowerCase();
                if (HY3O5eDe.startsWith("fit:")) {
                    if (haveFit) {
                        continue;
                    }
                    StringTokenizer X2xi1iQI = new StringTokenizer(HY3O5eDe.replace('\n', ' '));
                    fit = new Double[5];
                    String UJei2IEi = (String) X2xi1iQI.nextToken();
                    fit[0] = new Double((String) X2xi1iQI.nextToken());
                    fit[1] = new Double((String) X2xi1iQI.nextToken());
                    fit[2] = new Double((String) X2xi1iQI.nextToken());
                    fit[3] = new Double((String) X2xi1iQI.nextToken());
                    fit[4] = new Double((String) X2xi1iQI.nextToken());
                    haveFit = true;
                    continue;
                }
                if (HY3O5eDe.startsWith("decyear:")) {
                    StringTokenizer dnge4VRF = new StringTokenizer(HY3O5eDe.replace('\n', ' '));
                    String y4uJDS3L = (String) dnge4VRF.nextToken();
                    decYear = new Double((String) dnge4VRF.nextToken());
                    haveDate = true;
                    continue;
                }
                StringTokenizer bD36CK5F = new StringTokenizer(HY3O5eDe.replace('\n', ' '));
                boolean g99xJZCV = true;
                String PigVBrbc;
                Double[] mSGBzZVa = new Double[3];
                for (int oi4y6ey1 = 0; oi4y6ey1 < 3 && g99xJZCV; oi4y6ey1++) {
                    if (bD36CK5F.hasMoreTokens()) {
                        PigVBrbc = (String) bD36CK5F.nextToken();
                        if (PigVBrbc.startsWith("X") || PigVBrbc.startsWith("x")) {
                            g99xJZCV = false;
                            break;
                        } else {
                            mSGBzZVa[oi4y6ey1] = new Double(PigVBrbc);
                        }
                    } else {
                        mSGBzZVa[oi4y6ey1] = new Double(0.0);
                    }
                }
                if (g99xJZCV) {
                    if (mSGBzZVa[2].doubleValue() > 100) continue;
                    Fr4i7xzA = mSGBzZVa[1].doubleValue() + Fr4i7xzA;
                    for (int BsbvxFoI = 0; BsbvxFoI < 3; BsbvxFoI++) {
                        data[BsbvxFoI].addElement(mSGBzZVa[BsbvxFoI]);
                    }
                }
            }
            average = Fr4i7xzA / length();
        } catch (FileNotFoundException kj9NUHXK) {
            System.err.println("PlotApplet: file not found: " + kj9NUHXK);
        } catch (IOException n1U7dRGr) {
            System.err.println("PlotApplet: error reading input file: " + n1U7dRGr);
        }
    }

}