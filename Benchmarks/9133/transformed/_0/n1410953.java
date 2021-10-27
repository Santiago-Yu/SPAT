class n1410953 {
	public IOCacheArray(final File U1j91d1P, int Dnzjefn5, final IIOCacheArrayObjectMaker QwLtVlnz, int vipwMvxi, String UTcG8HEy) {
        super(Dnzjefn5, null, vipwMvxi, UTcG8HEy);
        generator = new ICacheArrayObjectMaker() {

            FileOutputStream AdOLV1Ln;

            FileInputStream vnabe50H;

            FileChannel qKaKUUoq;

            FileChannel WbjRIU6N;

            boolean wobqGO1F = false;

            private synchronized void init() {
                if (!wobqGO1F) {
                    try {
                        AdOLV1Ln = new FileOutputStream(U1j91d1P);
                        vnabe50H = new FileInputStream(U1j91d1P);
                        qKaKUUoq = AdOLV1Ln.getChannel();
                        WbjRIU6N = vnabe50H.getChannel();
                    } catch (FileNotFoundException U1xlGtZm) {
                        Logging.errorln("IOCacheArray constuctor error: Could not open file " + U1j91d1P + ".  Exception " + U1xlGtZm);
                        Logging.errorln("outStream " + AdOLV1Ln + "  inStream " + vnabe50H + "  outchan " + qKaKUUoq + "  inchannel " + WbjRIU6N);
                    }
                }
                wobqGO1F = true;
            }

            public Object make(int PgPw46fm, int iQNVFsY4, Object[] WgoEqlSe) {
                init();
                return QwLtVlnz.read(WbjRIU6N, PgPw46fm, iQNVFsY4, WgoEqlSe);
            }

            public boolean flush(int AqxRNJAy, Object[] K9yBcVr9) {
                init();
                return QwLtVlnz.write(qKaKUUoq, AqxRNJAy, K9yBcVr9);
            }

            public CacheArrayBlockSummary summarize(int BI5bWF9H, Object[] MlUJL3xW) {
                init();
                return QwLtVlnz.summarize(BI5bWF9H, MlUJL3xW);
            }
        };
    }

}