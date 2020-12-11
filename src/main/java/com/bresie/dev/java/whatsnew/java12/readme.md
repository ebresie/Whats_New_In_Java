The intent of this project is to provide example code of what's new in java releases.

I will be trying to get the high level elements from each Java/JDK version and provide samples in code where applicable.  

Some elements involve command line parameters which would require some form of "run configuration" which uses these so in those cases, this may be dependent upon run elements which may be provided as part of a build time "run" tasks which applicable parameters.

This has updates relative to JDK 12.

The material here is from the URL listed below.  The intent is to help guide exercise to demonstrate the changes relative to the whatsnew.  

All rights to the material replicated below are with the original authors as spelled out at the original site.

=============================================

https://www.oracle.com/technetwork/java/javase/12all-relnotes-5211423.html

 Cumulative Release Notes for JDK 12 and JDK 12 Update Releases

Java™ SE Development Kit 12.0.2 (JDK 12.0.2)
July 16, 2019

The full version string for this update release is 12.0.2+10 (where "+" means "build"). The version number is 12.0.2.

IANA Data 2018i
JDK 12.0.2 contains IANA time zone data version 2018i. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 12.0.2 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
12	12.0.2+10
11	11.0.4+10
8	1.8.0_221-b11
7	1.7.0_231-b08


Oracle JDK Expiration Date
The JDK expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JDK (version 12.0.2) will expire with the release of the next critical patch update scheduled for October 15, 2019.



Removed Features and Options
security-libs/java.security
➜ Removal of Two DocuSign Root CA Certificates
Two DocuSign root CA certificates are expired and have been removed from the cacerts keystore:

alias name "certplusclass2primaryca [jdk]"

Distinguished Name: CN=Class 2 Primary CA, O=Certplus, C=FR

alias name "certplusclass3pprimaryca [jdk]"

Distinguished Name: CN=Class 3P Primary CA, O=Certplus, C=FR

See JDK-8223499


security-libs/java.security
➜ Removal of Two Comodo Root CA Certificates
Two Comodo root CA certificates are expired and have been removed from the cacerts keystore:

alias name "utnuserfirstclientauthemailca [jdk]"

Distinguished Name: CN=UTN-USERFirst-Client Authentication and Email, OU=http://www.usertrust.com, O=The USERTRUST Network, L=Salt Lake City, ST=UT, C=US

alias name "utnuserfirsthardwareca [jdk]"

Distinguished Name: CN=UTN-USERFirst-Hardware, OU=http://www.usertrust.com, O=The USERTRUST Network, L=Salt Lake City, ST=UT, C=US

See JDK-8222136


security-libs/java.security
➜ Removal of T-Systems Deutsche Telekom Root CA 2 Certificate
The T-Systems Deutsche Telekom Root CA 2 certificate is expired and has been removed from the cacerts keystore:

alias name "deutschetelekomrootca2 [jdk]"

Distinguished Name: CN=Deutsche Telekom Root CA 2, OU=T-TeleSec Trust Center, O=Deutsche Telekom AG, C=DE

See JDK-8222137



Other notes
install
➜ Java Access Bridge Installation Workaround
There is a risk of breaking Java Access Bridge functionality when installing Java on a Windows system that has both a previously installed version of Java and an instance of JAWS running. After rebooting, the system can be left without the WindowsAccessBridge-64.dll in either the system directory (C:\Windows\System32) for 64bit Java products or the system directory used by WOW64 (C:\Windows\SysWoW64) for 32bit Java products.

To prevent breaking Java Access Bridge functionality, use one of the following workarounds:

Stop JAWS before running the Java installer.
Uninstall the existing JRE(s) before installing the new version of Java.
Uninstall the existing JRE(s) after the new version of Java is installed and the machine is rebooted.
The goal of the workarounds is to avoid the scenario of uninstalling existing JRE(s) from Java installer when JAWS is running.

JDK-8223293 (not public)


Java™ SE Development Kit 12.0.1 (JDK 12.0.1)
April 16, 2019

The full version string for this update release is 12.0.1+12 (where "+" means "build"). The version number is 12.0.1.

IANA Data 2018g
JDK 12.0.1 contains IANA time zone data version 2018g. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 12.0.1 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
12	12.0.1+12
11	11.0.3+12
10	10.0.99
9	9.0.99
8	1.8.0_211-b12
7	1.7.0_221-b08
6	1.6.0_221


Oracle JDK Expiration Date
The JDK expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JDK (version 12.0.1) will expire with the release of the next critical patch update scheduled for July 16, 2019.



Known Issues
install
➜ Java Access Bridge Installation Workaround
There is a risk of breaking Java Access Bridge functionality when installing Java on a Windows system that has both a previously installed version of Java and an instance of JAWS running. After rebooting, the system can be left without the WindowsAccessBridge-64.dll in either the system directory (C:\Windows\System32) for 64bit Java products or the system directory used by WOW64 (C:\Windows\SysWoW64) for 32bit Java products.

To prevent breaking Java Access Bridge functionality, use one of the following workarounds:

Stop JAWS before running the Java installer.
Uninstall the existing JRE(s) before installing the new version of Java.
Uninstall the existing JRE(s) after the new version of Java is installed and the machine is rebooted.
The goal of the workarounds is to avoid the scenario of uninstalling existing JRE(s) from Java installer when JAWS is running.

JDK-8223293 (not public)


