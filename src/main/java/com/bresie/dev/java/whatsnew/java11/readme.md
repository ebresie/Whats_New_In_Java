The intent of this project is to provide example code of what's new in java releases.

I will be trying to get the high level elements from each Java/JDK version and provide samples in code where applicable.  

Some elements involve command line parameters which would require some form of "run configuration" which uses these so in those cases, this may be dependent upon run elements which may be provided as part of a build time "run" tasks which applicable parameters.

This has updates relative to JDK 11.

The material here is from the URL listed below.  The intent is to help guide exercise to demonstrate the changes relative to the whatsnew.  

All rights to the material replicated below are with the original authors as spelled out at the original site.

=============================================

https://www.oracle.com/technetwork/java/javase/11all-relnotes-5013287.html

Cumulative Release Notes for JDK 11 and JDK 11 Update Releases

Java™ SE Development Kit 11.0.5 (JDK 11.0.5)
October 15, 2019

The full version string for this update release is 11.0.5+10 (where "+" means "build"). The version number is 11.0.5.

IANA Data 2019b
JDK 11.0.5 contains IANA time zone data version 2019b. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 11.0.5 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
11	11.0.5+10
8	1.8.0_231-b11
7	1.7.0_241-b09


Keeping the JDK up to Date
Oracle recommends that the JDK is updated with each Critical Patch Update (CPU). In order to determine if a release is the latest, the following Security Baseline page can be used to determine which is the latest version for each release family.

Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. It is not recommended that this JDK (version 11.0.5) be used after the next critical patch update scheduled for January 14, 2020.



New Features

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



Other notes


docs
➜ Using the JDK or JRE on macOS Catalina (10.15)
Changes introduced in macOS 10.15 (Catalina) have caused JCK test failures which will prevent Java from being supported on macOS 10.15. If you still want to install and test then please see http://www.oracle.com/technetwork/java/javase/using-jdk-jre-macos-catalina-5781620.html.

JDK-8230057 (not public)


security-libs/javax.net.ssl
➜ Remove Obsolete NIST EC Curves from the Default TLS Algorithms
This change removes older non-NIST Suite B EC curves from the default Named Groups used during TLS negotiation. The curves removed are sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, and secp256k1.

To re-enable these curves, use the jdk.tls.namedGroups system property. The property contains a comma-separated list within quotation marks of enabled named groups in preference order. For example:

java -Djdk.tls.namedGroups="secp256r1, secp384r1, secp521r1, sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, secp256k1, ffdhe2048, ffdhe3072, ffdhe4096, ffdhe6144, ffdhe8192" ...
JDK-8228825 (not public)


security-libs/javax.crypto
➜ Use SunJCE Mac in SecretKeyFactory PBKDF2 Implementation
The SunJCE implementation of the PBKDF2 SecretKeyFactory will now exclusively use the SunJCE Mac service for the underlying pseudorandom function (PRF). This fixes an issue where 3rd party JCE providers in rare cases could cause the SunJCE PBKDF2 SecretKeyFactory's underlying pseudorandom function (PRF) to fail on Mac.init().

See JDK-8218723


install
➜ Java Access Bridge Installation Workaround
There is a risk of breaking Java Access Bridge functionality when installing Java on a Windows system that has both a previously installed version of Java and an instance of JAWS running. After rebooting, the system can be left without the WindowsAccessBridge-64.dll in either the system directory (C:\Windows\System32) for 64bit Java products or the system directory used by WOW64 (C:\Windows\SysWoW64) for 32bit Java products.

To prevent breaking Java Access Bridge functionality, use one of the following workarounds:

Stop JAWS before running the Java installer.
Uninstall the existing JRE(s) before installing the new version of Java.
Uninstall the existing JRE(s) after the new version of Java is installed and the machine is rebooted.
The goal of the workarounds is to avoid the scenario of uninstalling existing JRE(s) from Java installer when JAWS is running.

JDK-8223293 (not public)


security-libs/javax.xml.crypto
➜ Updated XML Signature Implementation to Apache Santuario 2.1.3
The XML Signature implementation in the java.xml.crypto module has been updated to version 2.1.3 of Apache Santuario. New features include:

