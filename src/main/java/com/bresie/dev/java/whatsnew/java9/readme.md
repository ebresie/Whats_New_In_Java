The intent of this project is to provide example code of what's new in java releases.

I will be trying to get the high level elements from each Java/JDK version and provide samples in code where applicable.  

Some elements involve command line parameters which would require some form of "run configuration" which uses these so in those cases, this may be dependent upon run elements which may be provided as part of a build time "run" tasks which applicable parameters.

This has updates relative to JDK 9.

The material here is from the URL listed below.  The intent is to help guide exercise to demonstrate the changes relative to the whatsnew.  

Additional reference materials:
- https://nipafx.dev/java-module-system-tutorial/

All rights to the material replicated below are with the original authors as spelled out at the original site.

=============================================

https://docs.oracle.com/javase/9/whatsnew/toc.htm

What's New in JDK 9

Java Platform, Standard Edition
What’s New in Oracle JDK 9
Release 9

E77563-05

September 2017

Overview of What’s New in JDK 9
Java Platform, Standard Edition 9 is a major feature release. The following summarizes features and enhancements in Java SE 9 and in JDK 9, Oracle's implementation of Java SE 9.

A JDK Enhancement Proposal (JEP) is a proposal to design and implement a nontrivial change to the JDK. See JEP 1: JDK Enhancement-Proposal & Roadmap Process. A Java Specification Request (JSR) describes proposed and final specifications for the Java platform. See JSR Overview.

Key Changes in JDK 9
These changes affect more than one technology area.

Feature	Description

* Java Platform Module System	
(1) Introduces a new kind of Java programing component, the module, which is a named, self-describing collection of code and data. This module system:

(2) Introduces a new optional phase, link time, which is in-between compile time and run time, during which a set of modules can be assembled and optimized into a custom runtime image; see the jlink tool in Java Platform, Standard Edition Tools Reference.

(3) Adds options to the tools javac, jlink, and java where you can specify module paths, which locate definitions of modules.
Introduces the modular JAR file, which is a JAR file with a module-info.class file in its root directory.

(4) Introduces the JMOD format, which is a packaging format similar to JAR except it can include native code and configuration files; see the jmod tool.

The JDK itself has been divided into a set of modules. This change:

(5) Enables you to combine the JDK's modules into a variety of configurations, including:

(6) Configurations corresponding to the JRE and the JDK.

(7) Configurations roughly equivalent in content to each of the Compact Profiles defined in Java SE 8.

(8) Custom configurations that contain only a specified set of modules and their required modules.

(9) Restructures the JDK and JRE runtime images to accommodate modules and improve performance, security, and maintainability.

(10) Defines a new URI scheme for naming modules, classes, and resources stored in a runtime image without revealing the internal structure or format of the image.

(11) Removes the endorsed-standards override mechanism and the extension mechanism.

(12) Removes rt.jar and tools.jar from the Java runtime image.

(13) Makes most of the JDK's internal APIs inaccessible by default but leaves a few critical, widely used internal APIs accessible until supported replacements exist for all or most of their functionality.

(14) Run the command jdeps -jdkinternals to determine if your code uses internal JDK APIs.

For more information, see the following:

(15) Java Platform Module System (JSR 376)

(16) JEP 261: Module System

(17) JEP 200: The Modular JDK

(18) JEP 220: Modular Run-Time Images

(19) JEP 260: Encapsulate Most Internal APIs

* (20) JEP 223: New Version-String Scheme	
(21) Provides a simplified version-string format that helps to clearly distinguish major, minor, security, and patch update releases.

The new version-string format is as follows:

$MAJOR.$MINOR.$SECURITY.$PATCH

(22) $MAJOR is the version number that is incremented for a major release, for example JDK 9, which contains significant new features as specified by the Java SE platform specification. A major release contains new features and changes to existing features, which are planned and announced well in advance.

(23) $MINOR is the version number that is incremented for each minor update, such as bug fixes, revisions to standard APIs, or implementation of features outside the scope of the relevant platform specifications.

