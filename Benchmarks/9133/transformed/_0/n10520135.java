class n10520135 {
	public RegionInfo(String bhld0BwC, int Lo4CYniP, int BP5cB4Pp, float qNgWmJFR, float HxV4SJH3, float JihlttEP, float ebirwWTX, float qMC6yCed, float MQtBO5bT, String uYhv6gVA) {
        this.name = bhld0BwC;
        this.databaseID = Lo4CYniP;
        this.units = BP5cB4Pp;
        this.xMin = qNgWmJFR;
        this.xMax = HxV4SJH3;
        this.yMin = JihlttEP;
        this.yMax = ebirwWTX;
        this.zMin = qMC6yCed;
        this.zMax = MQtBO5bT;
        try {
            MessageDigest HHH2gvAD = MessageDigest.getInstance("SHA-1");
            HHH2gvAD.update(this.name.getBytes());
            ByteArrayOutputStream Q6clCGUO = new ByteArrayOutputStream();
            DataOutputStream fislmtnI = new DataOutputStream(Q6clCGUO);
            fislmtnI.writeInt(this.databaseID);
            fislmtnI.writeInt(this.units);
            fislmtnI.writeDouble(this.xMin);
            fislmtnI.writeDouble(this.xMax);
            fislmtnI.writeDouble(this.yMin);
            fislmtnI.writeDouble(this.yMax);
            fislmtnI.writeDouble(this.zMin);
            fislmtnI.writeDouble(this.zMax);
            fislmtnI.flush();
            byte[] MTgPUCH4 = HHH2gvAD.digest(Q6clCGUO.toByteArray());
            int ip5xNRPY = 0;
            for (int reS8h52M = 0; reS8h52M < MTgPUCH4.length; reS8h52M++) {
                ip5xNRPY += (int) MTgPUCH4[reS8h52M] << (reS8h52M % 4);
            }
            this.hashcode = ip5xNRPY;
        } catch (Exception ykBw7Kc2) {
            throw new IllegalArgumentException("Error occurred while generating hashcode for region " + this.name);
        }
        if (uYhv6gVA != null) {
            URL pGvT8Emd = null;
            try {
                pGvT8Emd = new URL(uYhv6gVA);
            } catch (MalformedURLException cNmP2a5D) {
            }
            if (pGvT8Emd != null) {
                BufferedImage hQX5x5w1 = null;
                try {
                    hQX5x5w1 = ImageIO.read(pGvT8Emd);
                } catch (Exception ym8MYSq1) {
                    ym8MYSq1.printStackTrace();
                }
                mapImage = hQX5x5w1;
            } else this.mapImage = null;
        } else this.mapImage = null;
    }

}