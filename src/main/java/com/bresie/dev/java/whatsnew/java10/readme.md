The intent of this project is to provide example code of what's new in java releases.

I will be trying to get the high level elements from each Java/JDK version and provide samples in code where applicable.  

Some elements involve command line parameters which would require some form of "run configuration" which uses these so in those cases, this may be dependent upon run elements which may be provided as part of a build time "run" tasks which applicable parameters.

This has updates relative to JDK 10.

The material here is from the URL listed below.  The intent is to help guide exercise to demonstrate the changes relative to the whatsnew.  

All rights to the material replicated below are with the original authors as spelled out at the original site.

=============================================

https://www.oracle.com/technetwork/java/javase/10all-relnotes-4108743.html

Cumulative Release Notes for JDK 10 and JDK 10 Update Releases

Java™ SE Development Kit 10.0.2 (JDK 10.0.2)
July 17, 2018

(1) The full version string for this update release is 10.0.2+13 (where "+" means "build"). The version number is 10.0.2.

(2) IANA Data 2018e
JDK 10.0.2 contains IANA time zone data version 2018e. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 10.0.2 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
10	10.0.2+13
9	9.0.99
8	1.8.0_181-b13
7	1.7.0_191-b08
6	1.6.0_201-b07


JRE Expiration Date for Oracle JDK
The JRE expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JRE (version 10.0.2) will expire with the release of the next critical patch update scheduled for October 16, 2018.

For systems unable to reach the Oracle Servers, a secondary mechanism expires this JRE (version 10.0.2) on November 16, 2018. After either condition is met (new release becoming available or expiration date reached), the JRE will provide additional warnings and reminders to users to update to the newer version. For more information, see JRE Expiration Date.



Changes
core-libs/java.lang.invoke
➜ filterArguments runs multiple filters in the wrong order
The specification of the method java.lang.invoke.MethodHandles.filterArguments was clarified to state more clearly that filter arguments are invoked in left to right order. The implementation of this method was also fixed to ensure it conformed to the specification. Prior to the fix the implementation incorrectly invoked filters in right to left order. For the majority of usages it is expected such a change in behavior will not be observable. Only in the minority of cases where two or more filters have side-effects that affect their results will such behavior be observable.

See JDK-8194554


core-libs/javax.naming
➜ Improve LDAP support
Endpoint identification has been enabled on LDAPS connections.

To improve the robustness of LDAPS (secure LDAP over TLS) connections, endpoint identification algorithms have been enabled by default.

Note that there may be situations where some applications that were previously able to successfully connect to an LDAPS server may no longer be able to do so. Such applications may, if they deem appropriate, disable endpoint identification using a new system property: com.sun.jndi.ldap.object.disableEndpointIdentification.

Define this system property (or set it to true) to disable endpoint identification algorithms.

JDK-8200666 (not public)


core-libs/java.io:serialization
➜ Better stack walking
New access checks have been added during the object creation phase of deserialization. This should not affect ordinary uses of deserialization. However, reflective frameworks that make use of JDK-internal APIs may be impacted. The new checks can be disabled if necessary by setting the system property jdk.disableSerialConstructorChecks to the value "true". This must be done by adding the argument -Djdk.disableSerialConstructorChecks=true to the Java command line.

JDK-8197925 (not public)


Bug Fixes

This release contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 10.0.2 Bug Fixes page.



Java™ SE Development Kit 10.0.1 (JDK 10.0.1)
April 17, 2018

The full version string for this update release is 10.0.1+10 (where "+" means "build"). The version number is 10.0.1.

For the April CPU, two different JDK10 bundles have been released:

Oracle JDK 10.0.1 (contains non-public commercial features, deploy, installers, etc.)
OpenJDK 10.0.1 (built only from OpenJDK source code)
This page provides release notes for both bundles. Content that only applies to a specific bundle is presented in sections that contain either OpenJDK or Oracle JDK in their titles. Sections that do not contain OpenJDK or Oracle JDK in their titles apply to both bundles.


