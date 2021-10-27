class n12744196 {
	public RandomGUID() {
        MessageDigest IMGPiwNP = null;
        try {
            IMGPiwNP = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException fkrQUqDG) {
            throw new RuntimeException(fkrQUqDG.getClass().getName() + ": " + fkrQUqDG.getMessage());
        }
        try {
            long x8earhzY = System.currentTimeMillis();
            long g2ofDaZk = 0;
            g2ofDaZk = myRand.nextLong();
            StringBuffer dJOV5Wy7 = new StringBuffer();
            dJOV5Wy7.append(s_id);
            dJOV5Wy7.append(":");
            dJOV5Wy7.append(Long.toString(x8earhzY));
            dJOV5Wy7.append(":");
            dJOV5Wy7.append(Long.toString(g2ofDaZk));
            IMGPiwNP.update(dJOV5Wy7.toString().getBytes());
            byte[] zQFeNjDz = IMGPiwNP.digest();
            dJOV5Wy7.setLength(0);
            for (int AoLRaSls = 0; AoLRaSls < zQFeNjDz.length; ++AoLRaSls) {
                int u4cSXdPK = zQFeNjDz[AoLRaSls] & 0xFF;
                if (u4cSXdPK < 0x10) dJOV5Wy7.append('0');
                dJOV5Wy7.append(Integer.toHexString(u4cSXdPK));
            }
            valueAfterMD5 = dJOV5Wy7.toString();
        } catch (Exception IrfZ7HgC) {
            throw new RuntimeException(IrfZ7HgC.getClass().getName() + ": " + IrfZ7HgC.getMessage());
        }
    }

}