(24) $SECURITY is the version number that is incremented for a security-update release, which contains critical fixes, including those necessary to improve security.

(25) $PATCH is the version number that is incremented for a release containing security and high-priority customer fixes that have been tested together.

See New Version String Format in Java Platform, Standard Edition Installation Guide.

* What’s New for the JDK 9 Installer
JDK 9 includes installer enhancements for Microsoft Windows and macOS platforms.

* Installer Enhancements for Microsoft Windows

Feature	Description
* (26) Enable or Disable Web Deployment with Installer's UI

Provides the option to enable or disable web deployment in the Welcome page of the installer. To enable web deployment, in the Welcome page, select Custom Setup , click Install, and select the Enable Java content in the Browser check box.

* Installer Enhancements for macOS

Feature	Description
* (27) CPU Version Availability

Provides notification on next CPU availability after uninstalling the current CPU version.

* (28) User Experience

Enhanced user experience while updating the JRE.


* What’s New for Tools in JDK 9
These are the tools enhancements in JDK 9.

Feature	Description
(29) JEP 222: jshell: The Java Shell (Read-Eval-Print Loop)	
Adds Read-Eval-Print Loop (REPL) functionality to the Java platform.

The jshell tool provides an interactive command-line interface for evaluating declarations, statements, and expressions of the Java programming language. It facilitates prototyping and exploration of coding options with immediate results and feedback. The immediate feedback combined with the ability to start with expressions is useful for education—whether learning the Java language or just learning a new API or language feature.

See jshell in Java Platform, Standard Edition Tools Reference, and Introduction to JShell in Java Platform, Standard Edition Java Shell User’s Guide.

The JShell API enables applications to leverage REPL functionality. See the jdk.jshell package.

(30) JEP 228: Add More Diagnostic Commands	
Defines additional diagnostic commands to improve the ability to diagnose issues with Hotspot and the JDK.

See jcmd in Java Platform, Standard Edition Tools Reference.

* (31) JEP 231: Remove Launch-Time JRE Version Selection	
(32) Removes the ability to request a version of the JRE that is not the JRE being launched at launch time.

(33) Modern applications are typically deployed through Java Web Start (with a JNLP file), native OS packaging systems, or active installers. These technologies have their own methods to manage the JREs needed by finding or downloading and updating the required JRE as needed. This makes launch-time JRE version selection obsolete.

* (34) JEP 238: Multi-Release JAR Files	
(35) Extends the JAR file format to enable multiple, Java release-specific versions of class files to coexist in a single archive.

(36) A multirelease JAR (MRJAR) contains additional, versioned directories for classes and resources specific to particular Java platform releases. Specify versioned directories with the jar tool's --release option.

* (37) JEP 240: Remove the JVM TI hprof Agent	
(38) Removes the hprof agent from the JDK. The hprof agent was written as demonstration code for the JVM Tool Interface and not intended to be a production tool.

(39) The useful features of the hprof agent have been superseded by better alternatives.

Note:

While the hprof agent has been removed, it is still possible to create heap dumps in the hprof format using jmap or other diagnostic tools. See Diagnostic Tools in Java Platform, Standard Edition Troubleshooting Guide.

* (40) JEP 241: Remove the jhat Tool	
Removes the jhat tool from the JDK.

The jhat tool was an experimental and unsupported tool added in JDK 6. It is out of date; superior heap visualizers and analyzers have been available for many years.

* (41) JEP 245: Validate JVM Command-Line Flag Arguments	
(42) Validates arguments to all numerical JVM command-line flags to avoid failures and instead displays an appropriate error message if they are found to be invalid.

(43) Range and optional constraint checks have been implemented for arguments that require a user-specified numerical value.

(44) See java and Validate Java Virtual Machine Flag Arguments in Java Platform, Standard Edition Tools Reference.

* (45) JEP 247: Compile for Older Platform Versions	
(46) Enhances javac so that it can compile Java programs to run on selected earlier versions of the platform.

(47) When using the -source or -target options, the compiled program might accidentally use APIs that are not supported on the given target platform. The --release option will prevent accidental use of APIs.

