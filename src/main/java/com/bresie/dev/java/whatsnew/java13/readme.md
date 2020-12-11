The intent of this project is to provide example code of what's new in java releases.

I will be trying to get the high level elements from each Java/JDK version and provide samples in code where applicable.  

Some elements involve command line parameters which would require some form of "run configuration" which uses these so in those cases, this may be dependent upon run elements which may be provided as part of a build time "run" tasks which applicable parameters.

This has updates relative to JDK 913
The material here is from the URL listed below.  The intent is to help guide exercise to demonstrate the changes relative to the whatsnew.  

All rights to the material replicated below are with the original authors as spelled out at the original site.

=============================================

https://www.oracle.com/technetwork/java/javase/11all-relnotes-5013287.html



Cumulative Release Notes for JDK 13 and JDK 13 Update Releases

Java™ SE Development Kit 13.0.1 (JDK 13.0.1)
October 15, 2019

The full version string for this update release is 13.0.1+9 (where "+" means "build"). The version number is 13.0.1.

IANA Data 2019b
JDK 13.0.1 contains IANA time zone data version 2019b. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 13.0.1 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
13	13.0.1+9
11	11.0.5+10
8	1.8.0_231-b11
7	1.7.0_241-b09


Keeping the JDK up to Date
Oracle recommends that the JDK is updated with each Critical Patch Update (CPU). In order to determine if a release is the latest, the following Security Baseline page can be used to determine which is the latest version for each release family.

Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. It is not recommended that this JDK (version 13.0.1) be used after the next critical patch update scheduled for January 14, 2020.



Other notes

docs
➜ Using the JDK or JRE on macOS Catalina (10.15)
Changes introduced in macOS 10.15 (Catalina) have caused JCK test failures which will prevent Java from being supported on macOS 10.15. If you still want to install and test then please see http://www.oracle.com/technetwork/java/javase/using-jdk-jre-macos-catalina-5781620.html.

JDK-8230057 (not public)


security-libs/javax.net.ssl
➜ Remove Obsolete NIST EC Curves from the Default TLS Algorithms
This change removes obsolete NIST EC curves from the default Named Groups used during TLS negotiation. The curves removed are sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, and secp256k1.

To re-enable these curves, use the jdk.tls.namedGroups system property. The property contains a comma-separated list within quotation marks of enabled named groups in preference order. For example:

java -Djdk.tls.namedGroups="x25519, secp256r1, secp384r1, secp521r1, x448, sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, secp256k1, ffdhe2048, ffdhe3072, ffdhe4096, ffdhe6144, ffdhe8192" ...
JDK-8228825 (not public)


client-libs
➜ Text Visibility Issues in macOS Dark Mode
A number of bugs have been reported against Dark Mode on macOS which require a fix in the JavaRuntimeSupport framework (JRS); an issue has been filed with Apple:

FB6798883: The JavaRuntimeSupport.framework does not work properly in Dark Mode

See JDK-8231386 and JDK-8228555 for examples of issues caused by this bug.

See JDK-8228555


core-libs/java.lang
➜ Runtime.exec and ProcessBuilder Argument Restrictions
Runtime.exec and ProcessBuilder have been updated in this release to tighten the constraints on the quoting of arguments to processes created by these APIs. The changes may impact applications on Microsoft Windows that are deployed with a security manager. The changes have no impact on applications that are run without a security manager.

In applications where there is no security manager, there is no change in the default behavior and the new restrictions are opt-in. To enable the restrictions, set the system property jdk.lang.Process.allowAmbiguousCommands to false.

In applications where there is a security manager, the new restrictions are opt-out. To revert to the previous behavior set the system property jdk.lang.Process.allowAmbiguousCommands to true.

Applications using Runtime.exec or ProcessBuilder with a security manager to invoke .bat or .cmd and command names that do not end in ".exe" may be more restrictive in the characters accepted for arguments if they contain double-quote, "&", "|", "<", ">", or "^". The arguments passed to applications may be quoted differently than in previous versions.

For .exe programs, embedded double quotes are allowed and are encoded so they are passed to Windows as literal quotes. In the case where the entire argument has been passed with quotes or must be quoted to encode special characters including space and tab, the encoding ensures they are passed to the application correctly. The restrictions are enforced if there is a security manager and the jdk.lang.Process.allowAmbiguousCommands property is "false" or there is no security manager and property is not "false".

JDK-8221858 (not public)


Bug Fixes

This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update.

JDK 13 Release Notes


The following sections are included in these Release Notes:

Introduction

What's New in JDK 13 - New Features and Enhancements

Removed Features and Options

Deprecated Features and Options

Other Notes

Differences Between Oracle JDK and Oracle's OpenJDK





Introduction
These notes describe important changes, enhancements, removed APIs and features, deprecated APIs and features, and other information about JDK 13 and Java SE 13. In some cases, the descriptions provide links to additional detailed information about an issue or a change. This page does not duplicate the descriptions provided by the Java SE 13 ( JSR 388) Platform Specification, which provides informative background for all specification changes and might also include the identification of removed or deprecated APIs and features not described here. The Java SE 13 ( JSR 388) specification provides links to:

Annex 1: The complete Java SE 13 API Specification.

Annex 2: An annotated API specification showing the exact differences relative to Java SE 12. Informative background for these changes may be found in the list of approved Change Specification Requests for this release.

Annex 3: Java SE 13 Editions of The Java Language Specification and The Java Virtual Machine Specification. The Java SE 13 Editions contain all corrections and clarifications made since the Java SE 12 Editions, as well as additions for new features.

You should be aware of the content in that document as well as the items described in this page.

The descriptions on this Release Note page also identify potential compatibility issues that you might encounter when migrating to JDK 13. The Kinds of Compatibility page on the OpenJDK wiki identifies three types of potential compatibility issues for Java programs used in these descriptions:

Source: Source compatibility preserves the ability to compile existing source code without error.

Binary: Binary compatibility is defined in The Java Language Specification as preserving the ability to link existing class files without error.

Behavioral: Behavioral compatibility includes the semantics of the code that is executed at runtime.

See CSRs Approved for JDK 13 for the list of CSRs closed in JDK 13 and the Compatibility & Specification Review (CSR) page on the OpenJDK wiki for general information about compatibility.



IANA Data 2019b
JDK 13 contains IANA time zone data version 2019b. For more information, refer to Timezone Data Versions in the JRE Software.