Added support for embedding elliptic curve public keys in the KeyValue element
See JDK-8219013


core-libs/java.util
➜ Changed Properties.loadFromXML to Comply with Specification
The implementation of the java.util.Properties loadFromXML method has been changed to comply with its specification. Specifically, the underlying XML parser implementation now rejects non-compliant XML documents by throwing an InvalidPropertiesFormatException as specified by the loadFromXML method.

The effect of the change is as follows:

Documents created by Properties.storeToXML: No change. Properties.loadFromXML will have no problem reading such files.

Documents not created by Properties.storeToXML: Any documents containing DTDs not in the format as specified in Properties.loadFromXML will be rejected. This means the DTD shall be exactly as follows (as generated by the Properties.storeToXML method):

<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
See JDK-8213325


core-libs/java.lang
➜ Runtime.exec and ProcessBuilder Argument Restrictions
Runtime.exec and ProcessBuilder have been updated in this release to tighten the constraints on the quoting of arguments to processes created by these APIs. The changes may impact applications on Microsoft Windows that are deployed with a security manager. The changes have no impact on applications that are run without a security manager.

In applications where there is no security manager, there is no change in the default behavior and the new restrictions are opt-in. To enable the restrictions, set the system property jdk.lang.Process.allowAmbiguousCommands to false.

In applications where there is a security manager, the new restrictions are opt-out. To revert to the previous behavior set the system property jdk.lang.Process.allowAmbiguousCommands to true.

Applications using Runtime.exec or ProcessBuilder with a security manager to invoke .bat or .cmd and command names that do not end in ".exe" may be more restrictive in the characters accepted for arguments if they contain double-quote, "&", "|", "<", ">", or "^". The arguments passed to applications may be quoted differently than in previous versions.

For .exe programs, embedded double quotes are allowed and are encoded so they are passed to Windows as literal quotes. In the case where the entire argument has been passed with quotes or must be quoted to encode special characters including space and tab, the encoding ensures they are passed to the application correctly. The restrictions are enforced if there is a security manager and the jdk.lang.Process.allowAmbiguousCommands property is "false" or there is no security manager and property is not "false".

JDK-8221858 (not public)


client-libs/2d
➜ Windows 2019 Core Server Is Not Supported
Windows Core Server 2019 does not ship a dll required by JDK in order to run. Specifically, if a Java application, including a headless one, requires awt.dll, the Java runtime will exit with an exception. There is no workaround. Until this is resolved, this Windows Server configuration is not supported.

See JDK-8229800


Bug Fixes

This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 11.0.5 Bug Fixes page.




Java™ SE Development Kit 11.0.4 (JDK 11.0.4)
July 16, 2019

The full version string for this update release is 11.0.4+10 (where "+" means "build"). The version number is 11.0.4.

IANA Data 2018i
JDK 11.0.4 contains IANA time zone data version 2018i. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 11.0.4 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
11	11.0.4+10
8	1.8.0_221-b11
7	1.7.0_231-b08


Oracle JDK Expiration Date
The JDK expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JDK (version 11.0.4) will expire with the release of the next critical patch update scheduled for October 15, 2019.


New Features
hotspot/runtime
➜ HotSpot Windows OS Detection Correctly Identifies Windows Server 2019
Prior to this fix, Windows Server 2019 was recognized as "Windows Server 2016", which produced incorrect values in the os.name system property and the hs_err_pid file.

See JDK-8211106



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


security-libs/java.security
➜ Removal of GTE CyberTrust Global Root
The GTE CyberTrust Global Root certificate is expired and has been removed from the cacerts keystore:

alias name "gtecybertrustglobalca [jdk]"

Distinguished Name: CN=GTE CyberTrust Global Root, OU="GTE CyberTrust Solutions, Inc.", O=GTE Corporation, C=US

See JDK-8195793



Other notes
security-libs/javax.crypto
➜ System Property to Switch Between Implementations of ECC
A new boolean system property, jdk.security.useLegacyECC, has been introduced that enables switching between implementations of ECC.

When the system property, jdk.security.useLegacyECC, is set to "true" (the value is case-insensitive) the JDK uses the old, native implementation of ECC. If the option is set to an empty string, it is treated as if it were set to "true". This makes it possible to specify -Djdk.security.useLegacyECC in the command line.

