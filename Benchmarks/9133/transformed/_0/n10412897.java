class n10412897 {
	@TestTargets({
			@TestTargetNew(level = TestLevel.PARTIAL_COMPLETE, notes = "Verifies that the ObjectInputStream constructor calls checkPermission on security manager.", method = "ObjectInputStream", args = {
					InputStream.class }) })
	public void test_ObjectInputStream2() throws IOException {
		class TestSecurityManager extends SecurityManager {

			boolean MwYR5ZsQ;

			Permission H1Klo9UC;

			void reset() {
				MwYR5ZsQ = false;
				H1Klo9UC = null;
			}

			@Override
			public void checkPermission(Permission nJU3I9Ju) {
				if (nJU3I9Ju instanceof SerializablePermission) {
					MwYR5ZsQ = true;
					this.H1Klo9UC = nJU3I9Ju;
				}
			}
		}
		class TestObjectInputStream extends ObjectInputStream {

			TestObjectInputStream(InputStream xZ4ZwpoL) throws StreamCorruptedException, IOException {
				super(xZ4ZwpoL);
			}
		}
		class TestObjectInputStream_readFields extends ObjectInputStream {

			TestObjectInputStream_readFields(InputStream eXTlfEC5) throws StreamCorruptedException, IOException {
				super(eXTlfEC5);
			}

			@Override
			public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
				return super.readFields();
			}
		}
		class TestObjectInputStream_readUnshared extends ObjectInputStream {

			TestObjectInputStream_readUnshared(InputStream Cjn3rMQD) throws StreamCorruptedException, IOException {
				super(Cjn3rMQD);
			}

			@Override
			public Object readUnshared() throws IOException, ClassNotFoundException {
				return super.readUnshared();
			}
		}
		long mr0leYfw = new java.util.Date().getTime();
		String riTwvuCw = "SecurityPermissionsTest_" + mr0leYfw;
		File uopVVjBM = File.createTempFile(riTwvuCw, null);
		ObjectOutputStream QLmC9ghp = new ObjectOutputStream(new FileOutputStream(uopVVjBM));
		QLmC9ghp.writeObject(new Node());
		QLmC9ghp.flush();
		QLmC9ghp.close();
		uopVVjBM.deleteOnExit();
		TestSecurityManager R5q5AiU1 = new TestSecurityManager();
		System.setSecurityManager(R5q5AiU1);
		R5q5AiU1.reset();
		new ObjectInputStream(new FileInputStream(uopVVjBM));
		assertTrue(
				"ObjectInputStream(InputStream) ctor must not call checkPermission on security manager on a class which neither overwrites methods readFields nor readUnshared",
				!R5q5AiU1.MwYR5ZsQ);
		R5q5AiU1.reset();
		new TestObjectInputStream(new FileInputStream(uopVVjBM));
		assertTrue(
				"ObjectInputStream(InputStream) ctor must not call checkPermission on security manager on a class which neither overwrites methods readFields nor readUnshared",
				!R5q5AiU1.MwYR5ZsQ);
		R5q5AiU1.reset();
		new TestObjectInputStream_readFields(new FileInputStream(uopVVjBM));
		assertTrue(
				"ObjectInputStream(InputStream) ctor must call checkPermission on security manager on a class which overwrites method readFields",
				R5q5AiU1.MwYR5ZsQ);
		assertEquals("Name of SerializablePermission is not correct", "enableSubclassImplementation",
				R5q5AiU1.H1Klo9UC.getName());
		R5q5AiU1.reset();
		new TestObjectInputStream_readUnshared(new FileInputStream(uopVVjBM));
		assertTrue(
				"ObjectInputStream(InputStream) ctor must call checkPermission on security manager on a class which overwrites method readUnshared",
				R5q5AiU1.MwYR5ZsQ);
		assertEquals("Name of SerializablePermission is not correct", "enableSubclassImplementation",
				R5q5AiU1.H1Klo9UC.getName());
	}

}