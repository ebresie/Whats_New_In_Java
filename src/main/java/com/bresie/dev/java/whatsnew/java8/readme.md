The intent of this project is to provide example code of what's new in java releases.

I will be trying to get the high level elements from each Java/JDK version and provide samples in code where applicable.  

Some elements involve command line parameters which would require some form of "run configuration" which uses these so in those cases, this may be dependent upon run elements which may be provided as part of a build time "run" tasks which applicable parameters.

This has updates relative to JDK 8.

The material here is from the URL listed below.  The intent is to help guide exercise to demonstrate the changes relative to the whatsnew.  

All rights to the material replicated below are with the original authors as spelled out at the original site.

=============================================

https://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html

What's New in JDK 8

Java Platform, Standard Edition 8 is a major feature release. This document summarizes features and enhancements in Java SE 8 and in JDK 8, Oracle's implementation of Java SE 8. Click the component name for a more detailed description of the enhancements for that component.

* Java Programming Language

(1) Lambda Expressions, a new language feature, has been introduced in this release. They enable you to treat functionality as a method argument, or code as data. Lambda expressions let you express instances of single-method interfaces (referred to as functional interfaces) more compactly.

(2) Method references provide easy-to-read lambda expressions for methods that already have a name.

(3) Default methods enable new functionality to be added to the interfaces of libraries and ensure binary compatibility with code written for older versions of those interfaces.

(4) Repeating Annotations provide the ability to apply the same annotation type more than once to the same declaration or type use.

(5) Type Annotations provide the ability to apply an annotation anywhere a type is used, not just on a declaration. Used with a pluggable type system, this feature enables improved type checking of your code.

(6) Improved type inference.

(7) Method parameter reflection.

* Collections

(8) Classes in the new java.util.stream package provide a Stream API to support functional-style operations on streams of elements. The Stream API is integrated into the Collections API, which enables bulk operations on collections, such as sequential or parallel map-reduce transformations.

(9) Performance Improvement for HashMaps with Key Collisions

* (10) Compact Profiles contain predefined subsets of the Java SE platform and enable applications that do not require the entire Platform to be deployed and run on small devices.

* Security

(11) Client-side TLS 1.2 enabled by default

(12) New variant of AccessController.doPrivileged that enables code to assert a subset of its privileges, without preventing the full traversal of the stack to check for other permissions

(13) Stronger algorithms for password-based encryption

(14) SSL/TLS Server Name Indication (SNI) Extension support in JSSE Server

(15) Support for AEAD algorithms: The SunJCE provider is enhanced to support AES/GCM/NoPadding cipher implementation as well as GCM algorithm parameters. And the SunJSSE provider is enhanced to support AEAD mode based cipher suites. See Oracle Providers Documentation, JEP 115.

(16) KeyStore enhancements, including the new Domain KeyStore type java.security.DomainLoadStoreParameter, and the new command option -importpassword for the keytool utility

(17) SHA-224 Message Digests

(18) Enhanced Support for NSA Suite B Cryptography

(19) Better Support for High Entropy Random Number Generation

(20) New java.security.cert.PKIXRevocationChecker class for configuring revocation checking of X.509 certificates

(21) 64-bit PKCS11 for Windows

(22) New rcache Types in Kerberos 5 Replay Caching

(23) Support for Kerberos 5 Protocol Transition and Constrained Delegation

(24) Kerberos 5 weak encryption types disabled by default

(25) Unbound SASL for the GSS-API/Kerberos 5 mechanism

(26) SASL service for multiple host names

(27) JNI bridge to native JGSS on Mac OS X

(28) Support for stronger strength ephemeral DH keys in the SunJSSE provider

(29) Support for server-side cipher suites preference customization in JSSE

* JavaFX

(30) The new Modena theme has been implemented in this release. For more information, see the blog at fxexperience.com.

(31) The new SwingNode class enables developers to embed Swing content into JavaFX applications. See the SwingNode javadoc and Embedding Swing Content in JavaFX Applications.

(32) The new UI Controls include the DatePicker and the TreeTableView controls.

(33) The javafx.print package provides the public classes for the JavaFX Printing API. See the javadoc for more information.

(34) The 3D Graphics features now include 3D shapes, camera, lights, subscene, material, picking, and antialiasing. The new Shape3D (Box, Cylinder, MeshView, and Sphere subclasses), SubScene, Material, PickResult, LightBase (AmbientLight and PointLight subclasses) , and SceneAntialiasing API classes have been added to the JavaFX 3D Graphics library. The Camera API class has also been updated in this release. See the corresponding class javadoc for javafx.scene.shape.Shape3D, javafx.scene.SubScene, javafx.scene.paint.Material, javafx.scene.input.PickResult, javafx.scene.SceneAntialiasing, and the Getting Started with JavaFX 3D Graphics document.

(35) The WebView class provides new features and improvements. Review Supported Features of HTML5 for more information about additional HTML5 features including Web Sockets, Web Workers, and Web Fonts.

(36) Enhanced text support including bi-directional text and complex text scripts such as Thai and Hindi in controls, and multi-line, multi-style text in text nodes.

(37) Support for Hi-DPI displays has been added in this release.

(38) The CSS Styleable* classes became public API. See the javafx.css javadoc for more information.

