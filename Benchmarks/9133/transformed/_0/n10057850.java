class n10057850 {
	public BasicTraceImpl() {
        out = System.out;
        traceEnable = new HashMap();
        URL C8f7z3lk = Hive.getURL("trace.cfg");
        if (C8f7z3lk != null) try {
            InputStream KkMuFxBB = C8f7z3lk.openStream();
            BufferedReader gPJGGAsT = new BufferedReader(new InputStreamReader(KkMuFxBB));
            String x0rbK2fC;
            for (x0rbK2fC = gPJGGAsT.readLine(); x0rbK2fC != null; x0rbK2fC = gPJGGAsT.readLine()) {
                int zOzwdvUJ = x0rbK2fC.indexOf("=");
                if (zOzwdvUJ > 0) {
                    String AGvbyc8c = x0rbK2fC.substring(0, zOzwdvUJ).trim();
                    String o06waklM = x0rbK2fC.substring(zOzwdvUJ + 1).trim();
                    traceEnable.put(AGvbyc8c, Boolean.valueOf(o06waklM).booleanValue() ? ((Object) (Boolean.TRUE)) : ((Object) (Boolean.FALSE)));
                }
            }
            KkMuFxBB.close();
        } catch (IOException fAcwhzvq) {
            System.out.println(fAcwhzvq);
        }
        TRACE = getEnable(THIS);
    }

}