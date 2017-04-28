DESCRIPTION = "Warehouse Robot package"
SECTION = "devel"

LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"

DEPENDS = "roscpp catkin rospy std-msgs geometry-msgs nav-msgs tf"
RDEPENDS_${PN} = "roscpp rospy std-msgs geometry-msgs nav-msgs tf"

SRC_URI = "git://github.com/SnappyRobotics/warehouse_robot.git"

SRCREV = "${AUTOREV}"
PV = "1.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git"

inherit catkin
