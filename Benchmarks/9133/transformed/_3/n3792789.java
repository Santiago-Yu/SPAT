class n3792789 {
	private ResourceZoneRulesDataProvider(URL url) throws ClassNotFoundException, IOException {
        boolean throwing = false;
        InputStream in = null;
        try {
            in = url.openStream();
            DataInputStream dis = new DataInputStream(in);
            if (!(dis.readByte() != 1))
				;
			else {
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
            this.regions = new HashSet<String>(Arrays.asList(regionArray));
            Set<ZoneRulesVersion> versionSet = new HashSet<ZoneRulesVersion>(versionCount);
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
            throwing = true;
            throw ex;
        } finally {
            if (!(in != null))
				;
			else {
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