See javac in Java Platform, Standard Edition Tools Reference.

* (48) JEP 282: jlink: The Java Linker	
(49) Assembles and optimizes a set of modules and their dependencies into a custom runtime image as defined in JEP 220.

(50) The jlink tool defines a plug-in mechanism for transformation and optimization during the assembly process, and for the generation of alternative image formats. It can create a custom runtime optimized for a single program. JEP 261 defines link time as an optional phase between the phases of compile time and run time. Link time requires a linking tool that assembles and optimizes a set of modules and their transitive dependencies to create a runtime image or executable.

See jlink in Java Platform, Standard Edition Tools Reference.

* What’s New for Security in JDK 9
These are the security enhancements in JDK 9.

Feature	Description
** (51) JEP 219: Datagram Transport Layer Security (DTLS)	
Enables Java Secure Socket Extension (JSSE) API and the SunJSSE security provider to support DTLS Version 1.0 and DTLS Version 1.2 protocols.

See Datagram Transport Layer Security (DTLS) in Java Platform, Standard Edition Security Developer's Guide.

** (52) JEP 244: TLS Application-Layer Protocol Negotiation Extension

(53) Enables the client and server in a Transport Layer Security (TLS) connection to negotiate the application protocol to be used. With Application-Layer Protocol Negotiation (ALPN), the client sends the list of supported application protocols as part of the TLS ClientHello message. The server chooses a protocol and returns the selected protocol as part of the TLS ServerHello message. The application protocol negotiation can be accomplished within the TLS handshake, without adding network round-trips.

See TLS Handshake and Application Layer Protocol Negotiation in Java Platform, Standard Edition Security Developer's Guide.

** (54) JEP 249: OCSP Stapling for TLS	
(55) Enables the server in a TLS connection to check for a revoked X.509 certificate revocation. The server does this during TLS handshaking by contacting an Online Certificate Status Protocol (OCSP) responder for the certificate in question. It then attaches or "staples" the revocation information to the certificate that it returns to the client so that the client can take appropriate action.

(56) Enables the client to request OCSP stapling from a TLS server. The client checks stapled responses from servers that support the feature.

See OCSP Stapling in Java Platform, Standard Edition Security Developer's Guide.

** (57) JEP 246: Leverage CPU Instructions for GHASH and RSA	
Improves performance ranging from 34x to 150x for AES/GCM/NoPadding using GHASH HotSpot intrinsics. GHASH intrinsics are accelerated by the PCLMULQDQ instruction on Intel x64 CPU and the xmul/xmulhi instructions on SPARC.

** (58) Improves performance up to 50% for BigInteger squareToLen and BigInteger mulAdd methods using RSA HotSpot intrinsics. RSA intrinsics apply to the java.math.BigInteger class on Intel x64.

** (59) A new security property jdk.security.provider.preferred is introduced to configure providers that offer significant performance gains for specific algorithms.

See Configuring the Preferred Provider for Specific Algorithms in Java Platform, Standard Edition Security Developer's Guide.

** (60) JEP 273: DRBG-Based SecureRandom Implementations	
Provides the functionality of Deterministic Random Bit Generator (DRBG) mechanisms as specified in NIST SP 800-90Ar1 in the SecureRandom API.

** (61) The DRBG mechanisms use modern algorithms as strong as SHA-512 and AES-256. Each of these mechanisms can be configured with different security strengths and features to match user requirements.

See Generating Random Numbers in Java Platform, Standard Edition Security Developer's Guide.

** (62) JEP 288: Disable SHA-1 Certificates	
(63) Improves the security configuration of the JDK by providing a more flexible mechanism to disable X.509 certificate chains with SHA-1-based signatures.

(64) Disables SHA-1 in TLS Server certificate chains anchored by roots included by default in the JDK; local or enterprise certificate authorities (CAs) are not affected.

(65) The jdk.certpath.disabledAlgorithms security property is enhanced with several new constraints that allow greater control over the types of certificates that can be disabled.

See JEP 288.

