DESCRIPTION = "Warehouse Robot package"
SECTION = "devel"

LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "roscpp catkin rospy std-msgs geometry-msgs nav-msgs tf gennodejs xacro"
RDEPENDS_${PN} = "roscpp rospy std-msgs geometry-msgs nav-msgs tf gennodejs xacro"

SRC_URI = "git://github.com/SnappyRobotics/warehouse_robot.git"

SRCREV = "${AUTOREV}"
PV = "1.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git"

inherit catkin
