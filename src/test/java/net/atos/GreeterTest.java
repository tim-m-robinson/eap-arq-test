package net.atos;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class GreeterTest {

  @Deployment
  public static Archive<?> createDeployment() {
    return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClass(Greeter.class)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @Inject
  Greeter testGreeter;

  @Test
  public void should_create_greeting() {
    String result = testGreeter.createGreeting("Foo");
    Assert.assertEquals("Hello, Foo!", result);
  }
}
