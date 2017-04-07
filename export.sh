#!/bin/sh
ECHO=`which echo`
BUILDDIR="../../build"
FIRST_TIME=0
cd layers/openembedded-core/
if [ ! -f ${BUILDDIR}/conf/local.conf ]; then
	FIRST_TIME=1
fi

. ./oe-init-build-env ${BUILDDIR}

echo ""
echo "Toradex targets are:"
echo "    angstrom-lxde-image"
echo "    console-trdx-image"
echo "    angstrom-qt-x11-image"

if [ $FIRST_TIME -eq 1 ]; then
	mkdir -p conf
	cp ../layers/meta-snappy/meta-snappy-setup/buildconf/*.conf conf/

	echo ""
	$ECHO -e "\033[1mDeveloped by Prajankya\033[0m"
fi
