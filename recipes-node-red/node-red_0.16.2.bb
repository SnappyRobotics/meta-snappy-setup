DESCRIPTION = "Node-RED is a visual tool for wiring the Internet of Things"
HOMEPAGE = "http://nodered.org"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d6f37569f5013072e9490d2194d10ae6"

SRC_URI = " \
	https://github.com/${PN}/${PN}/releases/download/${PV}/${PN}-${PV}.zip;name=pkg \
"
#	 
#FILES_${PN} += " \
#node-red.service \
#"

PROVIDES = "node-red"
RPROVIDES_${PN} = "node-red"

PACKAGES += "${PN}-systemd"
PRINC := "${@int(PRINC) + 2}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:" 

SRC_URI[pkg.md5sum] = "7cb9d56445dee1d8f26699a1bd098e24"
#SRC_URI[pkg.sha256sum] = "7fdae4b2d1ca2c309aeff7a9148a1dfe95b62223f54be78ac20028b6e42c10df"

SRC_URI +="file://node-red.service"

S = "${WORKDIR}/${PN}-${PV}"

inherit npm-install-global systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "node-red.service"

SYSTEMD_AUTO_ENABLE ??= "enable"

do_configure() {
	:
}

do_install_append() {
        install -d ${D}${systemd_unitdir}/system/
        install -m 0644 ${WORKDIR}/node-red.service ${D}${systemd_unitdir}/system
}

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

RDEPENDS_${PN} += "nodejs bash python zsh"
