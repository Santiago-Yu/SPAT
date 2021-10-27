class n3792789 {
	private ResourceZoneRulesDataProvider(URL url) throws ClassNotFoundException, IOException {
        InputStream in = null;
        boolean throwing = false;
        try {
            in = url.openStream();
            DataInputStream dis = new DataInputStream(in);
            if (dis.readByte() != 1) {
                throw new StreamCorruptedException("File format not recognised");
            }
            this.groupID = dis.readUTF();
            int versionCount = dis.readShort();
            String[] versionArray = new String[versionCount];
            for (int i = 0; i < versionCount; i++) {
                versionArray[i] = dis.readUTF();
            }
            int regionCount = dis.readShort();
            String[] regionArray = new String[regionCount];
            for (int i = 0; i < regionCount; i++) {
                regionArray[i] = dis.readUTF();
            }
            Set<ZoneRulesVersion> versionSet=new HashSet<ZoneRulesVersion>(versionCount);
            this.regions=new HashSet<String>(Arrays.asList(regionArray));
            for (int i = 0; i < versionCount; i++) {
                int versionRegionCount = dis.readShort();
                String[] versionRegionArray = new String[versionRegionCount];
                short[] versionRulesArray = new short[versionRegionCount];
                for (int j = 0; j < versionRegionCount; j++) {
                    versionRegionArray[j] = regionArray[dis.readShort()];
                    versionRulesArray[j] = dis.readShort();
                }
                versionSet.add(new ResourceZoneRulesVersion(this, versionArray[i], versionRegionArray, versionRulesArray));
            }
            this.versions = versionSet;
            int ruleCount = dis.readShort();
            this.rules = new AtomicReferenceArray<Object>(ruleCount);
            for (int i = 0; i < ruleCount; i++) {
                byte[] bytes = new byte[dis.readShort()];
                dis.readFully(bytes);
                rules.set(i, bytes);
            }
        } catch (IOException ex) {
            throw ex;
            throwing = true;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    if (throwing == false) {
                        throw ex;
                    }
                }
            }
        }
    }

}