Changes
security-libs/java.security
➜ Added GlobalSign R6 Root Certificate
The following root certificate has been added to the cacerts truststore:

GlobalSign
globalsignrootcar6

DN: CN=GlobalSign, O=GlobalSign, OU=GlobalSign Root CA - R6

JDK-8216577 (not public)


core-libs/java.time
➜ New Japanese Era Name Reiwa
An instance representing the new Reiwa era has been added to this update. Unlike other eras, there is no public field for this era. It can be obtained by calling JapaneseEra.of(3) or JapaneseEra.valueOf("Reiwa"). JDK 13 and later will have a new public field to represent this era.

The placeholder name, "NewEra", for the Japanese era that started from May 1st, 2019 has been replaced with the new official name. Applications that relied on the placeholder name (see JDK-8202088) to obtain the new era singleton (JapaneseEra.valueOf("NewEra")) will no longer work.

See JDK-8205432


Bug Fixes
This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 12.0.1 Bug Fixes page.




JDK 12 Release Notes


The following sections are included in these Release Notes:

Introduction

What's New in JDK 12 - New Features and Enhancements

Removed Features and Options

Deprecated Features and Options

Other Notes

Differences Between Oracle JDK and Oracle's OpenJDK



Introduction
These notes describe important changes, enhancements, removed APIs and features, deprecated APIs and features, and other information about JDK 12 and Java SE 12. In some cases, the descriptions provide links to additional detailed information about an issue or a change. This page does not duplicate the descriptions provided by the Java SE 12 ( JSR 386) Platform Specification, which provides informative background for all specification changes and might also include the identification of removed or deprecated APIs and features not described here. The Java SE 12 ( JSR 386) specification provides links to:

Annex 1: The complete Java SE 12 API Specification.

Annex 2: An annotated API specification showing the exact differences relative to Java SE 11. Informative background for these changes may be found in the list of approved Change Specification Requests for this release.

Annex 3: Java SE 12 Editions of The Java Language Specification and The Java Virtual Machine Specification. The Java SE 12 Editions contain all corrections and clarifications made since the Java SE 11 Editions, as well as additions for new features.

You should be aware of the content in that document as well as the items described in this page.

The descriptions on this Release Note page also identify potential compatibility issues that you might encounter when migrating to JDK 12. The Kinds of Compatibility page on the OpenJDK wiki identifies three types of potential compatibility issues for Java programs used in these descriptions:

Source: Source compatibility preserves the ability to compile existing source code without error.

Binary: Binary compatibility is defined in The Java Language Specification as preserving the ability to link existing class files without error.

Behavioral: Behavioral compatibility includes the semantics of the code that is executed at runtime.

See CSRs Approved for JDK 12 for the list of CSRs closed in JDK 12 and the Compatibility & Specification Review (CSR) page on the OpenJDK wiki for general information about compatibility.

Top


What's New in JDK 12 - New Features and Enhancements
This section describes some of the enhancements in Java SE 12 and JDK 12. In some cases, the descriptions provide links to additional detailed information about an issue or a change. The APIs described here are those that are provided with the Oracle JDK. It includes a complete implementation of the Java SE 12 Platform and additional Java APIs to support developing, debugging, and monitoring Java applications. Another source of information about important enhancements and new features in Java SE 12 and JDK 12 is the Java SE 12 ( JSR 386) Platform Specification, which documents the changes to the specification made between Java SE 11 and Java SE 12. This document includes descriptions of those new features and enhancements that are also changes to the specification. The descriptions also identify potential compatibility issues that you might encounter when migrating to JDK 12.



core-libs/java.lang
➜ Support for Unicode 11
The JDK 12 release includes support for Unicode 11.0.0. Following the release of JDK 11, which supported Unicode 10.0.0, Unicode 11.0.0 introduced the following new features that are now included in JDK 12:

684 new characters
11 new blocks
7 new scripts.
684 new characters that include important additions for the following:

66 emoji characters
Copyleft symbol
Half stars for rating systems
Additional astrological symbols
Xiangqi Chinese chess symbols
7 new scripts :

Hanifi Rohingya
Old Sogdian
Sogdian
Dogra
Gunjala Gondi
Makasar
Medefaidrin
11 new blocks that include 7 blocks for the new scripts listed above and 4 blocks for the following existing scripts:

Georgian Extended
Mayan Numerals
Indic Siyaq Numbers
Chess Symbols
See JDK-8209923


core-libs/java.lang
➜ POSIX_SPAWN Option on Linux
As an additional way to launch processes on Linux, the jdk.lang.Process.launchMechanism property can be set to POSIX_SPAWN. This option has been available for a long time on other *nix platforms. The default launch mechanism (VFORK) on Linux is unchanged, so this additional option does not affect existing installations.

POSIX_SPAWN mitigates rare pathological cases when spawning child processes, but it has not yet been excessively tested. Prudence is advised when using POSIX_SPAWN in productive installations.

See JDK-8212828


core-libs/java.lang.invoke
➜ JEP 334 JVM Constants API
The new package java.lang.invoke.constant introduces an API to model nominal descriptions of class file and run-time artifacts, in particular constants that are loadable from the constant pool. It does so by defining a family of value-based symbolic reference (JVMS 5.1) types, capable of describing each kind of loadable constant. A symbolic reference describes a loadable constant in purely nominal form, separate from class loading or accessibility context. Some classes can act as their own symbolic references (e.g., String); for linkable constants a family of symbolic reference types has been added (ClassDesc, MethodTypeDesc, MethodHandleDesc, and DynamicConstantDesc) that contain the nominal information to describe these constants.