If the option is explicitly set to "false", the provider decides which implementation of ECC is used.

The default value of the option is "true". Note that the default value might change in a future update release of the JDK.

JDK-8217763 (not public)






Bug Fixes
This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 11.0.4 Bug Fixes page.




Java SE 11.0.3 Advanced - Bundled Patch Release (BPR) - Bug Fixes and Updates
The following sections summarize changes made in all Java SE 11.0.3 Advanced BPR. Bug fixes and any other changes are listed below in date order, most current BPR first. Note that bug fixes in previous BPR are also included in the current BPR.

To determine the version of your JDK software, use the following command:

java -version

Changes in Java SE 11.0.3+31


Please note that fixes from prior BPR (11.0.2+32) are included in this version.
Bug Fixes
BugId	Category	Subcategory	Description
8210739	client-libs	javax.swing	Calling JSpinner's setFont with null throws NullPointerException
Java™ SE Development Kit 11.0.3 (JDK 11.0.3)
April 16, 2019

The full version string for this update release is 11.0.3+12 (where "+" means "build"). The version number is 11.0.3.

IANA Data 2018g
JDK 11.0.3 contains IANA time zone data version 2018g. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 11.0.3 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
11	11.0.3+12
10	10.0.99
9	9.0.99
8	1.8.0_211-b12
7	1.7.0_221-b08
6	1.6.0_221


Oracle JDK Expiration Date
The JDK expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JDK (version 11.0.3) will expire with the release of the next critical patch update scheduled for July 16, 2019.


New Features
core-libs/java.util:i18n
➜ Square Character Support for Japanese New Era
The code point, U+32FF, is reserved by the Unicode Consortium to represent the Japanese square character for the new era that begins from May, 2019. Relevant methods in the Character class return the same properties as the existing Japanese era characters (e.g., U+337E for "Meizi"). For details about the code point, see http://blog.unicode.org/2018/09/new-japanese-era.html.

See JDK-8211398


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


security-libs/javax.net.ssl
➜ Distrust TLS Server Certificates Anchored by Symantec Root CAs
The JDK will stop trusting TLS Server certificates issued by Symantec, in line with similar plans recently announced by Google, Mozilla, Apple, and Microsoft. The list of affected certificates includes certificates branded as GeoTrust, Thawte, and VeriSign, which were managed by Symantec.

TLS Server certificates issued on or before April 16, 2019 will continue to be trusted until they expire. Certificates issued after that date will be rejected. See the DigiCert support page for information on how to replace your Symantec certificates with a DigiCert certificate (DigiCert took over validation and issuance for all Symantec Website Security SSL/TLS certificates on December 1, 2017).

An exception to this policy is that TLS Server certificates issued through two subordinate Certificate Authorities managed by Apple, and identified below, will continue to be trusted as long as they are issued on or before December 31, 2019.

The restrictions are enforced in the JDK implementation (the SunJSSE Provider) of the Java Secure Socket Extension (JSSE) API. A TLS session will not be negotiated if the server's certificate chain is anchored by any of the Certificate Authorities in the table below.

An application will receive an Exception with a message indicating the trust anchor is not trusted, ex:

"TLS Server certificate issued after 2019-04-16 and anchored by a distrusted legacy Symantec root CA:
CN=GeoTrust Global CA, O=GeoTrust Inc., C=US"
If necessary, and at your own risk, you can work around the restrictions by removing "SYMANTEC_TLS" from the jdk.security.caDistrustPolicies security property in the java.security configuration file.

The restrictions are imposed on the following Symantec Root certificates included in the JDK:

Root Certificates distrusted after 2019-04-16
Distinguished Name	SHA-256 Fingerprint
CN=GeoTrust Global CA, O=GeoTrust Inc., C=US
FF:85:6A:2D:25:1D:CD:88:D3:66:56:F4:50:12:67:98:CF:AB:AA: DE:40:79:9C:72:2D:E4:D2:B5:DB:36:A7:3A

CN=GeoTrust Primary Certification Authority, O=GeoTrust Inc., C=US
37:D5:10:06:C5:12:EA:AB:62:64:21:F1:EC:8C:92:01:3F:C5:F8: 2A:E9:8E:E5:33:EB:46:19:B8:DE:B4:D0:6C