** (66) JEP 229: Create PKCS12 Keystores by Default	
(67) Modifies the default keystore type from JKS to PKCS12. PKCS#12 is an extensible, standard, and widely supported format for storing cryptographic keys. PKCS12 keystores improve confidentiality by storing private keys, trusted public key certificates, and secret keys. This feature also opens opportunities for interoperability with other systems such as Mozilla, Microsoft's Internet Explorer, and OpenSSL that support PKCS12.

(68) The SunJSSE provider supplies a complete implementation of the PKCS12 java.security.KeyStore format for reading and writing PKCS12 files.

See Key Management in Java Platform, Standard Edition Security Developer's Guide.

(69) The keytool key and certificate management utility can create PKCS12 keystores.

See Creating a Keystore in Java Platform, Standard Edition Security Developer's Guide and keytool in Java Platform, Standard Edition Tools Reference.

** (70) JEP 287: SHA-3 Hash Algorithms	
(71) Supports SHA-3 cryptographic hash functions as specified in NIST FIPS 202.

(72) The following additional standard algorithms are supported by the java.security.MessageDigest API: SHA3-224, SHA3-256, SHA3-384, and SHA3-512.

The following providers support SHA-3 algorithm enhancements:

(74) SUN provider: SHA3-224, SHA3-256, SHA3-384, and SHA3-512

(75) OracleUcrypto provider: SHA-3 digests supported by Solaris 12.0

* What’s New for Deployment in JDK 9
These are the deployment enhancements in JDK 9.

Feature	Description
** (76) Deprecate the Java Plug-in	
Deprecates the Java Plug-in and associated applet technologies in Oracle's JDK 9 builds. While still available in JDK 9, these technologies will be considered for removal from the Oracle JDK and JRE in a future release.

(77) Applets and JavaFX applications embedded in a web page require the Java Plug-in to run. Consider rewriting these types of applications as Java Web Start or self-contained applications.

See Migrating Java Applets to Java Web Start and JNLP and Self-Contained Application Packaging in Java Platform, Standard Edition Deployment Guide.

** (78) Enhanced Java Control Panel	
Improves the grouping and presentation of options within the Java Control Panel. Information is easier to locate, a search field is available, and modal dialog boxes are no longer used. Note that the location of some options has changed from previous versions of the Java Control Panel.

See Java Control Panel in Java Platform, Standard Edition Deployment Guide.

* (79) JEP 275: Modular Java Application Packaging	
(80) Integrates features from Project Jigsaw into the Java Packager, including module awareness and custom runtime creation.

(81) Leverages the jlink tool to create smaller packages.

(82) Creates applications that use the JDK 9 runtime only. Cannot be used to package applications with an earlier release of the JRE.

See Customization of the JRE and Packaging for Modular Applications in Java Platform, Standard Edition Deployment Guide.

* (83) JEP 289: Deprecate the Applet API	
Deprecates the Applet API, which is becoming less useful as web browser vendors remove support for Java browser plug-ins. While still available in JDK 9, the Applet class will be considered for removal in a future release. Consider rewriting applets as Java Web Start or self-contained applications.

See Migrating Java Applets to Java Web Start and JNLP and Self-Contained Application Packaging in Java Platform, Standard Edition Deployment Guide.

* What’s New for the Java Language in JDK 9
A few very small language changes are included in Java SE 9.

Feature	Description
* (84) JEP 213: Milling Project Coin	
Identifies a few small changes:

(85) Allow @SafeVargs on private instance methods.

(86) Allow effectively final variables to be used as resources in the try-with-resources statement.

(87) Allow the diamond with anonymous classes if the argument type of the inferred type is denotable.

(88) Complete the removal, begun in Java SE 8, of the underscore from the set of legal identifier names.

(89) Add support for private interface methods.

See Java Language Changes for Java SE 9 in Java Platform, Standard Edition Java Language Updates.

* What’s New for Javadoc in JDK 9
Javadoc enhancements include the following: a simplified Doclet API, Javadoc search, support for generating HTML5 output, and support for documentation comments in module systems.

