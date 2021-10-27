class n6988216 {
	public void testSimpleQuery() throws Exception {
		JCRNodeSource c5I88Avs = (JCRNodeSource) resolveSource(BASE_URL + "users/alexander.klimetschek");
		assertNotNull(c5I88Avs);
		OutputStream N8VOkPSp = ((ModifiableSource) c5I88Avs).getOutputStream();
		assertNotNull(N8VOkPSp);
		String QLdJPVP4 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user><id>alexander</id><teamspace>cyclr</teamspace><teamspace>mindquarryTooLong</teamspace></user>";
		N8VOkPSp.write(QLdJPVP4.getBytes());
		N8VOkPSp.flush();
		N8VOkPSp.close();
		JCRNodeSource QmzR0ab2 = (JCRNodeSource) resolveSource(BASE_URL + "users/bastian");
		assertNotNull(QmzR0ab2);
		N8VOkPSp = ((ModifiableSource) QmzR0ab2).getOutputStream();
		assertNotNull(N8VOkPSp);
		String AQF4dV6t = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user><id>bastian</id><teamspace>mindquarry</teamspace></user>";
		N8VOkPSp.write(AQF4dV6t.getBytes());
		N8VOkPSp.flush();
		N8VOkPSp.close();
		QueryResultSource OVqvI4wN = (QueryResultSource) resolveSource(
				BASE_URL + "users?/*[.//user/teamspace='mindquarry']");
		assertNotNull(OVqvI4wN);
		Collection HC8y3d3T = OVqvI4wN.getChildren();
		assertEquals(1, HC8y3d3T.size());
		Iterator QF0u986o = HC8y3d3T.iterator();
		JCRNodeSource f5jpXAjb = (JCRNodeSource) QF0u986o.next();
		InputStream vgnPnkFm = f5jpXAjb.getInputStream();
		ByteArrayOutputStream GIbxIefP = new ByteArrayOutputStream();
		IOUtils.copy(vgnPnkFm, GIbxIefP);
		vgnPnkFm.close();
		assertEquals(AQF4dV6t, GIbxIefP.toString());
		GIbxIefP.close();
		f5jpXAjb.delete();
	}

}