Top


What's New in JDK 13 - New Features and Enhancements
This section describes some of the enhancements in Java SE 13 and JDK 13. In some cases, the descriptions provide links to additional detailed information about an issue or a change. The APIs described here are those that are provided with the Oracle JDK. It includes a complete implementation of the Java SE 13 Platform and additional Java APIs to support developing, debugging, and monitoring Java applications. Another source of information about important enhancements and new features in Java SE 13 and JDK 13 is the Java SE 13 ( JSR 388) Platform Specification, which documents the changes to the specification made between Java SE 12 and Java SE 13. This document includes descriptions of those new features and enhancements that are also changes to the specification. The descriptions also identify potential compatibility issues that you might encounter when migrating to JDK 13.



core-libs/java.nio
➜ Added FileSystems.newFileSystem(Path, Map<String, ?>) Method
Three new methods have been added to java.nio.file.FileSystems to make it easier to use file system providers that treat the contents of a file as a file system.

newFileSystem(Path)
newFileSystem(Path, Map<String, ?>)
newFileSystem(Path, Map<String, ?>, ClassLoader)
The addition of newFileSystem(Path, Map<String, ?>) creates a source (but not binary) compatibility issue for code that has been using the existing 2-arg newFileSystem(Path, ClassLoader) and specifying the class loader as null. For example, the following cannot be compiled because the reference to newFileSystem is ambiguous:

FileSystem fs = FileSystems.newFileSystem(path, null);

To avoid the ambiguous reference, this code needs to be modified to cast the second parameter to java.lang.ClassLoader.

See JDK-8218875


core-libs/java.nio
➜ New java.nio.ByteBuffer Bulk get/put Methods Transfer Bytes Without Regard to Buffer Position
java.nio.ByteBuffer and the other buffer types in java.nio now define absolute bulk get and put methods to transfer contiguous sequences of bytes without regard to or effect on the buffer position.

See JDK-5029431


core-libs/java.time
➜ New Japanese Era Name Reiwa
An instance representing the new Reiwa era has been added to this update. Unlike other eras, there is no public field for this era. It can be obtained by calling JapaneseEra.of(3) or JapaneseEra.valueOf("Reiwa"). JDK 13 and later will have a new public field to represent this era.

The placeholder name, "NewEra", for the Japanese era that started from May 1st, 2019 has been replaced with the new official name. Applications that relied on the placeholder name (see JDK-8202088) to obtain the new era singleton (JapaneseEra.valueOf("NewEra")) will no longer work.

See JDK-8205432


core-libs/java.util:i18n
➜ Support for Unicode 12.1
This release upgrades Unicode support to 12.1 which includes the following:

java.lang.Character supports Unicode Character Database of 12.1 level, in which 12.0 adds 554 characters since 11.0, for a total of 137,928 characters. These additions include 4 new scripts, for a total of 150 scripts, as well as 61 new emoji characters. 12.1 adds exactly one character, U+32FF SQUARE ERA NAME REIWA, since 12.0.
java.text.Bidi and java.text.Normalizer classes support 12.0 level of Unicode Standard Annexes, #9 and #15, respectively.
java.util.regex package supports Extended Grapheme Clusters based on 12.0 level of Unicode Standard Annex #29
See JDK-8221431


hotspot/gc
➜ JEP 351 ZGC Uncommit Unused Memory
ZGC was enhanced to return unused heap memory to the operating system. This is useful for applications and environments where memory footprint is a concern.

This feature is enabled by default, but can be explicitly disabled using -XX:-ZUncommit. Furthermore, memory will not be uncommitted so that the heap size shrinks below the minimum heap size (-Xms). This means this feature will be implicitly disabled if the minimum heap size (-Xms) is configured to be equal to the maximum heap size (-Xmx).

An uncommit delay can be configured using -XX:ZUncommitDelay=<seconds> (defaults to 300 seconds). This delay specifies for how long memory should have been unused before it's eligible for uncommit.

For more details, see (JEP 351).

See JDK-8220347


hotspot/gc
➜ Added -XXSoftMaxHeapSize Flag
The manageable command-line flag -XX:SoftMaxHeapSize=<bytes> has been added. Currently, it only has an effect when the Z garbage collector is enabled (-XX:+UseZGC).

When set, the GC will strive to not grow the heap beyond the specified size, unless the GC decides it's necessary to do so to avoid OutOfMemoryError. The soft max heap size is not allowed to be set to a value greater than the maximum heap size (-Xmx). When not set on the command line, it defaults to a value equal to the maximum heap size.

Being manageable, its value can be adjusted at runtime. For example, its value can be adjusted by using jcmd VM.set_flag SoftMaxHeapSize <bytes> or through the HotSpot MXBean.

Setting this flag can be useful in a number of situations, such as:

In environments where resource usage is a concern, you might want to keep the heap footprint down while also retaining the capability to deal with a temporary increase in heap space requirement.

When using a concurrent GC (such as ZGC), you might want to play it safe and increase the confidence level that you will not run into an allocation stall because of an unforeseen increase in allocation rate. Setting a soft max heap size encourages the GC to maintain a smaller heap, which means the GC will collect garbage more aggressively than it otherwise would, making it more resilient to a sudden increase in the application allocation rate.

See JDK-8222145


hotspot/gc
➜ ZGC Maximum Heap Size Increased to 16TB
The maximum supported heap size for ZGC was increased from 4TB to 16TB.

See JDK-8221786


hotspot/runtime
➜ JEP 350 Dynamic CDS Archiving
JEP 350 extends application class-data sharing (AppCDS) to allow the dynamic archiving of classes as a Java application is exiting. It also improves the usability of AppCDS by eliminating the need for users to do trial runs to create a class list for each application. The existing static archiving enabled by the -Xshare:dump option, using a class list, continues work as is.

The dynamically-generated archive is created on top of the default system archive packaged with the running JDK image. A separate top-layer archive file is generated for each application. The user can specify the filename of the dynamic archive name as the argument to the -XX:ArchiveClassesAtExit option. For example, the following command creates hello.jsa:

      % bin/java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello
To run the same application using this dynamic archive:

     % bin/java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello
The user could also specify both the base and the dynamic archives in the -XX:SharedArchiveFile option such as:

     -XX:SharedArchiveFile=<base archive>:<dynamic archive>