Feature	Description
** (90) JEP 221: Simplified Doclet API	
Replaces the old Doclet API with a new simplified API that leverages other standard, existing APIs. The standard doclet has been rewritten to use the new Doclet API.

Note:

The existing API and old standard doclet are available, but have not been updated to support new language features, such as modules.

** (91) JEP 224: HTML5 Javadoc	
Supports generating HTML5 output. To get fully compliant HTML5 output, ensure that any HTML content provided in documentation comments are compliant with HTML5.

** (92) JEP 225: Javadoc Search	
Provides a search box to the generated API documentation. Use this search box to find program elements, tagged words, and phrases within the documentation.

** (93) JEP 261: Module System	
Supports documentation comments in module declarations. Includes new command-line options to configure the set of modules to be documented and generates a new summary page for any modules being documented.

* What’s New for the JVM in JDK 9
These are the JVM enhancements in JDK 9.

Feature	Description
** (94) JEP 165: Compiler Control	
Provides a way to control JVM compilation through compiler directive options. The level of control is runtime-manageable and method-specific. Compiler Control supersedes, and is backward compatible, with CompileCommand.

See Compiler Control in Java Platform, Standard Edition Java Virtual Machine Guide.

** (95) JEP 197: Segmented Code Cache	
Divides the code cache into distinct segments, each of which contains compiled code of a particular type, to improve performance and enable future extensions.

See java in Java Platform, Standard Edition Tools Reference.

** (96) JEP 276: Dynamic Linking of Language-Defined Object Models	
Dynamically links high-level object operations at run time, such as read a property, write a property, and invoke a function, to the appropriate target method handles. It links these operations to target method handles based on the actual types of the values passed. These object operations are expressed as invokedynamic sites.

While java.lang.invoke provides a low-level API for dynamic linking of invokedynamic call sites, it doesn't provide a way to express higher level operations on objects nor methods that implement them.

With the package jdk.dynalink, you can implement programming languages whose expressions contain dynamic types (types that cannot be determined statically) and whose operations on these dynamic types are expressed as invokedynamic call sites (because the language's object model or type system doesn't closely match that of the JVM).

* What’s New for JVM Tuning in JDK 9
These are the JVM tuning enhancements in JDK 9.

Feature	Description
** (97) Improve G1 Usability, Determinism, and Performance	
Enhances the Garbage-First (G1) garbage collector to automatically determine several important memory-reclamation settings. Previously these settings had to be set manually to obtain optimal results. In addition, fixes issues with the usability, determinism, and performance of the G1 garbage collector.

** (98) JEP 158: Unified JVM Logging	
Introduces a common logging system for all components of the JVM.

See the -Xloggc java option in Java Platform, Standard Edition Tools Reference.

** (99) JEP 214: Remove GC Combinations Deprecated in JDK 8	
Removes garbage collector (GC) combinations that were deprecated in JDK 8.

This means that the following GC combinations no longer exist:

DefNew + CMS

ParNew + SerialOld

Incremental CMS

The "foreground" mode for Concurrent Mark Sweep (CMS) has also been removed. The following command-line flags have been removed:

-Xincgc
-XX:+CMSIncrementalMode
-XX:+UseCMSCompactAtFullCollection
-XX:+CMSFullGCsBeforeCompaction
-XX:+UseCMSCollectionPassing
The command line flag -XX:+UseParNewGC no longer has an effect. ParNew can only be used with CMS and CMS requires ParNew. Thus, the -XX:+UseParNewGC flag has been deprecated and will likely be removed in a future release.

** (100) JEP 248: Make G1 the Default Garbage Collector	
Makes Garbage-First (G1) the default garbage collector (GC) on 32- and 64-bit server configurations. Using a low-pause collector such as G1 provides a better overall experience, for most users, than a throughput-oriented collector such as the Parallel GC, which was previously the default.

See Garbage-First Garbage Collector in Java Platform, Standard Edition HotSpot Virtual Machine Garbage Collection Tuning Guide

** (100) JEP 271: Unified GC Logging	
Reimplements Garbage Collection (GC) logging using the unified JVM logging framework introduced in JEP 158. GC logging is re-implemented in a manner consistent with the current GC logging format; however, some differences exist between the new and old formats.