IANA Data 2018c
JDK 10.0.1 contains IANA time zone data version 2018c. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 10.0.1 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
10	10.0.1+10
9	9.0.99
8	1.8.0_171-b11
7	1.7.0_181-b09
6	1.6.0_191-b09


JRE Expiration Date for Oracle JDK
The JRE expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Third Party Bulletin. This JRE (version 10.0.1) will expire with the release of the next critical patch update scheduled for July 17, 2018.

For systems unable to reach the Oracle Servers, a secondary mechanism expires this JRE (version 10.0.1) on August 17, 2018. After either condition is met (new release becoming available or expiration date reached), the JRE will provide additional warnings and reminders to users to update to the newer version. For more information, see JRE Expiration Date.



Notes
security-libs/javax.crypto
 CipherOutputStream Usage
The specification of javax.crypto.CipherOutputStream has been clarified to indicate that this class catches BadPaddingException and other exceptions thrown by failed integrity checks during decryption. These exceptions are not re-thrown, so the client is not informed that integrity checks have failed. Because of this behavior, this class may not be suitable for use with decryption in an authenticated mode of operation (for example, GCM) if the application requires explicit notification when authentication fails. These applications can use the Cipher API directly as an alternative to using this class.

JDK-8182362 (not public)


New Features
security-libs/javax.crypto
 Enhanced KeyStore Mechanisms
A new security property named jceks.key.serialFilter has been introduced. If this filter is configured, the JCEKS KeyStore uses it during the deserialization of the encrypted Key object stored inside a SecretKeyEntry. If it is not configured or if the filter result is UNDECIDED (for example, none of the patterns match), then the filter configured by jdk.serialFilter is consulted.

If the system property jceks.key.serialFilter is also supplied, it supersedes the security property value defined here.

The filter pattern uses the same format as jdk.serialFilter. The default pattern allows java.lang.Enum, java.security.KeyRep, java.security.KeyRep$Type, and javax.crypto.spec.SecretKeySpec but rejects all the others.

Customers storing a SecretKey that does not serialize to the above types must modify the filter to make the key extractable.

JDK-8189997 (not public)


Changes
security-libs/javax.xml.crypto
 XML Signatures Signed with EC Keys Less Than 224 Bits Disabled
The secure validation mode of the XML Signature implementation has been enhanced to restrict EC keys less than 224 bits by default. The secure validation mode is enabled either by setting the property org.jcp.xml.dsig.secureValidation to true with the javax.xml.crypto.XMLCryptoContext.setProperty() method, or by running the code with a SecurityManager.

JDK-8186032 (not public)


security-libs/javax.net.ssl
 3DES Cipher Suites Disabled
To improve the strength of SSL/TLS connections, 3DES cipher suites have been disabled in SSL/TLS connections in the JDK via the jdk.tls.disabledAlgorithms Security Property.

JDK-8175075 (not public)


Bug Fixes
This release contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 10.0.1 Bug Fixes page.


JDK 10 Documentation

The Java Platform, Standard Edition 10 Development Kit (JDK 10) is a feature release of the Java SE platform. It contains new features and enhancements in many functional areas.

You can use the links on this page to open the Release Notes describing important changes, enhancements, removed APIs and features, deprecated APIs and features, and other information about JDK 10 and Java SE 10.

Links to other sources of information about JDK 10 are also provided. The JDK Guides and Reference Documentation link below displays a page containing links to the user guides, troubleshooting information, and specific information of interest to users moving from previous versions of the JDK. Links to the JDK 10 API Specification and the Java Language and Virtual Machine Specifications are provided below in the JDK 10 Specifications group.


Note: The Release Notes files are located only on our website.

Release Notes:
JDK 10 Release Notes
Java Mission Control 6.0 Release Notes
JDK and JRE README
JDK Guides and Reference Documentation
JDK 10 Specifications:
JDK 10 API Specification
Java Language and Virtual Machine Specifications
JDK and JRE Certified System Configurations

JDK and JRE Supported Locales

Submitting a Bug Report and Available Support Options

Copyright and License Terms for Documentation
