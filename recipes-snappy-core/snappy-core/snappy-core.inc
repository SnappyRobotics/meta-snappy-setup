DESCRIPTION = "snappy-core"
HOMEPAGE = "http://snappyrobotics.github.io"

DEPENDS = "nodejs-native"
RDEPENDS_${PN} = "bash python nodejs"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "\
	https://github.com/SnappyRobotics/snappy-core/archive/${PV}.zip \
	file://snappy-core.service \
"

S = "${WORKDIR}/${PN}-${PV}"

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
	install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system/
}

pkg_postinst_${PN}() {
#!/bin/sh
# Post installation script

if [ -f ${bindir}/${PN} ]
then
	rm ${bindir}/${PN}
fi

ln -s ${NODE_MODULES_DIR}${PN}/index.js ${bindir}/${PN}
chmod 755 ${bindir}/${PN}

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

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "${PN}.service"

PACKAGES = "${PN}"

FILES_${PN} = "\
	${NODE_MODULES_DIR}${PN} \
	${systemd_unitdir} \
"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