See Enable Logging with the JVM Unified Logging Framework in Java Platform, Standard Edition Tools Reference.

** (101) JEP 291: Deprecate the Concurrent Mark Sweep (CMS) Garbage Collector	
Deprecates the Concurrent Mark Sweep (CMS) garbage collector. A warning message is issued when it is requested on the command line, using the -XX:+UseConcMarkSweepGC option. The Garbage-First (G1) garbage collector is intended to be a replacement for most uses of CMS.

* What’s New for Core Libraries in JDK 9
Feature	Description

** (102) JEP 102: Process API Updates	
Improves the API for controlling and managing operating system processes.

The ProcessHandle class provides the process's native process ID, arguments, command, start time, accumulated CPU time, user, parent process, and descendants. The class can also monitor processes' liveness and destroy processes. With the ProcessHandle.onExit method, the asynchronous mechanisms of the CompletableFuture class can perform an action when the process exits.

See Process API in Java Platform, Standard Edition Java Core Libraries Developer's Guide, java.lang.Process, and java.lang.ProcessHandle.

** (103) JEP 193: Variable Handles	
Defines a standard means to invoke the equivalents of java.util.concurrent.atomic and sun.misc.Unsafe operations upon object fields and array elements.

Defines a standard set of fence operations, which consist of VarHandle static methods that enable fine-grained control of memory ordering. This is an alternative to sun.misc.Unsafe, which provides a nonstandard set of fence operations.

Defines a standard reachability fence operation to ensure that a referenced object remains strongly reachable.

** (104) JEP 254: Compact Strings	
Adopts a more space-efficient internal representation for strings. Previously, the String class stored characters in a char array, using two bytes (16 bits) for each character. The new internal representation of the String class is a byte array plus an encoding-flag field.

This is purely an implementation change, with no changes to existing public interfaces.

See the CompactStrings option of the java command in Java Platform, Standard Edition Tools Reference.

** (105) JEP 264: Platform Logging API and Service	
Defines a minimal logging API that platform classes can use to log messages, together with a service interface for consumers of those messages. A library or application can provide an implementation of this service to route platform log messages to the logging framework of its choice. If no implementation is provided, then a default implementation based on the java.util.logging API is used.

** (106) JEP 266: More Concurrency Updates	
Adds further concurrency updates to those introduced in JDK 8 in JEP 155: Concurrency Updates, including an interoperable publish-subscribe framework and enhancements to the CompletableFuture API.

** (107) JEP 268: XML Catalogs	
Adds a standard XML Catalog API that supports the Organization for the Advancement of Structured Information Standards (OASIS) XML Catalogs version 1.1 standard. The API defines catalog and catalog-resolver abstractions that can be used as an intrinsic or external resolver with the JAXP processors that accept resolvers.

Existing libraries or applications that use the internal catalog API will need to migrate to the new API to take advantage of the new features.

See XML Catalog API in Java Platform, Standard Edition Java Core Libraries Developer's Guide.

** (108) JEP 269: Convenience Factory Methods for Collections	
Makes it easier to create instances of collections and maps with small numbers of elements. New static factory methods on the List, Set, and Map interfaces make it simpler to create immutable instances of those collections.

For example:
Set<String> alphabet = Set.of("a", "b", "c");
See Creating Immutable Lists, Sets, and Maps in Java Platform, Standard Edition Java Core Libraries Developer's Guide. For API documentation, see Immutable Set Static Factory Methods, Immutable Map Static Factory Methods, and Immutable List Static Factory Methods.

** (109) JEP 274: Enhanced Method Handles	
Enhances the MethodHandle, MethodHandles, and MethodHandles.Lookup classes of the java.lang.invoke package to ease common use cases and enable better compiler optimizations.

Additions include:
In the MethodHandles class in the java.lang.invoke package, provide new MethodHandle combinators for loops and try/finally blocks.

Enhance the MethodHandle and MethodHandles classes with new MethodHandle combinators for argument handling.