CN=GeoTrust Primary Certification Authority - G2, OU=(c) 2007 GeoTrust Inc. - For authorized use only, O=GeoTrust Inc., C=US
5E:DB:7A:C4:3B:82:A0:6A:87:61:E8:D7:BE:49:79:EB:F2:61:1F: 7D:D7:9B:F9:1C:1C:6B:56:6A:21:9E:D7:66

CN=GeoTrust Primary Certification Authority - G3, OU=(c) 2008 GeoTrust Inc. - For authorized use only, O=GeoTrust Inc., C=US
B4:78:B8:12:25:0D:F8:78:63:5C:2A:A7:EC:7D:15:5E:AA:62:5E: E8:29:16:E2:CD:29:43:61:88:6C:D1:FB:D4

CN=GeoTrust Universal CA, O=GeoTrust Inc., C=US
A0:45:9B:9F:63:B2:25:59:F5:FA:5D:4C:6D:B3:F9:F7:2F:F1:93: 42:03:35:78:F0:73:BF:1D:1B:46:CB:B9:12

CN=thawte Primary Root CA, OU="(c) 2006 thawte, Inc. - For authorized use only", OU=Certification Services Division, O="thawte, Inc.", C=US
8D:72:2F:81:A9:C1:13:C0:79:1D:F1:36:A2:96:6D:B2:6C:95:0A: 97:1D:B4:6B:41:99:F4:EA:54:B7:8B:FB:9F

CN=thawte Primary Root CA - G2, OU="(c) 2007 thawte, Inc. - For authorized use only", O="thawte, Inc.", C=US
A4:31:0D:50:AF:18:A6:44:71:90:37:2A:86:AF:AF:8B:95:1F:FB: 43:1D:83:7F:1E:56:88:B4:59:71:ED:15:57

CN=thawte Primary Root CA - G3, OU="(c) 2008 thawte, Inc. - For authorized use only", OU=Certification Services Division, O="thawte, Inc.", C=US
4B:03:F4:58:07:AD:70:F2:1B:FC:2C:AE:71:C9:FD:E4:60:4C: 06:4C:F5:FF:B6:86:BA:E5:DB:AA:D7:FD:D3:4C

EMAILADDRESS=premium-server@thawte.com, CN=Thawte Premium Server CA, OU=Certification Services Division, O=Thawte Consulting cc, L=Cape Town, ST=Western Cape, C=ZA
3F:9F:27:D5:83:20:4B:9E:09:C8:A3:D2:06:6C:4B:57:D3:A2:47: 9C:36:93:65:08:80:50:56:98:10:5D:BC:E9

OU=VeriSign Trust Network, OU="(c) 1998 VeriSign, Inc. - For authorized use only", OU=Class 2 Public Primary Certification Authority - G2, O="VeriSign, Inc.", C=US
3A:43:E2:20:FE:7F:3E:A9:65:3D:1E:21:74:2E:AC:2B:75:C2:0F: D8:98:03:05:BC:50:2C:AF:8C:2D:9B:41:A1

OU=Class 3 Public Primary Certification Authority, O="VeriSign, Inc.", C=US
A4:B6:B3:99:6F:C2:F3:06:B3:FD:86:81:BD:63:41:3D:8C:50:09: CC:4F:A3:29:C2:CC:F0:E2:FA:1B:14:03:05

OU=VeriSign Trust Network, OU="(c) 1998 VeriSign, Inc. - For authorized use only", OU=Class 3 Public Primary Certification Authority - G2, O="VeriSign, Inc.", C=US
83:CE:3C:12:29:68:8A:59:3D:48:5F:81:97:3C:0F:91:95:43:1E: DA:37:CC:5E:36:43:0E:79:C7:A8:88:63:8B

CN=VeriSign Class 3 Public Primary Certification Authority - G3, OU="(c) 1999 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
EB:04:CF:5E:B1:F3:9A:FA:76:2F:2B:B1:20:F2:96:CB:A5:20:C1: B9:7D:B1:58:95:65:B8:1C:B9:A1:7B:72:44

