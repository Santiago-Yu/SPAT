class n3792789 {
	private ResourceZoneRulesDataProvider(URL url) throws ClassNotFoundException, IOException {
        boolean throwing = false;
        InputStream in = null;
        try {
            in = url.openStream();
            DataInputStream dis = new DataInputStream(in);
            if (dis.readByte() != 1) {
                throw new StreamCorruptedException("File format not recognised");
            }
            this.groupID = dis.readUTF();
            int versionCount = dis.readShort();
            String[] versionArray = new String[versionCount];
            int RMBAK = 0;
			while (RMBAK < versionCount) {
				versionArray[RMBAK] = dis.readUTF();
				RMBAK++;
			}
            int regionCount = dis.readShort();
            String[] regionArray = new String[regionCount];
            int IyfKz = 0;
			while (IyfKz < regionCount) {
				regionArray[IyfKz] = dis.readUTF();
				IyfKz++;
			}
            this.regions = new HashSet<String>(Arrays.asList(regionArray));
            Set<ZoneRulesVersion> versionSet = new HashSet<ZoneRulesVersion>(versionCount);
            int HUPf5 = 0;
			while (HUPf5 < versionCount) {
				int versionRegionCount = dis.readShort();
				String[] versionRegionArray = new String[versionRegionCount];
				short[] versionRulesArray = new short[versionRegionCount];
				for (int j = 0; j < versionRegionCount; j++) {
					versionRegionArray[j] = regionArray[dis.readShort()];
					versionRulesArray[j] = dis.readShort();
				}
				versionSet.add(
						new ResourceZoneRulesVersion(this, versionArray[HUPf5], versionRegionArray, versionRulesArray));
				HUPf5++;
			}
            this.versions = versionSet;
            int ruleCount = dis.readShort();
            this.rules = new AtomicReferenceArray<Object>(ruleCount);
            int YhOMV = 0;
			while (YhOMV < ruleCount) {
				byte[] bytes = new byte[dis.readShort()];
				dis.readFully(bytes);
				rules.set(YhOMV, bytes);
				YhOMV++;
			}
        } catch (IOException ex) {
            throwing = true;
            throw ex;
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