See JDK-8203252


core-libs/java.text
➜ Support for Compact Number Formatting
NumberFormat adds support for formatting a number in its compact form. Compact number formatting refers to the representation of a number in a short or human readable form. For example, in the en_US locale, 1000 can be formatted as "1K" and 1000000 can be formatted as "1M", depending upon the style specified by NumberFormat.Style. The compact number formats are defined by LDML's specification for Compact Number Formats. To obtain an instance, use one of the factory methods given by NumberFormat for compact number formatting. For example:

NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
String result = fmt.format(1000);

The example above results in "1K".

See JDK-8177552


core-libs/java.util:i18n
➜ Square Character Support for Japanese New Era
The code point, U+32FF, is reserved by the Unicode Consortium to represent the Japanese square character for the new era that begins from May, 2019. Relevant methods in the Character class return the same properties as the existing Japanese era characters (e.g., U+337E for "Meizi"). For details about the code point, see http://blog.unicode.org/2018/09/new-japanese-era.html.

See JDK-8211398


hotspot/gc
➜ ZGC Concurrent Class Unloading
The Z Garbage Collector now supports class unloading. By unloading unused classes, data structures related to these classes can be freed, lowering the overall footprint of the application. Class unloading in ZGC happens concurrently, without stopping the execution of Java application threads, and has thus zero impact on GC pause times. This feature is enabled by default, but can be disabled using the command line option -XX:-ClassUnloading.

See JDK-8214897


hotspot/gc
➜ Allocation of Old Generation of Java Heap on Alternate Memory Devices
This experimental feature in G1 and Parallel GC allows them to allocate the old generation of the Java heap on an alternative memory device such as NV-DIMM memory.

Operating systems today expose NV-DIMM memory devices through the file system. Examples are NTFS DAX mode and ext4 DAX mode. Memory-mapped files in these file systems bypass the file cache and provide a direct mapping of virtual memory to the physical memory on the device. The specification of a path to an NV-DIMM file system by using the flag -XX:AllocateOldGenAt=<path> enables this feature. There is no additional flag to enable this feature.

When enabled, young generation objects are placed in DRAM only while old generation objects are always allocated in NV-DIMM. At any given point, the collector guarantees that the total memory committed in DRAM and NV-DIMM memory is always less than the size of the heap as specified by -Xmx.

The current implementation pre-allocates the full Java heap size in the NV-DIMM file system to avoid problems with dynamic generation sizing. Users need to make sure there is enough free space on the NV-DIMM file system.

When enabled, the VM also limits the maximum size of the young generation based on available DRAM, although it is recommended that users set the maximum size of the young generation explicitly.

For example, if the VM is run with -Xmx756g on a system with 32GB DRAM and 1024GB NV-DIMM memory, the collector will limit the young generation size based on following calculation:

No -XX:MaxNewSize or -Xmn is specified: the maximum young generation size is set to 80% of available memory (25.6GB).
-XX:MaxNewSize or -Xmn is specified: the maximum young generation size is capped at 80% of available memory (25.6GB) regardless of the amount specified.
Users can use -XX:MaxRAM to let the VM know how much DRAM is available for use. If specified, maximum young gen size is set to 80% of the value in MaxRAM.
Users can specify the percentage of DRAM to use (instead of the default 80%) for young generation with -XX:MaxRAMPercentage.
Enabling logging with the logging option gc+ergo=info will print the maximum young generation size at startup.

See JDK-8202286


hotspot/runtime
➜ HotSpot Windows OS Detection Correctly Identifies Windows Server 2019
Prior to this fix, Windows Server 2019 was recognized as "Windows Server 2016", which produced incorrect values in the os.name system property and the hs_err_pid file.

See JDK-8211106


hotspot/runtime
➜ Command-Line Flag -XX+ExtensiveErrorReports
The command-line flag -XX:+ExtensiveErrorReports has been added to allow more extensive reporting of information related to a crash as reported in the hs_err<pid>.log file. Disabled by default in product builds, the flag can be turned on in environments where maximal information is desired - even if the resulting logs may be quite large and/or contain information that might be considered sensitive.

See JDK-8211845


security-libs/java.security
➜ disallow and allow Options for java.security.manager System Property
New "disallow" and "allow" token options have been added to the java.security.manager system property. In the JDK implementation, if the Java Virtual Machine starts with the system property java.security.manager set to "disallow", then the System.setSecurityManager method cannot be used to set a security manager and will throw an UnsupportedOperationException. The "disallow" option can improve run-time performance for applications that never set a security manager. For further details on the behavior of these options, see the class description of java.lang.SecurityManager.

See JDK-8191053


security-libs/java.security
➜ -groupname Option Added to keytool Key Pair Generation
A new -groupname option has been added to keytool -genkeypair so that a user can specify a named group when generating a key pair. For example, keytool -genkeypair -keyalg EC -groupname secp384r1 will generate an EC key pair by using the secp384r1 curve. Because there might be multiple curves with the same size, using the -groupname option is preferred over the -keysize option.

See JDK-8213400


security-libs/java.security
➜ New Java Flight Recorder (JFR) Security Events
Four new JFR events have been added to the security library area. These events are disabled by default and can be enabled via the JFR configuration files or via standard JFR options.