CN=VeriSign Class 3 Public Primary Certification Authority - G4, OU="(c) 2007 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
69:DD:D7:EA:90:BB:57:C9:3E:13:5D:C8:5E:A6:FC:D5:48:0B:60: 32:39:BD:C4:54:FC:75:8B:2A:26:CF:7F:79

CN=VeriSign Class 3 Public Primary Certification Authority - G5, OU="(c) 2006 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
9A:CF:AB:7E:43:C8:D8:80:D0:6B:26:2A:94:DE:EE:E4:B4:65:99: 89:C3:D0:CA:F1:9B:AF:64:05:E4:1A:B7:DF

CN=VeriSign Universal Root Certification Authority, OU="(c) 2008 VeriSign, Inc. - For authorized use only", OU=VeriSign Trust Network, O="VeriSign, Inc.", C=US
23:99:56:11:27:A5:71:25:DE:8C:EF:EA:61:0D:DF:2F:A0:78:B5: C8:06:7F:4E:82:82:90:BF:B8:60:E8:4B:3C


Subordinate Certificates distrusted after 2019-12-31
Distinguished Name	SHA-256 Fingerprint
CN=Apple IST CA 2 - G1, OU=Certification Authority, O=Apple Inc., C=US
AC:2B:92:2E:CF:D5:E0:17:11:77:2F:EA:8E:D3:72:DE:9D:1E:22:45:FC:E3:F5:7A: 9C:DB:EC:77:29:6A:42:4B

CN=Apple IST CA 8 - G1, OU=Certification Authority, O=Apple Inc., C=US
A4:FE:7C:7F:15:15:5F:3F:0A:EF:7A:AA:83:CF:6E:06:DE:B9:7C:A3:F9:09:DF:92:0A: C1:49:08:82:D4:88:ED

If you have a TLS Server certificate issued by one of the CAs above, you should have received a message from DigiCert with information about replacing that certificate, free of charge.

You can also use the keytool utility from the JDK to print out details of the certificate chain, as follows:

keytool -v -list -alias <your_server_alias> -keystore <your_keystore_filename>


If any of the certificates in the chain are issued by one of the root CAs in the table above are listed in the output you will need to update the certificate or contact the organization that manages the server if not yours.

See JDK-8207258


core-libs/java.time
➜ New Japanese Era Name Reiwa
An instance representing the new Reiwa era has been added to this update. Unlike other eras, there is no public field for this era. It can be obtained by calling JapaneseEra.of(3) or JapaneseEra.valueOf("Reiwa"). JDK 13 and later will have a new public field to represent this era.

The placeholder name, "NewEra", for the Japanese era that started from May 1st, 2019 has been replaced with the new official name. Applications that relied on the placeholder name (see JDK-8202088) to obtain the new era singleton (JapaneseEra.valueOf("NewEra")) will no longer work.

See JDK-8205432


core-libs/java.time
➜ Support New Japanese Era in java.time.chrono.JapaneseEra
The JapaneseEra class and its of(int), valueOf(String), and values() methods are clarified to accommodate future Japanese era additions, such as how the singleton instances are defined, what the associated integer era values are, etc.

See JDK-8212941


Bug Fixes
This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 11.0.3 Bug Fixes page.




Java SE 11.0.2 Advanced - Bundled Patch Release (BPR) - Bug Fixes and Updates
The following sections summarize changes made in all Java SE 11.0.2 Advanced BPR. Bug fixes and any other changes are listed below in date order, most current BPR first. Note that bug fixes in previous BPR are also included in the current BPR.

To determine the version of your JDK software, use the following command:

java -version

Changes in Java SE 11.0.2+32


Bug Fixes
BugId	Category	Subcategory	Description
8211435	client-libs	java.awt	Exception in thread "AWT-EventQueue-1" java.lang.IllegalArgumentException: null source
8204142	client-libs	java.awt	AWT hang occurs when sequenced events arrive out of sequence in multiple AppContexts.
Changes in Java SE 11.0.2+31


