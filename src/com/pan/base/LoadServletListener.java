package com.pan.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LoadServletListener implements ServletContextListener {

    private static Map<String, UrlMappingBean> map = new HashMap<String, UrlMappingBean>();

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (map != null)
            map = null;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String classPath = context.getRealPath("/WEB-INF/classes/");
        scanClassPath(new File(classPath));
        context.setAttribute("mapPath", map);
    }

    private void scanClassPath(File file) {
        try {
            if (file.isFile()) {
                if (file.getName().endsWith(".class")) {
                    String path = file.getPath();
                    MyClassLoader myClassLoader = new MyClassLoader(this.getClass().getClassLoader());
                    Class<?> clazz = myClassLoader.load(path);
                    Controller controller = (Controller) clazz.getAnnotation(Controller.class);
                    if (controller != null) {
                        String uri = controller.value();
                        Method[] methods = clazz.getDeclaredMethods();

                        Object action = clazz.newInstance();
                        for (Method method : methods) {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            if (requestMapping != null) {
                                String suburl = requestMapping.value();
                                map.put(uri + "/" + suburl, new UrlMappingBean(action, method.getName()));
                            }
                        }

                    }
                }
            } else {
                File[] files = file.listFiles();
                for (File child : files) {
                    scanClassPath(child);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class MyClassLoader extends ClassLoader {
        public MyClassLoader(ClassLoader parent) {
            super(parent);
        }

        public Class<?> load(String path) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                byte[] buf = new byte[fis.available()];
                int len = 0;
                int total = 0;
                int fileLength = buf.length;
                while (total < fileLength) {
                    len = fis.read(buf, total, fileLength - total);
                    total = total + len;
                }
                return super.defineClass(null, buf, 0, fileLength);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    fis = null;
                }
            }
        }
    }
}