jdk.SecurityPropertyModification

Records Security.setProperty(String key, String value) method calls
jdk.TLSHandshake

Records TLS handshake activity. The event fields include:
Peer hostname
Peer port
TLS protocol version negotiated
TLS cipher suite negotiated
Certificate id of peer client
jdk.X509Validation

Records details of X.509 certificates negotiated in successful X.509 validation (chain of trust)
jdk.X509Certificate

Records details of X.509 Certificates. The event fields include:
Certificate algorithm
Certificate serial number
Certificate subject
Certificate issuer
Key type
Key length
Certificate id
Validity of certificate
See JDK-8148188


security-libs/java.security
➜ Customizing PKCS12 keystore Generation
New system and security properties have been added to enable users to customize the generation of PKCS #12 keystores. This includes algorithms and parameters for key protection, certificate protection, and MacData. The detailed explanation and possible values for these properties can be found in the "PKCS12 KeyStore properties" section of the java.security file.

See JDK-8076190


security-libs/javax.net.ssl
➜ ChaCha20 and Poly1305 TLS Cipher Suites
New TLS cipher suites using the ChaCha20-Poly1305 algorithm have been added to JSSE. These cipher suites are enabled by default. The TLS_CHACHA20_POLY1305_SHA256 cipher suite is available for TLS 1.3. The following cipher suites are available for TLS 1.2:

TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256
TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256
TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256
Refer to the "Java Secure Socket Extension (JSSE) Reference Guide" for details on these new TLS cipher suites.

See JDK-8140466


security-libs/org.ietf.jgss:krb5
➜ Support for dns_canonicalize_hostname in krb5.conf
The dns_canonicalize_hostname flag in the krb5.conf configuration file is now supported by the JDK Kerberos implementation. When set to "true", a short hostname in a service principal name will be canonicalized to a fully qualified domain name if available. Otherwise, no canonicalization is performed. The default value is "true". This is also the behavior before JDK 12.

See JDK-8210821


tools
➜ jdeps --print-module-deps Reports Transitive Dependences
jdeps --print-module-deps, --list-deps, and --list-reduce-deps options have been enhanced as follows.

By default, they perform transitive module dependence analysis on libraries on the class path and module path, both directly and indirectly, as required by the given input JAR files or classes. Previously, they only reported the modules required by the given input JAR files or classes. The --no-recursive option can be used to request non-transitive dependence analysis.

By default, they flag any missing dependency, i.e. not found from class path and module path, as an error. The --ignore-missing-deps option can be used to suppress missing dependence errors. Note that a custom image is created with the list of modules output by jdeps when using the --ignore-missing-deps option for a non-modular application. Such an application, running on the custom image, might fail at runtime when missing dependence errors are suppressed.

See JDK-8213909


tools/javac
➜ JEP 325 Switch Expressions (Preview)
The Java language enhances the switch statement so that it can be used as either a statement or an expression. Using switch as an expression often results in code that is more concise and readable. Both the statement and expression form can use either traditional case ... : labels (with fall through) or simplified case ... -> labels (no fall through). Also, both forms can switch on multiple constants in one case. These enhancements to switch are a preview language feature.

See JDK-8192963
Top


Removed Features and Options
This section describes the APIs, features, and options that were removed in Java SE 12 and JDK 12. The APIs described here are those that are provided with the Oracle JDK. It includes a complete implementation of the Java SE 12 Platform and additional Java APIs to support developing, debugging, and monitoring Java applications. Another source of information about important enhancements and new features in Java SE 12 and JDK 12 is the Java SE 12 ( JSR 386) Platform Specification, which documents changes to the specification made between Java SE 11 and Java SE 12. This document includes the identification of removed APIs and features not described here. The descriptions below might also identify potential compatibility issues that you could encounter when migrating to JDK 12. See CSRs Approved for JDK 12 for the list of CSRs closed in JDK 12.



client-libs/java.awt
➜ Removal of com.sun.awt.SecurityWarning Class
The com.sun.awt.SecurityWarning class was deprecated as forRemoval=true in JDK 11 (JDK-8205588). This class was unused in the JDK and has been removed in this release.

See JDK-8210692


core-libs/java.io
➜ Removal of finalize Methods from FileInputStream and FileOutputStream
The finalize methods of FileInputStream and FileOutputStream were deprecated for removal in JDK 9. They have been removed in this release. Thejava.lang.ref.Cleaner has been implemented since JDK 9 as the primary mechanism to close file descriptors that are no longer reachable from FileInputStream and FileOutputStream. The recommended approach to close files is to explicitly call close or to use try-with-resources.

See JDK-8192939


core-libs/java.util.jar
➜ Removal of finalize Method in java.util.ZipFile/Inflator/Deflator
The finalize method in java.util.ZipFile, java.util.Inflator, and java.util.Deflator was deprecated for removal in JDK 9 and its implementation was updated to be a no-op. The finalize method in java.util.ZipFile, java.util.Inflator, and java.util.Deflator has been removed in this release. Subclasses that override finalize in order to perform cleanup should be modified to use alternative cleanup mechanisms and to remove the overriding finalize method.

The removal of the finalize methods will expose Object.finalize to subclasses of ZipFile, Deflater, and Inflater. Compilation errors might occur on the override of finalize due to the change in declared exceptions. Object.finalize is now declared to throw java.lang.Throwable. Previously, only java.io.IOException was declared.

