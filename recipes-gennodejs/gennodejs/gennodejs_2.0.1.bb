DESCRIPTION = "gennodejs"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec03229cf6a2bffe6d8c8ba50f346072"

DEPENDS = "packagegroup-ros-comm roscpp catkin rospy genmsg"
RDEPENDS_${PN} = "roscpp rospy genmsg"


SRC_URI = "https://github.com/RethinkRobotics-opensource/${PN}/archive/${PV}.zip"


SRC_URI[md5sum] = "9d7160abf388389766fb26c6ff114d36"
SRC_URI[sha256sum] = "612584e8cddcaf0e8364dc45f4f4a64ada9e2b704bf5c80b27b05b9bb133ca72"


SRCREV = "${AUTOREV}"
PV = "2.0.1"

S = "${WORKDIR}/${PN}-${PV}"

inherit catkin