CSR JDK-8221706 has more details on the command line option.

See JDK-8207812


security-libs/java.security
➜ Configurable Read Timeout for CRLs
The com.sun.security.crl.readtimeout system property sets the maximum read timeout for CRL retrievals, in seconds. If the property has not been set, or if its value is negative, it is set to the default value of 15 seconds. A value of 0 means an infinite timeout.

See JDK-8191808


security-libs/java.security
➜ New keytool -showinfo -tls Command for Displaying TLS Configuration Information
A new keytool -showinfo -tls command has been added that displays TLS configuration information.

See JDK-8219861


security-libs/javax.crypto
➜ Support for MS Cryptography Next Generation (CNG)
The SunMSCAPI provider now supports reading private keys in Cryptography Next Generation (CNG) format. This means that RSA and EC keys in CNG format are loadable from Windows keystores, such as "Windows-MY". Signature algorithms related to EC (SHA1withECDSA, SHA256withECDSA, etc.) are also supported.

See JDK-8026953


security-libs/javax.crypto:pkcs11
➜ SunPKCS11 Provider Upgraded with Support for PKCS#11 v2.40
The SunPKCS11 provider has been updated with support for PKCS#11 v2.40. This version adds support for more algorithms such as the AES/GCM/NoPadding cipher, DSA signatures using SHA-2 family of message digests, and RSASSA-PSS signatures when the corresponding PKCS11 mechanisms are supported by the underlying PKCS11 library.

See JDK-8080462


security-libs/javax.net.ssl
➜ Support for X25519 and X448 in TLS
The named elliptic curve groups x25519 and x448 are now available for JSSE key agreement in TLS versions 1.0 to 1.3, with x25519 being the most preferred of the default enabled named groups. The default ordered list is now:

     x25519, secp256r1, secp384r1, secp521r1, x448,
  sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1,
  secp256k1,
  ffdhe2048, ffdhe3072, ffdhe4096, ffdhe6144, ffdhe8192
The default list can be overridden using the system property jdk.tls.namedGroups.

See JDK-8171279


security-libs/javax.net.ssl
➜ Session Resumption without Server-Side State in JSSE
The feature allows for the server-side of JSSE to operate stateless. As described in RFC 50771 for TLS 1.2 and below, and RFC 84462 for TLS 1.3, the TLS server sends internal session information in the form of an encrypted session ticket to a client that supports stateless. That session ticket is presented to the server during the TLS handshake to resume the session. This should improve the performance and memory usage of the TLS server under large workloads as the session cache will seldom be used. With less session information cached, some session information may not be available. This feature is not enabled by default and can be turned on by setting two properties.

Note that invalidated stateless TLS sessions could be resumed in the current implementation. The behavior is not guaranteed to be the same in future releases and updates (see bugid JDK-8229148).

Note that in the current implementation, the return value of SSLSession.getID() is not persistent across resumption for TLS 1.3 and stateless TLS 1.2 connections. This could be an issue if applications rely on the session identifier values. This may change to be consistent a future release (see bugid JDK-8229149).

Two new System properties are added in support of this feature: jdk.tls.client.enableSessionTicketExtension is used on the client side to toggle the Session Ticket Extension on the ClientHello message for TLS 1.2. Property value: "true" sends the extension, "false" does not (default).

jdk.tls.server.enableSessionTicketExtension enables a server to use stateless session tickets if the client supports it. Clients that do not support stateless session tickets will use the cache. Property value: "true" enables stateless, "false" does not (default).

See JDK-8211018


security-libs/javax.security
➜ Allow SASL Mechanisms to Be Restricted
A security property named jdk.sasl.disabledMechanisms has been added that can be used to disable SASL mechanisms. Any disabled mechanism will be ignored if it is specified in the mechanisms argument of Sasl.createSaslClient or the mechanism argument of Sasl.createSaslServer. The default value for this security property is empty, which means that no mechanisms are disabled out-of-the-box.

See JDK-8200400


security-libs/javax.xml.crypto
➜ New String Constants for Canonical XML 1.1 URIs
New String constants named INCLUSIVE_11 and INCLUSIVE_11_WITH_COMMENTS have been added to the javax.xml.crypto.dsig.CanonicalizationMethod API. These represent the URIs for the Canonical XML 1.1 and Canonical XML 1.1 with Comments algorithms for XML Signature.

See JDK-8224767


security-libs/javax.xml.crypto
➜ [xmldsig] Added KeyValueEC_TYPE
The ECKeyValue type as described in the W3C Recommendation for XML-Signature Syntax and Processing is now supported. A new EC_TYPE constant has been added to the javax.xml.crypto.dsig.keyinfo.KeyValue interface. Please note that only the NamedCurve domain parameter type is currently supported, and the ECParameters explicit curve parameter type is not supported.

See JDK-8223053


security-libs/org.ietf.jgss
➜ Added a Default Native GSS-API Library on Windows
A native GSS-API library has been added to JDK on the Windows platform. The library is client-side only and uses the default credentials. It will be loaded when the sun.security.jgss.native system property is set to "true". A user can still load a third-party native GSS-API library by setting the system property sun.security.jgss.lib to its path.

See JDK-6722928


security-libs/org.ietf.jgss:krb5
➜ Support for Kerberos Cross-Realm Referrals (RFC 6806)
The Kerberos client has been enhanced with the support of principal name canonicalization and cross-realm referrals, as defined by the RFC 6806 protocol extension.

As a result of this new feature, the Kerberos client can take advantage of more dynamic environment configurations and does not necessarily need to know (in advance) how to reach the realm of a target principal (user or service).

Support is enabled by default and 5 is the maximum number of referral hops allowed. To turn it off, set the sun.security.krb5.disableReferrals security or system property to false. To configure a custom maximum number of referral hops, set the sun.security.krb5.maxReferrals security or system property to any positive value.

See further information in JDK-8223172.

See JDK-8215032


tools/javac
➜ JEP 354 Switch Expressions (Preview)
Extend switch so it can be used as either a statement or an expression, and so that both forms can use either traditional case ... : labels (with fall through) or new case ... -> labels (with no fall through), with a further new statement for yielding a value from a switch expression. These changes will simplify everyday coding, and prepare the way for the use of pattern matching in switch. This is a preview language feature in JDK 13.

See JDK-8222184


