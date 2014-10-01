package mycloud;

import org.codehaus.janino.JavaSourceClassLoader;
import mycloud.Command;

import java.io.File;

public class JavaSourceClassLoaderExample
{
  public static void main(String[] args) throws Exception
  {
    new JavaSourceClassLoaderExample().execute();
  }

  private void execute() throws Exception
  {
    File janinoSourceDirs = new File("janino-src");
    File[] srcDirs = new File[]{janinoSourceDirs};
    String encoding = null;
    ClassLoader parentClassLoader = getClass().getClassLoader();
    ClassLoader cl = new JavaSourceClassLoader(parentClassLoader, srcDirs, encoding);

    Command xc = (Command) cl.loadClass("mycloud.MyCommand").newInstance();
    xc.execute();
  }
}