Implement new lookups for interface methods and, optionally, super constructors in the MethodHandles.Lookup class.

** (110) JEP 277: Enhanced Deprecation	
Revamps the @Deprecated annotation to provide better information about the status and intended disposition of an API in the specification. Two new elements have been added:
@Deprecated(forRemoval=true) indicates that the API will be removed in a future release of the Java SE platform.

@Deprecated(since="version") contains the Java SE version string that indicates when the API element was deprecated, for those deprecated in Java SE 9 and beyond.

For example: @Deprecated(since="9", forRemoval=true)

@Deprecated annotations in the core platform have been updated.

** (111) You can use a new tool, jdeprscan, to scan a class library (JAR file) for uses of deprecated JDK API elements.

See Enhanced Deprecation in Java Platform, Standard Edition Java Core Libraries Developer's Guide.

See jdperscan in Java Platform, Standard Edition Tools Reference.

** (112) JEP 285: Spin-Wait Hints	
Defines an API that enables Java code to hint that a spin loop is executing. A spin loop repeatedly checks to see if a condition is true, such as when a lock can be acquired, after which some computation can be safely performed followed by the release of the lock. This API is purely a hint, and carries no semantic behavior requirements. See the method Thread.onSpinWait.

** (113) JEP 290: Filter Incoming Serialization Data	
Allows incoming streams of object-serialization data to be filtered to improve both security and robustness. Object-serialization clients can validate their input more easily, and exported Remote Method Invocation (RMI) objects can validate invocation arguments more easily as well.

Serialization clients implement a filter interface that is set on an ObjectInputStream. For RMI, the object is exported through a RemoteServerRef that sets the filter on the MarshalInputStream to validate the invocation arguments as they are unmarshalled.

** (114) JEP 259: Stack-Walking API	
Provides a stack-walking API that allows easy filtering and lazy access to the information in stack traces.

The API supports both short walks that stop at a frame that matches given criteria, and long walks that traverse the entire stack. Stopping at a frame that matches a given criteria avoids the cost of examining all the frames if the caller is interested only in the top frames on the stack. The API enables access to Class objects when the stack walker is configured to do so. See the class java.lang.Stackwalker.

** (115) JEP 255: Merge Selected Xerces 2.11.0 Updates into JAXP	
Updates the JDK to support the 2.11.0 version of the Xerces parser. There is no change to the public JAXP API.

The changes are in the following categories of Xerces 2.11.0: Datatypes, DOM L3 Serializer, XPointer, Catalog Resolver, and XML Schema Validation (including bug fixes, but not the XML Schema 1.1 development code).

* What's New for Nashorn in JDK 9
These are the Nashorn enhancements in JDK 9.

Feature	Description
** (116) JEP 236: Parser API for Nashorn	
Enables applications, in particular IDEs and server-side frameworks, to parse and analyze ECMAScript code.

Parse ECMAScript code from a string, URL, or file with methods from the Parser class. These methods return an instance of CompilationUnitTree, which represents ECMAScript code as an abstract syntax tree.

The package jdk.nashorn.api.tree contains the Nashorn parser API.

** (117) JEP 292: Implement Selected ECMAScript 6 Features in Nashorn	Implements many new features introduced in the 6th edition of ECMA-262, also known as ECMAScript 6, or ES6 for short. Implemented features include the following:
Template strings
let, const, and block scope
Iterators and for..of loops
Map, Set, WeakMap, and WeakSet
Symbols
Binary and octal literals

* What’s New for Client Technologies in JDK 9
These are the client technologies enhancements in JDK 9.

Feature	Description
** (118) JEP 251: Multi-Resolution Images	
Enables a set of images with different resolutions to be encapsulated into a single multiresolution image. This could be useful for applications to adapt to display devices whose resolutions may vary from approximately 96dpi to 300dpi during run time.

The interface java.awt.image.MultiResolutionImage encapsulates a set of images with different resolutions into a single multiresolution image, which enables applications to easily manipulate and display images with resolution variants.

