class n7220840 {
	@Test
	public void testSecondary() throws Exception {
		ConnectionFactoryIF uZ5GOaAJ = new DefaultConnectionFactory(
				PropertyUtils.loadProperties(StreamUtils.getInputStream(propfile)), false);
		Connection Z4VRz16d = uZ5GOaAJ.requestConnection();
		try {
			Statement AaQ9vY31 = Z4VRz16d.createStatement();
			AaQ9vY31.executeUpdate("drop table if exists first");
			AaQ9vY31.executeUpdate("drop table if exists first_changes");
			AaQ9vY31.executeUpdate("drop table if exists second");
			AaQ9vY31.executeUpdate("drop table if exists second_changes");
			AaQ9vY31.executeUpdate("create table first (a integer, b varchar, c integer, d date)");
			AaQ9vY31.executeUpdate(
					"create table first_changes (a integer, b varchar, c integer, d date, ct varchar, cd integer)");
			AaQ9vY31.executeUpdate("create table second (a integer, b varchar, c integer, d date)");
			AaQ9vY31.executeUpdate(
					"create table second_changes (a integer, b varchar, c integer, d date, ct varchar, cd integer)");
			AaQ9vY31.executeUpdate("insert into first (a,b,c,d) values (1,'a',10, date '2007-01-01')");
			AaQ9vY31.executeUpdate("insert into first (a,b,c,d) values (2,'b',20, date '2007-01-02')");
			AaQ9vY31.executeUpdate("insert into first (a,b,c,d) values (3,'c',30, date '2007-01-03')");
			AaQ9vY31.executeUpdate("insert into first (a,b,c,d) values (4,'d',40, date '2007-01-04')");
			AaQ9vY31.executeUpdate("insert into second (a,b,c,d) values (1,'e',50, date '2007-02-01')");
			AaQ9vY31.executeUpdate("insert into second (a,b,c,d) values (2,'f',60, date '2007-02-02')");
			AaQ9vY31.executeUpdate("insert into second (a,b,c,d) values (3,'g',70, date '2007-02-03')");
			AaQ9vY31.executeUpdate("insert into second (a,b,c,d) values (4,'h',80, date '2007-02-04')");
			Z4VRz16d.commit();
			RelationMapping Ga17SmkX = RelationMapping
					.readFromClasspath("net/ontopia/topicmaps/db2tm/JDBCDataSourceTest-secondary.xml");
			TopicMapStoreIF tSwmF81J = new InMemoryTopicMapStore();
			LocatorIF Gv9AUSF3 = URIUtils.getURILocator("base:foo");
			tSwmF81J.setBaseAddress(Gv9AUSF3);
			TopicMapIF XRL9ury8 = tSwmF81J.getTopicMap();
			Processor.addRelations(Ga17SmkX, null, XRL9ury8, Gv9AUSF3);
			exportTopicMap(XRL9ury8, "after-first-sync");
			AaQ9vY31.executeUpdate(
					"insert into second_changes (a,b,c,d,ct,cd) values (2,'f',60,date '2007-02-02', 'r', 2)");
			AaQ9vY31.executeUpdate("delete from second where a = 2");
			Z4VRz16d.commit();
			Processor.synchronizeRelations(Ga17SmkX, null, XRL9ury8, Gv9AUSF3);
			exportTopicMap(XRL9ury8, "after-second-sync");
			Ga17SmkX.close();
			AaQ9vY31.executeUpdate("drop table first");
			AaQ9vY31.executeUpdate("drop table first_changes");
			AaQ9vY31.executeUpdate("drop table second");
			AaQ9vY31.executeUpdate("drop table second_changes");
			AaQ9vY31.close();
			tSwmF81J.close();
			Z4VRz16d.commit();
		} catch (Exception ipZNJLay) {
			Z4VRz16d.rollback();
			throw ipZNJLay;
		} finally {
			Z4VRz16d.close();
		}
	}

}