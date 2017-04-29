DESCRIPTION = "Apalis T30 IO"
SECTION = "devel"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "nodejs-native"
RDEPENDS_${PN} = "bash python nodejs"


SRC_URI = "git://github.com/SnappyRobotics/apalis-t30-io.git"

SRCREV = "${AUTOREV}"
PV = "1.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git"

NODE_MODULES_DIR = "${prefix}/lib/node_modules/"
NPM_CACHE_DIR ?= "${WORKDIR}/npm_cache"
NPM_REGISTRY ?= "http://registry.npmjs.org/"
NPM_INSTALL_FLAGS ?= "--production --without-ssl --insecure --no-optional --verbose"

do_compile() {
	export NPM_CONFIG_CACHE="${NPM_CACHE_DIR}"
	
	# Clear cache
	npm cache clear

	# Install
	npm --registry=${NPM_REGISTRY} --arch=${TARGET_ARCH} --target_arch=${TARGET_ARCH} ${NPM_INSTALL_FLAGS} install
	npm prune --production
}

do_install() {
	install -d ${D}${NODE_MODULES_DIR}${PN}
    	cp -r ${S}/* ${D}${NODE_MODULES_DIR}${PN}
	
	install -d ${D}${systemd_unitdir}/system/
}

pkg_prerm_${PN}() {
#!/bin/sh
# Pre removal script

if [ -f ${bindir}/${PN} ]
then
	rm ${bindir}/${PN}
fi

}

inherit systemd

PACKAGES = "${PN}"

FILES_${PN} = "\
	${NODE_MODULES_DIR}${PN} \
	${systemd_unitdir} \
"