Bug Fixes
BugId	Category	Subcategory	Description
8209055	tools	javac	c.s.t.javac.code.DeferredCompletionFailureHandler seems to use WeakHashMap incorrectly
8179098	security-libs	javax.crypto	Crypto AES/ECB encryption/decryption performance regression (introduced in jdk9b73)
8211765	core-libs	java.util.jar	JarFile constructor throws undocumented java.nio.file.InvalidPathException
8211698	hotspot	compiler	Crash in C2 compiled code during execution of double array heavy processing code
8210483	tools	javac	AssertionError in DeferredAttr at setOverloadKind caused by JDK-8203679
8215398	hotspot	runtime	-Xlog option usage => Invalid decorator '\temp\app_cds.log'.
8220165	security-libs	javax.crypto	Encryption using GCM results in RuntimeException: input length out of bound
8201633	security-libs	javax.crypto	Problems with AES-GCM native acceleration
8201317	security-libs	javax.crypto	X25519/X448 code improvements
8208648	security-libs	javax.crypto	ECC Field Arithmetic Enhancements
Java™ SE Development Kit 11.0.2 (JDK 11.0.2)
January 15, 2019

The full version string for this update release is 11.0.2+9 (where "+" means "build"). The version number is 11.0.2.

IANA Data 2018g
JDK 11.0.2 contains IANA time zone data version 2018g. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 11.0.2 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
11	11.0.2+9
10	10.0.99
9	9.0.99
8	1.8.0_201-b09
7	1.7.0_211-b07
6	1.6.0_221


Oracle JDK Expiration Date
The JDK expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JDK (version 11.0.2) will expire with the release of the next critical patch update scheduled for April 16, 2019.



Known Issues
client-libs
➜ GTK+ 3.20 and Later Unsupported by Swing
Due to incompatible changes in the GTK+ 3 library versions 3.20 and later, the Swing GTK Look and Feel does not render some UI components when using this library. Therefore, Linux installations with versions of GTK+ 3.20 and above are not supported for use by the Swing GTK Look And Feel in this release.

See JDK-8219072


Changes
security-libs/javax.net.ssl
➜ TLS anon and NULL Cipher Suites are Disabled
The TLS anon (anonymous) and NULL cipher suites have been added to the jdk.tls.disabledAlgorithms security property and are now disabled by default.

See JDK-8211883
hotspot/runtime
➜ Linux Native Code Checks
Additional safeguards to protect against buffer overruns in native code have been enabled on Linux. If a buffer overrun is encountered the system will write the message “stack smashing detected” and the program will exit. Issues of this type should be reported to your vendor.

JDK-8196902 (not public)

Bug Fixes
This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 11.0.2 Bug Fixes page.




Java™ SE Development Kit 11.0.1 (JDK 11.0.1)
October 16, 2018

The full version string for this update release is 11.0.1+13 (where "+" means "build"). The version number is 11.0.1.

IANA Data 2018e
JDK 11.0.1 contains IANA time zone data version 2018e. For more information, refer to Timezone Data Versions in the JRE Software.

Security Baselines
The security baselines for the Java Runtime Environment (JRE) at the time of the release of JDK 11.0.1 are specified in the following table:

JRE Family Version	JRE Security Baseline
(Full Version String)
11	11.0.1+13
10	10.0.99
9	9.0.99
8	1.8.0_191-b12
7	1.7.0_201-b11
6	1.6.0_211-b11


Oracle JDK Expiration Date
The JDK expires whenever a new release with security vulnerability fixes becomes available. Critical patch updates, which contain security vulnerability fixes, are announced one year in advance on Critical Patch Updates, Security Alerts and Bulletins. This JDK (version 11.0.1) will expire with the release of the next critical patch update scheduled for January 15, 2019.



Changes

security-libs/java.security
➜ Added Additional TeliaSonera Root Certificate
The following root certificate have been added to the OpenJDK cacerts truststore:

TeliaSonera
teliasonerarootcav1

DN: CN=TeliaSonera Root CA v1, O=TeliaSonera

See JDK-8210432


core-libs/javax.naming
➜ Improve LDAP support
Endpoint identification has been enabled on LDAPS connections.

To improve robustness of LDAPS (secure LDAP over TLS) connections, endpoint identification algorithms have been enabled by default.

Note that there may be situations where some applications that were previously able to successfully connect to an LDAPS server may no longer be able to do so. Such applications may, if they deem appropriate, disable endpoint identification using a new system property: com.sun.jndi.ldap.object.disableEndpointIdentification.