(39) The new ScheduledService class allows to automatically restart the service.

(40) JavaFX is now available for ARM platforms. JDK for ARM includes the base, graphics and controls components of JavaFX.

* Tools

(41) The jjs command is provided to invoke the Nashorn engine.

(42) The java command launches JavaFX applications.

(43) The java man page has been reworked.

(44) The jdeps command-line tool is provided for analyzing class files.

(45) Java Management Extensions (JMX) provide remote access to diagnostic commands.

(46) The jarsigner tool has an option for requesting a signed time stamp from a Time Stamping Authority (TSA).

** Javac tool

(47) The -parameters option of the javac command can be used to store formal parameter names and enable the Reflection API to retrieve formal parameter names.

(48) The type rules for equality operators in the Java Language Specification (JLS) Section 15.21 are now correctly enforced by the javac command.

(49) The javac tool now has support for checking the content of javadoc comments for issues that could lead to various problems, such as invalid HTML or accessibility issues, in the files that are generated when javadoc is run. The feature is enabled by the new -Xdoclint option. For more details, see the output from running "javac -X". This feature is also available in the javadoc tool, and is enabled there by default.

(50) The javac tool now provides the ability to generate native headers, as needed. This removes the need to run the javah tool as a separate step in the build pipeline. The feature is enabled in javac by using the new -h option, which is used to specify a directory in which the header files should be written. Header files will be generated for any class which has either native methods, or constant fields annotated with a new annotation of type java.lang.annotation.Native.

** Javadoc tool

(51) The javadoc tool supports the new DocTree API that enables you to traverse Javadoc comments as abstract syntax trees.

(52) The javadoc tool supports the new Javadoc Access API that enables you to invoke the Javadoc tool directly from a Java application, without executing a new process. See the javadoc what's new page for more information.

(53) The javadoc tool now has support for checking the content of javadoc comments for issues that could lead to various problems, such as invalid HTML or accessibility issues, in the files that are generated when javadoc is run. The feature is enabled by default, and can also be controlled by the new -Xdoclint option. For more details, see the output from running "javadoc -X". This feature is also available in the javac tool, although it is not enabled by default there.

* Internationalization

(54) Unicode Enhancements, including support for Unicode 6.2.0

(55) Adoption of Unicode CLDR Data and the java.locale.providers System Property

(56) New Calendar and Locale APIs

(57) Ability to Install a Custom Resource Bundle as an Extension

* Deployment

(58) For sandbox applets and Java Web Start applications, URLPermission is now used to allow connections back to the server from which they were started. SocketPermission is no longer granted.

(59) The Permissions attribute is required in the JAR file manifest of the main JAR file at all security levels.

* (60) Date-Time Package - a new set of packages that provide a comprehensive date-time model.

* Scripting

(61) The Rhino javascript engine has been replaced with the Nashorn Javascript Engine

* Pack200

(62) Pack200 Support for Constant Pool Entries and New Bytecodes Introduced by JSR 292

(63) JDK8 support for class files changes specified by JSR-292, JSR-308 and JSR-335

* IO and NIO

(64) New SelectorProvider implementation for Solaris based on the Solaris event port mechanism. To use, run with the system property java.nio.channels.spi.Selector set to the value sun.nio.ch.EventPortSelectorProvider.

(65) Decrease in the size of the <JDK_HOME>/jre/lib/charsets.jar file

(66) Performance improvement for the java.lang.String(byte[], *) constructor and the java.lang.String.getBytes() method.

* java.lang and java.util Packages

(67) Parallel Array Sorting

(68) Standard Encoding and Decoding Base64

(69) Unsigned Arithmetic Support

* JDBC

(70) The JDBC-ODBC Bridge has been removed.

(71) JDBC 4.2 introduces new features.

* Java DB

(72) JDK 8 includes Java DB 10.10.

* Networking

(73) The class java.net.URLPermission has been added.

(74) In the class java.net.HttpURLConnection, if a security manager is installed, calls that request to open a connection require permission.

* Concurrency

(75) Classes and interfaces have been added to the java.util.concurrent package.

(76) Methods have been added to the java.util.concurrent.ConcurrentHashMap class to support aggregate operations based on the newly added streams facility and lambda expressions.

(77) Classes have been added to the java.util.concurrent.atomic package to support scalable updatable variables.

(78) Methods have been added to the java.util.concurrent.ForkJoinPool class to support a common pool.

(79) The java.util.concurrent.locks.StampedLock class has been added to provide a capability-based lock with three modes for controlling read/write access.

* (80) Java XML - JAXP

* HotSpot

(81) Hardware intrinsics were added to use Advanced Encryption Standard (AES). The UseAES and UseAESIntrinsics flags are available to enable the hardware-based AES intrinsics for Intel hardware. The hardware must be 2010 or newer Westmere hardware.

Note: AES intrinsics are only supported by the Server VM.

For example, to enable hardware AES, use the following flags:

-XX:+UseAES -XX:+UseAESIntrinsics
To disable hardware AES use the following flags:

-XX:-UseAES -XX:-UseAESIntrinsics

(82) Removal of PermGen.

(83) Default Methods in the Java Programming Language are supported by the byte code instructions for method invocation.

* Java Mission Control 5.3 Release Notes

(84) JDK 8 includes Java Mission Control 5.3.
