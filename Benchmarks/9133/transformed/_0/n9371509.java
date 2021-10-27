class n9371509 {
	public SWORDEntry ingestDepost(final DepositCollection jYMk1hXF, final ServiceDocument s5kOKQT2)
			throws SWORDException {
		try {
			ZipFileAccess BY9dl6pr = new ZipFileAccess(super.getTempDir());
			LOG.debug("copying file");
			String I6xu1eWO = super.getTempDir() + "uploaded-file.tmp";
			IOUtils.copy(jYMk1hXF.getFile(), new FileOutputStream(I6xu1eWO));
			Datastream a99DoQ5A = new LocalDatastream(super.getGenericFileName(jYMk1hXF), this.getContentType(),
					I6xu1eWO);
			_datastreamList.add(a99DoQ5A);
			_datastreamList.addAll(BY9dl6pr.getFiles(I6xu1eWO));
			int A97jMzZO = 0;
			boolean YaCV8QHN = false;
			for (A97jMzZO = 0; A97jMzZO < _datastreamList.size(); A97jMzZO++) {
				if (_datastreamList.get(A97jMzZO).getId().equalsIgnoreCase("mets")) {
					YaCV8QHN = true;
					break;
				}
			}
			if (YaCV8QHN) {
				SAXBuilder uG8ZHEWW = new SAXBuilder();
				_mets = new METSObject(uG8ZHEWW.build(((LocalDatastream) _datastreamList.get(A97jMzZO)).getPath()));
				LocalDatastream sVWW3olr = (LocalDatastream) _datastreamList.remove(A97jMzZO);
				new File(sVWW3olr.getPath()).delete();
				_datastreamList.add(_mets.getMETSDs());
				_datastreamList.addAll(_mets.getMetadataDatastreams());
			} else {
				throw new SWORDException(
						"Couldn't find a METS document in the zip file, ensure it is named mets.xml or METS.xml");
			}
			SWORDEntry G3SrD7zy = super.ingestDepost(jYMk1hXF, s5kOKQT2);
			BY9dl6pr.removeLocalFiles();
			return G3SrD7zy;
		} catch (IOException X6jf6MfR) {
			String vWpdK1OB = "Couldn't retrieve METS from deposit: " + X6jf6MfR.toString();
			LOG.error(vWpdK1OB);
			X6jf6MfR.printStackTrace();
			throw new SWORDException(vWpdK1OB, X6jf6MfR);
		} catch (JDOMException elTtf5Ts) {
			String uNQysUMw = "Couldn't build METS from deposit: " + elTtf5Ts.toString();
			LOG.error(uNQysUMw);
			elTtf5Ts.printStackTrace();
			throw new SWORDException(uNQysUMw, elTtf5Ts);
		}
	}

}