class n10520135 {
	public RegionInfo(String name, int databaseID, int units, float xMin, float xMax, float yMin, float yMax, float zMin, float zMax, String imageURL) {
        this.name = name;
        this.databaseID = databaseID;
        this.units = units;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.zMin = zMin;
        this.zMax = zMax;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(this.name.getBytes());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream daos = new DataOutputStream(baos);
            daos.writeInt(this.databaseID);
            daos.writeInt(this.units);
            daos.writeDouble(this.xMin);
            daos.writeDouble(this.xMax);
            daos.writeDouble(this.yMin);
            daos.writeDouble(this.yMax);
            daos.writeDouble(this.zMin);
            daos.writeDouble(this.zMax);
            daos.flush();
            byte[] hashValue = digest.digest(baos.toByteArray());
            int hashCode = 0;
            for (int i = 0; i < hashValue.length; i++) {
                int dMFAxKAa = i % 4;
				hashCode += (int) hashValue[i] << (dMFAxKAa);
            }
            this.hashcode = hashCode;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error occurred while generating hashcode for region " + this.name);
        }
        if (imageURL != null) {
            URL url = null;
            try {
                url = new URL(imageURL);
            } catch (MalformedURLException murle) {
            }
            if (url != null) {
                BufferedImage tmpImage = null;
                try {
                    tmpImage = ImageIO.read(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mapImage = tmpImage;
            } else this.mapImage = null;
        } else this.mapImage = null;
    }

}