See JDK-8212129


infrastructure/build
➜ Dropped the YY.M Vendor Version String from Oracle-Produced Builds
The vendor version string was introduced in JDK 9 by JEP 322 (Time-Based Release Versioning), as the value of the system property java.vendor.version. As of that release it was set, in JDK builds from Oracle, to YY.M, where YY and M are the year and month, respectively, of the GA date of the release. This string is most apparent to end users in the output of the java --version command, and related commands. For example, with JDK 11:

java 11 2018-09-25
Java(TM) SE Runtime Environment 18.9 (build 11+28)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11+28, mixed mode)


As of JDK 12, JDK builds from Oracle will no longer include a vendor version string. As a consequence the system property java.vendor.version now has the value null, and the output of java --version and related commands will no longer include a vendor version string. For example, the output of the JDK 12 java --version command will be of the form:

java 12 2019-03-19
Java(TM) SE Runtime Environment (build 12+17)
Java HotSpot(TM) 64-Bit Server VM (build 12+17, mixed mode)


The relevant difference with respect to JDK 11 is the absence of 19.3 from the last two lines. Existing programs or scripts that expect the java.vendor.version property to have a non-null value, or that parse the output of java --version or related commands, may require adjustment in order to work properly with JDK 12.

JDK-8211726 (not public)


security-libs/java.security
➜ Removal of GTE CyberTrust Global Root
The GTE CyberTrust Global Root certificate is expired and has been removed from the cacerts keystore:

alias name "gtecybertrustglobalca [jdk]"

Distinguished Name: CN=GTE CyberTrust Global Root, OU="GTE CyberTrust Solutions, Inc.", O=GTE Corporation, C=US

See JDK-8195793


tools/javac
➜ Removal of javac Support for 6/1.6 source, target, and release Values
Consistent with the policy outlined in JEP 182: Policy for Retiring javac -source and -target Options, support for the 6/1.6 argument value for javac's -source, -target, and --release flags has been removed.

See JDK-8028563
Top


Deprecated Features and Options
Additional sources of information about the APIs, features, and options deprecated in Java SE 12 and JDK 12 include:

The deprecated API page (API specification) identifies all deprecated APIs including those deprecated in Java SE 12.
The Java SE 12 ( JSR 386) specification documents changes to the specification made between Java SE 11 and Java SE 12 that include the identification of deprecated APIs and features not described here.
JEP 277: Enhanced Deprecation provides a detailed description of the deprecation policy. You should be aware of the updated policy described in this document.
You should be aware of the contents in those documents as well as the items described in this release notes page.

The descriptions of deprecated APIs might include references to the deprecation warnings of forRemoval=true and forRemoval=false. The forRemoval=true text indicates that a deprecated API might be removed from the next major release. The forRemoval=false text indicates that a deprecated API is not expected to be removed from the next major release but might be removed in some later release.

The descriptions below also identify potential compatibility issues that you might encounter when migrating to JDK 12. See CSRs Approved for JDK 12 for the list of CSRs closed in JDK 12.



hotspot/runtime
➜ Obsoleted -XX+/-MonitorInUseLists
The VM Option -XX:-MonitorInUseLists is obsolete in JDK 12 and ignored. Use of this flag will result in a warning being issued. This option may be removed completely in a future release.

See JDK-8211384


security-libs/java.security
➜ Deprecated Default Keytool -keyalg Value
The default -keyalg value for the -genkeypair and -genseckey commands of keytool have been deprecated. If a user has not explicitly specified a value for the -keyalg option a warning will be shown. An additional informational text will also be printed showing the algorithm(s) used by the newly generated entry. In a subsequent JDK release, the default key algorithm values will no longer be supported and the -keyalg option will be required.

See JDK-8212003
Top


Other Notes
The following notes describe additional changes and information about this release. In some cases, the following descriptions provide links to additional detailed information about an issue or a change.

client-libs/javax.swing
➜ GTK+ 3.20 and Later Unsupported by Swing
Due to incompatible changes in the GTK+ 3 library versions 3.20 and later, the Swing GTK Look and Feel does not render some UI components when using this library. Therefore Linux installations with versions of GTK+ 3.20 and above are not supported for use by the Swing GTK Look And Feel in this release. Affected applications on such configurations should specify the system property -Djdk.gtk.version=2.2 to request GTK2+ based rendering instead.

See JDK-8218469


core-libs/java.lang
➜ Initial Value of user.timezone System Property Changed
The initial value of the user.timezone system property is undefined unless set using a command line argument, for example, -Duser.timezone="America/New_York". The first time the default timezone is needed, if user.timezone is undefined or empty the timezone provided by the operating system is used. Previously, the initial value was the empty string. In JDK 12, System.getProperty("user.timezone") may return null.

See JDK-8185496


core-libs/java.net
➜ Better HTTP Redirection Support
In this release, the behavior of methods that application code uses to set request properties in java.net.HttpURLConnection has changed. When a redirect occurs automatically from the original destination server to a resource on a different server, then all such properties are cleared for the redirect and any subsequent redirects. If these properties are required to be set on the redirected requests, then the redirect responses should be handled by the application by calling HttpURLConnection.setInstanceFollowRedirects(false) for the original request.

JDK-8196902 (not public)


