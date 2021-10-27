class n21959565 {
	public Font(String EhQ5dooX, String ZG6a6ecH) {
        this();
        StringTokenizer vMpx7pj9 = new StringTokenizer(EhQ5dooX, ";");
        NybbleInputStream mY1xykhn = null;
        while (mY1xykhn == null & vMpx7pj9.hasMoreTokens()) {
            try {
                URL ljAqO3D5 = new URL(vMpx7pj9.nextToken() + "/");
                ljAqO3D5 = new URL(ljAqO3D5, ZG6a6ecH);
                System.out.println(ljAqO3D5.toString());
                mY1xykhn = new NybbleInputStream(ljAqO3D5.openStream());
                parsePkStream(mY1xykhn);
                mY1xykhn.close();
                name = ZG6a6ecH;
            } catch (java.io.IOException lRuCkJiE) {
            }
        }
    }

}