tools/javac
➜ JEP 355 Text Blocks (Preview)
Add text blocks to the Java language. A text block is a multi-line string literal that avoids the need for most escape sequences, automatically formats the string in a predictable way, and gives the developer control over format when desired. This is a preview language feature in JDK 13.

JDK-8223930 (not public)


xml/jaxp
➜ New Methods for Creating DOM and SAX Factories with Namespace Support
New methods have been added for instantiating DOM and SAX factories with Namespace support by default. These methods are prefixed over their existing counterparts with "NS," which stands for NamespaceAware. Below is a list of the new methods:

newDefaultNSInstance()
newNSInstance()
newNSInstance(String factoryClassName, ClassLoader classLoader)
Using these new methods, a parser created through the factory will be NamespaceAware by default. For example, the following statement:

DocumentBuilder db = DocumentBuilderFactory.newDefaultNSInstance().newDocumentBuilder();
is equivalent to:

DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
dbf.setNamespaceAware(true);
DocumentBuilder db = dbf.newDocumentBuilder();
See JDK-8219692




Top


Removed Features and Options
This section describes the APIs, features, and options that were removed in Java SE 13 and JDK 13. The APIs described here are those that are provided with the Oracle JDK. It includes a complete implementation of the Java SE 13 Platform and additional Java APIs to support developing, debugging, and monitoring Java applications. Another source of information about important enhancements and new features in Java SE 13 and JDK 13 is the Java SE 13 ( JSR 388) Platform Specification, which documents changes to the specification made between Java SE 12 and Java SE 13. This document includes the identification of removed APIs and features not described here. The descriptions below might also identify potential compatibility issues that you could encounter when migrating to JDK 13. See CSRs Approved for JDK 13 for the list of CSRs closed in JDK 13.





client-libs
➜ Removal of awt.toolkit System Property
Historically (up to JDK 1.8), documentation for the java.awt.Toolkit class referred to the "awt.toolkit" system property, which was set to the name of the platform implementation subclass. The documentation of this property was removed in JDK 9 because (1) it was an internal detail not intended to be a supported interface and (2) encapsulation by the module system meant that the class could not be directly manipulated. However, the system property was not removed until now. Applications that previously read this property can still, if necessary, obtain it by instantiating the AWT Toolkit and querying the class name via that instance.

See JDK-8212700


core-libs/java.lang
➜ Removal of Runtime Trace Methods
The obsolete methods traceInstructions(boolean) and traceMethodCalls(boolean) have been removed from the java.lang.Runtime class. These methods have been non-functional for many releases, and their intended functions are provided by the Java Virtual Machine Tool Interface (JVMTI).

See JDK-8205131


core-libs/java.net
➜ Pre-JDK 1.4 SocketImpl Implementations No Longer Supported
Support for custom java.net.SocketImpl implementations compiled for Java SE 1.3 and older has been removed in this release. This change has no impact on SocketImpl implementations compiled for Java SE 1.4 (released in 2002) or newer.

See JDK-8216978


hotspot/runtime
➜ Removal of VM option -XX+AggressiveOpts
The VM option -XX:+AggressiveOpts was deprecated in JDK 11 and support for it was removed in JDK 12 (where its use was ignored other than generating a warning). Use of this flag will now cause an error on VM initialization.

See JDK-8216188


security-libs
➜ Duplicated RSA Services No Longer Supported by SunJSSE Provider
Support for RSA KeyFactory, RSA KeyPairGenerator, MD2withRSA, MD5withRSA, and SHA1withRSA Signature has been removed from SunJSSE provider.

Since JDK 5, SunRsaSign provider was introduced to support these RSA-related algorithms. The only reason for SunJSSE provider to support these was for backward-compatibility with pre-JDK 5 applications. Removal should only impact applications that explicitly request these RSA services from SunJSSE provider. Applications should remove the hardcoded "SunJSSE" provider name.

See JDK-8220016


security-libs/java.security
➜ Removal of T-Systems Deutsche Telekom Root CA 2 Certificate
The T-Systems Deutsche Telekom Root CA 2 certificate has expired and was removed from the cacerts keystore:

alias name "deutschetelekomrootca2 [jdk]"

Distinguished Name: CN=Deutsche Telekom Root CA 2, OU=T-TeleSec Trust Center, O=Deutsche Telekom AG, C=DE

See JDK-8222137


security-libs/java.security
➜ Removal of Two DocuSign Root CA Certificates
Two DocuSign root CA certificates have expired and were removed from the cacerts keystore:

alias name "certplusclass2primaryca [jdk]"

Distinguished Name: CN=Class 2 Primary CA, O=Certplus, C=FR

alias name "certplusclass3pprimaryca [jdk]"

Distinguished Name: CN=Class 3P Primary CA, O=Certplus, C=FR

See JDK-8223499


security-libs/java.security
➜ Removal of Two Comodo Root CA Certificates
Two Comodo root CA certificates have expired and were removed from the cacerts keystore:

alias name "utnuserfirstclientauthemailca [jdk]"

Distinguished Name: CN=UTN-USERFirst-Client Authentication and Email, OU=http://www.usertrust.com, O=The USERTRUST Network, L=Salt Lake City, ST=UT, C=US

alias name "utnuserfirsthardwareca [jdk]"

Distinguished Name: CN=UTN-USERFirst-Hardware, OU=http://www.usertrust.com, O=The USERTRUST Network, L=Salt Lake City, ST=UT, C=US

See JDK-8222136


security-libs/javax.net.ssl
➜ Removal of the Internal com.sun.net.ssl Package Only Used for Compatibility with Legacy JSSE 1.0 Applications
The internal package com.sun.net.ssl has been removed from the JDK. Prior to Java SE 1.4, when JSSE was shipped as a standalone product, the com.sun.net.ssl APIs were supported, but since Java SE 1.4, the package was deprecated and intended for internal use only. Standard replacement APIs such as HostNameVerifier, KeyManager, and TrustManager have been available in the javax.net.ssl package since Java SE 1.4. Although applications should have transitioned to the standard APIs, this note is a final warning that these non-standard APIs have been removed.

See JDK-8215430


security-libs/javax.net.ssl
➜ Removal of Experimental FIPS 140 Compliant Mode from SunJSSE Provider
The experimental FIPS 140 compliant mode has been removed from the SunJSSE provider.