core-libs/java.net
➜ Changed URLPermission Behavior with Query or Fragments in URL String
The behavior of java.net.URLPermission has changed slightly. It was previously specified to ignore query and fragment components in the supplied URL string. However, this behavior was not implemented and any query or fragment were included in the internal permission URL string. The change here is to implement the behavior as specified. Internal usages of URLPermission in the JDK do not include queries or fragments. So, this will not change. In the unlikely event that user code was creating URLPermission objects explicitly, then the behavior change may be seen and that permission checks which failed erroneously previously, will now pass as expected.

See JDK-8213616


core-libs/java.time
➜ Support New Japanese Era in java.time.chrono.JapaneseEra
The JapaneseEra class and its of(int), valueOf(String), and values() methods are clarified to accommodate future Japanese era additions, such as how the singleton instances are defined, what the associated integer era values are, etc.

See JDK-8212941


core-libs/java.util
➜ Changed Properties.loadFromXML to Comply with Specification
The implementation of the java.util.Properties loadFromXML method has been changed to comply with its specification. Specifically, the underlying XML parser implementation now rejects non-compliant XML documents by throwing an InvalidPropertiesFormatException as specified by the loadFromXML method.

The effect of the change is as follows:

Documents created by Properties.storeToXML: No change. Properties.loadFromXML will have no problem reading such files.

Documents not created by Properties.storeToXML: Any documents containing DTDs not in the format as specified in Properties.loadFromXML will be rejected. This means the DTD shall be exactly as follows (as generated by the Properties.storeToXML method):

<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
See JDK-8213325


core-libs/javax.naming
➜ LDAPS Communication Failure
Application code using LDAPS with a socket connect timeout that is <= 0 ( the default value ), may encounter an exception when establishing the connection.

The top most frames from Exception stack traces of applications encountering such issues might resemble the following:

javax.naming.ServiceUnavailableException: <server:port>; socket closed
at com.sun.jndi.ldap.Connection.readReply(Unknown Source)
at com.sun.jndi.ldap.LdapClient.ldapBind(Unknown Source)
...
See JDK-8211107


hotspot/gc
➜ G1 May Uncommit Memory During Marking Cycle
By default, G1 may now give back Java heap memory to the operating system during any concurrent mark cycle. G1 will respect default Java heap sizing policies at that time.

This change improves memory usage of the Java process if the application does not need all memory.

This behavior may be disabled in accordance with default heap sizing policies by setting minimum Java heap size to maximum Java heap size via the -Xms option.

See JDK-6490394




hotspot/jvmti
➜ can_pop_frame and can_force_early_return Capabilities are Disabled if JVMCI Compiler is Used
The JVMTI can_pop_frame and can_force_early_return capabilities are disabled if a JVMCI compiler (like Graal) is used. As a result the corresponding functionality (PopFrame and ForceEarlyReturnXXX functions) is not available to JVMTI agents. This issue is being tracked by JDK-8218885.

See JDK-8218025


infrastructure/build
➜ Linux Native Code Checks
Additional safeguards to protect against buffer overruns in native code have been enabled on Linux. If a buffer overrun is encountered, the system will write the message "stack smashing detected" and the program will exit. Issues of this type should be reported to your vendor.

JDK-8199552 (not public)


security-libs/java.security
➜ Added Additional TeliaSonera Root Certificate
The following root certificate have been added to the OpenJDK cacerts truststore:

TeliaSonera
teliasonerarootcav1

DN: CN=TeliaSonera Root CA v1, O=TeliaSonera

See JDK-8210432


security-libs/java.security
➜ Removal of AOL and Swisscom Root Certificates
The following root certificates have been removed from the cacerts truststore:

AOL

aolrootca1

DN: CN=America Online Root Certification Authority 1, O=America Online Inc., C=US

aolrootca2

DN: CN=America Online Root Certification Authority 2, O=America Online Inc., C=US

Swisscom

swisscomrootca2

DN: CN=Swisscom Root CA 2, OU=Digital Certificate Services, O=Swisscom, C=ch

See JDK-8203230


security-libs/javax.crypto
➜ Change to X25519 and X448 Encoded Private Key Format
The encoded format of X25519 and X448 private keys has been corrected to use the standard format described in RFC 8410. This change affects any private key produced from the "X25519", "X448", or "XDH" services in the SunEC provider. The correct format is not compatible with the format used in previous JDK versions. It is recommended that existing incompatible keys in storage be replaced with newly-generated private keys.

See JDK-8213363


security-libs/javax.net.ssl
➜ Removed TLS v1 and v1.1 from SSLContext Required Algorithms
The requirement that all SE implementations must support TLSv1 and TLSv1.1 has been removed from the javax.net.ssl.SSLContext API and the Java Security Standard Algorithm Names specification.

See JDK-8214140


security-libs/javax.net.ssl
➜ Disabled TLS anon and NULL Cipher Suites
The TLS anon (anonymous) and NULL cipher suites have been added to the jdk.tls.disabledAlgorithms security property and are now disabled by default.

See JDK-8211883


security-libs/javax.net.ssl
➜ Disabled All DES TLS Cipher Suites
DES-based TLS cipher suites are considered obsolete and should no longer be used. DES-based cipher suites have been deactivated by default in the SunJSSE implementation by adding the "DES" identifier to the jdk.tls.disabledAlgorithms security property. These cipher suites can be reactivated by removing "DES" from the jdk.tls.disabledAlgorithms security property in the java.security file or by dynamically calling the Security.setProperty() method. In both cases re-enabling DES must be followed by adding DES-based cipher suites to the enabled cipher suite list using the SSLSocket.setEnabledCipherSuites() or SSLEngine.setEnabledCipherSuites() methods.

