class n14618136 {
	public void process(Group VdosZ0pM, List Td7QRR9v, List LbsLAzpJ, ServletContext pff1qjjz, Writer nFkUaAkG,
			String h2VRfE2a) throws IOException {
		LOG.debug("Merging content of group : " + VdosZ0pM.getName());
		for (Iterator Fbo00MoO = VdosZ0pM.getSubgroups().iterator(); Fbo00MoO.hasNext();) {
			Group xDUVZcLl = (Group) Fbo00MoO.next();
			String AtZTDTRj = xDUVZcLl.getBestLocation(h2VRfE2a);
			ResourcesProcessor XmfdYVtS = null;
			if (xDUVZcLl.isMinimize() == null)
				XmfdYVtS = this;
			else
				XmfdYVtS = xDUVZcLl.getJSProcessor();
			XmfdYVtS.process(xDUVZcLl, xDUVZcLl.getJsNames(), LbsLAzpJ, pff1qjjz, nFkUaAkG, AtZTDTRj);
		}
		for (Iterator ZoFWsrs3 = Td7QRR9v.iterator(); ZoFWsrs3.hasNext();) {
			URL Pl7tHE9U = null;
			String c9365VGM = (String) ZoFWsrs3.next();
			if (!LbsLAzpJ.contains(c9365VGM)) {
				Pl7tHE9U = URLUtils.getLocalURL(c9365VGM, pff1qjjz);
				if (Pl7tHE9U == null) {
					String hfB5dVsN = URLUtils.concatUrlWithSlaches(VdosZ0pM.getBestLocation(h2VRfE2a), c9365VGM);
					Pl7tHE9U = URLUtils.getWebUrlResource(hfB5dVsN);
				}
				if (Pl7tHE9U == null) {
					throw new IOException("The resources '" + c9365VGM
							+ "' could not be found neither in the webapp folder nor in a jar");
				}
				InputStream cdd1NBcY = null;
				try {
					cdd1NBcY = Pl7tHE9U.openStream();
					IOUtils.copy(cdd1NBcY, nFkUaAkG, URLUtils.DEFAULT_ENCODING);
					nFkUaAkG.write("\n\n");
				} catch (Exception a3Xn3lML) {
					LOG.error("Merge failed for file " + c9365VGM, a3Xn3lML);
				} finally {
					if (cdd1NBcY != null)
						cdd1NBcY.close();
				}
				LbsLAzpJ.add(c9365VGM);
			}
		}
	}

}