class n9183056 {
	public void testHandler() throws MalformedURLException, IOException {
		assertTrue("This test can only be run once in a single JVM", imageHasNotBeenInstalledInThisJVM);
		URL cHskVtZK;
		Handler.installImageUrlHandler((ImageSource) new ClassPathXmlApplicationContext(
				"org/springframework/richclient/image/application-context.xml").getBean("imageSource"));
		try {
			cHskVtZK = new URL("image:test");
			imageHasNotBeenInstalledInThisJVM = false;
		} catch (MalformedURLException WYuxhmh1) {
			fail("protocol was not installed");
		}
		cHskVtZK = new URL("image:image.that.does.not.exist");
		try {
			cHskVtZK.openConnection();
			fail();
		} catch (NoSuchImageResourceException SJeKqyh7) {
		}
		cHskVtZK = new URL("image:test.image.key");
		cHskVtZK.openConnection();
	}

}