Note that prior to this change, DES40_CBC (but not all DES) suites were disabled via the jdk.tls.disabledAlgorithms security property.

See JDK-8208350


security-libs/javax.net.ssl
➜ Distrust TLS Server Certificates Anchored by Symantec Root CAs
The JDK will stop trusting TLS Server certificates issued by Symantec, in line with similar plans recently announced by Google, Mozilla, Apple, and Microsoft. The list of affected certificates includes certificates branded as GeoTrust, Thawte, and VeriSign, which were managed by Symantec.

TLS Server certificates issued on or before April 16, 2019 will continue to be trusted until they expire. Certificates issued after that date will be rejected. See the DigiCert support page for information on how to replace your Symantec certificates with a DigiCert certificate (DigiCert took over validation and issuance for all Symantec Website Security SSL/TLS certificates on December 1, 2017).

An exception to this policy is that TLS Server certificates issued through two subordinate Certificate Authorities managed by Apple, and identified below, will continue to be trusted as long as they are issued on or before December 31, 2019.

The restrictions are enforced in the JDK implementation (the SunJSSE Provider) of the Java Secure Socket Extension (JSSE) API. A TLS session will not be negotiated if the server's certificate chain is anchored by any of the Certificate Authorities in the table below.

An application will receive an Exception with a message indicating the trust anchor is not trusted, ex:

"TLS Server certificate issued after 2019-04-16 and anchored by a distrusted legacy Symantec root CA: CN=GeoTrust Global CA, O=GeoTrust Inc., C=US"
If necessary, and at your own risk, you can work around the restrictions by removing "SYMANTEC_TLS" from the jdk.security.caDistrustPolicies security property in the java.security configuration file.

The restrictions are imposed on the following Symantec Root certificates included in the JDK:

Root Certificates distrusted after 2019-04-16
Distinguished Name	SHA-256 Fingerprint
CN=GeoTrust Global CA, O=GeoTrust Inc., C=US
FF:85:6A:2D:25:1D:CD:88:D3:66:56:F4:50:12:67:98:CF:AB:AA:DE:40:
79:9C:72:2D:E4:D2:B5:DB:36:A7:3A

CN=GeoTrust Primary Certification Authority, O=GeoTrust Inc., C=US
37:D5:10:06:C5:12:EA:AB:62:64:21:F1:EC:8C:92:01:3F:C5:F8:2A:E9:
8E:E5:33:EB:46:19:B8:DE:B4:D0:6C

CN=GeoTrust Primary Certification Authority - G2, OU=(c) 2007 GeoTrust Inc. - For authorized use only, O=GeoTrust Inc., C=US
5E:DB:7A:C4:3B:82:A0:6A:87:61:E8:D7:BE:49:79:EB:F2:61:1F:7D:D7:
9B:F9:1C:1C:6B:56:6A:21:9E:D7:66

CN=GeoTrust Primary Certification Authority - G3, OU=(c) 2008 GeoTrust Inc. - For authorized use only, O=GeoTrust Inc., C=US
B4:78:B8:12:25:0D:F8:78:63:5C:2A:A7:EC:7D:15:5E:AA:62:5E:E8:29:
16:E2:CD:29:43:61:88:6C:D1:FB:D4

CN=GeoTrust Universal CA, O=GeoTrust Inc., C=US
A0:45:9B:9F:63:B2:25:59:F5:FA:5D:4C:6D:B3:F9:F7:2F:F1:93:42:03:
35:78:F0:73:BF:1D:1B:46:CB:B9:12

CN=thawte Primary Root CA, OU="(c) 2006 thawte, Inc. - For authorized use only", OU=Certification Services Division, O="thawte, Inc.", C=US
8D:72:2F:81:A9:C1:13:C0:79:1D:F1:36:A2:96:6D:B2:6C:95:0A:97:1D:
B4:6B:41:99:F4:EA:54:B7:8B:FB:9F

CN=thawte Primary Root CA - G2, OU="(c) 2007 thawte, Inc. - For authorized use only", O="thawte, Inc.", C=US
A4:31:0D:50:AF:18:A6:44:71:90:37:2A:86:AF:AF:8B:95:1F:FB:43:1D:
83:7F:1E:56:88:B4:59:71:ED:15:57

CN=thawte Primary Root CA - G3, OU="(c) 2008 thawte, Inc. - For authorized use only", OU=Certification Services Division, O="thawte, Inc.", C=US
4B:03:F4:58:07:AD:70:F2:1B:FC:2C:AE:71:C9:FD:E4:60:4C:06:4C:F5:
FF:B6:86:BA:E5:DB:AA:D7:FD:D3:4C

EMAILADDRESS=premium-server@thawte.com, CN=Thawte Premium Server CA, OU=Certification Services Division, O=Thawte Consulting cc, L=Cape Town, ST=Western Cape, C=ZA
3F:9F:27:D5:83:20:4B:9E:09:C8:A3:D2:06:6C:4B:57:D3:A2:47:9C:36:
93:65:08:80:50:56:98:10:5D:BC:E9

