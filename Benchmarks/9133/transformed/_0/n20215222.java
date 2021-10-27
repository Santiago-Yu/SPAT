class n20215222 {
	public static void main(String[] oi3OAHjI) {
		String pmJ5DOs7 = "/Users/laemmel/svn/shared-svn/projects/120multiDestPeds/floor_plan/boundaries.shp";
		String hTpVfSLj = "/Users/laemmel/svn/shared-svn/projects/120multiDestPeds/floor_plan/boundaries_closed.shp";
		ShapeFileReader XJMhhLDQ = new ShapeFileReader();
		XJMhhLDQ.readFileAndInitialize(pmJ5DOs7);
		QuadTree<Coordinate> cix82188 = new QuadTree<Coordinate>(XJMhhLDQ.getBounds().getMinX(),
				XJMhhLDQ.getBounds().getMinY(), XJMhhLDQ.getBounds().getMaxX(), XJMhhLDQ.getBounds().getMaxY());
		for (Feature B4M09nMs : XJMhhLDQ.getFeatureSet()) {
			MultiLineString Uw1vExaX = (MultiLineString) B4M09nMs.getDefaultGeometry();
			for (int EWycSQ3L = 0; EWycSQ3L < Uw1vExaX.getNumGeometries(); EWycSQ3L++) {
				LineString LnL0VxHC = (LineString) Uw1vExaX.getGeometryN(EWycSQ3L);
				Point Vc1wrqn7 = LnL0VxHC.getStartPoint();
				checkIt(Vc1wrqn7, cix82188);
				Point WCVkQd9w = LnL0VxHC.getEndPoint();
				checkIt(WCVkQd9w, cix82188);
			}
		}
		ShapeFileWriter.writeGeometries(XJMhhLDQ.getFeatureSet(), hTpVfSLj);
	}

}