Legacy applications might have used the experimental mode with one of the following approaches:

1. Updating the java.security file and specifying a crypto provider for the SunJSSE provider (for example, security.provider.4=com.sun.net.ssl.internal.ssl.Provider SunPKCS11-NSS)

2. Using the JDK internal class and creating a provider with a specified crypto provider (for example, new com.sun.net.ssl.internal.ssl.Provider(cryptoProvider);).
Because the SunJSSE provider uses JDK default cryptography providers, applications can configure the security.provider security properties to use the FIPS 140 compliant cryptography providers.

See JDK-8217835


tools/javadoc(tool)
➜ Removal of Old Features from javadoc Tool
The following four features have been removed from the javadoc tool:

Support for generating API documentation using HTML 4: Support for HTML 5 was added in JDK 9 and has been the default since JDK 11. To generate API documentation that is fully compliant with the HTML 5 specification, developers should ensure that any use of HTML tags in their documentation comments is also compliant with the HTML 5 specification.

Support for the "old" javadoc API: This includes the API (com.sun.javadoc), the old standard doclet (com.sun.tools.doclets.standard), and the old entry point (com.sun.tools.javadoc.Start), all in the jdk.javadoc module. A new API and a new standard doclet were introduced in JDK 9, leveraging other modern modeling API such as javax.lang.model. The javadoc tool can be programmatically invoked using the javax.tools.DocumentationTool API, or (for simple use) java.util.spi.ToolProvider. Users that just use the javadoc tool to generate standard API documentation are not affected.

Support for generating documentation using HTML frames: It has been replaced by the "Search" feature, added in JDK 9, and by improved index files and links within pages.

Support for the --no-module-directories option: This option provided limited support for the organization used for the generated documentation by the javadoc tool in JDK 9 and 10, in which the files for different modules were not grouped into separate directories.

See JDK-8215608




Top


Deprecated Features and Options
Additional sources of information about the APIs, features, and options deprecated in Java SE 13 and JDK 13 include:

The deprecated API page (API specification) identifies all deprecated APIs including those deprecated in Java SE 13.
The Java SE 13 ( JSR 388) specification documents changes to the specification made between Java SE 12 and Java SE 13 that include the identification of deprecated APIs and features not described here.
JEP 277: Enhanced Deprecation provides a detailed description of the deprecation policy. You should be aware of the updated policy described in this document.
You should be aware of the contents in those documents as well as the items described in this release notes page.

The descriptions of deprecated APIs might include references to the deprecation warnings of forRemoval=true and forRemoval=false. The forRemoval=true text indicates that a deprecated API might be removed from the next major release. The forRemoval=false text indicates that a deprecated API is not expected to be removed from the next major release but might be removed in some later release.

The descriptions below also identify potential compatibility issues that you might encounter when migrating to JDK 13. See CSRs Approved for JDK 13 for the list of CSRs closed in JDK 13.




client-libs
➜ Deprecated and Unsupported Swing Motif Look and Feel on macOS
Swing Motif Look and Feel is unsupported on macOS in JDK 13.

In the source code, Swing Motif Look and Feel is deprecated with the intent to remove it in a future release. Use javax.swing.plaf.metal.MetalLookAndFeel instead.

See JDK-8177960


core-libs/java.rmi
➜ Deprecated rmic Tool for Removal
The rmic tool has been deprecated and may be removed from a future release. The rmic tool was used to create static stubs that support the Java Remote Method Protocol (JRMP) used by the Java Remote Method Invocation (RMI) facility. Statically generated stubs are obsolete and were replaced by dynamically generated stubs in Java SE 5.0. Dynamically generated stubs no longer require pregeneration using a tool such as rmic, and they are functionally equivalent to statically generated stubs. RMI applications should be migrated to use dynamically generated RMI stubs by changing the way remote objects are exported. See the class documentation for java.rmi.server.UnicastRemoteObject for further details.

See JDK-8217412




hotspot/runtime
➜ Deprecated Java Options -Xverifynone and -noverify
The Java options -Xverify:none and -noverify have been deprecated in this release. The options will continue to work as intended but will generate the following warning when used:

warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.
Deprecating these options helps prevent users from running code that violates the JVM Specification, which can leave their applications open to malicious code.

Users who need to run without startup verification can use AppCDS to archive their classes. The classes are verified during archiving and avoid verification at runtime.

Note that if you encounter issues while using either of these options, it is very likely that you will be required to reproduce the problem without using these options before Oracle Support can assist with an investigation.

See JDK-8214719


security-libs/javax.net.ssl
➜ Deprecated javax.security.cert APIs with forRemoval=true
The javax.security.cert API has been deprecated and marked for removal. The classes in this package should no longer be used. The java.security.cert package contains suitable replacements.

See JDK-8160247


Top


Other notes
 The following notes describe additional changes and information about this release. In some cases, the following descriptions provide links to additional detailed information about an issue or a change.


client-libs
➜ GraphicsEnvironment.getCenterPoint() and getMaximumWindowBounds() are Unified Across Platforms
Two methods were added to the GraphicsEnvironment class in JDK 1.4:

getCenterPoint()
getMaximumWindowBounds()
See https://docs.oracle.com/javase/7/docs/technotes/guides/awt/1.4/AWTChanges.html#windowCentering.

The page in the preceding link includes the following description:

"X-Window, Xinerama All monitors share a single virtual coordinate space, as on Microsoft Windows. However, it is possible for the user to specify through X resources where windows should be centered. If these resources are set, getCenterPoint reflects their value. Otherwise, it returns the point at the center of the virtual coordinate space. (In practice, this will almost always be set - CDE sets it by default.)"

Now, in JDK 13, the implementation of getCenterPoint() and getMaximumWindowBounds() has been unified across the platforms (Windows, Linux, Solaris, and macOS):

getCenterPoint returns the coordinates of the center of the primary display, for all platforms.
getMaximumWindowBounds returns the bounds of the primary display minus display insets, for all platforms.
See JDK-8214918


client-libs/2d
➜ Windows 2019 Core Server Is Not Supported
Windows Core Server 2019 does not ship a dll required by JDK in order to run. Specifically, if a Java application, including a headless one, requires awt.dll, the Java runtime will exit with an exception. There is no workaround. Until this is resolved, this Windows Server configuration is not supported.

See JDK-8229800