Define this system property (or set it to true) to disable endpoint identification algorithms.

JDK-8200666 (not public)


core-svc
➜ Changed Central File System Location for usagetracker.properties File
The file system location in Windows for the usagetracker.properties file has been moved from %ProgramData%\Oracle\Java\ to %ProgramFiles%\Java\conf

There is no change in the file path for Linux, Solaris, or macOS.

JDK-8204901 (not public)


security-libs/javax.net.ssl
➜ Disabled all DES TLS Cipher Suites
DES-based TLS cipher suites are considered obsolete and should no longer be used. DES-based cipher suites have been deactivated by default in the SunJSSE implementation by adding the "DES" identifier to the jdk.tls.disabledAlgorithms security property. These cipher suites can be reactivated by removing "DES" from the jdk.tls.disabledAlgorithms security property in the java.security file or by dynamically calling the Security.setProperty() method. In both cases re-enabling DES must be followed by adding DES-based cipher suites to the enabled cipher suite list using the SSLSocket.setEnabledCipherSuites() or SSLEngine.setEnabledCipherSuites() methods.

Note that prior to this change, DES40_CBC (but not all DES) suites were disabled via the jdk.tls.disabledAlgorithms security property.

See JDK-8208350




security-libs/javax.crypto
➜ Improved Cipher Inputs
The specification of javax.crypto.CipherInputStream has been clarified to indicate that this class may catch BadPaddingException and other exceptions thrown by failed integrity checks during decryption. These exceptions are not re-thrown, so the client may not be informed that integrity checks failed. Because of this behavior, this class may not be suitable for use with decryption in an authenticated mode of operation (e.g. GCM). Applications that require authenticated encryption can use the Cipher API directly as an alternative to using this class.

JDK-8201756 (not public)

Bug Fixes
The following are some of the notable bug fixes included in this release:

core-libs/javax.naming
➜ LDAPS Communication Failure
Application code using LDAPS with a socket connect timeout that is <= 0 (the default value) may encounter an exception when establishing the connection.

The top most frames from Exception stack traces of applications encountering such issues might resemble the following:

javax.naming.ServiceUnavailableException: <server:port>; socket closed
at com.sun.jndi.ldap.Connection.readReply(Unknown Source)
at com.sun.jndi.ldap.LdapClient.ldapBind(Unknown Source)
...
See JDK-8211107


core-libs/java.net
➜ Better HTTP Redirection Support
In this release, the behavior of methods which application code uses to set request properties in java.net.HttpURLConnection has changed. When a redirect occurs automatically from the original destination server to a resource on a different server, then all such properties are cleared for the redirect and any subsequent redirects. If these properties are required to be set on the redirected requests, then the redirect responses should be handled by the application by calling HttpURLConnection.setInstanceFollowRedirects(false) for the original request.

JDK-8196902 (not public)

This release also contains fixes for security vulnerabilities described in the Oracle Critical Patch Update. For a more complete list of the bug fixes included in this release, see the JDK 11.0.1 Bug Fixes page.




JDK 11 Documentation

The Java Platform, Standard Edition 11 Development Kit (JDK 11) is a feature release of the Java SE platform. It contains new features and enhancements in many functional areas.

You can use the links on this page to open the Release Notes describing important changes, enhancements, removed APIs and features, deprecated APIs and features, and other information about JDK 11 and Java SE 11.

Links to other sources of information about JDK 11 are also provided. The JDK Guides and Reference Documentation link below displays a page containing links to the user guides, troubleshooting information, and specific information of interest to users moving from previous versions of the JDK. Links to the JDK 11 API Specification and the Java Language and Virtual Machine Specifications are provided below in the JDK 11 Specifications group.


Note: The Release Notes files are located only on our website.

JDK 11 Release Notes
JDK and JRE README
JDK Guides and Reference Documentation
JDK 11 Specifications:
JDK 11 API Specification
Java Language and Virtual Machine Specifications
JDK and JRE Certified System Configurations

JDK and JRE Supported Locales

Submitting a Bug Report and Available Support Options

Copyright and License Terms for Documentation