OU=VeriSign Trust Network, OU="(c) 1998 VeriSign, Inc. - For authorized use only", OU=Class 2 Public Primary Certification Authority - G2, O="VeriSign, Inc.", C=US
3A:43:E2:20:FE:7F:3E:A9:65:3D:1E:21:74:2E:AC:2B:75:C2:0F:D8:98:
03:05:BC:50:2C:AF:8C:2D:9B:41:A1

OU=Class 3 Public Primary Certification Authority, O="VeriSign, Inc.", C=US
A4:B6:B3:99:6F:C2:F3:06:B3:FD:86:81:BD:63:41:3D:8C:50:09:CC:4F:
A3:29:C2:CC:F0:E2:FA:1B:14:03:05

OU=VeriSign Trust Network, OU="(c) 1998 VeriSign, Inc. - For authorized use only", OU=Class 3 Public Primary Certification Authority - G2, O="VeriSign, Inc.", C=US
83:CE:3C:12:29:68:8A:59:3D:48:5F:81:97:3C:0F:91:95:43:1E:DA:37:
CC:5E:36:43:0E:79:C7:A8:88:63:8B

CN=VeriSign Class 3 Public Primary Certification Authority - G3, OU="(c) 1999 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
EB:04:CF:5E:B1:F3:9A:FA:76:2F:2B:B1:20:F2:96:CB:A5:20:C1:B9:7D:
B1:58:95:65:B8:1C:B9:A1:7B:72:44

CN=VeriSign Class 3 Public Primary Certification Authority - G4, OU="(c) 2007 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
69:DD:D7:EA:90:BB:57:C9:3E:13:5D:C8:5E:A6:FC:D5:48:0B:60:32:
39:BD:C4:54:FC:75:8B:2A:26:CF:7F:79

CN=VeriSign Class 3 Public Primary Certification Authority - G5, OU="(c) 2006 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
9A:CF:AB:7E:43:C8:D8:80:D0:6B:26:2A:94:DE:EE:E4:B4:65:99:89:C3:
D0:CA:F1:9B:AF:64:05:E4:1A:B7:DF

CN=VeriSign Universal Root Certification Authority, OU="(c) 2008 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
23:99:56:11:27:A5:71:25:DE:8C:EF:EA:61:0D:DF:2F:A0:78:B5:C8:06:
7F:4E:82:82:90:BF:B8:60:E8:4B:3C

Subordinate Certificates to be distrusted after 2019-12-31
Distinguished Name	SHA-256 Fingerprint
CN=Apple IST CA 2 - G1, OU=Certification Authority, O=Apple Inc., C=US
AC:2B:92:2E:CF:D5:E0:17:11:77:2F:EA:8E:D3:72:DE:9D:1E:22:45:FC:E3:F5:7A:9C:DB:
EC:77:29:6A:42:4B

CN=Apple IST CA 8 - G1, OU=Certification Authority, O=Apple Inc., C=US
A4:FE:7C:7F:15:15:5F:3F:0A:EF:7A:AA:83:CF:6E:06:DE:B9:7C:A3:F9:09:DF:92:0A:C1:
49:08:82:D4:88:ED

If you have a TLS Server certificate issued by one of the CAs above, you should have received a message from DigiCert with information about replacing that certificate, free of charge.

You can also use the keytool utility from the JDK to print out details of the certificate chain, as follows:

keytool -v -list -alias <your_server_alias> -keystore <your_keystore_filename>
If any of the certificates in the chain are issued by one of the root CAs in the table above are listed in the output you will need to update the certificate or contact the organization that manages the server if not yours.

See JDK-8207258


Top

Differences Between Oracle JDK and Oracle's OpenJDK
Although we have stated the goal to have OpenJDK and Oracle JDK binaries be as close to each other as possible there remains, at least for JDK 12, several differences between the two options.

The current differences are:

Oracle JDK offers "installers" (msi, rpm, deb, etc.) which not only place the JDK binaries in your system but also contain update rules and in some cases handle some common configurations like set common environmental variables (such as, JAVA_HOME in Windows) and establish file associations (such as, use java to launch .jar files). OpenJDK is offered only as compressed archive (tar.gz or .zip).
javac —release for release values 9 and 10 behave differently. Oracle JDK binaries include APIs that were not added to OpenJDK binaries such as javafx, resource management, and (pre JDK 11 changes) JFR APIs.
Usage Logging is only available in Oracle JDK.
OpenJDK continues to throw an error and halt if the -XX:+UnlockCommercialFeatures flag is used. Oracle JDK no longer requires the flag and prints a warning but continues execution if used.
Oracle JDK requires that third-party cryptographic providers be signed with a Java Cryptography Extension (JCE) Code Signing Certificate. OpenJDK continues allowing the use of unsigned third-party crypto providers.
The output of java -version is different. Oracle JDK returns java and includes the Oracle-specific identifier. OpenJDK returns OpenJDK and does not include the Oracle-specific identifier.
Oracle JDK is released under the OTN License. OpenJDK is released under GPLv2wCP. License files included with each will therefore be different.
Oracle JDK distributes FreeType under the FreeType license and OpenJDK does so under GPLv2. The contents of \legal\java.desktop\freetype.md is therefore different.
Oracle JDK has Java cup and steam icons and OpenJDK has Duke icons.
Oracle JDK source code includes "ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." Source code distributed with OpenJDK refers to the GPL license terms instead.