core-libs
➜ Improved Handling of the "Class-Path" JAR Manifest Attribute
The JAR file specification has been updated to clarify what constitutes a valid entry for the Class-Path JAR Manifest Attribute. See the JAR file specification for further details.

Invalid entries are now ignored. Applications relying on invalid Class-Path entries may see a ClassNotFoundException. A system property has been added to aid in debugging the Class-Path attribute. When the "jdk.net.URLClassPath.showIgnoredClassPathEntries" property is set to true, invalid Class-Path entries will be printed to the console.

See JDK-8211941


core-libs/java.lang
➜ StringBuffer(CharSequence) and StringBuilder(CharSequence) Throw NegativeArraySizeException for Negatively Sized Argument
The behavior of StringBuffer(CharSequence) and StringBuilder(CharSequence) is changed for the argument reporting a negative length. The constructors were inconsistently throwing either NegativeArraySizeException or IndexOutOfBoundException. The new behavior is to always throw NegativeArraySizeException for any argument reporting a negative length.

See JDK-8218228


core-libs/java.lang
➜ Default Process launch mechanism on Linux now uses posix_spawn
Runtime.exec() and ProcessBuilder, on Linux now use posix_spawn(3) to spawn child processes. This increases reliability and performance in low-memory situations.

See JDK-8213192


core-libs/java.lang.invoke
➜ Lookup.unreflectSetter(Field) Now Throws IllegalAccessException for Static Final Fields
java.lang.invoke.MethodHandles.Lookup::unreflectSetter returns a MethodHandle giving write access to the given Field object. A Field object for a static final field does not have write access even if its accessible flag is true (i.e. Field.setAccessibe(true) has been called). In JDK 13, Lookup::unreflectSetter is fixed to throw IllegalAccessException if the given Field object is a static final field.

See JDK-8216558


core-libs/java.net
➜ Change to Default Implementation of SocketImpl Methods supportedOptions, getOption, and setOption
The default implementation of the supportedOptions(), getOption(SocketOption<T>) and setOption(SocketOption<T>, T) methods, defined by java.net.SocketImpl and java.net.DatagramSocketImpl, have changed in this release. The default implementation of the supportedOptions() method has been changed to return an empty set. The default implementations of the getOption(SocketOption<T>) and setOption(SocketOption<T>, T) methods have been changed to throw UnsupportedOperationException.

Developers extending java.net.SocketImpl or java.net.DatagramSocketImpl to create their own socket or datagram socket implementations need to override these methods to support the socket options that the custom socket implementation supports.

See JDK-8224477


core-libs/java.net
➜ Change to ServerSocket.accept() When the System-Wide Factory for Client or Server Socket Implementations Is Set
Developers using the java.net.Socket.setSocketImplFactory or java.net.ServerSocket.setSocketFactory APIs to change the system-wide factories for client socket or server socket implementations should note the following changes:

1.Invoking ServerSocket::accept on a ServerSocket using a system-default SocketImpl to accept a connection will always return a Socket with a system-default SocketImpl. In this case, the system-wide factory for client socket implementations will not be invoked to create the client socket implementation.


2.java.net.ServerSocket::implAccept has been changed to disallow a ServerSocket using a system-default SocketImpl from accepting a connection with a Socket using a custom SocketImpl. It has also been changed to disallow a ServerSocket using a custom SocketImpl to accept a connection with a Socket using a system-default SocketImpl. Disallowing these nonsensical combinations of SocketImpl improves reliability in cases where an application sets one, but not both, socket implementation factories.


The changes should have no impact on applications that set the same factory for both client and server socket implementations.

See JDK-8220493


core-libs/java.net
➜ JEP 353 Reimplement the Legacy Socket API
The underlying implementation for the java.net.Socket and java.net.ServerSocket APIs has been replaced in this release. JEP 353 provides all the details on this change.

Every effort has been made to ensure that the new implementation is compatible with the old implementation but it is possible that there is existing code that depends on unspecified behavior in corner cases where the old and new implementations behave differently. The JDK continues to include the old implementation (known as "PlainSocketImpl" or the "plain" implementation) to allow such code continue to run. The old implementation is selected by running with the system property "jdk.net.usePlainSockteImpl" set, or set to the value "true", i.e. run with -Djdk.net.usePlainSocketImpl or -Djdk.net.usePlainSocketImpl=true. The property can also be configured in the JDK network configuration file, located in ${java.home}/conf/net.properties. The old implementation, and the system property to select the old implementation, will be removed in a future release.

See JDK-8221481


core-libs/java.nio
➜ Files.createSymbolicLink Can Be Used in "Developer Mode" Without Additional Privileges
On Microsoft Windows, java.nio.file.Files.createSymbolicLink has been changed so that it can now be used to create symbolic links when the process is not elevated but the user is running in "Developer Mode". This may be useful for tools and other development time tasks that need to create symbolic links without requiring additional privileges.

See JDK-8218418


core-libs/java.nio
➜ JNI NewDirectByteBuffer Creates Direct Buffer That Is java.nio.ByteOrder.BIG_ENDIAN
The Java Native Interface (JNI) specification has been clarified in this release to specify that the NewDirectByteBuffer function creates a direct buffer that is always big-endian (high byte first; java.nio.ByteOrder.BIG_ENDIAN). This aligns the specification with long standing behavior (JDK 1.4, released in 2002) so it does not affect existing code.

See JDK-5043362


core-libs/java.nio
➜ Files.isHidden Returns true for Hidden Directories on Windows
On Microsoft Windows, the java.nio.file.Files.isHidden method has historically ignored the DOS "hidden" attribute on directories. This has been fixed in this release so that isHidden now returns true when invoked to test a directory that has this attribute set.

See JDK-8215467


core-libs/java.nio.charsets
➜ Corrected UnicodeDecoder U+FFFE Handling
The behavior of decoding the code point U+FFFE in the middle of the buffer has been corrected for StandardCharsets.UTF_16[LE/BE]. The decoders have been reporting the code point as "malformed". They now pass through the code point in order to conform to the Unicode Consortium's Corrigendum#9.

See JDK-8216140


core-libs/java.time
➜ DateTimeFormatter now throws DateTimeParseException on Invalid HOUR_OF_AMPM
The parsing behavior of DateTimeFormatter with HOUR_OF_AMPM has changed. It now correctly throws a DateTimeParseException with an out-of-bounds input values, such as 12.

