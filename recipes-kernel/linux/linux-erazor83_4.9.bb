SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|nanopi-neo)"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# http://lists.openembedded.org/pipermail/openembedded-core/2015-May/104616.html
KCONFIG_MODE="--alldefconfig"

DEFAULT_PREFERENCE = "1"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
	
PV = "4.9"
SRCREV_pn-${PN} = "e75d8db7c6937ca0a1a83043ae6e157f29b90b18"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_append := ":${THISDIR}/files"
FILESEXTRAPATHS_append := ":${THISDIR}/files-erazor8349"

# file://dts.patch
# file://dtsi.patch

SRC_URI = "git://github.com/erazor83/linux.git;protocol=git;branch=orange-pi-4.9 \
	file://amwifi.cfg \
	file://sun8i_emac.cfg \
	file://ths.cfg \
	file://defconfig \
"
#	file://dtsi.patch \
#	file://dts.patch \
#

do_install_prepend() {
}

do_configure_append() {
	cp ${WORKDIR}/git/arch/arm/boot/dts/sun8i-h3-nanopi-neo.dts ${WORKDIR}/git/arch/arm/boot/dts/sun8i-h3-orangepi-one.dts
}

