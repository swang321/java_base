#####  jvm1

#### java沙箱的基本组件

    1.类装载器结构(可以由用户定制)
    2.class文件检验器
    3.内置的java虚拟机
    4.安全管理器(可以由用户定制)
    5.java核心API

#### 双亲委派模型

      protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    try {
                        if (parent != null) {
                            c = parent.loadClass(name, false);
                        } else {
                            c = findBootstrapClassOrNull(name);
                        }
                    } catch (ClassNotFoundException e) {
                        // ClassNotFoundException thrown if class not found
                        // from the non-null parent class loader
                    }
    
                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                        c = findClass(name);
    
                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        } 
        
当虚拟机去装载一个类的时候会先调用一个叫loadClass的方法，接着在这个方法里它会先调用findLoadedClass来判断要装载的类字节码是否已经转入了内存，如果没有的话，它会找到它的parent（这里的parent指装载自己的那个类加载器，一般我们的应用程序类的parent是AppClassLoader），然后调用parent的loadClass，重复自己loadClass的过程，如果parent没有装载过着这个类，就调用findBootstrapClass(这里是指bootStrap，启动装载器)来尝试装载这个类的字节码，如果bootStrap也没有办法装载这个类，则调用自己的findClass来尝试装载这个类，如果还是没办法装载则抛出异常   