See JDK-8223773


core-libs/java.util
➜ Base64.Encoder and Base64.Decoder Methods Can Throw OutOfMemoryError
The behavior of Base64.Encoder.encode and Base64.Decoder.decode methods have been changed for large arrays. The methods previously threw an unspecified exception, such as, NegativeArraySizeException. The new behavior throws an OutOfMemoryError exception if the encode and decode methods fail to allocate the output array/buffer or memory.

See JDK-8210583


core-libs/java.util
➜ Properties Files Containing Malformed Unicode Was Sometimes Misparsed
An IllegalArgumentException is always thrown now when loading a properties file with malformed unicode sequences. Previously, a malformed unicode sequence appearing at the end of a line was parsed using the contents of the preceding line, which in rare cases meant it could be parsed as a valid (but likely incorrect) sequence.

See JDK-8224240


core-libs/java.util.jar
➜ Using the ZIP File System (zipfs) Provider to Update a ZIP or JAR File Containing Uncompressed Entries Might Corrupt the File
Using the ZIP File System (zipfs) to update a JAR or ZIP file might corrupt that file. Corruption occurs only if the JAR or ZIP file contains a non-compressed entry. If the JAR or ZIP file contains only compressed entries, as is typical, then no data corruption occurs.

As a workaround, users can use the jar tool or the java.util.zip API to update JAR or ZIP files that contain non-compressed entries.

See JDK-8229887


core-libs/java.util.logging
➜ NullPointerException in java.util.logging.Handler#isLoggable
The default implementation of java.util.logging.Handler.isLoggable has been updated to match its specification and to return false if the record parameter is null. The implementation of java.util.logging.MemoryHandler.isLoggable and java.util.logging.MemoryHandler.publish will no longer throw NullPointerException if the record parameter is null, which conforms to their specification.

See JDK-8216363


core-libs/java.util:i18n
➜ Upgraded CLDR to Version 35.1
Locale data based on Unicode Consortium's CLDR has been upgraded to their version 35.1, which includes several localized display names for the Japanese new era, Reiwa. There are some notable locale data changes, such as year formatting in Dutch locale (JDK-8225240) and French grouping separator change (JDK-8225245). For the detailed locale data changes, please refer to the cumulative CLDR changes from the previously supported version v.33. The following are links to each CLDR upgrade release:

CLDR 33.1: http://cldr.unicode.org/index/downloads/cldr-33-1
CLDR 34: http://cldr.unicode.org/index/downloads/cldr-34
CLDR 35, 35.1: http://cldr.unicode.org/index/downloads/cldr-35
See JDK-8221432


hotspot/compiler
➜ More Registers Available When Running Without Compressed References on x86_64
When running with compressed references on x86_64, one of the CPU registers holds the heap base pointer to be used for references encoding/decoding. This register is not available for register allocation.

Simple implementations before this release made this register unavailable (and thus unused) even if compressed references were disabled. In this release, the implementation was revised to put this unused register back into the available registers pool. Configurations with large heaps and/or -XX:-UseCompressedOops benefit from this improvement.

See JDK-8217909


hotspot/gc
➜ Improve Ergonomics for Sparse PRT Entry Size
This enhancement changes the ergonomics for sizing the lowest level (most quickly to access, but taking most space per element) remembered set memory storage in G1 called Sparse PRTs.

The number of entries now grow exponentially with region size instead of linearly. This means that G1 uses 4/8/16/32/62/128 entries per Sparse PRT if configured for 1/2/4/8/16/32 MB regions respectively instead of 4/8/12/16/20/24 entries.

With this change, G1 uses significantly less memory for remembered sets for applications requiring a significant amount of remembered sets. This may also result in decreased garbage collection pause times in these cases.

The ergonomically determined values may be overridden using the -XX:G1RSetSparseRegionEntries option as before.

See JDK-8223162


hotspot/gc
➜ Improvements in Serial GC Young pause time report
With Serial GC, when Young GC fails and upgrades to Full GC, the logging messages may be confusing. In previous releases, the log would say both "Pause Full" and "Pause Young" finished at the same time, leading to double-counting the pause time. In this release, the logging is fixed to properly reflect times spent in "Young" and "Full" collections. See more at JDK-8215221.

See JDK-8215221


hotspot/gc
➜ Improve the Behavior of MaxRAM Settings and UseCompressedOops
The behavior of several GC Heap selection flags have been changed to better meet the expectation of users.

Prior to this change, if the heap size selection resulting from the use of these flags exceeded the maximum reachable address when UseCompressedOops is enabled, the heap size would be truncated to be within the CompressedOops range. Also, the percentage or fractional calculation performed was based on the value of MaxRAM and not the amount of physical memory available in the system. The following are the options impacted by this change:

-XX:MaxRAMPercentage
-XX:MaxRAMFraction
-XX:MinRAMPercentage
-XX:MinRAMFraction
-XX:InitialRAMPercentage
-XX:InitialRAMFraction
-XX:MaxRAM
The new behavior calculates the percentage or fraction based on the host's available memory unless the user also specifies -XX:MaxRAM. In addition, UseCompressedOops is automatically disabled if the heap size resulting from the use of any of these options, including -XX:MaxRAM, is greater than can be addressed in CompressedOops mode, unless the -XX:+UseCompressedOops option is specified to override this behavior.

Note: This change only impacts 64-bit platforms.

See JDK-8222252


security-libs/javax.crypto
➜ Use SunJCE Mac in SecretKeyFactory PBKDF2 Implementation
The SunJCE implementation of the PBKDF2 SecretKeyFactory will now exclusively use the SunJCE Mac service for the underlying pseudorandom function (PRF). This fixes an issue where 3rd party JCE providers in rare cases could cause the SunJCE PBKDF2 SecretKeyFactory's underlying pseudorandom function (PRF) to fail on Mac.init().

See JDK-8218723


security-libs/javax.crypto:pkcs11
➜ Memory Growth Issue in SunPKCS11 Fixed
A memory growth issue in the SunPKCS11 cryptographic provider that affects the NSS back-end has been fixed.

A system property, sun.security.pkcs11.disableKeyExtraction has been introduced to disable the fix. A "true" value disables the fix, while a "false" value (default) keeps it enabled.

