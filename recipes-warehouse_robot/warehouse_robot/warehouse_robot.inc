DESCRIPTION = "warehouse_robot"
HOMEPAGE = "http://snappyrobotics.github.io"

#DEPENDS = "nodejs-native"
#RDEPENDS_${PN} = "bash python nodejs"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "\
	https://github.com/SnappyRobotics/${PN}/archive/${PV}.zip \
"

inherit catkin

ROS_SPN = "warehouse_robot"

S = "${WORKDIR}/${PN}-${PV}"