** (119) JEP 253: Prepare JavaFX UI Controls and CSS APIs for Modularization	
** (120) Provides public APIs for JavaFX UI controls and CSS functionality that were previously available only through internal packages but are now inaccessible due to modularization.

The new package javafx.scene.control.skin consists of a set of classes that provides a default implementation for the skin (or the look) of each UI control.

** (121) The new class CssParser is a CSS parser that returns a Stylesheet object, which gives you more control over the CSS styling of your application. It’s part of the CSS API (the javafx.css package). The CSS API includes new support classes, including a set of standard converters used by the parser; see the javafx.css.converter package.

** (122) JEP 256: BeanInfo Annotations	
Replaces the @beaninfo Javadoc tag with the annotation types JavaBean, BeanProperty, and SwingContainer.

These annotation types set the corresponding feature attributes during BeanInfo generation at runtime. Thus, you can more easily specify these attributes directly in Bean classes instead of creating a separate BeanInfo class for every Bean class. It also enables the removal of automatically generated classes, which makes it easier to modularize the client library.

** (123) JEP 262: TIFF Image I/O	
Adds Tag Image File Format (TIFF) reading and writing as standard to the package javax.imageio. The new package javax.imageio.plugins.tiff provides classes that simplify the optional manipulation of TIFF metadata.

** (124) JEP 263: HiDPI Graphics on Windows and Linux	
Automatically scales and sizes AWT and Swing components for High Dots Per Inch (HiDPI) displays on Windows and Linux.

The JDK already supports HiDPI "retina displays" on OS X.

Prior to this release, on Windows and Linux, Java applications were sized and rendered based on pixels, even on HiDPI displays that can have pixel densities two to three times as high as traditional displays. This led to GUI components and windows that were too small to read or use.

** (125) JEP 272: Platform-Specific Desktop Features	
Adds additional methods to the class java.awt.Desktop that enable you to interact with the desktop, including the following:

** (126) Show custom About and Preferences windows.

** (127) Handle requests to open or print a list of files.

** (128) Handle requests to open a URL.

** (129) Open the native help viewer application.

** (130) Set the default menu bar.

** (131) Enable or disable the application to be suddenly terminated.

These new methods replace the functionality of the internal APIs contained in the OS X package com.apple.eawt, which are not accessible by default in JDK 9. Note that the package com.apple.eio is no longer accessible.

** (132) JEP 283: Enable GTK 3 on Linux	
Enables Java graphical applications, whether based on JavaFX, Swing, or Abstract Window Toolkit (AWT), to use either the GTK+ version 2 or version 3 on Linux or Solaris.

By default, the JDK on Linux or Solaris uses GTK+ 2 if available; if not, it uses GTK+ 3.

To use a specific version of GTK+, set the system property jdk.gtk.version. This system property may have a value of 2, 2.2, or 3. You must set this property before your application loads GTK+, and it must not conflict with a GTK+ version that may have been loaded earlier by another toolkit.

* What’s New for Internationalization in JDK 9
These are the internationalization enhancements in JDK 9.

Feature	Description
** (133) JEP 267: Unicode 8.0	
Supports Unicode 8.0. JDK 8 supported Unicode 6.2.

The Unicode 6.3, 7.0 and 8.0 standards combined introduced 10,555 characters, 29 scripts, and 42 blocks, all of which are supported in JDK 9.

** (134) JEP 252: CLDR Locale Data Enabled by Default	
Uses the Common Locale Data Repository's (CLDR) XML-based locale data, first added in JDK 8, as the default locale data in JDK 9. In previous releases, the default was JRE.

To enable behavior compatible with JDK 8, set the system property java.locale.providers to a value with COMPAT ahead of CLDR.

See CLDR Locale Data Enabled by Default in Java Platform, Standard Edition Internationalization Guide.

** (135) JEP 226: UTF-8 Properties Files	
Loads properties files in UTF-8 encoding. In previous releases, ISO-8859-1 encoding was used when loading property resource bundles. UTF-8 is a much more convenient way to represent non-Latin characters.

Most existing properties files should not be affected.

See UTF-8 Properties Files in Java Platform, Standard Edition Internationalization Guide.