When enabled, PKCS#11 attributes of the NSS native keys are copied to Java byte buffers after key creation. Once used, NSS keys are destroyed and native heap space is freed up. If NSS keys are required again, they are recreated with the previously saved attributes.

Further information and implementation details can be found in the CSR: JDK-8213430.

See JDK-6913047


security-libs/javax.net.ssl
➜ Updated the Default Enabled Cipher Suites Preference
The preference of the default enabled cipher suites has been changed. The compatibility impact should be minimal. If needed, applications can customize the enabled cipher suites and the preference. For more details, refer to the SunJSSE provider documentation and the JSSE Reference Guide documentation.

See JDK-8163326


security-libs/javax.net.ssl
➜ Use Server Cipher Suites Preference by Default
For TLS connections, the cipher suite selection, by default, is updated to use the server cipher suites preference. Applications can configure the behavior by using the SSLParameters.setUseCipherSuitesOrder​() method.

See JDK-8168261


security-libs/javax.xml.crypto
➜ Updated XML Signature Implementation to Apache Santuario 2.1.3
The XML Signature implementation in the java.xml.crypto module has been updated to version 2.1.3 of Apache Santuario. New features include:

Added support for embedding elliptic curve public keys in the KeyValue element
See JDK-8219013


tools/javac
➜ Bad EnclosingMethod Attribute on Classes Declared in Lambdas
If an anonymous or local inner class is declared inside of a lambda, the EnclosingMethod attribute on that class refers to the synthetic lambda method rather than to the method that enclosed the original declaration. The original method should be considered as the closest lexically enclosing method.

The proposed solution to this issue is to point the EnclosingMethod attribute of inner classes declared inside a lambda to the original enclosing method. The Java compiler was updated, so that the EnclosingMethod attribute of anonymous or local inner classes declared inside a lambda point to the method enclosing the declaration.

The following is the related section in the Java Language Specification: JVMS 11 4.7.7: It is the responsibility of a Java compiler to ensure that the method identified via the method_index is indeed the closest lexically enclosing method of the class that contains this EnclosingMethod attribute.

See JDK-8215470


tools/javac
➜ javac Rejects Class Files with Broken EnclosingMethod Attribute
javac now rejects class files that have an invalid EnclosingMethod attribute, in which the name of the enclosing class is not a prefix of the name of the current class, as required by JLS 13.1.

See JDK-8215407


tools/javap
➜ javap Checksum Uses SHA-256
javap includes a checksum of the contents of the class file in verbose output. The checksum is now calculated with the SHA-256 algorithm, instead of the older MD5 algorithm.

See JDK-8225748


tools/jlink
➜ A jrt URI Can Only Encode Paths to Files in /modules Tree
A jrt URL is a hierarchical URI with the syntax jrt:/[$MODULE[/$PATH]]. When using the jrt file system, a java.net.URI object can be created with the java.nio.file.Path::toUri method to encode a normalized path to a file in the /modules tree. A jrt URL cannot encode a path to a file in the /packages tree. The jrt file system provider has been changed in this release so that toUri fails with IOError when it is not possible to encode the file path as a jrt URI. This change might impact tools that assume a URI can be created to locate files in the /packages tree. Tools with paths to files in /packages can use the toRealPath() method to obtain the real path (in /modules) before attempting to convert the file path to a URI.

See JDK-8224946


xml/javax.xml.parsers
➜ Change DOM Parser to Not Resolve EntityReference and Add Text Node with DocumentBuilderFactory.setExpandEntityReferences(false)
The implementation of the ExpandEntityReferences feature was changed to comply with the specification of the DocumentBuilderFactory.setExpandEntityReferences method. Specifically, now when the method is set to false and encounters an entity reference, a DOM parser created by the DocumentBuilderFactory adds the EntityReference node to the DOM tree without the expanded Text node. Before the change, the implementation incorrectly added both nodes.

With the change, the DOM parser no longer reads and resolves entity references when the feature ExpandEntityReferences is set to false. For applications that intend to avoid resolving entity references, it will work as expected.

This change also affects the DOM Load and Save parser. The entities parameter is aligned with the ExpandEntityReferences feature, so that setting the entities parameter to true is equivalent to setting ExpandEntityReferences to false. In the following code snippet, the document will contain EntityReference nodes but not expanded Text nodes:

       LSParser domParser = domImplementationLS.createLSParser(MODE_SYNCHRONOUS, null);
   domParser.getDomConfig().setParameter("entities", true);
   LSInput src = domImplementationLS.createLSInput();
   src.setStringData(source);
   Document document = domParser.parse(src);
Because the references are not resolved, the resulting string will contain entity references without the text when the document is serialized:

       LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
   lsSerializer.getDomConfig().setParameter("format-pretty-print", true);
   String result = lsSerializer.writeToString(document);
See JDK-8206132


Top

Differences Between Oracle JDK and Oracle's OpenJDK
Although we have stated the goal to have OpenJDK and Oracle JDK binaries be as close to each other as possible there remains, at least for JDK 13, several differences between the two options.

The current differences are:

Oracle JDK offers "installers" (msi, rpm, deb, etc.) which not only place the JDK binaries in your system but also contain update rules and in some cases handle some common configurations like set common environmental variables (such as, JAVA_HOME in Windows) and establish file associations (such as, use java to launch .jar files). OpenJDK is offered only as compressed archive (tar.gz or .zip).
javac —release for release values 9 and 10 behave differently. Oracle JDK binaries include APIs that were not added to OpenJDK binaries such as javafx, resource management, and (pre JDK 11 changes) JFR APIs.
Usage Logging is only available in Oracle JDK.
Oracle JDK requires that third-party cryptographic providers be signed with a Java Cryptography Extension (JCE) Code Signing Certificate. OpenJDK continues allowing the use of unsigned third-party crypto providers.
The output of java -version is different. Oracle JDK returns java and includes the Oracle-specific identifier. OpenJDK returns OpenJDK and does not include the Oracle-specific identifier.
Oracle JDK is released under the OTN License. OpenJDK is released under GPLv2wCP. License files included with each will therefore be different.
Oracle JDK distributes FreeType under the FreeType license and OpenJDK does so under GPLv2. The contents of \legal\java.desktop\freetype.md is therefore different.
Oracle JDK has Java cup and steam icons and OpenJDK has Duke icons.
Oracle JDK source code includes "ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." Source code distributed with OpenJDK refers to the GPL license terms instead.
